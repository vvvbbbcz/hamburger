package bilibili.vvvbbbcz.hamburger.entity;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Entities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, Hamburger.MODID);
    public static final RegistryObject<EntityType<DuckEntity>> DUCK = ENTITIES.register("duck", () -> EntityType.Builder.create(DuckEntity::new, EntityClassification.CREATURE).size(0.5F, 0.8F).build("duck"));
    public static final RegistryObject<EntityType<DuckEggEntity>> DUCK_EGG = ENTITIES.register("duck_egg", () -> EntityType.Builder.<DuckEggEntity>create(DuckEggEntity::new, EntityClassification.MISC).size(0.25F, 0.25F).build("duck_egg"));
//    public static final RegistryObject<EntityType<LaoBaEntity>> LAO_BA = ENTITIES.register("lao_ba", () -> EntityType.Builder.create(LaoBaEntity::new, EntityClassification.MISC).size(0.6F, 1.95F).build("lao_ba"));
}
