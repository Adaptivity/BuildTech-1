package buildtech.items;

import java.util.HashSet;
import java.util.Set;


import buildcraft.api.tools.IToolWrench;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public abstract class CraftingDrillDamage extends Item implements IToolWrench
{
	private final Set<Class<? extends Block>> shiftRotations = new HashSet<Class<? extends Block>>();

    public CraftingDrillDamage(int par1)
    {
        super();
        setMaxStackSize(1);
        setNoRepair();
        setFull3D();
		setMaxStackSize(1);
		shiftRotations.add(BlockLever.class);
		shiftRotations.add(BlockButton.class);
		shiftRotations.add(BlockChest.class);
		shiftRotations.add(BlockTorch.class);
    }


  @Override
public ItemStack getContainerItem(ItemStack stack) {
    ItemStack result = stack.copy();
    result.setItemDamage(stack.getItemDamage() + 1);
	return result;
}

@Override
public boolean hasContainerItem(ItemStack stack) {
    return stack.getItemDamage() < stack.getMaxDamage();
	}

private boolean isShiftRotation(Class<? extends Block> cls) {
	for (Class<? extends Block> shift : shiftRotations) {
		if (shift.isAssignableFrom(cls))
			return true;
	}
	return false;
}

@Override
public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
	Block block = world.getBlock(x, y, z);

	if(block == null)
		return false;

	if (player.isSneaking() != isShiftRotation(block.getClass()))
		return false;

	if (block.rotateBlock(world, x, y, z, ForgeDirection.getOrientation(side))) {
		player.swingItem();
		return !world.isRemote;
	}
	return false;
}

@Override
public boolean doesSneakBypassUse(World world, int x, int y, int z, EntityPlayer player) {
	return true;
}

}