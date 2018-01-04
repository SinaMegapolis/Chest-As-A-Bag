package net.sinamegapolis.thecaab.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.sinamegapolis.thecaab.caabs.blocks.TheCAAB;
import net.sinamegapolis.thecaab.caabs.items.ItemCAABHammer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m on 11/01/2017.
 */
public class ModRegistry {
    public static final List<Block> BLOCKS = new ArrayList<Block>();
    public static final List<Item> ITEMS = new ArrayList<Item>();
    public static final Item HAMMER = new ItemCAABHammer("the_hammer");
    public static final Block SampleCAAB = new TheCAAB("the_caab");

    @SubscribeEvent
    public void onBlockRegister(Register<Block> event) {
        event.getRegistry().registerAll(BLOCKS.toArray(new Block[0]));
    }


    @SubscribeEvent
    public void onItemRegister(Register<Item> event) {
        event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
    }

}
