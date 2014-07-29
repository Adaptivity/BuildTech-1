package buildtech.containers;

import buildtech.blocks.factory.*;
import buildtech.extras.erates.realmachines.recipes.Recipe;
import buildtech.libs.Book;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFabricatingMachine extends ContainerMachine 
{
	private TileFabricatingMachine tile;

	public ContainerFabricatingMachine(InventoryPlayer invPlayer, TileFabricatingMachine te) 
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
		

				addSlotToContainer(new Slot(tile, 1, 33, 35));

				addSlotToContainer(new Slot(tile, 2, 11, 35));

				addSlotToContainer(new Slot(tile, 0, 55, 35));

				//Output
				addSlotToContainer(new Slot(tile, 3, 113, 35));
		}

		


	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return tile.isUseableByPlayer(player);
	}


	public TileFabricatingMachine getTileEntity() 
	{
		return tile;
	}
}