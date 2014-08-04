package buildtech.configuration;

import java.util.ArrayList;
import java.util.List;

import buildtech.utils.BuildTechUtilities;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class ConfigGui extends GuiConfig
{
	public ConfigGui(GuiScreen parentScreen) 
	{
        super(parentScreen, getList(), "buildtech", false, false, BuildTechUtilities.localize("config"));
    }

    public static List<IConfigElement> getList() 
    {
        List list = new ArrayList<IConfigElement>();
        list.add(new ConfigElement(ConfigHandler.config.getCategory("Updates")));
        list.add(new ConfigElement(ConfigHandler.config.getCategory("IDS'")));
	    list.add(new ConfigElement(ConfigHandler.config.getCategory("Misc")));
        return list;
    }
}
