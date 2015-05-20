package mods.common.addon.plugin.test;

import net.minecraft.client.gui.GuiScreen;
import mods.client.gui.GuiTab2;
import mods.common.addon.plugin.Plugin;
import mods.common.addon.plugin.PluginMetadata;
import mods.common.addon.plugin.common.Info;

/**
 * @author Zach
 *
 */
@Info(name = "RPM", version = "0.1.0")
public class RPMPlugin implements Plugin {

	@Info.PreInit
	@Override
	public void preInit() 
	{
		
	}

	@Info.Init
	@Override
	public void init() 
	{
	
	}


	@Override
	public void postInit() 
	{
		
	}

	@Override
	public PluginMetadata meta() 
	{
		return new PluginMetadata(this.getClass());
	}

	@Override
	public boolean Tabs() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Class<? extends GuiScreen> Tabclass() {
		// TODO Auto-generated method stub
		return GuiTab2.class;
	}

	@Override
	public String desc() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
