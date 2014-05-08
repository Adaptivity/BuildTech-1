package buildtech.factory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.api.mj.MjBattery;
import buildcraft.core.inventory.SimpleInventory;
import buildtech.recipes.RecipeHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class TileChromaCell extends TileEntity implements ISidedInventory {

	@MjBattery(maxCapacity = 50000)
	protected double mjStored = 0;

	protected static int POWER_EXTRACTED_PER_TICK = 100;

	protected int currentWorkTime;
	public static int MAX_WORK_TICKS = 20;

	private final SimpleInventory _inventory;
	private int machineType;

	public TileChromaCell(String inventoryName, int machineType) {
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

	@Override
	public int[] getAccessibleSlotsFromSide(int var1) {

		return getAccessibleSlotsFromSide(6);
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
