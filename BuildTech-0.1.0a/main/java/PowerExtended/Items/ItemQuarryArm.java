package PowerExtended.Items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import PowerExtended.ModBuildTech;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class ItemQuarryArm extends Item{
	
	public ItemQuarryArm() {
		setCreativeTab(ModBuildTech.CreativeTabPowerExtended);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean visible)
	{
			list.add("The Arm of The Quarry, NOT YOURS!");
		
		}

 
	}

