package buildtech.configuration;

import java.io.File;

import buildtech.libs.VersionCheck;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ConfigHandler 
{
		public static int fluxEngine;

		public static int fabricatingMachine;
		public static int chromaCell;
		public static int mineralCompressor;
		public static int mechanicalFurnace;
		public static int metalTransfuser;
		
		public static int chromaOre;
		public static int chromaIngot;
		public static int chromaChunk;
		
		public static int chromaItemsPipe;
		
		public static int plasticRod;
		public static int reinforcedRod;
		public static int titaniumRod;
		public static int fluxRod;
		
		public static int fluxGear;
		public static int woodenGearPart;
		public static int stoneGearPart;
		public static int ironGearPart;
		public static int goldGearPart;
		public static int diamondGearPart;
		
		public static int emptyDrill;
		public static int woodDrill;
		public static int stoneDrill;
		public static int ironDrill;
		public static int goldDrill;
		public static int diamondDrill;

		public static int quarryArm;
		
		public static int coalDust;
		public static int woodPulp;
		public static int plasticDust;
		public static int ironDust;
		public static int reinforcedDust;
		public static int titaniumDust;
		public static int goldDust;
		public static int diamondDust;
		public static int emeraldDust;
		public static int chromaDust;
		
		
		public static int pipeChromaItems;
		
		public static int ironBattery;
		public static int goldBattery;
		public static int diamondBattery;
		public static int emeraldBattery;
		public static int chromaBattery;
		
		public static int battleWrench;
		
		public static int reinforcedIngot;
		public static int titaniumIngot;
		public static int plasmaIngot;
		public static int fluxIngot;

		// Fluids
		
		public static int chromaTank;
		public static int ironTank;
		public static int goldTank;
		public static int diamondTank;
		public static int emeraldTank;
		
		public static int oreTitanium;
		public static int oreChroma;
		public static int oreTin;
		public static int oreCopper;
		public static int blockTitanium;
		public static int blockChroma;
		public static int blockTin;
		public static int blockCopper;
		
		public static int plateSteel;
		
		public static int gearFlux;

		public static boolean toggleCustomRecipes;
		
		public static boolean shouldPrintChangelog;
	    public static int[] powerDifficultyModifiers;
	    public static int basePowerModifier;

	    public static Configuration config;

	   
		
		public static void loadConfig(Configuration config)
		{
			try
			{
	        config.addCustomCategoryComment("Misc", "Misc. Section");

	        toggleCustomRecipes = config.get("Toggle to Enable Custom BC Recipes ", "Toggle Custom BC Recipes" , false).getBoolean(false);

	        config.addCustomCategoryComment("IDS'", "IDS' Section");
	        
	        fluxEngine = config.get("Blocks", "FluxEngine", 3000).getInt();
	        
	        fabricatingMachine = config.get("Blocks", "GearMachine", 3001).getInt();
	    	chromaCell = config.get("Blocks", "ChromaCell", 3002).getInt();
	    	mineralCompressor = config.get("Blocks", "MineralCompressor", 3003).getInt();
	    	
	    	chromaOre = config.get("Blocks", "ChromaOre", 3004).getInt();
	    	chromaIngot = config.get("Items", "ChromaIngot", 3005).getInt();
	    	chromaChunk = config.get("Items", "ChromaChunk", 3006).getInt();
	    	
	    	fluxGear = config.get("Items", "FluxGear", 3007).getInt();
	    	woodenGearPart = config.get("Items", "WoodenGearPart", 3008).getInt();
	    	stoneGearPart = config.get("Items", "StoneGearPart", 3009).getInt();
	    	ironGearPart = config.get("Items", "IronGearPart", 3010).getInt();
	    	goldGearPart = config.get("Items", "GoldGearPart", 3011).getInt();
	    	diamondGearPart = config.get("Items", "DiamondGearPart", 3012).getInt();
	    	
	    	emptyDrill = config.get("Items", "EmptyDrill", 3013).getInt();
	    	woodDrill = config.get("Items", "WoodDrill", 3014).getInt();
	    	stoneDrill = config.get("Items", "StoneDrill", 3015).getInt();
	    	ironDrill = config.get("Items", "IronDrill", 3016).getInt();
	    	goldDrill = config.get("Items", "GoldDrill", 3017).getInt();
	    	diamondDrill = config.get("Items", "DiamondDrill", 3018).getInt();

	    	quarryArm = config.get("Items", "QuarryArm", 3019).getInt();
	    	
	    	ironDust = config.get("Items", "IronDust", 3020).getInt();
	    	goldDust = config.get("Items", "GoldDust", 3021).getInt();
	    	diamondDust = config.get("Items", "DiamondDust", 3022).getInt();
	    	emeraldDust = config.get("Items", "EmeraldDust", 3023).getInt();
	    	chromaDust = config.get("Items", "ChromaDust", 3024).getInt();
	    	woodPulp = config.get("Items", "WoodDust", 3025).getInt();
	    	plasticDust = config.get("Items", "PlasticDust", 3026).getInt();
	    	reinforcedDust = config.get("Items", "ReinforcedDust", 3027).getInt();
	    	titaniumDust = config.get("Items", "TitaniumDust", 3028).getInt();

	    	pipeChromaItems = config.get("Pipes", "PipeChromaItems", 3029).getInt();
	    	
	    	ironBattery = config.get("Batteries", "ironBattery", 3030).getInt();
	    	goldBattery = config.get("Batteries", "goldBattery", 3031).getInt();
	    	diamondBattery = config.get("Batteries", "diamondBattery", 3032).getInt();
	    	chromaBattery = config.get("Batteries", "ChromaBattery", 3033).getInt();

	    	battleWrench = config.get("Weapons", "battleWrench", 3034).getInt();
	    	
	    	plasticRod = config.get("rods", "plasticRod", 3035).getInt();
	    	reinforcedRod = config.get("rods", "reinforcedRod", 3036).getInt();
	    	titaniumRod = config.get("rods", "titaniumRod", 3037).getInt();
	    	fluxRod = config.get("rods", "fluxRod", 3038).getInt();
	    	
	    	reinforcedIngot = config.get("Items", "reinforcedIngot", 3039).getInt();
	    	titaniumIngot = config.get("Items", "titaniumIngot", 3040).getInt();
	    	plasmaIngot = config.get("Items", "plasmaIngot", 3041).getInt();
	    	fluxIngot = config.get("Items", "fluxIngot", 3042).getInt();
	    	
	    	coalDust = config.get("Items", "CoalDust", 3043).getInt();

	    	metalTransfuser = config.get("Blocks", "MetalTransfuser", 3044).getInt();

	    	oreTitanium = config.get("Blocks", "OreTitanium", 3045).getInt();
	    	oreChroma = config.get("Blocks", "OreChroma", 3046).getInt();
	    	blockTitanium = config.get("Blocks", "BlockTitanium", 3047).getInt();
	    	blockChroma = config.get("Blocks", "BlockChroma", 3048).getInt();
	    	oreTin = config.get("Blocks", "oreTin", 3049).getInt();
	    	oreCopper = config.get("Blocks", "oreCopper", 3050).getInt();
	    	blockTin = config.get("Blocks", "blockTin", 3051).getInt();
	    	blockCopper = config.get("Blocks", "blockCopper", 3052).getInt();
	    	
	    	plateSteel = config.get("Items", "PlateSteel", 3053).getInt();

	    	gearFlux = config.get("Items", "gearFlux", 3054).getInt();
	    	
	    	powerDifficultyModifiers = new int[4];

	        config.addCustomCategoryComment("Updates", "Updates Section");

	        if (config.get("Updates", "shouldCheckForUpdates", true).getBoolean())
	            VersionCheck.start();
	        shouldPrintChangelog = config.get("Updates", "shouldPrintOutChangelog", false).getBoolean();
	        
		}finally{
			
			if(config.hasChanged());
				config.save();
		}
	}
}
