package bilibili.vvvbbbcz.hamburger.blocks.fluid;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.FluidLoader;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraftforge.fluids.BlockFluidClassic;

import javax.annotation.Nonnull;

public class BlockFluidShit extends BlockFluidClassic {
    public BlockFluidShit() {
        super(FluidLoader.fluidShit, Material.WATER);
        this.setUnlocalizedName("shit");
    }

    @Nonnull
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }
}
