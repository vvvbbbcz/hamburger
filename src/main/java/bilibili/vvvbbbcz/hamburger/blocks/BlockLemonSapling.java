package bilibili.vvvbbbcz.hamburger.blocks;

import bilibili.vvvbbbcz.hamburger.blocks.trees.LemonTree;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLemonSapling extends SaplingBlock {
    public BlockLemonSapling() {
        super(new LemonTree(), Properties.create(Material.PLANTS)
                .doesNotBlockMovement()
                .tickRandomly()
                .hardnessAndResistance(0.0F)
                .sound(SoundType.PLANT));
    }
}
