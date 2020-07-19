package bilibili.vvvbbbcz.hamburger.blocks;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLemonLeaf extends LeavesBlock {
    public BlockLemonLeaf() {
        super(Properties.create(Material.LEAVES)
                .tickRandomly()
                .hardnessAndResistance(0.2F)
                .sound(SoundType.PLANT)
                .notSolid()
        );
    }
}
