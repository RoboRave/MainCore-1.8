package mods.common.addon.plugin;

import mods.common.addon.lib.CoreLogger;



/**
 * Handles detecting and loading Plugins.
 * 
 * @author RoboRave
 */
public class PluginLoader
{   
    /**
     * the Main way to add plugin to the PluginLoader
     * 
     * @author RoboRave
     * 
     * @param plugin the class of the plugin
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
	@SuppressWarnings("static-access")
	public static void addPlugin(Class<?extends Plugin> plugin) throws InstantiationException, IllegalAccessException
    {

		
			plugin.newInstance().preInit();
			CoreLogger.info("Loaded Preinit for " + plugin.newInstance().meta().name);
			
			plugin.newInstance().init();
        	CoreLogger.info("Loaded Init for " + plugin.newInstance().meta().name);
        	
        	plugin.newInstance().postInit();
        	CoreLogger.info("Loaded Postinit for " + plugin.newInstance().meta().name);
                
        Loader.instance().mods.add(plugin);
        
        Loader.instance().plugins.add(plugin.newInstance().meta().name);
    }
	@SuppressWarnings("static-access")
	public static void removePlugin(Class<?extends Plugin> plugin) throws InstantiationException, IllegalAccessException
	{
		Loader.instance().mods.remove(plugin);
		Loader.instance().plugins.remove(plugin.newInstance().meta().name);
	}
}