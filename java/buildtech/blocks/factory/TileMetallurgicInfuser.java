package buildtech.blocks.factory;

import buildtech.blocks.TileMachine;
import buildtech.erates.realmachines.recipes.Recipe;
import buildtech.erates.realmachines.recipes.RecipeHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileMetallurgicInfuser extends TileMachine 
{
	public TileMetallurgicInfuser() 
	{
		super("metallurgicInfuser", Recipe.metallurgicInfuser);
	}

	@Override
	public void updateEntity() 
	{
		super.updateEntity();

		if (worldObj.isRemote) return;

		ItemStack recipeOutputStack = RecipeHelper.getRecipeOutput(Recipe.metallurgicInfuser, new ItemStack[] { getStackInSlot(0), getStackInSlot(1) });
		if (recipeOutputStack == null) 
		{
			currentWorkTime = 0;
			return;
		}

		if (RecipeHelper.getValidRecipe(Recipe.metallurgicInfuser, new ItemStack[] { getStackInSlot(0), getStackInSlot(1) }) != null) {
			if (getStackInSlot(2) != null) 
			{
				if (getStackInSlot(2).getMaxStackSize() < getStackInSlot(2).stackSize + recipeOutputStack.stackSize) return;
				if (!getStackInSlot(2).getUnlocalizedName().equals(recipeOutputStack.getUnlocalizedName())) return;
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

				Recipe recipe = RecipeHelper.getValidRecipe(Recipe.metallurgicInfuser, new ItemStack[] { getStackInSlot(0), getStackInSlot(1) });

				decrStackSize(0, recipe.getInputItemStack(0).stackSize);
				decrStackSize(1, recipe.getInputItemStack(1).stackSize);

				ItemStack outputStack = getStackInSlot(2);
				if (outputStack == null) {
					setInventorySlotContents(2, recipeOutputStack);
				} else {
					outputStack.stackSize += recipeOutputStack.stackSize;
					setInventorySlotContents(2, outputStack);
				}
				currentWorkTime = 0;
			}
		} else {
			currentWorkTime = 0;
		}
	}
}
