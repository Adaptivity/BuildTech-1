package buildtech.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public abstract class Recipe {

	private ItemStack[] inputItemStacks;
	private FluidStack[] inputFluidStacks;
	private ItemStack outputItemStack;
	private int recipeType;


	
	public static final int GearMachine = 1;
	public static final int HydroMb = 2;
	public static final int EnchantTable = 3;

	
	public Recipe(int recipeType, ItemStack[] inputItemStacks, ItemStack outputItemStack) {
		this.recipeType = recipeType;
		this.inputItemStacks = inputItemStacks;
		this.inputFluidStacks = null;
		this.outputItemStack = outputItemStack;
	}

	public Recipe(int recipeType, ItemStack[] inputItemStacks, FluidStack[] inputFluids, ItemStack outputItemStack) {
		this.recipeType = recipeType;
		this.inputItemStacks = inputItemStacks;
		this.inputFluidStacks = inputFluids;
		this.outputItemStack = outputItemStack;
	}

	public Recipe(int recipeType, FluidStack[] inputFluids, ItemStack outputItemStack) {
		this.recipeType = recipeType;
		this.inputItemStacks = null;
		this.inputFluidStacks = inputFluids;
		this.outputItemStack = outputItemStack;
	}

	public int getRecipeType() {
		return recipeType;
	}

	public ItemStack getInputItemStack(int i) {
		return inputItemStacks != null ? (inputItemStacks.length > i ? inputItemStacks[i] : null) : null;
	}

	public FluidStack getInputFluidStack(int i) {
		return inputFluidStacks != null ? (inputFluidStacks.length > i ? inputFluidStacks[i] : null) : null;
	}

	public ItemStack getOutputItemStack() {
		return outputItemStack.copy();
	}

	public int getInputItemStackCount() {
		return inputItemStacks != null ? inputItemStacks.length : 0;
	}

	public int getInputFluidStackCount() {
		return inputFluidStacks != null ? inputFluidStacks.length : 0;
	}
	
}