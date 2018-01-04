package net.sinamegapolis.thecaab;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.sinamegapolis.thecaab.proxy.CommonProxy;

/**
 * Created by m on 10/27/2017.
 */
@Mod(modid = TheCAAB.MODID, name = TheCAAB.NAME, version = TheCAAB.VERSION)
public class TheCAAB {
    public static final String MODID = "thecaab";
    public static final String NAME = "The CAAB";
    public static final String VERSION = "alpha0.0.1";

    @Mod.Instance
    public static TheCAAB INSTANCE;

   @SidedProxy(clientSide = "net.sinamegapolis.thecaab.proxy.ClientProxy", serverSide = "net.sinamegapolis.thecaab.proxy.CommonProxy")
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        PROXY.preInit(e);
        PROXY.registerRenderers();
    }
    @Mod.EventHandler
	public void init(FMLInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(this);
        PROXY.init(e);
    }

    @Mod.EventHandler
	public void postInit(FMLPostInitializationEvent e) {
        PROXY.postInit(e);
    }
}
