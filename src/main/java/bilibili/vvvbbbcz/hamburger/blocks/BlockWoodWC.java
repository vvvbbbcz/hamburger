package bilibili.vvvbbbcz.hamburger.blocks;

import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
import bilibili.vvvbbbcz.hamburger.loaders.SoundLoader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

public class BlockWoodWC extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static int clickTime = 1;

    public BlockWoodWC() {
        super(Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0F, 5.0F)
                .harvestTool(ToolType.AXE)
                .harvestLevel(0)
        );
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (player.getFoodStats().getFoodLevel() >= 6) {
            switch (clickTime) {
                case 1:
                    player.playSound(SoundLoader.AO, 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 3:
                    player.playSound(SoundLoader.LI, 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 5:
                    player.playSound(SoundLoader.GEI, 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 7:
                    player.playSound(SoundLoader.GAN, 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 9:
                    player.playSound(SoundLoader.LE, 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 10:
                    player.addItemStackToInventory(new ItemStack(RegisterLoader.itemShit, 1));
                    player.getFoodStats().addStats(-6, 0);
                    clickTime = 1;
                    return ActionResultType.SUCCESS;
                default:
                    clickTime++;
                    return ActionResultType.SUCCESS;
            }
        }
        return ActionResultType.FAIL;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(FACING, Objects.requireNonNull(context.getPlayer()).getHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(FACING, direction.rotate(state.get(FACING)));
    }

    @Nonnull
    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
