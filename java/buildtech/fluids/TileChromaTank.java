package buildtech.fluids;

import java.io.IOException;

import io.netty.buffer.ByteBuf;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.EnumSkyBlock;

import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;

import buildcraft.BuildCraftCore;
import buildcraft.api.core.SafeTimeTracker;
import buildcraft.core.TileBuildCraft;
import buildcraft.core.fluids.Tank;
import buildcraft.core.fluids.TankManager;
import buildcraft.core.network.PacketPayload;
import buildcraft.core.network.PacketUpdate;

public class TileChromaTank extends TileBuildCraft implements IFluidHandler {

	public final Tank tank = new Tank("tank", FluidContainerRegistry.BUCKET_VOLUME * 32, this);
	public final TankManager tankManager = new TankManager(tank);
	public boolean hasUpdate = false;
	public SafeTimeTracker tracker = new SafeTimeTracker();
	private int prevLightValue = 0;

	/* UPDATING */
	@Override
	public void updateEntity() {
		if (worldObj.isRemote) {
			int lightValue = getFluidLightLevel();
			if (prevLightValue != lightValue) {
				prevLightValue = lightValue;
				worldObj.updateLightByType(EnumSkyBlock.Block, xCoord, yCoord, zCoord);
			}
			return;
		}

		// Have liquid flow down into tanks below if any.
		if (tank.getFluid() != null) {
			moveFluidBelow();
		}

		if (hasUpdate && tracker.markTimeIfDelay(worldObj, 2 * BuildCraftCore.updateFactor)) {
			sendNetworkUpdate();
			hasUpdate = false;
		}
	}

	/* NETWORK */
	@Override
	public PacketPayload getPacketPayload() {
		PacketPayload payload = new PacketPayload(new PacketPayload.StreamWriter() {
			@Override
			public void writeData(ByteBuf data) {
				tankManager.writeData(data);
			}
		});
		return payload;
	}

	@Override
	public void handleUpdatePacket(PacketUpdate packet) throws IOException {
		ByteBuf stream = packet.payload.stream;
		tankManager.readData(stream);
	}

	/* SAVING & LOADING */
	@Override
	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);
		tankManager.readFromNBT(data);
	}

	@Override
	public void writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);
		tankManager.writeToNBT(data);
	}

	/* HELPER FUNCTIONS */
	/**
	 * @return Last tank block below this one or this one if it is the last.
	 */
	public TileChromaTank getBottomTank() {

		TileChromaTank lastTank = this;

		while (true) {
			TileChromaTank below = getTankBelow(lastTank);
			if (below != null) {
				lastTank = below;
			} else {
				break;
			}
		}

		return lastTank;
	}

	public TileChromaTank getTopTank() {

		TileChromaTank lastTank = this;

		while (true) {
			TileChromaTank above = getTankAbove(lastTank);
			if (above != null) {
				lastTank = above;
			} else {
				break;
			}
		}

		return lastTank;
	}

	public static TileChromaTank getTankBelow(TileChromaTank tile) {
		TileEntity below = tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord - 1, tile.zCoord);
		if (below instanceof TileChromaTank) {
			return (TileChromaTank) below;
		} else {
			return null;
		}
	}

	public static TileChromaTank getTankAbove(TileChromaTank tile) {
		TileEntity above = tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord + 1, tile.zCoord);
		if (above instanceof TileChromaTank) {
			return (TileChromaTank) above;
		} else {
			return null;
		}
	}

	public void moveFluidBelow() {
		TileChromaTank below = getTankBelow(this);
		if (below == null) {
			return;
		}

		int used = below.tank.fill(tank.getFluid(), true);
		if (used > 0) {
			hasUpdate = true; // not redundant because tank.drain operates on an IFluidTank, not a tile
			below.hasUpdate = true; // redundant because below.fill sets hasUpdate

			tank.drain(used, true);
		}
	}

	/* ITANKCONTAINER */
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		if (resource == null) {
			return 0;
		}

		FluidStack resourceCopy = resource.copy();
		int totalUsed = 0;
		TileChromaTank tankToFill = getBottomTank();

		FluidStack liquid = tankToFill.tank.getFluid();
		if (liquid != null && liquid.amount > 0 && !liquid.isFluidEqual(resourceCopy)) {
			return 0;
		}

		while (tankToFill != null && resourceCopy.amount > 0) {
			int used = tankToFill.tank.fill(resourceCopy, doFill);
			resourceCopy.amount -= used;
			if (used > 0) {
				tankToFill.hasUpdate = true;
			}

			totalUsed += used;
			tankToFill = getTankAbove(tankToFill);
		}
		return totalUsed;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {
		TileChromaTank bottom = getBottomTank();
		bottom.hasUpdate = true;
		return bottom.tank.drain(maxEmpty, doDrain);
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
		if (resource == null) {
			return null;
		}
		if (!resource.isFluidEqual(tank.getFluid())) {
			return null;
		}
		return drain(from, resource.amount, doDrain);
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection direction) {
		FluidTank compositeTank = new FluidTank(tank.getCapacity());

		TileChromaTank tile = getBottomTank();

		int capacity = tank.getCapacity();

		if (tile != null && tile.tank.getFluid() != null) {
			compositeTank.setFluid(tile.tank.getFluid().copy());
		} else {
			return new FluidTankInfo[]{compositeTank.getInfo()};
		}

		tile = getTankAbove(tile);

		while (tile != null) {

			FluidStack liquid = tile.tank.getFluid();
			if (liquid == null || liquid.amount == 0) {
				// NOOP
			} else if (!compositeTank.getFluid().isFluidEqual(liquid)) {
				break;
			} else {
				compositeTank.getFluid().amount += liquid.amount;
			}

			capacity += tile.tank.getCapacity();
			tile = getTankAbove(tile);
		}

		compositeTank.setCapacity(capacity);
		return new FluidTankInfo[]{compositeTank.getInfo()};
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		return true;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		return false;
	}

	public int getFluidLightLevel() {
		FluidStack tankFluid = tank.getFluid();
		return tankFluid == null ? 0 : tankFluid.getFluid().getLuminosity(tankFluid);
	}
}
