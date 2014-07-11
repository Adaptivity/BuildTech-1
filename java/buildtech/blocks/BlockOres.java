package buildtech.blocks;

import buildtech.libs.CreativeTabBuildTech;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockOres extends Block
{
	public BlockOres(Material m, int x, Block block) 
	{
		super(m.rock);
		setCreativeTab(CreativeTabBuildTech.BTBlockTab);
		setHardness(20F);
	}
}
