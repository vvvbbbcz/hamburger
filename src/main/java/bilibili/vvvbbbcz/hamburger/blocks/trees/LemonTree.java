package bilibili.vvvbbbcz.hamburger.blocks.trees;

import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

import javax.annotation.Nullable;
import java.util.Random;

public class LemonTree extends Tree {
    private static final TreeFeatureConfig CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(RegisterLoader.blockLemonLog.getDefaultState()),
            new SimpleBlockStateProvider(RegisterLoader.blockLemonLeaf.getDefaultState()),
            new BlobFoliagePlacer(2, 0)))
            .baseHeight(5)
            .heightRandA(2)
            .foliageHeight(3)
            .ignoreVines()
            .setSapling((net.minecraftforge.common.IPlantable) Blocks.BIRCH_SAPLING)
            .build();

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(CONFIG);
    }
}
