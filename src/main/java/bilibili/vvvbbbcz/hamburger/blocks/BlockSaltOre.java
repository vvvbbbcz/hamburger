package bilibili.vvvbbbcz.hamburger.blocks;

import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
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
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(0)
                .hardnessAndResistance(1.5F, 10.0F)
                .sound(SoundType.STONE)
        );
    }
}
