package buildtech.recipes.factory;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import buildtech.erates.realmachines.recipes.Recipe;

public class RecipeMetallurgicInfuser extends Recipe
{
	public RecipeMetallurgicInfuser(ItemStack input1,ItemStack input2, ItemStack output) 
	{
		super(Recipe.metallurgicInfuser, new ItemStack[] { input1, input2 }, output);
	}
}
