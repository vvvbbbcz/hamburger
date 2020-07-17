package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.hamburger;
import bilibili.vvvbbbcz.hamburger.configure.ModConfig;
import bilibili.vvvbbbcz.hamburger.entities.EntityDuck;
import bilibili.vvvbbbcz.hamburger.entities.EntityDuckEgg;
import bilibili.vvvbbbcz.hamburger.entities.renders.RenderDuck;
import bilibili.vvvbbbcz.hamburger.entities.renders.RenderDuckEgg;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityLoader {
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(EntityDuck.class)
                .egg(0xd5ff00, 0x8ca700)
                .id(new ResourceLocation(hamburger.MODID, "duck"), ModConfig.ID_ENTITY_DUCK)
                .tracker(80, 3, false)
                .spawn(EnumCreatureType.CREATURE, 10, 4, 4, Biomes.JUNGLE, Biomes.PLAINS)
                .name("duck")
                .build());

        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(EntityDuckEgg.class)
                .id(new ResourceLocation(hamburger.MODID, "duck_egg"), ModConfig.ID_ENTITY_DUCK_EGG)
                .tracker(64, 1, false)
                .name("duckEgg")
                .build());
    }

    @SideOnly(Side.CLIENT)
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityDuck.class, RenderDuck::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDuckEgg.class, RenderDuckEgg::new);
    }
}
