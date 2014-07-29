package buildtech.configuration;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class ConfigGui extends GuiConfig
{
	public ConfigGui(GuiScreen parentScreen) 
	{
        super(parentScreen, getList(), "BuildTech", false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }

    public static List<IConfigElement> getList() 
    {
        List list = new ArrayList<IConfigElement>();
        list.add(new ConfigElement (ConfigHandler.config.getCategory("updates")));
        list.add(new ConfigElement (ConfigHandler.config.getCategory("power usage")));
	    list.add(new ConfigElement (ConfigHandler.config.getCategory("misc")));
        return list;
    }
}
