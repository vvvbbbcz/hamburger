package bilibili.vvvbbbcz.hamburger.blocks.trees;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class LemonTree extends Tree {
//    private static final TreeFeatureConfig CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(RegisterLoader.blockLemonLog.getDefaultState()),
//            new SimpleBlockStateProvider(RegisterLoader.blockLemonLeaf.getDefaultState()),
//            new BlobFoliagePlacer(2, 0)))
//            .baseHeight(5)
//            .heightRandA(2)
//            .foliageHeight(3)
//            .ignoreVines()
//            .setSapling((net.minecraftforge.common.IPlantable) Blocks.BIRCH_SAPLING)
//            .build();

//    private static final TreeFeatureConfig CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BIRCH_LOG), new SimpleBlockStateProvider(BIRCH_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(2).foliageHeight(3).ignoreVines().setSapling((net.minecraftforge.common.IPlantable) Blocks.BIRCH_SAPLING).build()

    @Nullable
    @Override
    public ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.BIRCH_TREE_CONFIG);
    }
}
