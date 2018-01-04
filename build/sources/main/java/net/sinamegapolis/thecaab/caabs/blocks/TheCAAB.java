package net.sinamegapolis.thecaab.caabs.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.sinamegapolis.thecaab.client.IHasModel;
import net.sinamegapolis.thecaab.init.ModRegistry;

/**
 * Created by m on 11/03/2017.
 */
public class TheCAAB extends Block implements IHasModel {
    public TheCAAB(String name) {
        super(Material.ROCK);
        setRegistryName(name);
        setUnlocalizedName(net.sinamegapolis.thecaab.TheCAAB.MODID + "." + name);
        setCreativeTab(CreativeTabs.MISC);
        ModRegistry.BLOCKS.add(this);
        ModRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
    }

    @Override
    public void registerModels() {

        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this),
                0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
