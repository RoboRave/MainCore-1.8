package mods.common.addon.plugin;

import mods.common.addon.plugin.common.Info;

/**
 * @author Zach
 *
 */
public class PluginMetadata
{
    /**
     * name of plugin
     */
    public static String name;
    /**
     * description of plugin
     */
    public String description;
	/**
	 * version of plugin
	 */
	public static String version;
	
	/**
	 * test ID of Plugin
	 */
    public static String testID;

    /**
     * @param clazz the class
     */
    public PluginMetadata(Class<? extends Plugin> clazz)
    {
        name = clazz.getAnnotation(Info.class).name();
        version = clazz.getAnnotation(Info.class).version();
        testID= clazz.getAnnotation(Info.class).testID();
        try {
        	description= clazz.newInstance().desc();
		} catch (InstantiationException e) {e.printStackTrace();} catch (IllegalAccessException e) {e.printStackTrace();}
        
    }
   
}
