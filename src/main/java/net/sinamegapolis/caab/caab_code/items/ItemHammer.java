package net.sinamegapolis.caab.caab_code.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.sinamegapolis.caab.ChestAsABag;
import net.sinamegapolis.caab.client.IHasModel;
import net.sinamegapolis.caab.init.ModRegistry;

/**
 * Created by m on 11/02/2017.
 */
public class ItemHammer extends Item implements IHasModel{
    public ItemHammer(String Name){
        setRegistryName(Name);
        setUnlocalizedName(ChestAsABag.MODID + "." + Name);
        setCreativeTab(CreativeTabs.MISC);
        ModRegistry.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
