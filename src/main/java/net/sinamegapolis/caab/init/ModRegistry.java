package net.sinamegapolis.caab.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.sinamegapolis.caab.caab_code.blocks.BlockChestAsABag;
import net.sinamegapolis.caab.caab_code.items.ItemHammer;
import net.sinamegapolis.caab.caab_code.items.ItemNail;
import net.sinamegapolis.caab.caab_code.tileentities.TileEntityChestAsABag;
import net.sinamegapolis.caab.utill.CustomModelRegistry;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SinaMegapolis on 11/01/2017.
 */
public class ModRegistry  {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item HAMMER = new ItemHammer("caab_item_hammer");
    public static final Block SampleCAAB = new BlockChestAsABag("caab_block");
    public static final Item CopperNail = new ItemNail("caab_item_nail");
    public static final TileEntityChestAsABag CAAB_TileEntitySample = new TileEntityChestAsABag();

    @SubscribeEvent
    public void onBlockRegister(Register<Block> event) {
        event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
        GameRegistry.registerTileEntity(TileEntityChestAsABag.class,SampleCAAB.getRegistryName().toString());
    }


    @SubscribeEvent
    public void onItemRegister(Register<Item> event) {
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
    }


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
    CustomModelRegistry.registerModel("module_orange","inventroy");
    }



}
