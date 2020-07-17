package bilibili.vvvbbbcz.hamburger.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class BlockSaltOre extends Block {
    public BlockSaltOre() {
        super((Properties.create(Material.ROCK))
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(0)
                .hardnessAndResistance(1.5F, 10.0F)
                .sound(SoundType.STONE)
        );
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        int count = new Random().nextInt(5);
        drops.add(new ItemStack(RegisterLoader.itemSalt, 1 + count));
    }
}
