package net.sinamegapolis.thecaab.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.sinamegapolis.thecaab.caabs.tileentities.TheCAABTE;
import net.sinamegapolis.thecaab.client.IHasModel;
import net.sinamegapolis.thecaab.init.ModRegistry;

/**
 * Created by m on 10/27/2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
	public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(this);

    }

    @Override
	public void init(FMLInitializationEvent e) {
       super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @SubscribeEvent
    public void onModelRegister(ModelRegistryEvent e) {
        for(Block b : ModRegistry.BLOCKS) if(b instanceof IHasModel) ((IHasModel) b).registerModels();
        for(Item i: ModRegistry.ITEMS) if(i instanceof IHasModel) ((IHasModel) i).registerModels();
    }

    @Override
    public void registerRenderers(){
        ClientRegistry.bindTileEntitySpecialRenderer(TheCAABTE.class,new CAABTESR());
    }
}
