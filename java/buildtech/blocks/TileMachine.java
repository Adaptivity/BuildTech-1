package buildtech.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import buildcraft.api.mj.MjBattery;
import buildcraft.core.fluids.Tank;
import buildcraft.core.fluids.TankManager;
import buildcraft.core.inventory.SimpleInventory;
import buildtech.extras.erates.realmachines.recipes.*;


public class TileMachine extends TileEntity implements ISidedInventory {

	@MjBattery(maxCapacity = 1500)
	protected double mjStored = 0;

	private static final int[] slots_top = new int[] {0};
	private static final int[] slots_bottom = new int[] {2, 1};
	private static final int[] slots_sides = new int[] {1};
	protected static int POWER_USAGE = 30;

	protected int currentWorkTime;
	public static int MAX_WORK_TICKS = 20;

	private final SimpleInventory _inventory;
	private int machineType;

	public TileMachine(String inventoryName, int machineType) {
		currentWorkTime = 0;
		_inventory = new SimpleInventory(4, inventoryName, 64);
		this.machineType = machineType;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64;
	}

	@Override
	public int getSizeInventory() {
		return _inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return _inventory.getStackInSlot(i);
	}

	@Override
	public ItemStack decrStackSize(int i, int count) {
		return _inventory.decrStackSize(i, count);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return _inventory.getStackInSlotOnClosing(i);
	}

	@Override
	public void setInventorySlotContents(int slotId, ItemStack itemstack) {
		_inventory.setInventorySlotContents(slotId, itemstack);
	}

	@Override
	public String getInventoryName() {
		return _inventory.getInventoryName();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return _inventory.hasCustomInventoryName();
	}

	@Override
	public int getInventoryStackLimit() {
		return _inventory.getInventoryStackLimit();
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemStack) {
		return RecipeHelper.isStackValidForSlot(machineType, itemStack, i);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		NBTTagCompound inventoryTag = new NBTTagCompound();
		_inventory.writeToNBT(inventoryTag);
		compound.setTag("inventory", inventoryTag);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		NBTTagCompound p = (NBTTagCompound) compound.getTag("inventory");
		_inventory.readFromNBT(p);
	}

	public int getCookProgressScaled(int i) {
		double deling = (double) currentWorkTime / (double) MAX_WORK_TICKS;
		double vermenigvuldiging = deling * i;
		int totaal = (int) vermenigvuldiging;
		return totaal;
	}

	public int getCurrentWorkTime() {
		return currentWorkTime;
	}

	public int getMaxWorkTime() {
		return MAX_WORK_TICKS;
	}

	public void setCurrentWorkTime(int currentWorkTime) {
		this.currentWorkTime = currentWorkTime;
	}

	public void setMaxWorkTime(int maxWorkTime) {
		this.MAX_WORK_TICKS = maxWorkTime;
	}

	public int[] getAccessibleSlotsFromSide(int par1)
	{
    	return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
	}


	@Override
	public boolean canInsertItem(int var1, ItemStack var2, int var3) {

		return true;
	}

	@Override
	public boolean canExtractItem(int var1, ItemStack var2, int var3) {

		return true;
	}
}
