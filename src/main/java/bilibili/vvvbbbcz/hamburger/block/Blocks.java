package bilibili.vvvbbbcz.hamburger.block;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import net.minecraft.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Blocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, Hamburger.MODID);
    public static final Block OAK_TOILET = register("oak_toilet", new WoodToiletBlock());
    public static final Block SPRUCE_TOILET = register("spruce_toilet", new WoodToiletBlock());
    public static final Block BIRCH_TOILET = register("birch_toilet", new WoodToiletBlock());
    public static final Block JUNGLE_TOILET = register("jungle_toilet", new WoodToiletBlock());
    public static final Block ACACIA_TOILET = register("acacia_toilet", new WoodToiletBlock());
    public static final Block DARK_OAK_TOILET = register("dark_oak_toilet", new WoodToiletBlock());
    public static final Block LEMON_TOILET = register("lemon_toilet", new WoodToiletBlock());
    public static final Block STONE_TOILET = register("stone_toilet", new StoneToiletBlock());
    public static final Block IRON_TOILET = register("iron_toilet", new IronToiletBlock());
    public static final Block GOLD_TOILET = register("gold_toilet", new GoldToiletBlock());
    public static final Block DIAMOND_TOILET = register("diamond_toilet", new DiamondToiletBlock());
    public static final Block LEMON_LOG = register("lemon_log", new LemonLogBlock());
    public static final Block LEMON_LEAVES = register("lemon_leaves", new LemonLeavesBlock());
    public static final Block LEMON_SAPLING = register("lemon_sapling", new LemonSaplingBlock());
    public static final Block LEMON_DOOR = register("lemon_door", new LemonDoorBlock());
    public static final Block LEMON_PLANKS = register("lemon_planks", new LemonPlanksBlock());
    public static final Block LEMON_STAIRS = register("lemon_stairs", new LemonStairsBlock());
    public static final Block SALT_ORE = register("salt_ore", new SaltOreBlock());
    public static final Block FERTILE_DIRT = register("fertile_dirt", new FertileDirtBlock());
    public static final Block FERTILE_GRASS_BLOCK = register("fertile_grass_block", new FertileGrassBlock());
    public static final Block FERTILE_FARMLAND = register("fertile_farmland", new FertileFarmlandBlock());
    // FluidBlocks
    public static final Block SHIT_FLUID_BLOCK = register("shit_fluid", new ShitFluidBlock());

    private static <T extends Block> T register(String name, T block) {
        BLOCKS.register(name, () -> block);
        return block;
    }
}
