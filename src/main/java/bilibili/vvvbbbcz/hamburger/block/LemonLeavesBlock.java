package bilibili.vvvbbbcz.hamburger.block;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LemonLeavesBlock extends LeavesBlock {
    public LemonLeavesBlock() {
        super(Properties.create(Material.LEAVES)
                .tickRandomly()
                .hardnessAndResistance(0.2F)
                .sound(SoundType.PLANT)
                .notSolid()
        );
    }
}
