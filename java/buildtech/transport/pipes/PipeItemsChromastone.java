package buildtech.transport.pipes;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.BuildCraftTransport;
import buildcraft.api.core.IIconProvider;
import buildcraft.core.utils.MathUtils;
import buildcraft.transport.Pipe;
import buildcraft.transport.PipeIconProvider;
import buildcraft.transport.PipeTransportItems;
import buildcraft.transport.TransportConstants;
import buildcraft.transport.TravelingItem;
import buildcraft.transport.pipes.events.PipeEventItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PipeItemsChromastone extends Pipe {

	public PipeItemsChromastone(Item item) {
		super(new PipeTransportItems(), item);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIconProvider getIconProvider() {
		return BuildCraftTransport.instance.pipeIconProvider;
	}

	@Override
	public int getIconIndex(ForgeDirection direction) {
		return PipeIconProvider.TYPE.PipeItemsGold.ordinal();
	}

	public void eventHandler(PipeEventItem.AdjustSpeed event) {
		event.handled = true;
		TravelingItem item = event.item;
		item.setSpeed(MathUtils.clamp(item.getSpeed() * 6F, TransportConstants.PIPE_NORMAL_SPEED * 5F, TransportConstants.PIPE_NORMAL_SPEED * 20F));
	}
}
