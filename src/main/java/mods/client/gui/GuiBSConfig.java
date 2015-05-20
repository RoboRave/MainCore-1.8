 package mods.client.gui;

 import mods.common.config.ConfigManager;
import mods.common.library.Library;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class GuiBSConfig extends GuiConfig
{
	
	public GuiBSConfig(GuiScreen parent) throws NoSuchMethodException, SecurityException
    {
        super(parent, new ConfigElement(ConfigManager.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                 Library.modid, true,true, GuiConfig.getAbridgedConfigPath(ConfigManager.config.toString()));
    }
}