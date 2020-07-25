package bilibili.vvvbbbcz.hamburger;

import bilibili.vvvbbbcz.hamburger.block.Blocks;
import bilibili.vvvbbbcz.hamburger.block.trees.LemonTree;
import bilibili.vvvbbbcz.hamburger.client.gui.Screens;
import bilibili.vvvbbbcz.hamburger.client.renderer.entity.EntityRenderers;
import bilibili.vvvbbbcz.hamburger.entity.Entities;
import bilibili.vvvbbbcz.hamburger.fluid.Fluids;
import bilibili.vvvbbbcz.hamburger.inventory.container.Containers;
import bilibili.vvvbbbcz.hamburger.item.Items;
import bilibili.vvvbbbcz.hamburger.potion.Effects;
import bilibili.vvvbbbcz.hamburger.tileentity.TileEntities;
import bilibili.vvvbbbcz.hamburger.util.SoundEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Hamburger.MODID)
public class Hamburger {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "hamburger";

    public Hamburger() {
        Blocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Containers.CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Effects.EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Entities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        Fluids.FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundEvents.SOUND_EVENTS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TileEntities.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.SALT_ORE.get().getDefaultState(), 24)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 128))));

            if (biome == Biomes.PLAINS) {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(LemonTree.CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
            }
        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        EntityRenderers.register();
        Screens.register();
        RenderTypeLookup.setRenderLayer(Blocks.LEMON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(Blocks.IRON_PLATE.get(), RenderType.getCutout());
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
//         do something when the server starts
    }
}
