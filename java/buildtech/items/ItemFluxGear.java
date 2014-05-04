/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import buildtech.ModBuildTech;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public class ItemFluxGear extends Item{
	
	public ItemFluxGear() {
		setCreativeTab(ModBuildTech.CreativeTabPowerExtended);

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack iStack, EntityPlayer player, List list, boolean visible)
	{
			list.add("Gearing It Up To The Next level");
		
		}

 
	}

