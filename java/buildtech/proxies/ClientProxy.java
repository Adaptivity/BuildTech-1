/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech.proxies;


import java.util.Random;

import buildcraft.BuildCraftCore;
import buildcraft.core.render.RenderRobot;
import buildtech.recipes.GearPlatingRecipes;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy{


	
	public static void addGearRecipe(Item Item,ItemStack itemStack) {
		
	}

	private static void addGearRecipe(GearPlatingRecipes gearPlatingRecipes) {

		
	}

	public static void loadRecipes(){
		
		addGearRecipe(new GearPlatingRecipes(new ItemStack(Items.stick), new ItemStack(Blocks.planks), new ItemStack(Items.stick), new ItemStack(BuildCraftCore.woodenGearItem)));

	}
	

	//Planned for the future
/*
   public static void addFreezerRecipe(Block block, ItemStack result){
   //Wild Example
 		addFreezerRecipe(Blocks.water, new ItemStack(Blocks.ice));
 		addFreezerRecipe(Blocks.sapling, new ItemStack(Items.stick, 2));
 		}
 */
 
  
  
  	
 
	
	
}
