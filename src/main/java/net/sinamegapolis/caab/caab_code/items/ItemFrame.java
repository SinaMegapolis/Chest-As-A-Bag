package net.sinamegapolis.caab.caab_code.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.sinamegapolis.caab.ChestAsABag;
import net.sinamegapolis.caab.init.ModRegistry;

/**
 * Created by m on 11/02/2017.
 */
public class ItemFrame extends Item {
    public ItemFrame(String Name){
        setRegistryName(Name);
        setUnlocalizedName(ChestAsABag.MODID + "." + Name);
        setCreativeTab(CreativeTabs.MISC);
        ModRegistry.ITEMS.add(this);
    }
}
