package PowerExtended.Recipes;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import PowerExtended.ModBuildTech;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftSilicon;
import buildcraft.api.recipes.BuildcraftRecipes;
import buildcraft.api.recipes.IAssemblyRecipeManager;
import buildcraft.core.recipes.AssemblyRecipeManager;
import buildcraft.silicon.ItemRedstoneChipset.Chipset;
import cpw.mods.fml.common.registry.GameRegistry;

public class AssemblyRecipes extends GameRegistry{

	public static void loadRecipes(){
	
		BuildcraftRecipes.assemblyTable.addRecipe(100000, new ItemStack(ModBuildTech.FluxGear), Items.redstone, BuildCraftCore.diamondGearItem);
		//BuildcraftRecipes.assemblyTable.addRecipe(100000, new ItemStack(BuildCraftFactory.quarryBlock), Blocks.redstone_block, ModBuildTech.FluxGear, ModBuildTech.QuarryArm);
	}
}
