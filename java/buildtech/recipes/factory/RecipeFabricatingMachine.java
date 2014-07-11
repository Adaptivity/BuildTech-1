package buildtech.recipes.factory;

import buildtech.erates.realmachines.recipes.Recipe;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class RecipeFabricatingMachine extends Recipe 
{
	public RecipeFabricatingMachine(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output) 
	{
		super(Recipe.fabricatingMachine, new ItemStack[] { input1, input2, input3 }, output);
	}
}