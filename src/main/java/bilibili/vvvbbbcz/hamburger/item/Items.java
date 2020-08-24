package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Hamburger.MODID);
    public static final Item SHIT = register("shit", new ShitItem());
    public static final Item TOFU = register("tofu", new TofuItem());
    public static final Item STINKY_TOFU = register("stinky_tofu", new StinkyTofuItem());
    public static final Item FERMENT_BEAN_CURD = register("ferment_bean_curd", new FermentedBeanCurdItem());
    public static final Item OLD_GODMOTHER = register("old_godmother", new OldGodmotherItem());
    public static final Item SALT = register("salt", new SaltItem());
    public static final Item WOW_HA_HA = register("wow_ha_ha", new WowHaHaItem());
    public static final Item LEMON_SEED = register("lemon_seed", new LemonSeedItem());
    public static final Item LEMON = register("lemon", new LemonItem());
    public static final Item DUCK_EGG = register("duck_egg", new DuckEggItem());
    public static final Item DUCK = register("duck", new DuckItem());
    public static final Item GRILLED_DUCK = register("grilled_duck", new GrilledDuckItem());
    public static final Item HAMBURGER = register("hamburger", new HamburgerItem());
    public static final Item HAMBURGER_8 = register("hamburger_8", new Hamburger8Item());
    public static final Item SWEETS_BEFORE_SLEEP = register("sweets_before_sleep", new SweetsBeforeSleepItem());
    public static final Item SWEETS_BEFORE_SLEEP_8 = register("sweets_before_sleep_8", new SweetsBeforeSleep8Item());
    public static final Item DUCK_BUTT = register("duck_butt", new DuckButtItem());
    public static final Item SHIT_BUCKET = register("shit_bucket", new ShitFluidBucketItem());
    public static final Item DUCK_SPAWN_EGG = register("duck_spawn_egg", new DuckSpawnEggItem());
    public static final Item LAO_BA_SPAWN_EGG = register("lao_ba_spawn_egg", new LaoBaSpawnEggItem());

    // BlockItems
    public static final Item OAK_TOILET = register("oak_toilet", new BlockItem(Blocks.OAK_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item SPRUCE_TOILET = register("spruce_toilet", new BlockItem(Blocks.SPRUCE_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item BIRCH_TOILET = register("birch_toilet", new BlockItem(Blocks.BIRCH_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item JUNGLE_TOILET = register("jungle_toilet", new BlockItem(Blocks.JUNGLE_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item ACACIA_TOILET = register("acacia_toilet", new BlockItem(Blocks.ACACIA_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item DARK_OAK_TOILET = register("dark_oak_toilet", new BlockItem(Blocks.DARK_OAK_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item LEMON_TOILET = register("lemon_toilet", new BlockItem(Blocks.LEMON_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item STONE_TOILET = register("stone_toilet", new BlockItem(Blocks.STONE_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item IRON_TOILET = register("iron_toilet", new BlockItem(Blocks.IRON_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item GOLD_TOILET = register("gold_toilet", new BlockItem(Blocks.GOLD_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item DIAMOND_TOILET = register("diamond_toilet", new BlockItem(Blocks.DIAMOND_TOILET, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item LEMON_LOG = register("lemon_log", new BlockItem(Blocks.LEMON_LOG, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item LEMON_LEAVES = register("lemon_leaves", new BlockItem(Blocks.LEMON_LEAVES, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item LEMON_PLANKS = register("lemon_planks", new BlockItem(Blocks.LEMON_PLANKS, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item SALT_ORE = register("salt_ore", new BlockItem(Blocks.SALT_ORE, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item FERTILE_DIRT = register("fertile_dirt", new BlockItem(Blocks.FERTILE_DIRT, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item FERTILE_GRASS_BLOCK = register("fertile_grass_block", new BlockItem(Blocks.FERTILE_GRASS_BLOCK, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item FERTILE_FARMLAND = register("fertile_farmland", new BlockItem(Blocks.FERTILE_FARMLAND, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item LEMON_DOOR = register("lemon_door", new BlockItem(Blocks.LEMON_DOOR, new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final Item LEMON_STAIRS = register("lemon_stairs", new BlockItem(Blocks.LEMON_STAIRS, new Item.Properties().group(ItemGroups.HAMBURGER)));

    private static Item register(String name, Item item) {
        ITEMS.register(name, () -> item);
        return item;
    }
}
