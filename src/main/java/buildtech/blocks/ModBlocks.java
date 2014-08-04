package buildtech.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import buildtech.blocks.factory.*;
import buildtech.blocks.ores.*;
import buildtech.configuration.ConfigHandler;
import buildtech.utils.EventManager;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks 
{
	public static Block fabricatingMachine;
	
	public static Block mineralCompressor;
	
	public static Block mechanicalFurnace;
	
	public static Block metallurgicInfuser;
	
	public static Block oreTitanium;
	
	public static Block oreChroma;
	
	public static Block blockTitanium;
	
	public static Block blockChroma;
	
	public static Block oreCopper;
	
	public static Block oreTin;
	
	public static Block blockCopper;
	
	public static Block blockTin;
	
	public static void BlockInit()
	{
		fabricatingMachine = new BlockFabricatingMachine(ConfigHandler.fabricatingMachine, fabricatingMachine)
		.setBlockName("fabricatingMachine");	
		mineralCompressor = new BlockMineralCompressor(ConfigHandler.mineralCompressor, mineralCompressor)
		.setBlockName("mineralCompressor");
		mechanicalFurnace = new BlockMechanicalFurnace(ConfigHandler.mechanicalFurnace, mechanicalFurnace)
		.setBlockName("mechanicalFurnace");	
		metallurgicInfuser = new BlockMetalTransfuser(ConfigHandler.metalTransfuser, metallurgicInfuser)
		.setBlockName("metalTransfuser");
		
		oreTitanium = new OreTitanium(Material.rock, ConfigHandler.oreTitanium, oreTitanium)
		.setBlockName("oreTitanium")
		.setBlockTextureName("buildtech:oreTitanium");
		
		blockTitanium = new BlockOres(Material.rock, ConfigHandler.blockTitanium, blockTitanium)
		.setBlockName("blockTitanium")
		.setBlockTextureName("buildtech:blockTitanium");
		
		blockChroma = new BlockOres(Material.rock, ConfigHandler.blockChroma, blockChroma)
		.setBlockName("blockChroma")
		.setBlockTextureName("buildtech:blockChroma");
		
		oreChroma = new OreChroma(Material.rock, ConfigHandler.oreChroma, oreTitanium)
		.setBlockName("oreChroma")
		.setBlockTextureName("buildtech:chroma_ore");
		
		oreTin = new OreTin(Material.rock, ConfigHandler.oreTin, oreTin)
		.setBlockName("oreTin")
		.setBlockTextureName("buildtech:oreTin");
		
		oreCopper = new OreCopper(Material.rock, ConfigHandler.oreCopper, oreCopper)
		.setBlockName("oreCopper")
		.setBlockTextureName("buildtech:oreCopper");
	}
	
	public static void BlockRegistry()
	{
		GameRegistry.registerBlock(fabricatingMachine, "fabricatingMachine");
		GameRegistry.registerTileEntity(TileFabricatingMachine.class, "fabricatingMachine");
		
		GameRegistry.registerBlock(mineralCompressor, "mineralCompressor");
		GameRegistry.registerTileEntity(TileMineralCompressor.class, "mineralCompressor");
		
		GameRegistry.registerBlock(mechanicalFurnace, "mechanicalFurnace");
		GameRegistry.registerTileEntity(TileMechanicalFurnace.class, "mechanicalFurnace");
		
		GameRegistry.registerBlock(metallurgicInfuser, "metallurgicInfuser");
		GameRegistry.registerTileEntity(TileMetallurgicInfuser.class, "metallurgicInfuser");
		
		GameRegistry.registerBlock(oreTitanium, "oreTitanium");
		GameRegistry.registerBlock(oreChroma, "oreChroma");
	//	GameRegistry.registerBlock(oreTin, "oreTin");
	//	GameRegistry.registerBlock(oreCopper, "oreCopper");

		GameRegistry.registerBlock(blockTitanium, "blockTitanium");
		GameRegistry.registerBlock(blockChroma, "blockChroma");
		
		GameRegistry.registerWorldGenerator(new EventManager(), 4);
	}
}
