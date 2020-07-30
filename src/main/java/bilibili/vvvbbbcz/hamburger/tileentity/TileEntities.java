package bilibili.vvvbbbcz.hamburger.tileentity;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Hamburger.MODID);
    public static final TileEntityType<IronPlateTileEntity> IRON_PLATE = register("iron_plate", TileEntityType.Builder.create(IronPlateTileEntity::new, Blocks.IRON_PLATE).build(null));

    private static <T extends TileEntity> TileEntityType<T> register(String name, TileEntityType<T> type) {
        TILE_ENTITIES.register(name, () -> type);
        return type;
    }
}
