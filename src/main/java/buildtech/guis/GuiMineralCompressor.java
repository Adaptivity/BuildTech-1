package buildtech.guis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import buildtech.blocks.factory.*;
import buildtech.containers.*;

public class GuiMineralCompressor extends GuiContainer
{
	private static final ResourceLocation textureBackground = new ResourceLocation("buildtech", "textures/guis/mineralcompressor_gui.png");
	private TileMineralCompressor te;

	public GuiMineralCompressor(InventoryPlayer invPlayer, TileMineralCompressor tile) 
	{
		super(new ContainerMineralCompressor(invPlayer, tile));

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
		fontRendererObj.drawString("Mineral Compressor", 8, 6, 0x404040);

	}
}
