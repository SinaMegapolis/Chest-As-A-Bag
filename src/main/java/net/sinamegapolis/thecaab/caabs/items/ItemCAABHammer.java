package net.sinamegapolis.thecaab.caabs.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.sinamegapolis.thecaab.TheCAAB;
import net.sinamegapolis.thecaab.client.IHasModel;
import net.sinamegapolis.thecaab.init.ModRegistry;

/**
 * Created by m on 11/02/2017.
 */
public class ItemCAABHammer extends Item implements IHasModel{
    public ItemCAABHammer(String Name){
        setRegistryName(Name);
        setUnlocalizedName(TheCAAB.MODID + "." + Name);
        setCreativeTab(CreativeTabs.MISC);
        ModRegistry.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
