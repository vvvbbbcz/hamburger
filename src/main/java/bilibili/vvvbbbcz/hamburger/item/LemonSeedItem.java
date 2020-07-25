package bilibili.vvvbbbcz.hamburger.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public class LemonSeedItem extends Item {
    public LemonSeedItem() {
        super(new Properties().group(ItemGroups.HAMBURGER));
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        ItemStack itemstack = player.getHeldItem(context.getHand());
        BlockPos pos = context.getPos();
        World world = context.getWorld();
        Direction direction = context.getFace();
        Block soil = world.getBlockState(pos).getBlock();
        if (direction == Direction.UP && player.canPlayerEdit(pos.offset(direction), direction, itemstack) && world.isAirBlock(pos.up()) && soil == Blocks.GRASS_BLOCK) {
            world.setBlockState(pos.up(), bilibili.vvvbbbcz.hamburger.block.Blocks.LEMON_SAPLING.get().getDefaultState());

            itemstack.shrink(1);
            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.FAIL;
        }
    }
}