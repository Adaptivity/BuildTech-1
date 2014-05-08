/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for BuildCraft, a mod for MineCraft
 */
package buildtech.proxies;


import java.util.Random;

import buildtech.factory.TileChromaCell;
import buildtech.fluids.TileChromaTank;
import buildtech.recipes.GearPlatingRecipes;
import buildtech.renderers.RenderChromaCell;
import buildtech.renderers.RenderChromaTank;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy{ 
	
	public void registerRenders(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileChromaTank.class, new RenderChromaTank());

	}
}
