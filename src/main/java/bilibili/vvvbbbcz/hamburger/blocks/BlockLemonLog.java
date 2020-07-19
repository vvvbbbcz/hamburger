package bilibili.vvvbbbcz.hamburger.blocks;

import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockLemonLog extends LogBlock {
    public BlockLemonLog() {
        super(MaterialColor.WOOD, Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0F)
                .sound(SoundType.WOOD)
        );
    }
}
