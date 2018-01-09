package net.sinamegapolis.caab.caab_code.tileentities;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.sinamegapolis.caab.caab_code.blocks.BlockChestAsABag;
import net.sinamegapolis.caab.init.ModRegistry;
import net.sinamegapolis.caab.utill.CustomModelRegistry;

/**
 * Created by m on 12/23/2017.
 */
public class TileEntityChestAsABagRenderer extends TileEntitySpecialRenderer<TileEntityChestAsABag>{

    @Override
    public void render(TileEntityChestAsABag te, double x, double y, double z, float partialTicks, int destroyStage, float alpha){
        GlStateManager.pushMatrix();
        GlStateManager.translate(x,y,z);


        GlStateManager.popMatrix();
    }
}
