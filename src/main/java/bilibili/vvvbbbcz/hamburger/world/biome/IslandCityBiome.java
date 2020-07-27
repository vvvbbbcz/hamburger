package bilibili.vvvbbbcz.hamburger.world.biome;

import bilibili.vvvbbbcz.hamburger.entity.Entities;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class IslandCityBiome extends Biome {
    protected IslandCityBiome() {
        super(new Biome.Builder()
                .category(Category.PLAINS)
                .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState()))
                .depth(0.0F) // 深度
                .downfall(0.2F) // 平整度
                .precipitation(Biome.RainType.RAIN) // 降水类型
                .scale(0.3F) // 规模
                .temperature(0.8F) // 温度
                .waterColor(0x643c00) // 水的颜色(RGB)
                .waterFogColor(0x643c00) // 水下颜色(RGB)
                .parent((String) null)
        );
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        this.addFeature(GenerationStage.Decoration.UNDERGROUND_STRUCTURES, Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(Entities.DUCK, 10, 4, 6)); // TODO 空指针异常
        DefaultBiomeFeatures.addCarvers(this);
        DefaultBiomeFeatures.addLakes(this); // TODO 将会改成奥利给水
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSwampClayDisks(this);
        DefaultBiomeFeatures.addBamboo(this);
    }
}
