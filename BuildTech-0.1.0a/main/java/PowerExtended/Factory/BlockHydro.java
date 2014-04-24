package PowerExtended.Factory;

import PowerExtended.ModBuildTech;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockHydro extends Block{
	IIcon texture;

	public BlockHydro(Material p_i45386_1_) {
		super(Material.iron);
		setHardness(5F);
		setResistance(10F);
	}

	
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
		texture = par1IconRegister.registerIcon(ModBuildTech.MODID + ":" + "hydroblock");
	}
}
