package PowerExtended.Recipes;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import buildcraft.BuildCraftCore;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class RecipeRemover{

	public static void removeRecipesWithResult(ItemStack resultItem)
	{
	    ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

	    for (int scan = 0; scan < recipes.size(); scan++)
	    {
	        IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
	        ItemStack recipeResult = tmpRecipe.getRecipeOutput();
	        if (ItemStack.areItemStacksEqual(resultItem, recipeResult)){
	        	if (tmpRecipe instanceof ShapedOreRecipe)
	        	{
	        	                  ShapedOreRecipe recipe = (ShapedOreRecipe)tmpRecipe;
	        	                  recipeResult = recipe.getRecipeOutput();
	        	}
	        	if (tmpRecipe instanceof ShapelessRecipes)
	            {
	                ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
	                recipeResult = recipe.getRecipeOutput();
	            }
	            System.out.println("[Power Extended] Removing Recipe: " + recipes.get(scan) + " -> " + recipeResult);
	            recipes.remove(scan);
	        }
	    }
	}
}