package buildtech.blocks.factory;

import buildtech.blocks.TileMachine;
import buildtech.extras.erates.realmachines.recipes.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileMechanicalFurnace extends TileMachine 
{
	public TileMechanicalFurnace() 
	{
		super("mechanicalFurnace", Recipe.mechanicalFurnace);
	}

	@Override
	public void updateEntity() 
	{
		super.updateEntity();

		if (worldObj.isRemote) return;

		ItemStack recipeOutputStack = RecipeHelper.getRecipeOutput(Recipe.mechanicalFurnace, new ItemStack[] { getStackInSlot(0) });
		if (recipeOutputStack == null) 
		{
			currentWorkTime = 0;
			return;
		}

		if (RecipeHelper.getValidRecipe(Recipe.mechanicalFurnace, new ItemStack[] { getStackInSlot(0) }) != null) {
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

				Recipe recipe = RecipeHelper.getValidRecipe(Recipe.mechanicalFurnace, new ItemStack[] { getStackInSlot(0) });

				decrStackSize(0, recipe.getInputItemStack(0).stackSize);
				decrStackSize(1, recipe.getOutputItemStack().stackSize);

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
