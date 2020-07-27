package bilibili.vvvbbbcz.hamburger.block;

import bilibili.vvvbbbcz.hamburger.block.trees.LemonTree;
import bilibili.vvvbbbcz.hamburger.item.Items;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockReader;

public class LemonSaplingBlock extends SaplingBlock {
    public LemonSaplingBlock() {
        super(new LemonTree(), Properties.create(Material.PLANTS)
                .tickRandomly()
                .doesNotBlockMovement()
                .hardnessAndResistance(0.0F)
                .sound(SoundType.PLANT));
    }

    @Override
    public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos, PlayerEntity player) {
        return new ItemStack(Items.LEMON_SEED);
    }
}
