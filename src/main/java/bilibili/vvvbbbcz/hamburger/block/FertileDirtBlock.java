package bilibili.vvvbbbcz.hamburger.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class FertileDirtBlock extends Block {
    public FertileDirtBlock() {
        super(Properties.create(Material.EARTH, MaterialColor.DIRT).hardnessAndResistance(0.5F).sound(SoundType.GROUND));
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack stack = player.getHeldItemMainhand();
        if (hit.getFace() != Direction.DOWN && worldIn.isAirBlock(pos.up())) {
            if (stack.getItem() instanceof HoeItem) {
                worldIn.playSound(player, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                if (!worldIn.isRemote) {
                    worldIn.setBlockState(pos, bilibili.vvvbbbcz.hamburger.block.Blocks.FERTILE_FARMLAND.getDefaultState(), 11);
                    if (player != null) {
                        stack.damageItem(1, player, (p_220043_1_) -> {
                            p_220043_1_.sendBreakAnimation(handIn);
                        });
                    }
                }
                return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }
}
