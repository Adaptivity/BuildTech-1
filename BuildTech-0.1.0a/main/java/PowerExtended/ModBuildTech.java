package PowerExtended;

import java.util.logging.Logger;

import buildcraft.BuildCraftCore;
import buildcraft.BuildCraftEnergy;
import buildcraft.BuildCraftFactory;
import buildcraft.core.CreativeTabBuildCraft;
import buildcraft.core.proxy.CoreProxy;
import buildcraft.energy.BlockEngine;
import buildcraft.energy.ItemEngine;
import PowerExtended.Energy.Gui.GuiHandler;
import PowerExtended.Factory.BlockGearBox;
import PowerExtended.Factory.BlockHydro;
import PowerExtended.Items.ItemFluxGear;
import PowerExtended.Items.ItemQuarryArm;
import PowerExtended.Proxies.CommonProxy;
import PowerExtended.Recipes.AssemblyRecipes;
import PowerExtended.Recipes.BuildCraftRecipes;
import PowerExtended.Recipes.RecipeRemover;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;



@Mod(modid="buildtech", name="BuildTech", version="0.1.0a",dependencies = "required-after:BuildCraft|Energy@{6.0.6}")
public class ModBuildTech {
	
public static Block FluxEngine;

public static Block GearPlatingMachine;

public static Block GearBox;
public static Block HydroBlock;
public static Block Block;

	
	public static Item FluxGear;
	public static Item WoodenGearPart;
	public static Item StoneGearPart;
	public static Item IronGearPart;
	public static Item GoldGearPart;
	public static Item DiamondGearPart;
	
	public static Item QuarryArm;

	
	public static final String MODID = "buildtech";
    public static final String NAME = "BuildTech";
    public static final String VERSION = "0.1.0a";

    @Instance(MODID)
    public static ModBuildTech instance;
    public static Achievement fluxGearAchievement;
    public static Achievement gearBoxAchievement;
    public static AchievementPage BuildTech;
    
    
    
    
    @SidedProxy(clientSide = "PowerExtended.Proxies.CommonProxy", serverSide = "PowerExtended.Proxies.ClientProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void init(FMLInitializationEvent event){
    	
    }

    @EventHandler
    	public void PreInit(FMLPreInitializationEvent event){
    	

    	
    	GearBox = new BlockGearBox(Material.wood).setBlockName("gearbox").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "gear_box");
			GameRegistry.registerBlock(GearBox, "gearbox");
			
		HydroBlock = new BlockHydro(Material.wood).setBlockName("hydroblock").setCreativeTab(CreativeTabPowerExtended).setBlockTextureName(MODID + ":" + "hydroblock");
			GameRegistry.registerBlock(HydroBlock, "hydroblock");
			
   
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
		
		AssemblyRecipes.loadRecipes();
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
    	
    	fluxGearAchievement = new Achievement("achievement.fluxGearAchievement", "fluxGearAchievement", 20, 3, ModBuildTech.FluxGear, gearBoxAchievement).registerStat();
    	gearBoxAchievement = new Achievement("achievement.gearBoxAchievement", "gearBoxAchievement", 23, 5, ModBuildTech.FluxGear, gearBoxAchievement).registerStat();

    	
    	BuildCraftCore.BuildcraftAchievements = new AchievementPage("BuildCraft", fluxGearAchievement, gearBoxAchievement);
    	AchievementPage.registerAchievementPage(BuildCraftCore.BuildcraftAchievements);
    }
    
    
    
    
    
    
    private void registerBlock(Block block, String string) {

    	
	}










	public static CreativeTabs CreativeTabPowerExtended = new CreativeTabs("Power Extended"){
	 	public Item getTabIconItem() {
			return FluxGear;
	 };

    };
}

