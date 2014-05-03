/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
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