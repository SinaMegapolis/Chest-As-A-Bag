package net.sinamegapolis.thecaab.caabs.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.sinamegapolis.thecaab.TheCAAB;
import net.sinamegapolis.thecaab.init.ModRegistry;

/**
 * Created by m on 11/02/2017.
 */
public class ItemCAABFrame extends Item {
    public ItemCAABFrame(String Name){
        setRegistryName(Name);
        setUnlocalizedName(TheCAAB.MODID + "." + Name);
        setCreativeTab(CreativeTabs.MISC);
        ModRegistry.ITEMS.add(this);
    }
}
