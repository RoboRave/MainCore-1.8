package mods.common.addon.plugin;

import net.minecraft.client.gui.GuiScreen;



/**
 * @author RoboRave
 * 
 */

public interface Plugin
{

    /**
     * Called when pre-initialization occurs.
     */
    void preInit();
    
    /**
     * Called when main initialization occurs.
     */
    void init();
    
    /**
     * Called when post-initialization occurs.
     */
    void postInit();
    
    /**
     * @return meta
     */
    PluginMetadata meta();

	String desc();
	
    
	boolean Tabs();
	
	public Class<? extends GuiScreen> Tabclass();
}