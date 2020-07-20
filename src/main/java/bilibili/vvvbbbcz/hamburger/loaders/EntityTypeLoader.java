package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.entities.EntityDuck;
import bilibili.vvvbbbcz.hamburger.entities.EntityDuckEgg;
import bilibili.vvvbbbcz.hamburger.entities.renders.RenderDuck;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityTypeLoader {
    public static final EntityType<EntityDuck> DUCK = EntityType.Builder.create(EntityDuck::new, EntityClassification.CREATURE).size(0.5F, 0.8F).build("duck");
    public static final EntityType<EntityDuckEgg> DUCK_EGG = EntityType.Builder.<EntityDuckEgg>create(EntityDuckEgg::new, EntityClassification.MISC).size(0.25F, 0.25F).build("duck_egg");

//    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
//        event.getRegistry().register(EntityEntryBuilder.create()
//                .entity(EntityDuck.class)
//                .egg(0xd5ff00, 0x8ca700)
//                .id(new ResourceLocation(hamburger.MODID, "duck"), ModConfig.ID_ENTITY_DUCK)
//                .tracker(80, 3, false)
//                .spawn(EnumCreatureType.CREATURE, 10, 4, 4, Biomes.JUNGLE, Biomes.PLAINS)
//                .name("duck")
//                .build());
//
//        event.getRegistry().register(EntityEntryBuilder.create()
//                .entity(EntityDuckEgg.class)
//                .id(new ResourceLocation(hamburger.MODID, "duck_egg"), ModConfig.ID_ENTITY_DUCK_EGG)
//                .tracker(64, 1, false)
//                .name("duckEgg")
//                .build());
//    }

    @SubscribeEvent
    public static void register(RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().register(DUCK.setRegistryName("duck"));
        event.getRegistry().register(DUCK_EGG.setRegistryName("duck_egg"));
    }

    @OnlyIn(Dist.CLIENT)
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(DUCK, RenderDuck::new);
//        RenderingRegistry.registerEntityRenderingHandler(DUCK_EGG, RenderDuckEgg::new); // TODO 可能不需要
    }
}
