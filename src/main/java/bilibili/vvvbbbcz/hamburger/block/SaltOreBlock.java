package bilibili.vvvbbbcz.hamburger.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SaltOreBlock extends Block {
    public SaltOreBlock() {
        super(Properties.create(Material.ROCK)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(0)
                .hardnessAndResistance(1.5F, 10.0F)
                .sound(SoundType.STONE)
        );
    }
}
