package bilibili.vvvbbbcz.hamburger.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLemonPlank extends Block {
    public BlockLemonPlank() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.WOOD));
    }
}
