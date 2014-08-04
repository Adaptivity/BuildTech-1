package buildtech.recipes.factory;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import buildtech.extras.erates.realmachines.recipes.Recipe;

public class RecipeMineralCompressor extends Recipe
{
	public RecipeMineralCompressor(ItemStack input1, ItemStack output) 
	{
		super(Recipe.mineralCompressor, new ItemStack[] { input1 }, output);
	}
}
