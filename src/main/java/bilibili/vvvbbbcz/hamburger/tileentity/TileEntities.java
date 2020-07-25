package bilibili.vvvbbbcz.hamburger.tileentity;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntities {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, Hamburger.MODID);
    public static final RegistryObject<TileEntityType<IronPlateTileEntity>> IRON_PLATE = TILE_ENTITIES.register("iron_plate", () -> TileEntityType.Builder.create(IronPlateTileEntity::new, Blocks.IRON_PLATE.get()).build(null));
}
