package bilibili.vvvbbbcz.hamburger.block;

import bilibili.vvvbbbcz.hamburger.item.Items;
import bilibili.vvvbbbcz.hamburger.util.SoundEvents;
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

public class StoneToiletBlock extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static int clickTime = 1;

    public StoneToiletBlock() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(1.5F, 5.0F)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(0)
        );
    }

    @Nonnull
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (player.getFoodStats().getFoodLevel() >= 6) {
            switch (clickTime) {
                case 1:
                    player.playSound(SoundEvents.AO.get(), 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 3:
                    player.playSound(SoundEvents.LI.get(), 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 5:
                    player.playSound(SoundEvents.GEI.get(), 1.0F, 1.0F);
                    clickTime++;
                    return ActionResultType.SUCCESS;
                case 6:
                    player.addItemStackToInventory(new ItemStack(Items.SHIT.get(), 1));
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
