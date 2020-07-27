package bilibili.vvvbbbcz.hamburger.world;

import bilibili.vvvbbbcz.hamburger.block.trees.LemonTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class TreeGenerations {
    public static void register() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome == Biomes.PLAINS) {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(LemonTree.CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.1F, 1))));
            }
        }
    }
}
