package net.sinamegapolis.caab;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.sinamegapolis.caab.proxy.CommonProxy;

/**
 * Created by m on 10/27/2017.
 */
@Mod(modid = ChestAsABag.MODID, name = ChestAsABag.NAME, version = ChestAsABag.VERSION)
public class ChestAsABag {
    public static final String MODID = "caab";
    public static final String NAME = "The Chest As A Bag";
    public static final String VERSION = "indev0.1";

    @Mod.Instance
    public static ChestAsABag INSTANCE;

   @SidedProxy(clientSide = "net.sinamegapolis.caab.proxy.ClientProxy", serverSide = "net.sinamegapolis.caab.proxy.CommonProxy")
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
