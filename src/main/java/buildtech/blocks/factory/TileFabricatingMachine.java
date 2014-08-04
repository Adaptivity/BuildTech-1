package buildtech.blocks.factory;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import buildcraft.core.inventory.SimpleInventory;
import buildtech.blocks.TileMachine;
import buildtech.extras.erates.realmachines.recipes.*;




public class TileFabricatingMachine extends TileMachine 
{
	public TileFabricatingMachine() 
	{
		super("fabricatingMachine", Recipe.fabricatingMachine);
	}

	@Override
	public void updateEntity() 
	{
		super.updateEntity();

		if (worldObj.isRemote) return;

		ItemStack recipeOutputStack = RecipeHelper.getRecipeOutput(Recipe.fabricatingMachine, new ItemStack[] { getStackInSlot(0), getStackInSlot(2), getStackInSlot(3)  });
		if (recipeOutputStack == null) 
		{
			currentWorkTime = 0;
			return;
		}

		if (RecipeHelper.getValidRecipe(Recipe.fabricatingMachine, new ItemStack[] { getStackInSlot(0), getStackInSlot(2), getStackInSlot(3) }) != null) {
			if (getStackInSlot(1) != null) 
			{
				if (getStackInSlot(1).getMaxStackSize() < getStackInSlot(1).stackSize + recipeOutputStack.stackSize) return;
				if (!getStackInSlot(1).getUnlocalizedName().equals(recipeOutputStack.getUnlocalizedName())) return;
			}

			if (mjStored > POWER_USAGE) 
			{
				mjStored -= POWER_USAGE;
			} else {
				return;
			}

			currentWorkTime++;
			if (currentWorkTime == MAX_WORK_TICKS) 
			{

				Recipe recipe = RecipeHelper.getValidRecipe(Recipe.fabricatingMachine, new ItemStack[] {  getStackInSlot(0), getStackInSlot(2), getStackInSlot(3) });

				decrStackSize(0, recipe.getInputItemStack(0).stackSize);
				decrStackSize(2, recipe.getInputItemStack(2).stackSize);
//				decrStackSize(3, recipe.getInputItemStack(3).stackSize);

				ItemStack outputStack = getStackInSlot(1);
				if (outputStack == null) {
					setInventorySlotContents(1, recipeOutputStack);
				} else {
					outputStack.stackSize += recipeOutputStack.stackSize;
					setInventorySlotContents(1, outputStack);
				}
				currentWorkTime = 0;
			}
		} else {
			currentWorkTime = 0;
		}
	}
}