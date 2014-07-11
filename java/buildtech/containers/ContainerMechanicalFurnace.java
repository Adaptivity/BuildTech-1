package buildtech.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import buildtech.blocks.factory.*;
import buildtech.erates.realmachines.recipes.Recipe;

public class ContainerMechanicalFurnace extends ContainerMachine 
{

	private TileMechanicalFurnace tile;

	public ContainerMechanicalFurnace(InventoryPlayer invPlayer, TileMechanicalFurnace te) 
	{
		super(Recipe.fabricatingMachine, te);
		this.tile = te;

		// Player inventory
		int i;

		for (i = 0; i < 3; ++i)
		{
			for (int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i)
		{
			addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
		}
		
				addSlotToContainer(new Slot(tile, 0, 55, 35));

				//Output
				addSlotToContainer(new Slot(tile, 1, 113, 35));
		}

		


	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return tile.isUseableByPlayer(player);
	}


	public TileMechanicalFurnace getTileEntity() 
	{
		return tile;
	}
}
