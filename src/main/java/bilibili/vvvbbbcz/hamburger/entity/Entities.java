package bilibili.vvvbbbcz.hamburger.entity;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Hamburger.MODID);
    public static final EntityType<DuckEntity> DUCK = register("duck", EntityType.Builder.create(DuckEntity::new, EntityClassification.CREATURE).size(0.5F, 0.8F).build("duck"));
    public static final EntityType<DuckEggEntity> DUCK_EGG = register("duck_egg", EntityType.Builder.<DuckEggEntity>create(DuckEggEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).build("duck_egg"));
    public static final EntityType<LaoBaEntity> LAO_BA = register("lao_ba", EntityType.Builder.create(LaoBaEntity::new, EntityClassification.MISC).size(0.6F, 1.95F).build("lao_ba"));

    private static <T extends Entity> EntityType<T> register(String name, EntityType<T> type) {
        ENTITIES.register(name, () -> type);
        return type;
    }
}
