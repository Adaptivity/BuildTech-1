/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech;

import java.util.LinkedList;
import java.util.logging.Logger;

import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftFactory;
import buildcraft.BuildCraftTransport;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.DefaultProps;
import buildcraft.core.proxy.CoreProxy;
import buildcraft.energy.*;
import buildcraft.transport.BlockGenericPipe;
import buildcraft.transport.ItemPipe;
import buildcraft.transport.Pipe;
import buildcraft.transport.pipes.PipeItemsCobblestone;
import buildtech.blocks.OreChroma;
import buildtech.energy.*;
import buildtech.energy.gui.*;
import buildtech.factory.*;
import buildtech.factory.gui.*;
import buildtech.factory.gui.GuiHandler;
import buildtech.items.*;
import buildtech.proxies.*;
import buildtech.recipes.*;
import buildtech.robots.EntityRobotKiller;
import buildtech.transport.pipes.PipeItemsChromastone;
import buildtech.worldgen.WorldGenChroma;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.*;



@Mod(modid= ModBuildTech.MODID, name=ModBuildTech.NAME, version=ModBuildTech.VERSION,dependencies = "required-after:BuildCraft|Energy@{6.0.7}")
public class ModBuildTech{
	
	public static Block FluxEngine;

	public static BlockGearMachine GearMachine;

	public static Block GearBox;
	public static Block HydroBlock;
	public static Block Block;
	public static Block MJEnchantedTable;
	
	public static Entity RobotKiller;

	public static Block ChromaOre;
	public static Item ChromaIngot;
	public static Item ChromaChunk;
	
	public static Item ChromaItemsPipe;

	
	public static Item FluxGear;
	public static Item WoodenGearPart;
	public static Item StoneGearPart;
	public static Item IronGearPart;
	public static Item GoldGearPart;
	public static Item DiamondGearPart;
	
	public static Item WoodBattery;
	public static Item StoneBattery;
	public static Item IronBattery;
	public static Item GoldBattery;
	public static Item DiamondBattery;
	
	public static Item EmptyDrill;
	public static Item WoodDrill;
	public static Item StoneDrill;
	public static Item IronDrill;
	public static Item GoldDrill;
	public static Item DiamondDrill;

	public static Item QuarryArm;

	
	public static final String MODID = "buildtech";
    public static final String NAME = "BuildTech";
    public static final String VERSION = "0.1.5a";

    @Instance(MODID)
    public static ModBuildTech instance;
    public static Achievement fluxGearAchievement;
    public static Achievement gearBoxAchievement;
    public static AchievementPage BuildTech;
    
    public static final int GuiGearPlating = 60;
    public static final int GuiGearBox = 61;
    public static final int GuiFluxEngine = 62;
    
    
    @SidedProxy(clientSide = "buildtech.proxies.CommonProxy", serverSide = "buildtech.proxies.ClientProxy")
    public static CommonProxy proxy;
   

    @EventHandler
    	public void PreInit(FMLPreInitializationEvent event){
    	
    	
    	GearBox = new BlockGearBox(Material.wood).setBlockName("gearbox").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "gear_box");
			GameRegistry.registerBlock(GearBox, "gearbox");
			
