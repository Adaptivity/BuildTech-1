package buildtech.recipes;

import java.util.ArrayList;

import buildcraft.BuildCraftCore;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.registry.GameRegistry;


public class RecipeHelper {

	private static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	public static void registerRecipes() {
		registerRecipe(new GearPlatingRecipes(new ItemStack(Items.diamond, 2), new ItemStack(BuildCraftCore.goldGearItem), new ItemStack(Items.diamond, 2), new ItemStack(BuildCraftCore.diamondGearItem)));
		registerRecipe(new GearPlatingRecipes(new ItemStack(Items.gold_ingot, 2), new ItemStack(BuildCraftCore.ironGearItem), new ItemStack(Items.gold_ingot, 2), new ItemStack(BuildCraftCore.goldGearItem)));
		registerRecipe(new GearPlatingRecipes(new ItemStack(Items.iron_ingot, 2), new ItemStack(BuildCraftCore.stoneGearItem), new ItemStack(Items.iron_ingot, 2), new ItemStack(BuildCraftCore.ironGearItem)));
		registerRecipe(new GearPlatingRecipes(new ItemStack(Blocks.cobblestone, 2), new ItemStack(BuildCraftCore.woodenGearItem), new ItemStack(Blocks.cobblestone, 2), new ItemStack(BuildCraftCore.stoneGearItem)));
		registerRecipe(new GearPlatingRecipes(new ItemStack(Items.stick, 2), new ItemStack(Blocks.planks, 1), new ItemStack(Items.stick, 2), new ItemStack(BuildCraftCore.woodenGearItem)));
	}

	public static void registerRecipe(Recipe recipe) {
		recipeList.add(recipe);
	}

	public static boolean isStackValidForSlot(int recipeType, ItemStack stack, int slotId) {
		for (Recipe recipe : recipeList) {
			if (recipe.getRecipeType() == recipeType) {
				ItemStack inputFromRecipe = recipe.getInputItemStack(slotId);
				if (inputFromRecipe != null) {
					if (inputFromRecipe.getUnlocalizedName().equals(stack.getUnlocalizedName())) return true;
				}
			}
		}

		return false;
	}

	public static Recipe getValidRecipe(int recipeType, ItemStack[] inputItemStack) {
		return getValidRecipe(recipeType, inputItemStack, null);
	}

	public static Recipe getValidRecipe(int recipeType, FluidStack[] inputFluidStack) {
		return getValidRecipe(recipeType, null, inputFluidStack);
	}

	public static Recipe getValidRecipe(int recipeType, ItemStack[] inputItemStack, FluidStack[] inputFluidStack) {
		for (Recipe recipe : recipeList) {
			if (recipe.getRecipeType() == recipeType) {
				boolean itemsOk = false;
				boolean fluidsOk = false;
				if (inputItemStack != null) {
					boolean[] validItems = new boolean[inputItemStack.length];
					if (inputItemStack.length == recipe.getInputItemStackCount()) {

						for (int i = 0; i < inputItemStack.length; i++) {
							if (inputItemStack[i] == null) {
								validItems[i] = false;
								break;
							}
							if (inputItemStack[i].getUnlocalizedName().equals(recipe.getInputItemStack(i).getUnlocalizedName()) && inputItemStack[i].stackSize >= recipe.getInputItemStack(i).stackSize) {
								validItems[i] = true;
							} else {
								validItems[i] = false;
							}
						}

						boolean containsFalseItems = false;
						for (boolean bo : validItems) {
							if (!bo) {
								containsFalseItems = true;
								break;
							}
						}
						if (!containsFalseItems) itemsOk = true;

						if (inputFluidStack != null) {
							if (inputFluidStack.length == recipe.getInputFluidStackCount()) {
								boolean[] validFluids = new boolean[inputFluidStack.length];
								if (inputFluidStack.length == recipe.getInputFluidStackCount()) {

									for (int i = 0; i < inputFluidStack.length; i++) {
										if (inputFluidStack[i] == null) {
											validFluids[i] = false;
											break;
										}
										if (inputFluidStack[i].getFluid().getUnlocalizedName().equals(recipe.getInputFluidStack(i).getFluid().getUnlocalizedName()) && inputFluidStack[i].amount >= recipe.getInputFluidStack(i).amount) {
											validFluids[i] = true;
										} else {
											validFluids[i] = false;
										}
									}

									boolean containsFalseFluids = false;
									for (boolean bo : validFluids) {
										if (!bo) {
											containsFalseFluids = true;
											break;
										}
									}
									if (!containsFalseFluids) fluidsOk = true;
								}
							}
						} else {
							if (recipe.getInputFluidStackCount() == 0) {
								fluidsOk = true;
							}
						}
					}
				} else {
					if (recipe.getInputItemStackCount() == 0) {
						itemsOk = true;
					}

					if (inputFluidStack != null) {
						if (inputFluidStack.length == recipe.getInputFluidStackCount()) {
							boolean[] validFluids = new boolean[inputFluidStack.length];
							if (inputFluidStack.length == recipe.getInputFluidStackCount()) {

								for (int i = 0; i < inputFluidStack.length; i++) {
									if (inputFluidStack[i] == null) {
										validFluids[i] = false;
										break;
									}
									if (inputFluidStack[i].getFluid().getUnlocalizedName().equals(recipe.getInputFluidStack(i).getFluid().getUnlocalizedName())) {
										validFluids[i] = true;
									} else {
										validFluids[i] = false;
									}
								}

								boolean containsFalseFluids = false;
								for (boolean bo : validFluids) {
									if (!bo) {
										containsFalseFluids = true;
										break;
									}
								}
								if (!containsFalseFluids) fluidsOk = true;
							}
						}
					} else {
						if (recipe.getInputFluidStackCount() == 0) {
							fluidsOk = true;
						}
					}
				}

				if (itemsOk && fluidsOk) return recipe;
			}
		}
		return null;
	}

	public static ItemStack getRecipeOutput(int recipeType, ItemStack[] inputItemStack) {
		Recipe recipe = getValidRecipe(recipeType, inputItemStack, null);
		if (recipe == null) return null;
		return recipe.getOutputItemStack();
	}

	public static ItemStack getRecipeOutput(int recipeType, FluidStack[] inputFluidStack) {
		Recipe recipe = getValidRecipe(recipeType, null, inputFluidStack);
		if (recipe == null) return null;
		return recipe.getOutputItemStack();
	}

	public static ItemStack getRecipeOutput(int recipeType, ItemStack[] inputItemStack, FluidStack[] inputFluidStack) {
		Recipe recipe = getValidRecipe(recipeType, inputItemStack, inputFluidStack);
		if (recipe == null) return null;
		return recipe.getOutputItemStack();
	}
}