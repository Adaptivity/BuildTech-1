package buildtech.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import buildtech.blocks.ModBlocks;
import buildtech.items.ModItems;
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
	}
	
	public static void BuildTechAssemblyRecipes()
	{
		
	}
	
	public static void BuildTechToggledRecipes()
	{
		
	}
}
