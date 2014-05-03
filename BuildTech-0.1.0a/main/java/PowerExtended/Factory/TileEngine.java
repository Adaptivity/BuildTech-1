/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package PowerExtended.Factory;

import java.util.LinkedList;

import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.api.gates.IOverrideDefaultTriggers;
import buildcraft.api.gates.ITrigger;
import buildcraft.api.mj.MjBattery;
import buildcraft.api.power.IPowerEmitter;
import buildcraft.api.power.IPowerReceptor;
import buildcraft.api.power.PowerHandler;
import buildcraft.api.power.PowerHandler.PowerReceiver;
import buildcraft.api.transport.IPipeConnection;
import buildcraft.api.transport.IPipeTile.PipeType;
import buildcraft.core.TileBuffer;
import buildcraft.core.TileBuildCraft;

public class TileEngine extends TileBuildCraft implements IPowerReceptor, IPowerEmitter, IOverrideDefaultTriggers, IPipeConnection{
	public static final float MIN_HEAT = 20;
	public static final float IDEAL_HEAT = 100;
	public static final float MAX_HEAT = 250;
	protected int progressPart = 0;
	protected boolean lastPower = false;
	protected PowerHandler powerHandler;
	@MjBattery()
	public double currentOutput = 0;
	public boolean isRedstonePowered = false;
	private boolean checkOrienation = false;
	private TileBuffer[] tileCache;
	public float progress;
	public double energy;
	public float heat = MIN_HEAT;
	
	@Override
	public PowerReceiver getPowerReceiver(ForgeDirection side) {

		return powerHandler.getPowerReceiver();
	}

	@Override
	public void doWork(PowerHandler workProvider) {

		if (worldObj.isRemote) {
			return;
		}
	}

	@Override
	public ConnectOverride overridePipeConnection(PipeType type,ForgeDirection with) {

		return null;
	}

	@Override
	public LinkedList<ITrigger> getTriggers() {

		return null;
	}

	@Override
	public boolean canEmitPowerFrom(ForgeDirection side) {

		return false /*side == orientation*/;
	}

}
