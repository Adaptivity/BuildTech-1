package buildtech.recipes.factory;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import buildtech.extras.erates.realmachines.recipes.Recipe;

public class RecipeMechanicalFurnace extends Recipe
{
	public RecipeMechanicalFurnace(ItemStack input1, ItemStack output) 
	{
		super(Recipe.mechanicalFurnace, new ItemStack[] { input1 }, output);
	}
}
