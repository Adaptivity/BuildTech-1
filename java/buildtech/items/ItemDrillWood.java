package buildtech.items;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import buildcraft.api.mj.MjBattery;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import buildtech.ModBuildTech;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockLever;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ItemDrillWood extends CraftingDrillDamage {

	IIcon texture;
	private final Set<Class<? extends Block>> shiftRotations = new HashSet<Class<? extends Block>>();

	public ItemDrillWood(int par1) {
		super(par1);
		setMaxDamage(6);
        setCreativeTab(ModBuildTech.CreativeTabPowerExtended);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean visible)
	{
			list.add("6 Uses");
		
		}

	@Override
	public boolean canWrench(EntityPlayer player, int x, int y, int z) {

		return false;
	}

	@Override
	public void wrenchUsed(EntityPlayer player, int x, int y, int z) {
		
	}

}
