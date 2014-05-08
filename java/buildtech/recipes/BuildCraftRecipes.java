/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftTransport;
import buildtech.ModBuildTech;
import cpw.mods.fml.common.registry.GameRegistry;


public class BuildCraftRecipes extends GameRegistry{

	
	public static void loadBCRecipes(){
	/* Maybe anothe time I will re-dd this, but for right now these recipes are TOO Unbalanced	
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
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftCore.diamondGearItem,1), new Object[]{
			"XPX","PIP","XPX",'I',Items.diamond,'P',ModBuildTech.GoldGearPart
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
	*/	
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.EmptyDrill,1), new Object[]{
			"IIW","XXS","XXS",'I',Items.iron_ingot,'W', BuildCraftCore.woodenGearItem,'S', Items.stick
			});
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.GearMachine,1), new Object[]{
			"IGI",
			"GRG",
			"IGI",
			'I',Items.iron_ingot,'G', BuildCraftCore.ironGearItem,'R', Blocks.redstone_block
			});
		
		GameRegistry.addRecipe(new ItemStack(ModBuildTech.ChromaTank,1), new Object[]{
			"GCG",
			"GTG",
			"GCG",
			'C',ModBuildTech.ChromaIngot,'G', Blocks.glass,'T', BuildCraftFactory.tankBlock
			});
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.ChromaIngot, 1), new Object[]{ ModBuildTech.ChromaChunk, new ItemStack(ModBuildTech.WoodDrill, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.ChromaIngot, 1), new Object[]{ ModBuildTech.ChromaChunk, new ItemStack(ModBuildTech.StoneDrill, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.ChromaIngot, 1), new Object[]{ ModBuildTech.ChromaChunk, new ItemStack(ModBuildTech.IronDrill, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.ChromaIngot, 2), new Object[]{ ModBuildTech.ChromaChunk, new ItemStack(ModBuildTech.GoldDrill, 1, OreDictionary.WILDCARD_VALUE)});
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.ChromaIngot, 2), new Object[]{ ModBuildTech.ChromaChunk, new ItemStack(ModBuildTech.DiamondDrill, 1, OreDictionary.WILDCARD_VALUE)});

		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.WoodDrill, 1), new Object[]{ ModBuildTech.EmptyDrill, ModBuildTech.WoodBattery });
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.StoneDrill, 1), new Object[]{ ModBuildTech.EmptyDrill, ModBuildTech.StoneBattery });
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.IronDrill, 1), new Object[]{ ModBuildTech.EmptyDrill, ModBuildTech.IronBattery });
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.GoldDrill, 1), new Object[]{ ModBuildTech.EmptyDrill, ModBuildTech.GoldBattery });
		GameRegistry.addShapelessRecipe(new ItemStack(ModBuildTech.DiamondDrill, 1), new Object[]{ ModBuildTech.EmptyDrill, ModBuildTech.DiamondDrill });
	/*	
		GameRegistry.addRecipe(new ItemStack(BuildCraftTransport.pipeItemsWood,4), new Object[]{
			"WGW","XPX","XXX",'W',Blocks.planks,'G', Blocks.glass,'P', BuildCraftCore.woodenGearItem
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftTransport.pipeItemsCobblestone,4), new Object[]{
			"WGW","XPX","XXX",'W',Blocks.cobblestone,'G', Blocks.glass,'P', BuildCraftCore.stoneGearItem
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftTransport.pipeItemsIron,4), new Object[]{
			"WGW","XPX","XXX",'W',Items.iron_ingot,'G', Blocks.glass,'P', BuildCraftCore.ironGearItem
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftTransport.pipeItemsGold,4), new Object[]{
			"WGW","XPX","XXX",'W',Items.gold_ingot,'G', Blocks.glass,'P', BuildCraftCore.goldGearItem
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftTransport.pipeItemsDiamond,4), new Object[]{
			"WGW","XPX","XXX",'W',Items.diamond,'G', Blocks.glass,'P', BuildCraftCore.diamondGearItem
			});
		
		GameRegistry.addRecipe(new ItemStack(BuildCraftTransport.pipeItemsEmerald,4), new Object[]{
			"WGW","XPX","XXX",'W',Items.emerald,'G', Blocks.glass,'P', BuildCraftCore.diamondGearItem
			});
		*/
		
		
	}
}
