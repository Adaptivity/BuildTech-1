package buildtech.recipes;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import buildcraft.*;
import buildcraft.api.recipes.BuildcraftRecipes;
import buildcraft.api.recipes.IAssemblyRecipeManager;
import buildcraft.silicon.ItemRedstoneChipset.Chipset;
import buildtech.blocks.ModBlocks;
import buildtech.items.ModItems;
import buildtech.utils.RecipeRemover;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes
{
	public static void BuildTechRecipes()
	{
		
		/*Items*/
		GameRegistry.addRecipe(new ItemStack(ModItems.plateSteel, 1), new Object[]
		{
			"SSX",
			"SSX",
			"XXX",
			'S', ModItems.ingotTitanium
		});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.plateSteel, 1), new Object[]
		{
			"SSX",
			"SSX",
			"XXX",
			'S', ModItems.ingotReinforced
		});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.plasmaRod, 1), new Object[]
		{
			"FXX",
			"XSX",
			"XXF",
			'F', ModItems.ingotFlux, 'S', ModItems.plateSteel
		});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.plasticRod, 1), new Object[]
		{
			"PXX",
			"XRX",
			"XXP",
			'P', ModItems.dustPlastic, 'R', ModItems.ingotReinforced
		});
		
		GameRegistry.addRecipe(new ItemStack(ModItems.titaniumRod, 1), new Object[]
		{
			"PXX",
			"XRX",
			"XXP",
			'P', ModItems.ingotTitanium, 'R', ModItems.dustChroma
		});		
		
		GameRegistry.addRecipe(new ItemStack(ModItems.reinforcedRod, 1), new Object[]
		{
			"PXX",
			"XRX",
			"XXP",
			'P', ModItems.ingotReinforced, 'R', ModItems.dustCoal
		});	
		
		GameRegistry.addRecipe(new ItemStack(ModItems.fluxRod, 1), new Object[]
		{
			"PXX",
			"XRX",
			"XXP",
			'P', ModItems.ingotFlux, 'R', ModItems.dustChroma
		});		
		
		/*Blocks*/
		GameRegistry.addRecipe(new ItemStack(ModBlocks.fabricatingMachine, 1), new Object[]
		{
			"SPS",
			"PRP",
			"SPS",
			'S', ModItems.plateSteel, 'P', Blocks.piston, 'R', Blocks.redstone_block
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.mechanicalFurnace, 1), new Object[]
		{
			"SCS",
			"CRC",
			"SCS",
			'S', ModItems.plateSteel, 'C', Blocks.cobblestone, 'R', Blocks.redstone_block
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.mineralCompressor, 1), new Object[]
		{
			"SCS",
			"CRC",
			"SPS",
			'S', ModItems.plateSteel, 'P', Blocks.piston, 'R', Blocks.redstone_block, 'C', Blocks.cobblestone
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockChroma, 1), new Object[]
		{
			"CCC",
			"CCC",
			"CCC",
			'C', ModItems.ingotChroma
		});
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.blockTitanium, 1), new Object[]
		{
			"CCC",
			"CCC",
			"CCC",
			'C', ModItems.ingotTitanium
		});
		
		GameRegistry.addSmelting(ModBlocks.oreChroma, new ItemStack(ModItems.ingotChroma), 3F);
		GameRegistry.addSmelting(ModBlocks.oreTitanium, new ItemStack(ModItems.ingotTitanium), 3F);
		GameRegistry.addSmelting(ModItems.dustChroma, new ItemStack(ModItems.ingotChroma), 3F);
		GameRegistry.addSmelting(ModItems.dustTitanium, new ItemStack(ModItems.ingotTitanium), 3F);
		GameRegistry.addSmelting(ModItems.dustReinforced, new ItemStack(ModItems.ingotReinforced), 3F);
		
		GameRegistry.addSmelting(ModItems.dustGold, new ItemStack(Items.gold_ingot), 3F);
		GameRegistry.addSmelting(ModItems.dustIron, new ItemStack(Items.iron_ingot), 3F);
	}
	
	public static void BuildTechAssemblyRecipes()
	{
		BuildcraftRecipes.assemblyTable.addRecipe(20000, new ItemStack(ModItems.gearFlux), Items.redstone, Items.diamond);
	
	}
	
	public static void BuildTechToggledRecipes()
	{
    	RecipeRemover.removeRecipes(new ItemStack(BuildCraftFactory.quarryBlock));
    	RecipeRemover.removeRecipes(new ItemStack(BuildCraftFactory.floodGateBlock));

    	GameRegistry.addRecipe(new ItemStack(BuildCraftFactory.quarryBlock,1), new Object[]
    	{
			"SIS",
			"IRI",
			"SSS",
			'I',BuildCraftCore.ironGearItem, 'S', ModItems.plateSteel,'R', Blocks.redstone_block
		});
    	
    	GameRegistry.addRecipe(new ItemStack(BuildCraftFactory.floodGateBlock,1), new Object[]
    	{
    		"SBS",
    		"GRG",
    		"SGS",
    		'G',BuildCraftTransport.pipeFluidsGold, 'S', ModItems.plateSteel,'R', Blocks.redstone_block, 'B', Blocks.iron_block
    	});
	}
}
