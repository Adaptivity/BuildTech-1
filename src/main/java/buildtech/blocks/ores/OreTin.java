package buildtech.blocks.ores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import buildtech.blocks.ModBlocks;
import buildtech.libs.CreativeTabBuildTech;

public class OreTin extends Block
{
	public OreTin(Material m, int x, Block b) 
	{
		super(Material.rock);
		setCreativeTab(CreativeTabBuildTech.BTBlockTab);
		setHardness(20.0F);
	}
	
	public Block idDropped(int par1, Random random, int par2) 
	{
        return ModBlocks.oreTin;
    }
}