		HydroBlock = new BlockHydro(Material.wood).setBlockName("hydroblock").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "hydroblock");
			GameRegistry.registerBlock(HydroBlock, "hydroblock");
			
		ChromaOre = new OreChroma(Material.iron).setBlockName("chromaore").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "chroma_ore").setLightLevel(0.5F);
			GameRegistry.registerBlock(ChromaOre, "chromaore");
   
    	FluxGear = new ItemFluxGear().setUnlocalizedName("fluxgear").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "fluxgear");
		GameRegistry.registerItem(FluxGear, "Flux Gear");
		
		WoodenGearPart = new Item().setUnlocalizedName("woodengearpart").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "wooden_gear_part");
		GameRegistry.registerItem(WoodenGearPart, "Part of a Wooden Gear");	
		
		StoneGearPart = new Item().setUnlocalizedName("stonegearpart").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "stone_gear_part");
		GameRegistry.registerItem(StoneGearPart, "Part of a Stone Gear");	
		
		IronGearPart = new Item().setUnlocalizedName("irongearpart").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "iron_gear_part");
		GameRegistry.registerItem(IronGearPart, "Part of a Iron Gear");	
		
		GoldGearPart = new Item().setUnlocalizedName("goldgearpart").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "gold_gear_part");
		GameRegistry.registerItem(GoldGearPart, "Part of a Gold Gear");	
		
		DiamondGearPart = new Item().setUnlocalizedName("diamondgearpart").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "diamond_gear_part");
		GameRegistry.registerItem(DiamondGearPart, "Part of a Diamond Gear");	
		
		QuarryArm = new ItemQuarryArm().setUnlocalizedName("quarryarm").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "quarry_arm");
		GameRegistry.registerItem(QuarryArm, "quarryarm");	
		
		ChromaChunk = new Item().setUnlocalizedName("chromachunk").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "chroma_chunk");
		GameRegistry.registerItem(ChromaChunk, "chromachunk");	
		
		ChromaIngot = new Item().setUnlocalizedName("chromaingot").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "chromaingot");
		GameRegistry.registerItem(ChromaIngot, "chromaingot");	
		
		WoodBattery = new ItemDrillBattery().setUnlocalizedName("woodbattery").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "wood_battery");
		GameRegistry.registerItem(WoodBattery, "woodbattery");	
		
		StoneBattery = new ItemDrillBattery().setUnlocalizedName("stonebattery").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "stone_battery");
		GameRegistry.registerItem(StoneBattery, "stonebattery");	
		
		IronBattery = new ItemDrillBattery().setUnlocalizedName("ironbattery").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "iron_battery");
		GameRegistry.registerItem(IronBattery, "ironbattery");	
		
		GoldBattery = new ItemDrillBattery().setUnlocalizedName("goldbattery").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "gold_battery");
		GameRegistry.registerItem(GoldBattery, "goldbattery");	
		
		DiamondBattery = new ItemDrillBattery().setUnlocalizedName("diamondbattery").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "diamond_battery");
		GameRegistry.registerItem(DiamondBattery, "diamondbattery");
		
		WoodDrill = new ItemDrillWood(0).setUnlocalizedName("wooddrill").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "drill_wood");
		GameRegistry.registerItem(WoodDrill, "wooddrill");	
		
		StoneDrill = new ItemDrillStone(0).setUnlocalizedName("stonedrill").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "drill_stone");
		GameRegistry.registerItem(StoneDrill, "stonedrill");	
		
		IronDrill = new ItemDrillIron(0).setUnlocalizedName("irondrill").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "drill_iron");
		GameRegistry.registerItem(IronDrill, "irondrill");	
		
		GoldDrill = new ItemDrillGold(0).setUnlocalizedName("golddrill").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "drill_gold");
		GameRegistry.registerItem(GoldDrill, "golddrill");	
		
		DiamondDrill = new ItemDrillDiamond(0).setUnlocalizedName("diamonddrill").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "drill_diamond");
		GameRegistry.registerItem(DiamondDrill, "diamonddrill");
		
		EmptyDrill = new ItemDrillEmpty(0).setUnlocalizedName("emptydrill").setCreativeTab(CreativeTabPowerExtended).setTextureName(MODID + ":" + "drill_empty");
		GameRegistry.registerItem(EmptyDrill, "emptydrill");
		
			
		AssemblyRecipes.loadRecipes();
		
    	GameRegistry.registerWorldGenerator(new WorldGenChroma(), 5);
    	
    	OreDictionary.registerOre("chromaore", ChromaOre);
    	
    	System.out.println("BuildTech Initialized!");
    }


	


	@EventHandler
    public void PostInit(FMLPostInitializationEvent event){
		
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.woodenGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.stoneGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.ironGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.goldGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.diamondGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftFactory.quarryBlock));
  

    	
    	BuildCraftRecipes.loadBCRecipes();
    }
    
    @EventHandler
    public void Load(FMLInitializationEvent event){
    	
    }
    
    @EventHandler
	public void init(FMLInitializationEvent event) {

	}
    
    @Mod.EventHandler
	public void initialize(FMLPreInitializationEvent evt) {
    	GearMachine = new BlockGearMachine();
    	CoreProxy.proxy.registerBlock(GearMachine.setBlockName("gearmachine").setCreativeTab(CreativeTabPowerExtended));
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        GameRegistry.registerTileEntity(TileGearMachine.class, "gearmachine");
		RecipeHelper.registerRecipes();
    }
    
    











	public static CreativeTabs CreativeTabPowerExtended = new CreativeTabs("BuildTech"){
	 	public Item getTabIconItem() {
			return FluxGear;
	 };

    };
}

