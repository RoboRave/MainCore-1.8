package mods.common.core;

import java.io.File;
import java.util.Arrays;

import mods.common.addon.plugin.Loader;
import mods.common.client.CombinedClientProxy;
import mods.common.config.ConfigManager;
import mods.common.dedicated.DedicatedServerProxy;
import mods.common.library.Library;
import mods.common.load.Load;
import mods.common.logger.CoreLogger;
import mods.common.server.CommonProxy;
import mods.common.util.Const;
import mods.common.util.ModVersionChecker;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Level;

	/**
	 * @author Zach
	 */
	@Mod(modid = Library.modid,name=Library.name,version= Library.version,guiFactory="mods.client.gui.GuiFactoryHandler")
	public class MainCore 
	{
		/**
		 * Instance for mod
		 */
		@Instance("ModdingCore")
		public static MainCore instance;
	
		/**
		 *  the proxy for MainCore
		 */
		@SidedProxy
		(clientSide="mods.common.client.CombinedClientProxy", 
		 serverSide="mods.common.dedicated.DedicatedServerProxy")
		public static CommonProxy proxy;
		
		/**
		 * Minecraft's version
		 */
		public String actualMCVersion = Const.MCVERSION;
	
		private String Plugin= "PluginLoader";
		private String Dev= "Developer Mode";

		public boolean plugin;
		public final String	allowUpdateCheckDesc          	= "Set to true to allow checking for updates for ALL of my mods, false to disable";
		public boolean      allowUpdateCheck              	= true;
		public final String allowDebugOutputDesc          	= "";
		public boolean      allowDebugOutput              	= false;
		public final String updateTimeoutMillisecondsDesc 	= "The timeout in milliseconds for the version update check.";
		public int          updateTimeoutMilliseconds     	= 3000;
		public final String generateUniqueNamesFileDesc   	= "When true a file called UniqueNames.txt will be generated in the config folder for convenience. \n" +
		                                                                      "The names found in the file are the string representation of blocks and items in Minecraft.\n" +
		                                                                      "Mods such as Treecapitator and StartingInventory use them in their config files since IDs are gone.";
		public boolean     			generateUniqueNamesFile       	= true;
		protected ModVersionChecker versionChecker;
		private final String        versionURL                    	= Const.VERSION_URL + "/minecraft/" + "mods/MainCore/"+ Const.MCVERSION + "/"+Const.MCVERSION+".version";
		private final String        mcfTopic                      	= "Minecraft";
		public static Configuration config;
		private String 				descriptionPlugin				="When true a new config screen will become useable.\n" 
			                                                        + "and you will be able to see loaded plugins in the new screen. "
			                                                        + "Warning: this is WIP feature";
		public boolean dev;
		private String descriptionDEV								="this is Developer mode for ModdingCore."+"\n"
																	+"It may print random info in the console,"
																	+ "which could make loading minecraft slower."+"\n"
																	+" Enable at your own risk";
		/**
		 * @param event the helping part
		 */
		@Mod.EventHandler
		public void preInit(FMLPreInitializationEvent event) 
		{
			ModMetadata metadata = event.getModMetadata();
			metadata.autogenerated = false;
			metadata.credits = "(C) Roborave, 2013-2015";
			metadata.authorList = Arrays.asList("Roborave");
			metadata.name = Library.name;
			metadata.version = Library.version;
			metadata.description = "This the core for all my mods. It is also a API " +
					"that can be very useful to modders ";
			
	        File file2 = new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + "MainCore" + File.separator + metadata.name+ ".config");
			
	        MainCore.config = new Configuration(file2);
			syncConfig();
			
			ConfigManager.CreateConfig(event, "MainCore", metadata.name);
			this.plugin = ConfigManager.config.get(Configuration.CATEGORY_GENERAL, this.Plugin, true, this.descriptionPlugin).getBoolean(true);
			this.dev = ConfigManager.config.get(Configuration.CATEGORY_GENERAL, this.Dev, true, this.descriptionDEV).getBoolean(true);
			ConfigManager.config.save();
			
				/**
		         * for the new PluginLoader
		         * TODO Make Automatic
		         */
				if(this.plugin==true)
				{
					CoreLogger.info("===================================================================");
					CoreLogger.info("========= PluginLoader has been enabled for your game. ============");
					CoreLogger.info("this means that you will be able to load plugins for "+ Library.name+".");
					CoreLogger.info("Please note that this feature is very WIP. It may crash your game.");
					CoreLogger.info("===================================================================");
					
					Loader.instance().loadPlugins();
					try {
						Load.Mods();
					} 
						catch (InstantiationException e) 
					{
						e.printStackTrace();
					} 
						catch (IllegalAccessException e) 
					{
						e.printStackTrace();
					}
					
					Loader.instance().initializePlugins();
				}
				
				if(this.dev==true)
				{
					DedicatedServerProxy.log("Loaded!!");
					CombinedClientProxy.log("Loaded!!");
					CommonProxy.log("Loaded!!");
					MainCore.console("Loaded!!");
					CoreLogger.info("   _|      _|           |_|              _|_|_|                                ");
					CoreLogger.info("   _|_|  _|_|    _|_|_|      _|_|_|    _|          _|_|    _|  _|_|    _|_|_   ");
					CoreLogger.info("   _|_|  _|_|    _|_|_|      _|_|_|    _|          _|_|    _|  _|_|    _| |_|  ");
					CoreLogger.info("   _|  _|  _|  _|    _|  _|  _|   _|   _|        _|    _|  _|_|      _|_|_|_|  ");
					CoreLogger.info("   _|      _|  _|    _|  _|  _|   _|   _|        _|    _|  _|        _|        ");
					CoreLogger.info("   _|      _|    _|_|_|  _|  _|   _|     _|_|_|    _|_|    _|          _|_|_|  ");
				}  
		}
		/**
		 * helps with the config
		 */
		public void syncConfig()
	    {
	        String ctgyGen = Configuration.CATEGORY_GENERAL;
	        MainCore.config.load();
	        
	        this.allowUpdateCheck = MainCore.config.getBoolean("allowUpdateCheck", ctgyGen, this.allowUpdateCheck, this.allowUpdateCheckDesc);
	        this.allowDebugOutput = MainCore.config.getBoolean("allowDebugOutput", ctgyGen, this.allowDebugOutput, this.allowDebugOutputDesc);
	        this.updateTimeoutMilliseconds = MainCore.config.getInt("updateTimeoutMilliseconds", ctgyGen, this.updateTimeoutMilliseconds, 100, 30000, this.updateTimeoutMillisecondsDesc);
	        this.generateUniqueNamesFile = MainCore.config.getBoolean("generateUniqueNamesFile", ctgyGen, this.generateUniqueNamesFile, this.generateUniqueNamesFileDesc);
	        
	        MainCore.config.save();
		}
		@SubscribeEvent
	    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
	        if(eventArgs.modID.equals(Library.modid));
	           syncConfig();
	    }
		
		/**
		 * @param event main event loader
		 */
		@EventHandler
		public void load(FMLInitializationEvent event)
		{
			CoreLogger.init();
			DedicatedServerProxy.init();
			
			if (this.allowUpdateCheck)
	        {
	            this.versionChecker = new ModVersionChecker("MainCore", Library.version, this.versionURL, this.mcfTopic);
	            this.versionChecker.checkVersionWithLogging();
	        }
			
		}
	
		public String getName() 
		{
			return Library.name;
		}
	
		public String getVersion() 
		{
			return Library.version;
		}
		/**
		 * @param s the message
		 */
		public static void console(String s)
		{
		        StringBuilder sb = new StringBuilder();
		        CoreLogger.log(Level.INFO,sb.append("[").append(Library.version).append("] ").append(s).toString());
		}
	}
