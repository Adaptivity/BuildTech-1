package buildtech.items;

import java.util.List;

import buildtech.ModBuildTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemDrillEmpty extends Item{

	
IIcon texture;
	
	public ItemDrillEmpty(int par1) {
		super();
		setMaxDamage(64);
        setCreativeTab(ModBuildTech.CreativeTabPowerExtended);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean visible)
	{
			list.add("Equipe with a Battery to start using!");
		
		}

	
}
