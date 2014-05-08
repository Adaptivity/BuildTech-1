package buildtech.factory;

import buildcraft.core.IItemPipe;
import buildcraft.core.utils.Utils;
import buildtech.ModBuildTech;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockChromaCell extends Block {

	public BlockChromaCell(Material p_i45394_1_) {
		super(Material.iron);
		this.setLightLevel(1.0F);

	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

		if (player.isSneaking()) return false;

		if (player.getCurrentEquippedItem() != null) {
			if (player.getCurrentEquippedItem().getItem() instanceof IItemPipe) return false;
		}

		if (!world.isRemote) FMLNetworkHandler.openGui(player, ModBuildTech.instance, ModBuildTech.GuiGearPlating, world, x, y, z);

		return true;
	}
	
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileChromaCell(textureName, var2);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof IInventory) {
			IInventory inventory = (IInventory) te;

			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				ItemStack stack = inventory.getStackInSlotOnClosing(i);

				if (stack != null) {
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = z + world.rand.nextFloat();

					EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);

					float mult = 0.05f;

					droppedItem.motionX = (-0.5f + world.rand.nextFloat()) * mult;
					droppedItem.motionY = (4f + world.rand.nextFloat()) * mult;
					droppedItem.motionZ = (-0.5f + world.rand.nextFloat()) * mult;

					world.spawnEntityInWorld(droppedItem);
				}
			}
		}

		super.breakBlock(world, x, x, z, block, meta);
	}

	
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack stack) {
		ForgeDirection orientation = Utils.get2dOrientation(entityliving);
		world.setBlockMetadataWithNotify(i, j, k, orientation.getOpposite().ordinal(),1);
	}
	
	public int getRenderType() {
		return -1;
	} 
		
	public boolean isOpaqueCube(){
		return false;
		}
	public boolean renderAsNormalBlock(){
		return false;
	}


}
