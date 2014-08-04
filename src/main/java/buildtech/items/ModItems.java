package buildtech.items;

import buildtech.configuration.ConfigHandler;
import buildtech.items.rods.*;
import buildtech.libs.Book;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems
{
	//Tiers of Rods//
	public static Item plasticRod;

	public static Item reinforcedRod;
		
	public static Item titaniumRod;
	
	public static Item plasmaRod;
	
	public static Item fluxRod;
	
	//Types of Dusts//
	public static Item dustCoal;
	
	public static Item pulpWood;
	
	public static Item dustPlastic;
	
	public static Item dustIron;
	
	public static Item dustReinforced;
	
	public static Item dustTitanium;
	
	public static Item dustGold;
	
	public static Item dustDiamond;
	
	public static Item dustEmerald;
	
	public static Item dustChroma;
	
	//Tiers of batteries//		
	public static Item ironBattery;
	
	public static Item goldBattery;
	
	public static Item diamondBattery;
		
	public static Item chromaBattery;
	
	//Types of Ingots//
	public static Item ingotReinforced;
	
	public static Item ingotTitanium;
	
	public static Item ingotFlux;
		
	public static Item ingotChroma;

	//Types of Plates//
	public static Item plateSteel;
	
	//Other//
	public static Item gearFlux;
	
	public static void ItemInit()
	{
		/*Rods*/
		plasticRod = new PlasticRod(ConfigHandler.plasticRod, plasticRod)
		.setUnlocalizedName("plasticRod");
		
		reinforcedRod = new ReinforcedRod(ConfigHandler.reinforcedRod, reinforcedRod)
		.setUnlocalizedName("reinforcedRod");
		
		titaniumRod = new TitaniumRod(ConfigHandler.titaniumRod, reinforcedRod)
		.setUnlocalizedName("titaniumRod");
		
		fluxRod = new FluxRod(ConfigHandler.fluxRod, fluxRod)
		.setUnlocalizedName("fluxRod");
		
		/*Dusts*/
		dustCoal = new ItemDusts(ConfigHandler.coalDust, dustCoal)
		.setUnlocalizedName("coalDust")
		.setTextureName(Book.MODID + ":" + "coalDust");
		
		pulpWood = new ItemDusts(ConfigHandler.woodPulp, pulpWood)
		.setUnlocalizedName("woodPulp")
		.setTextureName(Book.MODID + ":" + "woodPulp");
		
		dustPlastic = new ItemDusts(ConfigHandler.plasticDust, dustPlastic)
		.setUnlocalizedName("plasticDust")
		.setTextureName(Book.MODID + ":" + "plasticDust");
		
		dustIron = new ItemDusts(ConfigHandler.ironDust, dustIron)
		.setUnlocalizedName("ironDust")
		.setTextureName(Book.MODID + ":" + "ironDust");
		
		dustTitanium = new ItemDusts(ConfigHandler.titaniumDust, dustTitanium)
		.setUnlocalizedName("titaniumDust")
		.setTextureName(Book.MODID + ":" + "titaniumDust");
		
		dustGold = new ItemDusts(ConfigHandler.goldDust, dustGold)
		.setUnlocalizedName("goldDust")
		.setTextureName(Book.MODID + ":" + "goldDust");
		
		dustDiamond = new ItemDusts(ConfigHandler.diamondDust, dustDiamond)
		.setUnlocalizedName("diamondDust")
		.setTextureName(Book.MODID + ":" + "diamondDust");
		
		dustEmerald = new ItemDusts(ConfigHandler.emeraldDust, dustEmerald)
		.setUnlocalizedName("emeraldDust")
		.setTextureName(Book.MODID + ":" + "emeraldDust");
		
		dustChroma = new ItemDusts(ConfigHandler.chromaDust, dustChroma)
		.setUnlocalizedName("chromaDust")
		.setTextureName(Book.MODID + ":" + "chromaDust");
		
		ingotReinforced = new ItemIngots(ConfigHandler.reinforcedIngot, ingotReinforced)
		.setUnlocalizedName("ingotReinforced")
		.setTextureName(Book.MODID + ":" + "ingotReinforced");
		
		ingotTitanium = new ItemIngots(ConfigHandler.titaniumIngot, ingotTitanium)
		.setUnlocalizedName("ingotTitanium")
		.setTextureName(Book.MODID + ":" + "ingotTitanium");
		
		ingotFlux = new ItemIngots(ConfigHandler.fluxIngot, ingotFlux)
		.setUnlocalizedName("ingotFlux")
		.setTextureName(Book.MODID + ":" + "ingotFlux");
		
		ingotChroma = new ItemIngots(ConfigHandler.chromaIngot, ingotChroma)
		.setUnlocalizedName("ingotChroma")
		.setTextureName(Book.MODID + ":" + "chromaingot");
		
		plateSteel = new ItemIngots(ConfigHandler.plateSteel, plateSteel)
		.setUnlocalizedName("plateSteel")
		.setTextureName(Book.MODID + ":" + "plateSteel");
		
		gearFlux = new ItemIngots(ConfigHandler.gearFlux, gearFlux)
		.setUnlocalizedName("gearFlux")
		.setTextureName(Book.MODID + ":" + "fluxgear");
		
		/*Batteries*/
/*		ironBattery = new ItemBatteries(ConfigHandler.ironBattery, ironBattery)
		.setUnlocalizedName("ironBattery");
		
		goldBattery = new ItemDusts(ConfigHandler.goldBattery, goldBattery)
		.setUnlocalizedName("goldBattery");
		
		diamondBattery = new ItemDusts(ConfigHandler.diamondBattery, diamondBattery)
		.setUnlocalizedName("diamondBattery");
		
		chromaBattery = new ItemDusts(ConfigHandler.chromaBattery, chromaBattery)
		.setUnlocalizedName("chromaBattery");
*/
		
		
	}
	
	public static void ItemRegistry()
	{
		GameRegistry.registerItem(plasticRod, "plasticRod");
		GameRegistry.registerItem(reinforcedRod, "reinforcedRod");
		GameRegistry.registerItem(titaniumRod, "titaniumRod");
		GameRegistry.registerItem(fluxRod, "fluxRod");
		
		GameRegistry.registerItem(dustCoal, "coalDust");
		GameRegistry.registerItem(pulpWood, "woodPulp");
		GameRegistry.registerItem(dustPlastic, "plasticDust");
		GameRegistry.registerItem(dustIron, "ironDust");
		GameRegistry.registerItem(dustTitanium, "titaniumDust");
		GameRegistry.registerItem(dustGold, "goldDust");
		GameRegistry.registerItem(dustDiamond, "diamondDust");
		GameRegistry.registerItem(dustEmerald, "emeraldDust");
		GameRegistry.registerItem(dustChroma, "chromaDust");
		
		GameRegistry.registerItem(ingotReinforced, "ingotReinforced");
		GameRegistry.registerItem(ingotTitanium, "ingotTitanium");
		GameRegistry.registerItem(ingotFlux, "ingotFlux");
		GameRegistry.registerItem(ingotChroma, "ingotChroma");
		
		GameRegistry.registerItem(plateSteel, "plateSteel");
		
		GameRegistry.registerItem(gearFlux, "gearFlux");

	/*	
		GameRegistry.registerItem(ironBattery, "ironBattery");
		GameRegistry.registerItem(goldBattery, "goldBattery");
		GameRegistry.registerItem(diamondBattery, "diamondBattery");
		GameRegistry.registerItem(chromaBattery, "chromaBattery");
	*/
	}
}
