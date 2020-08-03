package bilibili.vvvbbbcz.hamburger.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class FertileDirtBlock extends Block {
    public FertileDirtBlock() {
        super(Properties.create(Material.EARTH, MaterialColor.DIRT).hardnessAndResistance(0.5F).sound(SoundType.GROUND));
    }
}
