package buildtech.libs;

import java.util.Locale;

import net.minecraft.creativetab.*;
import net.minecraft.init.*;
import net.minecraft.item.*;
import buildcraft.transport.*;
import buildtech.blocks.ModBlocks;
import buildtech.items.ModItems;

public class CreativeTabBuildTech 
{
	public static CreativeTabs BTItemTab = new CreativeTabs("BTItemTab")
	 {

		@Override
		public Item getTabIconItem() 
		{
			return new ItemStack(ModItems.titaniumRod).getItem();
		}	 
	 };
	
	 public static CreativeTabs BTBlockTab = new CreativeTabs("BTBlockTab")
	 {

		@Override
		public Item getTabIconItem() 
		{
			return new ItemStack(ModBlocks.fabricatingMachine).getItem();
		}	 
	 };
	 
	public static void CreativeTabInit()
	{
	 //Creative Tab-Items
	 CreativeTabs BTItemTab = new CreativeTabs("BTItemTab")
	 {

		@Override
		public Item getTabIconItem() 
		{
			return ModItems.plasmaRod;
		}	 
	 };
	 
	 //Creative Tab-Block
	 CreativeTabs BTBlockTab = new CreativeTabs("BTBlockTab")
	 {

		@Override
		public Item getTabIconItem() 
		{
			return null;
		}	 
	 };
	}
}