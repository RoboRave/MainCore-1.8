package mods.common.addon.plugin.test;

import net.minecraft.client.gui.GuiScreen;
import mods.client.gui.GuiTab;
import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;

/**
 * @author Zach
 */
@Info(name = "PluginLoader", version = "0.0.2")
public class ModLoaderPlugin implements Plugin
{
	@Override
	public PluginMetadata meta()
	{
		return new PluginMetadata(this.getClass());
	}
	    
    @Override
    public void preInit()
    {
       this.meta().description="the main point of this plugin is to show tabs";
    }
    
    @Override
    public void init()
    {
        
    }
    
   
   
    @Override
    public void postInit()
    {
        
    }

	@Override
	public boolean Tabs() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Class<? extends GuiScreen> Tabclass() {
		// TODO Auto-generated method stub
		return GuiTab.class;
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return null;
	}

	

   
    
}
