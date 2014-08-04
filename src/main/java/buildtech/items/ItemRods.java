package buildtech.items;

import java.util.List;

import cpw.mods.fml.relauncher.*;
import buildtech.libs.Book;
import buildtech.libs.CreativeTabBuildTech;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.IIcon;

public class ItemRods extends Item
{
	IIcon icon;
	
	public ItemRods(int n,Item item)
	{
		setCreativeTab(CreativeTabBuildTech.BTItemTab);
	}	
}
