package mods.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Some forge config utilities
 */
public class ConfigManager extends Configuration
{
    /**
     * The configuration instance
     */
    public static Configuration config = new Configuration();
 
    /**
     * Creates the config file itself
     * 
     * @param event
     *            The event used to get the directory
     * @param dir
     *            The sub-directory
     * @param modidName
     *            The mod id to name the config
     */
    public static void CreateConfig(FMLPreInitializationEvent event, String dir, String modidName)
    {
        config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + dir + File.separator + modidName + ".cfg"));
    }
    
   
}
