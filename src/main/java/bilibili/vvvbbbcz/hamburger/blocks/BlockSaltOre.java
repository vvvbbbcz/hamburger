package bilibili.vvvbbbcz.hamburger.blocks;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockSaltOre extends Block {
    public BlockSaltOre() {
        super(Material.ROCK);
        this.setUnlocalizedName("saltOre");
        this.setHarvestLevel("pickaxe", 0);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        int count = new Random().nextInt(5);
        drops.add(new ItemStack(RegisterLoader.itemSalt, 1 + count));
    }
}
