package buildtech.guis;

import org.lwjgl.opengl.GL11;

import buildcraft.BuildCraftCore;
import buildcraft.core.CoreIconProvider;
import buildcraft.core.utils.Utils;
import buildtech.blocks.factory.*;
import buildtech.containers.ContainerFabricatingMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiFabricatingMachine extends GuiContainer 
{
	private static final ResourceLocation textureBackground = new ResourceLocation("buildtech", "textures/guis/gear_gui.png");
	private TileFabricatingMachine te;

	public GuiFabricatingMachine(InventoryPlayer invPlayer, TileFabricatingMachine tile) 
	{
		super(new ContainerFabricatingMachine(invPlayer, tile));

		this.te = tile;

		xSize = 176;
		ySize = 185;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		GL11.glColor4f(1, 1, 1, 1);

		Minecraft.getMinecraft().renderEngine.bindTexture(textureBackground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		 int k = (this.width - this.xSize) / 2;
		 int l = (this.height - this.ySize) / 2;
		 this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
		 int i1;

		        i1 = this.te.getCookProgressScaled(24);
		        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		   
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString("Fabricating Machine", 8, 6, 0x404040);

	}
}