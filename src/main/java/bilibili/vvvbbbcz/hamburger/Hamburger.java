package bilibili.vvvbbbcz.hamburger;

import bilibili.vvvbbbcz.hamburger.block.Blocks;
import bilibili.vvvbbbcz.hamburger.client.gui.Screens;
import bilibili.vvvbbbcz.hamburger.client.renderer.RenderTypes;
import bilibili.vvvbbbcz.hamburger.client.renderer.entity.EntityRenderers;
import bilibili.vvvbbbcz.hamburger.entity.Entities;
import bilibili.vvvbbbcz.hamburger.fluid.Fluids;
import bilibili.vvvbbbcz.hamburger.inventory.container.Containers;
import bilibili.vvvbbbcz.hamburger.item.Items;
import bilibili.vvvbbbcz.hamburger.potion.Effects;
import bilibili.vvvbbbcz.hamburger.tileentity.TileEntities;
import bilibili.vvvbbbcz.hamburger.util.SoundEvents;
import bilibili.vvvbbbcz.hamburger.world.OreGenerations;
import bilibili.vvvbbbcz.hamburger.world.TreeGenerations;
import bilibili.vvvbbbcz.hamburger.world.biome.Biomes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Hamburger.MODID)
public class Hamburger {
    public static final String MODID = "hamburger";

    public Hamburger() {
        Blocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Biomes.BIOMES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Containers.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Effects.EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Entities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
//        Features.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Fluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundEvents.SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntities.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onServerStarting);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        OreGenerations.register();
        TreeGenerations.register();
        Biomes.add();
//        StructureTypes.register();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRenderers.register();
        Screens.register();
        RenderTypes.registerRenderLayers();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    public void onServerStarting(final FMLServerStartingEvent event) {
    }
}
