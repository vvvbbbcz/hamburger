package bilibili.vvvbbbcz.hamburger.world.gen.feature;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.world.gen.feature.structure.BathroomStructure;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Features {
    public static final DeferredRegister<Feature<?>> FEATURES = new DeferredRegister<>(ForgeRegistries.FEATURES, Hamburger.MODID);
    public static final Structure<NoFeatureConfig> BATHROOM = register("bathroom", new BathroomStructure(NoFeatureConfig::deserialize));

    public static <T extends Structure<NoFeatureConfig>> Structure<NoFeatureConfig> register(String name, T structure) {
        FEATURES.register(name, () -> structure);
        return structure;
    }
}
