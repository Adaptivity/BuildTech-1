package buildtech.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import buildtech.extras.aenterprise.buildcraftadditions.items.ItemDust;
import buildtech.libs.CreativeTabBuildTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemIngots extends Item
{
	IIcon icon;
	ItemDust itemDust;
	public String metal;
	
	public ItemIngots(int n,Item item)
	{
		setCreativeTab(CreativeTabBuildTech.BTItemTab);
	}
	
	@SuppressWarnings(
			{ "rawtypes", "unchecked" 
			})
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean visible)
	{	
		list.add("BuildTech");
		}
}
