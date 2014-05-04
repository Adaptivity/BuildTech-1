/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class GearPlatingRecipes extends Recipe {

	public GearPlatingRecipes(ItemStack input1, ItemStack input2, ItemStack input3, ItemStack output) {
		super(Recipe.GearMachine, new ItemStack[] { input1, input2, input3 }, output);
	}
}