package buildtech;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import buildtech.blocks.*;
import buildtech.configuration.*;
import buildtech.erates.realmachines.recipes.RecipeHelper;
import buildtech.extras.aenterprise.buildcraftadditions.items.ItemDust;
import buildtech.extras.aenterprise.buildcraftadditions.utils.DusterRecepies;
import buildtech.guis.GuiHandler;
import buildtech.items.*;
import buildtech.libs.*;
import buildtech.proxies.CommonProxy;
import buildtech.recipes.ModRecipes;
import buildtech.recipes.factory.RecipeMineralCompressor;
import buildtech.utils.EventManager;

@Mod
(
modid= Book.MODID, 
name= Book.NAME, 
version= Book.VERSION,
dependencies = "required-after:BuildCraft|Energy@{6.0.16}"
)

public class ModBuildTech 
{
	
	 public static Configuration config;
	 public static Logger logger;
	 ItemDusts itemDust;
	 
	 @Instance(value=Book.MODID)
	 public static ModBuildTech instance;
	
	 @SidedProxy
	 ( clientSide = "buildtech.proxies.ClientProxy", 
	 serverSide = "buildtech.proxies.CommonProxy" )
	 
	 public static CommonProxy proxy;
	 		
	 EventManager eventmanager = new EventManager();
	 
	 @EventHandler
	 public void PreInit(FMLPreInitializationEvent event)
	 {
		 config = new Configuration(new File(event.getModConfigurationDirectory(), "BuildTech/BuildTech.cfg"));
         ConfigHandler.loadConfig(config);
		 
		 ModItems.ItemInit();
		 ModItems.ItemRegistry();
		 
		 ModBlocks.BlockInit();
		 ModBlocks.BlockRegistry();
		 
		 NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		 
		 RecipeHelper.registerRecipes();
		 
		 ModRecipes.BuildTechRecipes();
		 ModRecipes.BuildTechAssemblyRecipes();
		 
		 if(ConfigHandler.toggleCustomRecipes == true)
		 {
			 ModRecipes.BuildTechToggledRecipes();
		 }
	 }
	 
	 @EventHandler
	 public void Init(FMLInitializationEvent event)
	 {
		 
	 }
	 
	 @EventHandler
	 public void PostInit(FMLPostInitializationEvent event)
	 {
       
	 }
}
