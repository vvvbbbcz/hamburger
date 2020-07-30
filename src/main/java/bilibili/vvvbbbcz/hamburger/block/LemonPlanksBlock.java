package bilibili.vvvbbbcz.hamburger.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LemonPlanksBlock extends Block {
    public LemonPlanksBlock() {
        super(Properties.create(Material.WOOD)
                .hardnessAndResistance(2.0F, 3.0F)
                .sound(SoundType.WOOD));
    }
}
