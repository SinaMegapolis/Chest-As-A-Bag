package net.sinamegapolis.thecaab.client;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by m on 11/01/2017.
 */
public interface IHasModel {
    @SideOnly(Side.CLIENT)
    public void registerModels();
}
