package PowerExtended.Recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftFactory;
import cpw.mods.fml.common.registry.GameRegistry;
import PowerExtended.ModBuildTech;

public class BuildCraftRecipes extends GameRegistry{

	
	public static void loadBCRecipes(){
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.WoodenGearPart,1), new Object[]{
			"IIX","IPX","XXX",'I',Items.stick,'P',Blocks.planks
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.woodenGearItem,1), new Object[]{
			"IIX","IIX","XXX",'I',ModBuildTech.WoodenGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.StoneGearPart,1), new Object[]{
			"IIX","IPX","XXX",'I',Blocks.cobblestone,'P',ModBuildTech.WoodenGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.stoneGearItem,1), new Object[]{
			"IIX","IIX","XXX",'I',ModBuildTech.StoneGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.IronGearPart,1), new Object[]{
			"IIX","IPX","XXX",'I',Items.iron_ingot,'P',ModBuildTech.StoneGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.ironGearItem,1), new Object[]{
			"IIX","IIX","XXX",'I',ModBuildTech.IronGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.GoldGearPart,1), new Object[]{
			"IIX","IPX","XXX",'I',Items.gold_ingot,'P',ModBuildTech.IronGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.goldGearItem,1), new Object[]{
			"IIX","IIX","XXX",'I',ModBuildTech.GoldGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.DiamondGearPart,1), new Object[]{
			"IXX","IPX","XXX",'I',Items.diamond,'P',ModBuildTech.GoldGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.diamondGearItem,1), new Object[]{
			"IIX","IIX","XXX",'I',ModBuildTech.DiamondGearPart
			});
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.QuarryArm,1), new Object[]{
			"OXO","OXO","OXO",'O',Items.gold_ingot
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftFactory.quarryBlock,1), new Object[]{
			"FRF",
			"BQB",
			"IQI",
			'I',BuildCraftCore.ironGearItem,'Q', ModBuildTech.QuarryArm,'R', Blocks.redstone_block,'F',ModBuildTech.FluxGear,'B',Items.iron_ingot
			});
	}
}
