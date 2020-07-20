package bilibili.vvvbbbcz.hamburger.items;

import bilibili.vvvbbbcz.hamburger.loaders.ItemGroupLoader;
import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
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

public class ItemLemonSeed extends Item {
    public ItemLemonSeed() {
        super(new Properties().group(ItemGroupLoader.HAMBURGER));
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
        if (direction == Direction.UP && player.canPlayerEdit(pos.offset(direction), direction, itemstack) && world.isAirBlock(pos.up()) && soil == Blocks.GRASS) {
            world.setBlockState(pos.up(), RegisterLoader.blockLemonSapling.getDefaultState());

            itemstack.shrink(1);
            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.FAIL;
        }
    }
}