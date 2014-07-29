package buildtech.libs;

import buildtech.blocks.ModBlocks;
import buildtech.items.ModItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryBuildTech
{
	public static void initOreDicts()
	{
		/*VANILLA|Dusts*/
		OreDictionary.registerOre("dustDiamond", ModItems.dustDiamond);
		OreDictionary.registerOre("dustEmerald", ModItems.dustEmerald);
		OreDictionary.registerOre("dustIron", ModItems.dustIron);
		OreDictionary.registerOre("dustGold", ModItems.dustGold);
		OreDictionary.registerOre("pulpWood", ModItems.pulpWood);
		OreDictionary.registerOre("dustCoal", ModItems.dustCoal);


		/*MOD|Dusts*/
		OreDictionary.registerOre("dustChroma", ModItems.dustChroma);
		OreDictionary.registerOre("dustTitanium", ModItems.dustTitanium);
		OreDictionary.registerOre("dustPlastic", ModItems.dustPlastic);
		
		/*MOD|Ingots*/
		OreDictionary.registerOre("ingotReinforced", ModItems.ingotReinforced);
		OreDictionary.registerOre("ingotTitanium", ModItems.ingotTitanium);
		OreDictionary.registerOre("ingotFlux", ModItems.ingotFlux);
		OreDictionary.registerOre("ingotChroma", ModItems.ingotChroma);
		
		/*MOD|Ores*/
		OreDictionary.registerOre("oreTitanium", ModBlocks.oreTitanium);
		OreDictionary.registerOre("blockTitanium", ModBlocks.blockTitanium);	
		OreDictionary.registerOre("oreChroma", ModBlocks.oreChroma);
		OreDictionary.registerOre("blockChroma", ModBlocks.blockChroma);	
	/*	OreDictionary.registerOre("oreCopper", ModBlocks.oreCopper);
		OreDictionary.registerOre("blockCopper", ModBlocks.blockCopper);	
		OreDictionary.registerOre("oreTin", ModBlocks.oreTin);
		OreDictionary.registerOre("blockTin", ModBlocks.blockTin);
	*/
		
		/*MOD|Plates*/
		OreDictionary.registerOre("plateSteel", ModItems.plateSteel);
	}
}
