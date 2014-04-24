package PowerExtended.Recipes;

import buildcraft.BuildCraftCore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import PowerExtended.ModBuildTech;
import PowerExtended.Proxies.ClientProxy;
import cpw.mods.fml.common.registry.GameRegistry;

public class GearPlatingRecipes extends GameRegistry{	
	


private static GearPlatingRecipes addRecipe(Item Item, ItemStack itemStack) {

		return ClientProxy.addRecipe(ModBuildTech.WoodenGearPart, new ItemStack(BuildCraftCore.woodenGearItem));
}
}