package bilibili.vvvbbbcz.hamburger.item;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Hamburger.MODID);
    public static final RegistryObject<Item> SHIT = ITEMS.register("shit", ShitItem::new);
    public static final RegistryObject<Item> TOFU = ITEMS.register("tofu", TofuItem::new);
    public static final RegistryObject<Item> STINKY_TOFU = ITEMS.register("stinky_tofu", StinkyTofuItem::new);
    public static final RegistryObject<Item> FERMENT_BEAN_CURD = ITEMS.register("ferment_bean_curd", FermentedBeanCurdItem::new);
    public static final RegistryObject<Item> OLD_GODMOTHER = ITEMS.register("old_godmother", OldGodmotherItem::new);
    public static final RegistryObject<Item> SALT = ITEMS.register("salt", SaltItem::new);
    public static final RegistryObject<Item> WOW_HA_HA = ITEMS.register("wow_ha_ha", WowHaHaItem::new);
    public static final RegistryObject<Item> LEMON_SEED = ITEMS.register("lemon_seed", LemonSeedItem::new);
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", LemonItem::new);
    public static final RegistryObject<Item> DUCK_EGG = ITEMS.register("duck_egg", DuckEggItem::new);
    public static final RegistryObject<Item> DUCK = ITEMS.register("duck", DuckItem::new);
    public static final RegistryObject<Item> GRILLED_DUCK = ITEMS.register("grilled_duck", GrilledDuckItem::new);
    public static final RegistryObject<Item> HAMBURGER = ITEMS.register("hamburger", HamburgerItem::new);
    public static final RegistryObject<Item> HAMBURGER_8 = ITEMS.register("hamburger_8", Hamburger8Item::new);
    public static final RegistryObject<Item> SWEETS_BEFORE_SLEEP = ITEMS.register("sweets_before_sleep", SweetsBeforeSleepItem::new);
    public static final RegistryObject<Item> SWEETS_BEFORE_SLEEP_8 = ITEMS.register("sweets_before_sleep_8", SweetsBeforeSleep8Item::new);
    public static final RegistryObject<Item> DUCK_BUTT = ITEMS.register("duck_butt", DuckButtItem::new);

    // BlockItems
    public static final RegistryObject<Item> WOOD_TOILET = ITEMS.register("wood_toilet", () -> new BlockItem(Blocks.WOOD_TOILET.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> STONE_TOILET = ITEMS.register("stone_toilet", () -> new BlockItem(Blocks.STONE_TOILET.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> IRON_TOILET = ITEMS.register("iron_toilet", () -> new BlockItem(Blocks.IRON_TOILET.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> GOLD_TOILET = ITEMS.register("gold_toilet", () -> new BlockItem(Blocks.GOLD_TOILET.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> LEMON_LOG = ITEMS.register("lemon_log", () -> new BlockItem(Blocks.LEMON_LOG.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> LEMON_LEAVES = ITEMS.register("lemon_leaves", () -> new BlockItem(Blocks.LEMON_LEAVES.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> LEMON_PLANKS = ITEMS.register("lemon_planks", () -> new BlockItem(Blocks.LEMON_PLANKS.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> SALT_ORE = ITEMS.register("salt_ore", () -> new BlockItem(Blocks.SALT_ORE.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));
    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new BlockItem(Blocks.IRON_PLATE.get(), new Item.Properties().group(ItemGroups.HAMBURGER)));

//    public static final RegistryObject<Item> SHIT_BUCKET = ITEMS.register("shit_bucket", ShitFluidBucketItem::new);
}
