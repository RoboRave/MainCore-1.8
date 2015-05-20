package mods.common.load;

import mods.common.addon.plugin.PluginLoader;
import mods.common.addon.plugin.main.ExamplePlugin;
import mods.common.addon.plugin.test.ModLoaderPlugin;
import mods.common.addon.plugin.test.RPMPlugin;


public class Load {
	
	public static void Mods() throws InstantiationException, IllegalAccessException
	{
		PluginLoader.addPlugin(ExamplePlugin.class);
		
		PluginLoader.addPlugin(RPMPlugin.class);
		
		PluginLoader.addPlugin(ModLoaderPlugin.class);
		
	}
	
}
