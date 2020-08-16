package bilibili.vvvbbbcz.hamburger.block;

import net.minecraft.block.DoorBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class LemonDoorBlock extends DoorBlock {
    protected LemonDoorBlock() {
        super(Properties.create(Material.WOOD).hardnessAndResistance(3.0F).sound(SoundType.WOOD).notSolid());
    }
}
