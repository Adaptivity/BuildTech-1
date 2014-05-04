package buildtech.items;

import java.util.List;

import buildtech.ModBuildTech;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemDrillDiamond extends CraftingDrillDamage{

	IIcon texture;
	
	public ItemDrillDiamond(int par1) {
		super(par1);
		setMaxDamage(64);
        setCreativeTab(ModBuildTech.CreativeTabPowerExtended);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean visible)
	{
			list.add("64 Uses");
		
		}

	@Override
	public boolean canWrench(EntityPlayer player, int x, int y, int z) {

		return true;
	}

	@Override
	public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
		wrenchUsed(player, x, y, z);
		
	}

}
