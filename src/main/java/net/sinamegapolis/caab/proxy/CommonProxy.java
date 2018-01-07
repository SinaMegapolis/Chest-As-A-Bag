package net.sinamegapolis.caab.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.*;
import net.sinamegapolis.caab.init.ModRegistry;

/**
 * Created by SinaMegapolis on 10/27/2017.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new ModRegistry());
    }

    public void init(FMLInitializationEvent e) {

    }

    public void postInit(FMLPostInitializationEvent e) {

    }

    public void registerRenderers(){}
}
