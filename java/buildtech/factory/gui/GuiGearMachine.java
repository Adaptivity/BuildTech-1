package buildtech.factory.gui;

import org.lwjgl.opengl.GL11;

import buildcraft.BuildCraftCore;
import buildcraft.core.CoreIconProvider;
import buildcraft.core.utils.Utils;
import buildtech.factory.TileGearMachine;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiGearMachine extends GuiContainer {

	private static final ResourceLocation textureBackground = new ResourceLocation("buildtech", "textures/guis/gear_gui.png");
	private TileGearMachine te;

	public GuiGearMachine(InventoryPlayer invPlayer, TileGearMachine tile) {
		super(new ContainerGearMachine(invPlayer, tile));

		this.te = tile;

		xSize = 176;
		ySize = 185;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1, 1, 1, 1);

		Minecraft.getMinecraft().renderEngine.bindTexture(textureBackground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	}

	@Override
	protected void drawGuiContainerForegroundLayer(int x, int y) {
		fontRendererObj.drawString("Gearing Machine", 8, 6, 0x404040);

	}
	
	
}