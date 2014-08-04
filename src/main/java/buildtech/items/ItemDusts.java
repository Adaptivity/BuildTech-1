package buildtech.items;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import buildtech.extras.aenterprise.buildcraftadditions.items.ItemDust;
import buildtech.extras.aenterprise.buildcraftadditions.utils.DusterRecepies;
import buildtech.libs.CreativeTabBuildTech;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.oredict.OreDictionary;

public class ItemDusts extends Item
{
	IIcon icon;
	ItemDust itemDust;
	public String metal;
	
	public ItemDusts(int n,Item item)
	{
		setCreativeTab(CreativeTabBuildTech.BTItemTab);
	}
	
	public ItemDusts(String metal) 
	{
        this.metal = metal;
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
