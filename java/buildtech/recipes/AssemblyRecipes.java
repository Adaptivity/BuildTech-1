/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech.recipes;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftSilicon;
import buildcraft.api.recipes.BuildcraftRecipes;
import buildcraft.api.recipes.IAssemblyRecipeManager;
import buildcraft.core.recipes.AssemblyRecipeManager;
import buildcraft.silicon.ItemRedstoneChipset.Chipset;
import buildtech.ModBuildTech;
import cpw.mods.fml.common.registry.GameRegistry;

public class AssemblyRecipes extends GameRegistry{

	public static void loadRecipes(){
	
		BuildcraftRecipes.assemblyTable.addRecipe(100000, new ItemStack(ModBuildTech.FluxGear), Items.redstone, BuildCraftCore.diamondGearItem);
		//BuildcraftRecipes.assemblyTable.addRecipe(100000, new ItemStack(BuildCraftFactory.quarryBlock), Blocks.redstone_block, ModBuildTech.FluxGear, ModBuildTech.QuarryArm);
	
	}
}
