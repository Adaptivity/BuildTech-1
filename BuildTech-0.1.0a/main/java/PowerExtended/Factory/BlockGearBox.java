/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package PowerExtended.Factory;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import PowerExtended.ModBuildTech;
import PowerExtended.Api.BlockContainerTags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockGearBox extends Block{

	public BlockGearBox(Material p_i45386_1_) {
		super(Material.wood);
		setCreativeTab(ModBuildTech.CreativeTabPowerExtended);
	}
	@SideOnly(Side.CLIENT)
	
	IIcon texture;
	
	@Override
	public IIcon getIcon(int i, int j) {

		if (j == 0 && i == 3) {
			return texture;
		}

		if (i == j && i > 1) {
			return texture;
		}

		switch (i) {
		case 0:
			return texture;
		case 1:
			return texture;
		default:
			return texture;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		texture = par1IconRegister.registerIcon(ModBuildTech.MODID + ":" + "gear_box");
	}
}
