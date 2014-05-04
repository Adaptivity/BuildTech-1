package buildtech.blocks;

import java.util.Random;



import buildtech.ModBuildTech;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class OreChroma extends BlockOre{

	public OreChroma(Material p_i45394_1_) {
		super();
		setHardness(10.0F);
		}

	 public Item idDropped(int par1, Random random, int par2) {
         return ModBuildTech.ChromaChunk;
 }
	
	
	
	
}
