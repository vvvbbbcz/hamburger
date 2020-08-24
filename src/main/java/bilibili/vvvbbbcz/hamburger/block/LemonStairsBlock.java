package bilibili.vvvbbbcz.hamburger.block;

import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;

public class LemonStairsBlock extends StairsBlock {
    public LemonStairsBlock() {
        super(Blocks.LEMON_PLANKS::getDefaultState, Properties.create(Material.WOOD));
    }
}
