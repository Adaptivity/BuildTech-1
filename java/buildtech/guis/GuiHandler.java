package buildtech.guis;

import buildtech.ModBuildTech;
import buildtech.blocks.factory.*;
import buildtech.containers.*;
import buildtech.libs.Book;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.*;


public class GuiHandler implements IGuiHandler 
{

	public GuiHandler() 
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(ModBuildTech.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{

		TileEntity te = world.getTileEntity(x, y, z);
		
		switch (ID) 
		{
			case Book.guiFabricatingMachine:
				if (te instanceof TileFabricatingMachine)
					return new ContainerFabricatingMachine(player.inventory, (TileFabricatingMachine) te); 
				
			case Book.guiMineralCompressor:
				if (te instanceof TileMineralCompressor)
					return new ContainerMineralCompressor(player.inventory, (TileMineralCompressor) te); 
				
			case Book.guiMechanicalFurnace:
				if (te instanceof TileMechanicalFurnace)
					return new ContainerMechanicalFurnace(player.inventory, (TileMechanicalFurnace) te); 
				
			case Book.guiMetallurgicInfuser:
				if (te instanceof TileMetallurgicInfuser)
					return new ContainerMetallurgicInfuser(player.inventory, (TileMetallurgicInfuser) te); 
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{

		TileEntity te = world.getTileEntity(x, y, z);

		switch (ID) 
		{
			case Book.guiFabricatingMachine:
				if (te instanceof TileFabricatingMachine)
					return new GuiFabricatingMachine(player.inventory, (TileFabricatingMachine) te);
		
			case Book.guiMineralCompressor:
				if (te instanceof TileMineralCompressor)
					return new GuiMineralCompressor(player.inventory, (TileMineralCompressor) te);
				
			case Book.guiMechanicalFurnace:
				if (te instanceof TileMechanicalFurnace)
					return new GuiMechanicalFurnace(player.inventory, (TileMechanicalFurnace) te);
				
			case Book.guiMetallurgicInfuser:
				if (te instanceof TileMetallurgicInfuser)
					return new GuiMetallurgicInfuser(player.inventory, (TileMetallurgicInfuser) te);
		}
		return null;
	}

}