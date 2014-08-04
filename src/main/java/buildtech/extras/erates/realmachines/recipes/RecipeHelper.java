package buildtech.extras.erates.realmachines.recipes;

import java.util.ArrayList;

import buildcraft.BuildCraftCore;
import buildtech.ModBuildTech;
import buildtech.blocks.ModBlocks;
import buildtech.items.ModItems;
import buildtech.recipes.factory.*;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;


public class RecipeHelper {

	private static ArrayList<Recipe> recipeList = new ArrayList<Recipe>();

	public static void registerRecipes()
	{
		/*Fabricating_Machine*/
		registerRecipe(new RecipeFabricatingMachine(new ItemStack(Items.diamond, 1), new ItemStack(BuildCraftCore.goldGearItem), new ItemStack(Items.diamond, 1), new ItemStack(BuildCraftCore.diamondGearItem)));
		registerRecipe(new RecipeFabricatingMachine(new ItemStack(Items.gold_ingot, 1), new ItemStack(BuildCraftCore.ironGearItem), new ItemStack(Items.gold_ingot, 1), new ItemStack(BuildCraftCore.goldGearItem)));
		registerRecipe(new RecipeFabricatingMachine(new ItemStack(Items.iron_ingot, 1), new ItemStack(BuildCraftCore.stoneGearItem), new ItemStack(Items.iron_ingot, 1), new ItemStack(BuildCraftCore.ironGearItem)));
		registerRecipe(new RecipeFabricatingMachine(new ItemStack(Blocks.cobblestone, 1), new ItemStack(BuildCraftCore.woodenGearItem), new ItemStack(Blocks.cobblestone, 1), new ItemStack(BuildCraftCore.stoneGearItem)));
		registerRecipe(new RecipeFabricatingMachine(new ItemStack(Items.stick, 1), new ItemStack(Blocks.planks), new ItemStack(Items.stick, 1), new ItemStack(BuildCraftCore.woodenGearItem)));

		/*Mineral_Compressor*/
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Blocks.coal_ore, 1), new ItemStack(ModItems.dustCoal, 2)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Items.coal, 1),new ItemStack(ModItems.dustCoal, 1)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Blocks.iron_ore, 1), new ItemStack(ModItems.dustIron, 2)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Items.iron_ingot, 1),new ItemStack(ModItems.dustIron, 1)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Blocks.gold_ore, 1), new ItemStack(ModItems.dustGold, 2)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Items.gold_ingot, 1),new ItemStack(ModItems.dustGold, 1)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Blocks.diamond_ore, 1), new ItemStack(ModItems.dustDiamond, 2)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Items.diamond, 1),new ItemStack(ModItems.dustDiamond, 1)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Blocks.emerald_ore, 1), new ItemStack(ModItems.dustEmerald, 2)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Items.emerald, 1),new ItemStack(ModItems.dustEmerald, 1)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Blocks.lapis_ore), new ItemStack(Items.dye, 4)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(Blocks.redstone_ore), new ItemStack(Items.redstone, 4)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(ModBlocks.oreTitanium), new ItemStack(ModItems.dustTitanium, 2)));
		registerRecipe(new RecipeMineralCompressor(new ItemStack(ModItems.ingotTitanium), new ItemStack(ModItems.dustTitanium, 1)));

		/*Mechanical_Furnace*/
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.iron_ore), new ItemStack(Items.iron_ingot)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.gold_ore), new ItemStack(Items.gold_ingot)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.coal_ore), new ItemStack(Items.coal)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.diamond_ore), new ItemStack(Items.diamond)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.lapis_ore), new ItemStack(Items.dye, 2)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.redstone_ore), new ItemStack(Items.redstone, 2)));


		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(ModItems.dustGold), new ItemStack(Items.gold_ingot)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(ModItems.dustIron), new ItemStack(Items.iron_ingot)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(ModItems.dustTitanium), new ItemStack(ModItems.ingotTitanium)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(ModBlocks.oreTitanium), new ItemStack(ModItems.ingotTitanium)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(ModItems.dustReinforced), new ItemStack(ModItems.ingotReinforced)));

		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Items.potato), new ItemStack(Items.baked_potato)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Items.porkchop), new ItemStack(Items.cooked_porkchop)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Items.beef), new ItemStack(Items.cooked_beef)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Items.chicken), new ItemStack(Items.cooked_chicken)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.stone)));
		registerRecipe(new RecipeMechanicalFurnace(new ItemStack(Blocks.log), new ItemStack(Items.coal)));

		/*Metallurgic_Infuser*/
		registerRecipe(new RecipeMetallurgicInfuser(new ItemStack(ModItems.dustCoal), new ItemStack(Items.coal)));
		registerRecipe(new RecipeMetallurgicInfuser(new ItemStack(ModItems.dustChroma), new ItemStack(ModItems.ingotChroma)));
		registerRecipe(new RecipeMetallurgicInfuser(new ItemStack(ModItems.ingotChroma), new ItemStack(ModItems.ingotFlux)));
		registerRecipe(new RecipeMetallurgicInfuser(new ItemStack(ModBlocks.oreChroma), new ItemStack(ModItems.ingotChroma)));

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