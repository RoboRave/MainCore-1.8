package mods.common.addon.plugin.main;

import net.minecraft.client.gui.GuiScreen;
import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;
import mods.common.addon.plugin.common.Info.Init;
import mods.common.addon.plugin.common.Info.PostInit;
import mods.common.addon.plugin.common.Info.PreInit;
/**
 * @author Zach
 *
 */
@Info(name = "Example-Plugin", version = "0.1.0")
public class ExamplePlugin implements Plugin
{
    @Override
    public PluginMetadata meta()
    {
        return new PluginMetadata(this.getClass());
    }
    
    @PreInit()
    @Override
    public void preInit()
    {
        
    }
    
    @Init()
    @Override
    public void init()
    {
        
    }
    
    @PostInit()
    @Override
    public void postInit()
    {
        
    }

	@Override
	public boolean Tabs() {
		return false;
	}

	@Override
	public Class<? extends GuiScreen> Tabclass() {
		return null;
	}

	@Override
	public String desc() {
		return "Core";
	}

	
   
 
}
