/**
 * This work is licensed under the MMPL Mod License.
 * You can find more information about the MMPL license here:
 * http://www.mod-buildcraft.com/MMPL-1.0.txt
 *
 * This file is a property of BuildTech made by UniversalRed for Buildcraft, a Minecraft Mod
 */
package PowerExtended.Energy.Gui;



import buildcraft.core.GuiIds;
import buildcraft.factory.gui.ContainerAutoWorkbench;
import buildcraft.factory.gui.GuiAutoCrafting;
import PowerExtended.ModBuildTech;
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
       TileEntity entity = world.getTileEntity(x, y, z);
       if (!world.blockExists(x, y, z))
			return null;

		TileEntity tile = world.getTileEntity(x, y, z);

		switch (ID) {

	//	case GuiIDs.GuiGearPlating:
		//	if (!(tile instanceof TileGearPlatingMachine))
		//		return null;
	//		return new GuiGearPlatingMachine(player.inventory, (TileGearPlatingMachine) tile);
       
		default:
			return null;
		}
    }


    
    
    

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
       TileEntity entity = world.getTileEntity(x, y, z);
       if (!world.blockExists(x, y, z))
			return null;

		TileEntity tile = world.getTileEntity(x, y, z);

		switch (ID) {

		//case GuiIDs.GuiGearPlating:
		//	if (!(tile instanceof TileGearPlatingMachine))
		//		return null;
		//	return new ContainerGearPlatingMachine(player.inventory, (TileGearPlatingMachine) tile);
                  
		default:
			return null;   
            

       }
    }  
}