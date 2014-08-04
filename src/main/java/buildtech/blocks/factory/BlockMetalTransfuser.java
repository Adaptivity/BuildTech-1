package buildtech.blocks.factory;

import buildcraft.core.IItemPipe;
import buildcraft.core.utils.Utils;
import buildtech.ModBuildTech;
import buildtech.libs.Book;
import buildtech.libs.CreativeTabBuildTech;
import buildtech.utils.BuildTechUtilities;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockMetalTransfuser extends BlockContainer
{
	IIcon textureFront;
	IIcon textureTop;
	IIcon textureSide;
	IIcon textureBack;
	IIcon textureBottom;

	public BlockMetalTransfuser(int x,Block block) 
	{
		super(Material.iron);
		setCreativeTab(CreativeTabBuildTech.BTBlockTab);
		setHardness(3.0F);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) 
	{

		if (player.isSneaking()) return false;

		if (player.getCurrentEquippedItem() != null) 
		{
			if (player.getCurrentEquippedItem().getItem() instanceof IItemPipe) return false;
		}

		if (!world.isRemote) FMLNetworkHandler.openGui(player, ModBuildTech.instance, Book.guiMetallurgicInfuser, world, x, y, z);

		return true;
	}

	@Override
	public IIcon getIcon(int i, int j) 
	{
		if (j == 0 && i == 3)
			return textureFront;

		if (i == j && i > 1)
			return textureFront;

		switch (i) {
		case 0:
			return textureBottom;
		case 1:
			return textureTop;
		default:
			return textureSide;
		}
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) 
	{
		textureFront = par1IconRegister.registerIcon("buildtech:metallurgicInfuser_front");
		textureSide = par1IconRegister.registerIcon("buildtech:gearmachine_sides");
		textureTop = par1IconRegister.registerIcon("buildtech:gearmachine_bottom");
		textureBack = par1IconRegister.registerIcon("buildtech:gearmachine_back");
		textureBottom = par1IconRegister.registerIcon("buildtech:gearmachine_bottom");
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) 
	{
		return new TileMetallurgicInfuser();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) 
	{
	      TileMetallurgicInfuser infuser = (TileMetallurgicInfuser) world.getTileEntity(x, y, z);
	        infuser.openInventory();
	        for (int t = 0; t < 2; t++){
	            ItemStack stack = infuser.getStackInSlot(t);
	            if (stack != null) {
	            	infuser.setInventorySlotContents(t, null);
	                BuildTechUtilities.dropItemstack(world, x, y, z, stack);
	            }
	        }
	        infuser.closeInventory();
	        super.breakBlock(world, x, y, z, block, meta);
	}

	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack stack) 
	{
		ForgeDirection orientation = Utils.get2dOrientation(entityliving);
		world.setBlockMetadataWithNotify(i, j, k, orientation.getOpposite().ordinal(),1);
	}
}
