package mods.common.implement;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;


public interface IMod {
    
    void preInit(FMLPreInitializationEvent evt);
    
    void init(FMLInitializationEvent evt);
    
    void postInit(FMLPostInitializationEvent evt);
}