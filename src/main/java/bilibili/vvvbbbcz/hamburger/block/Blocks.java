package bilibili.vvvbbbcz.hamburger.block;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Hamburger.MODID);
    public static final Block WOOD_TOILET = register("wood_toilet", new WoodToiletBlock());
    public static final Block STONE_TOILET = register("stone_toilet", new StoneToiletBlock());
    public static final Block IRON_TOILET = register("iron_toilet", new IronToiletBlock());
    public static final Block GOLD_TOILET = register("gold_toilet", new GoldToiletBlock());
    public static final Block LEMON_LOG = register("lemon_log", new LemonLogBlock());
    public static final Block LEMON_LEAVES = register("lemon_leaves", new LemonLeavesBlock());
    public static final Block LEMON_SAPLING = register("lemon_sapling", new LemonSaplingBlock());
    public static final Block LEMON_PLANKS = register("lemon_planks", new LemonPlanksBlock());
    public static final Block SALT_ORE = register("salt_ore", new SaltOreBlock());
    public static final Block IRON_PLATE = register("iron_plate", new IronPlateBlock());

    // FluidBlocks
//    public static final Block SHIT_FLUID_BLOCK = register("shit_fluid", new ShitFluidBlock());

    private static Block register(String name, Block block) {
        BLOCKS.register(name, () -> block);
        return block;
    }
}
