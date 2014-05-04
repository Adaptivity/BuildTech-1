package buildtech.factory.gui;


import buildtech.ModBuildTech;
import buildtech.factory.TileGearMachine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;


public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(ModBuildTech.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te;
		switch (ID) {
			case ModBuildTech.GuiGearPlating:
				te = world.getTileEntity(x, y, z);
				if (te != null && te instanceof TileGearMachine) { return new ContainerGearMachine(player.inventory, (TileGearMachine) te); }
				break;
			
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te;
		switch (ID) {
			case ModBuildTech.GuiGearPlating:
				te = world.getTileEntity(x, y, z);
				if (te != null && te instanceof TileGearMachine) { return new GuiGearMachine(player.inventory, (TileGearMachine) te); }
				break;
		
		}

		return null;
	}

}