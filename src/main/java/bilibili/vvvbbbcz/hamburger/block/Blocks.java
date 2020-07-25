package bilibili.vvvbbbcz.hamburger.block;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Hamburger.MODID);
    public static final RegistryObject<Block> WOOD_TOILET = BLOCKS.register("wood_toilet", WoodToiletBlock::new);
    public static final RegistryObject<Block> STONE_TOILET = BLOCKS.register("stone_toilet", StoneToiletBlock::new);
    public static final RegistryObject<Block> IRON_TOILET = BLOCKS.register("iron_toilet", IronToiletBlock::new);
    public static final RegistryObject<Block> GOLD_TOILET = BLOCKS.register("gold_toilet", GoldToiletBlock::new);
    public static final RegistryObject<Block> LEMON_LOG = BLOCKS.register("lemon_log", LemonLogBlock::new);
    public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", LemonLeavesBlock::new);
    public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", LemonSaplingBlock::new);
    public static final RegistryObject<Block> LEMON_PLANKS = BLOCKS.register("lemon_planks", LemonPlanksBlock::new);
    public static final RegistryObject<Block> SALT_ORE = BLOCKS.register("salt_ore", SaltOreBlock::new);
    public static final RegistryObject<Block> IRON_PLATE = BLOCKS.register("iron_plate", IronPlateBlock::new);

    public static Block lemonSapling = new LemonSaplingBlock();
//    public static final RegistryObject<Block> SHIT_FLUID_BLOCK = BLOCKS.register("shit_fluid", ShitFluidBlock::new);
}
