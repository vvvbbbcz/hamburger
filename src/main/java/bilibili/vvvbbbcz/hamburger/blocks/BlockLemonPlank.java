package bilibili.vvvbbbcz.hamburger.blocks;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.CreativeTabLoader;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLemonPlank extends Block {
    public BlockLemonPlank() {
        super(Material.WOOD);
        this.setUnlocalizedName("lemonPlank");
        this.setSoundType(SoundType.WOOD);
        this.setHardness(2.0F);
        this.setHarvestLevel("axe", 0);
        this.setCreativeTab(CreativeTabLoader.tabLao8);
    }
}
