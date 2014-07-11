package buildtech.blocks.ores;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import buildtech.blocks.ModBlocks;
import buildtech.libs.Book;
import buildtech.libs.CreativeTabBuildTech;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.MinecraftForge;

public class OreTitanium extends Block 
{	
	public OreTitanium(Material m, int x, Block b) 
	{
		super(Material.rock);
		setCreativeTab(CreativeTabBuildTech.BTBlockTab);
		setHardness(20.0F);
	}
	
	public Block idDropped(int par1, Random random, int par2) 
	{
        return ModBlocks.oreTitanium;
    }
}
