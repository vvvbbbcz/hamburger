package bilibili.vvvbbbcz.hamburger.block.trees;

import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

public class LemonTree extends Tree {
    public static final TreeFeatureConfig CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(Blocks.LEMON_LOG.getDefaultState()),
            new SimpleBlockStateProvider(Blocks.LEMON_LEAVES.getDefaultState()),
            new BlobFoliagePlacer(2, 0)))
            .baseHeight(5)
            .heightRandA(2)
            .foliageHeight(3)
            .ignoreVines()
            .setSapling((IPlantable) Blocks.LEMON_SAPLING)
            .build();

    @Nullable
    @Override
    public ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(@Nonnull Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(CONFIG);
    }
}
