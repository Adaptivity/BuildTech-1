package buildtech.recipes.factory;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import buildtech.erates.realmachines.recipes.Recipe;

public class RecipeMineralCompressor extends Recipe
{
	public RecipeMineralCompressor(ItemStack input1, ItemStack output) 
	{
		super(Recipe.mineralCompressor, new ItemStack[] { input1 }, output);
	}

	 public static ArrayList<Item> dusterInput = new ArrayList<Item>(20);
	 public static ArrayList<ItemStack> dusterOutput = new ArrayList<ItemStack>(20);

	    public static void addMineralRecipe(ItemStack input, ItemStack output){
	        dusterInput.add(input.getItem());
	        dusterOutput.add(output);
	    }

	    public static ItemStack getOutput(ItemStack input){
	         if (dusterInput.contains(input.getItem()))
	            return dusterOutput.get(dusterInput.indexOf(input.getItem())).copy();
	        return null;
	    }
}
