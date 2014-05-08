/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.oredict.OreDictionary;
import buildcraft.core.ItemRobot;
import buildcraft.core.proxy.CoreProxy;
import buildcraft.core.robots.EntityRobot;
import buildtech.blocks.OreChroma;
import buildtech.factory.BlockGearMachine;
import buildtech.factory.TileGearMachine;
import buildtech.factory.gui.GuiHandler;
import buildtech.factory.multiblocks.BlockHydro;
import buildtech.fluids.BlockChromaTank;
import buildtech.fluids.TileChromaTank;
import buildtech.items.ItemDrillBattery;
import buildtech.items.ItemDrillDiamond;
import buildtech.items.ItemDrillEmpty;
import buildtech.items.ItemDrillGold;
import buildtech.items.ItemDrillIron;
import buildtech.items.ItemDrillStone;
import buildtech.items.ItemDrillWood;
import buildtech.items.ItemFluxGear;
import buildtech.items.ItemQuarryArm;
import buildtech.proxies.CommonProxy;
import buildtech.recipes.AssemblyRecipes;
import buildtech.recipes.BuildCraftRecipes;
import buildtech.recipes.RecipeHelper;
import buildtech.robots.EntityRobotKiller;
import buildtech.worldgen.WorldGenChroma;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod(modid= ModBuildTech.MODID, name=ModBuildTech.NAME, version=ModBuildTech.VERSION,dependencies = "required-after:BuildCraft|Energy@{6.0.9}")
public class ModBuildTech{
	
	 @SidedProxy(clientSide = "buildtech.proxies.ClientProxy", serverSide = "buildtech.proxies.CommonProxy")
    public static CommonProxy proxy;
	
	public static Block FluxEngine;

	public static BlockGearMachine GearMachine;
	public static Block ChromaCell;
	
	public static Block GearBox;
	public static Block HydroBlock;
	public static Block Block;
	
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

	// Fluids
	
	public static Block ChromaTank;
	public static Block IronTank;
	public static Block GoldTank;
	public static Block DiamondTank;
	public static Block EmeraldTank;

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
    
    
   
   

    @EventHandler
    	public void PreInit(FMLPreInitializationEvent event){
    	
    	
    
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
		
		ChromaTank = new BlockChromaTank().setBlockName("chromatank").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "chroma_ore");
		GameRegistry.registerBlock(ChromaTank, "chromatank");
		GameRegistry.registerTileEntity(TileChromaTank.class, "chromatank");
		
	//	IronTank = new BlockIronTank().setBlockName("irontank").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "chroma_ore");
	//	GameRegistry.registerBlock(IronTank, "irontank");
	//	GameRegistry.registerTileEntity(TileIronTank.class, "irontank");
	/*	
		GoldTank = new BlockChromaTank().setBlockName("chromatank").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "chroma_ore");
		GameRegistry.registerBlock(ChromaTank, "chromatank");
		GameRegistry.registerTileEntity(TileChromaTank.class, "chromatank");
		
		DiamondTank = new BlockChromaTank().setBlockName("chromatank").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "chroma_ore");
		GameRegistry.registerBlock(ChromaTank, "chromatank");
		GameRegistry.registerTileEntity(TileChromaTank.class, "chromatank");
		
		EmeraldTank = new BlockChromaTank().setBlockName("chromatank").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "chroma_ore");
		GameRegistry.registerBlock(ChromaTank, "chromatank");
		GameRegistry.registerTileEntity(TileChromaTank.class, "chromatank");
		*/
		AssemblyRecipes.loadRecipes();
		
    	GameRegistry.registerWorldGenerator(new WorldGenChroma(), 5);
    	
    	OreDictionary.registerOre("chromaore", ChromaOre);
    	OreDictionary.registerOre("chromachunk", ChromaChunk);
    	OreDictionary.registerOre("chromaingot", ChromaIngot);
    	
    	//Hadn't had enough time to finish this as of yet!
  //  	RobotKiller = new ItemRobot(EntityRobotKiller.class).setUnlocalizedName("robotkiller");
  //		GameRegistry.registerItem(RobotKiller, "robotkiller");

    }


	


	@EventHandler
    public void PostInit(FMLPostInitializationEvent event){
	/*	
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.woodenGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.stoneGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.ironGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.goldGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftCore.diamondGearItem));
    	RecipeRemover.removeRecipesWithResult(new ItemStack(BuildCraftFactory.quarryBlock));
  */

    	
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
		
		GearMachine = new BlockGearMachine();
    	CoreProxy.proxy.registerBlock(GearMachine.setBlockName("gearmachine").setCreativeTab(CreativeTabPowerExtended));
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        GameRegistry.registerTileEntity(TileGearMachine.class, "gearmachine");
		RecipeHelper.registerRecipes();
		
		    proxy.registerRenders();
    }
    
    











	public static CreativeTabs CreativeTabPowerExtended = new CreativeTabs("BuildTech"){
	 	public Item getTabIconItem() {
			return FluxGear;
	 };

    };


}

