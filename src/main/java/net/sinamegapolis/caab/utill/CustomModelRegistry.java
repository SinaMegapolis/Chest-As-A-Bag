package net.sinamegapolis.caab.utill;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = "caab", value = Side.CLIENT)
public final class CustomModelRegistry {

    /**
     * I just copy pasted it from @kit becuz i needed a way to load JSON models for rendering in CAAB's TESR
     */

    private static final List<ModelResourceLocation> MODELS = new ArrayList<>();

    private CustomModelRegistry() {
    }

    public static void registerModel(ResourceLocation model, String variant) {
        MODELS.add(new ModelResourceLocation(model, variant));
    }

    public static void registerModel(String model, String variant) {
        ModContainer container = Loader.instance().activeModContainer();
        String modid = container != null ? container.getModId() : "minecraft";
        ResourceLocation rl = new ResourceLocation(modid, model);
        MODELS.add(new ModelResourceLocation(rl, variant));
    }

    public static IBakedModel retrieveModel(ResourceLocation model, String variant) {
        return getModelManager().getModel(new ModelResourceLocation(model, variant));
    }

    public static IBakedModel retrieveModel(String model, String variant) {
        ModContainer container = Loader.instance().activeModContainer();
        String modid = container != null ? container.getModId() : "minecraft";
        ResourceLocation rl = new ResourceLocation(modid, model);
        return getModelManager().getModel(new ModelResourceLocation(rl, variant));
    }

    @SubscribeEvent
    protected static void onTextureStitchPre(TextureStitchEvent.Pre event) {
        for (ModelResourceLocation mrl : MODELS) {
            for (ResourceLocation texture : getModelFor(mrl).getTextures()) {
                event.getMap().registerSprite(texture);
            }
        }
    }

    @SubscribeEvent
    protected static void onModelBake(ModelBakeEvent event) {
        for (ModelResourceLocation mrl : MODELS) {
            IModel model = getModelFor(mrl);
            event.getModelRegistry().putObject(mrl, model.bake(
                    model.getDefaultState(),
                    DefaultVertexFormats.BLOCK,
                    ModelLoader.defaultTextureGetter()
            ));
        }
    }

    private static IModel getModelFor(ModelResourceLocation mrl) {
        String error = "Failed to get model for <" + mrl.toString() + ">!";
        return ModelLoaderRegistry.getModelOrLogError(mrl, error);
    }

    private static ModelManager getModelManager() {
        Minecraft mc = FMLClientHandler.instance().getClient();
        BlockRendererDispatcher brd = mc.getBlockRendererDispatcher();
        BlockModelShapes bms = brd.getBlockModelShapes();
        return bms.getModelManager();
    }
}


