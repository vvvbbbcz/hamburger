package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.hamburger.blocks.*;
import bilibili.vvvbbbcz.hamburger.blocks.fluid.BlockFluidShit;
import bilibili.vvvbbbcz.hamburger.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterLoader {
    public static Block blockWoodWC = new BlockWoodWC();
    public static Block blockStoneWC = new BlockStoneWC();
    public static Block blockIronWC = new BlockIronWC();
    public static Block blockGoldWC = new BlockGoldWC();
    public static Item itemShit = new ItemShit();
    public static Item itemTofu = new ItemTofu();
    public static Item itemChouTofu = new ItemChouTofu();
    public static Item itemFuru = new ItemBeanCurd();
    public static Item itemMother = new ItemMother();
    public static Block blockSaltOre = new BlockSaltOre();
    public static Item itemSalt = new ItemSalt();
    public static Item itemWahaha = new ItemWahaha();
    public static Item itemLemonSeed = new ItemLemonSeed();
    public static Block blockLemonSapling = new BlockLemonSapling();
    public static Item itemLemon = new ItemLemon();
    public static Block blockLemonLog = new BlockLemonLog();
    public static Block blockLemonLeaf = new BlockLemonLeaf();
    public static Block blockLemonPlank = new BlockLemonPlank();
    public static Item itemDuckEgg = new ItemDuckEgg();
    public static ItemFood itemDuck = new ItemDuck();
    public static ItemFood itemDuckCooked = new ItemDuckCooked();
    public static Block blockIronPan = new BlockIronPan();
    public static ItemFood itemHamburger = new ItemHamburger();
    public static ItemFood itemHamburger8 = new ItemHamburger8();
    public static ItemFood itemBeforeSleep = new ItemBeforeSleep();
    public static ItemFood itemBeforeSleep8 = new ItemBeforeSleep8();
    public static ItemFood itemDuck8 = new ItemDuck8();
    // Fluids
    public static BlockFluidClassic fluidShit = new BlockFluidShit();

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(itemShit.setRegistryName("shit"));
        event.getRegistry().register(itemTofu.setRegistryName("tofu"));
        event.getRegistry().register(itemChouTofu.setRegistryName("chou_tofu"));
        event.getRegistry().register(itemFuru.setRegistryName("furu"));
        event.getRegistry().register(itemMother.setRegistryName("mother"));
        event.getRegistry().register(itemSalt.setRegistryName("salt"));
        event.getRegistry().register(itemWahaha.setRegistryName("wahaha"));
        event.getRegistry().register(itemLemonSeed.setRegistryName("lemon_seed"));
        event.getRegistry().register(itemLemon.setRegistryName("lemon"));
        event.getRegistry().register(itemDuckEgg.setRegistryName("duck_egg"));
        event.getRegistry().register(itemDuck.setRegistryName("duck"));
        event.getRegistry().register(itemDuckCooked.setRegistryName("duck_cooked"));
        event.getRegistry().register(itemHamburger.setRegistryName("hamburger"));
        event.getRegistry().register(itemHamburger8.setRegistryName("hamburger_8"));
        event.getRegistry().register(itemBeforeSleep.setRegistryName("before_sleep"));
        event.getRegistry().register(itemBeforeSleep8.setRegistryName("before_sleep_8"));
        event.getRegistry().register(itemDuck8.setRegistryName("duck_8"));

        /*---===方块的物品形式===---*/
        event.getRegistry().register(new BlockItem(blockWoodWC).setRegistryName("wood_wc"));
        event.getRegistry().register(new BlockItem(blockStoneWC).setRegistryName("stone_wc"));
        event.getRegistry().register(new BlockItem(blockIronWC).setRegistryName("iron_wc"));
        event.getRegistry().register(new BlockItem(blockGoldWC).setRegistryName("gold_wc"));
        event.getRegistry().register(new BlockItem(blockLemonLog).setRegistryName("lemon_log"));
        event.getRegistry().register(new BlockItem(blockLemonLeaf).setRegistryName("lemon_leaf"));
        event.getRegistry().register(new BlockItem(blockLemonPlank).setRegistryName("lemon_plank"));
        event.getRegistry().register(new BlockItem(blockSaltOre).setRegistryName("salt_ore"));
        event.getRegistry().register(new BlockItem(blockIronPan).setRegistryName("iron_pan"));
    }

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(blockWoodWC.setRegistryName("wood_wc"));
        event.getRegistry().register(blockStoneWC.setRegistryName("stone_wc"));
        event.getRegistry().register(blockIronWC.setRegistryName("iron_wc"));
        event.getRegistry().register(blockGoldWC.setRegistryName("gold_wc"));
        event.getRegistry().register(blockLemonSapling.setRegistryName("lemon_sapling"));
        event.getRegistry().register(blockLemonLog.setRegistryName("lemon_log"));
        event.getRegistry().register(blockLemonLeaf.setRegistryName("lemon_leaf"));
        event.getRegistry().register(blockLemonPlank.setRegistryName("lemon_plank"));
        event.getRegistry().register(blockSaltOre.setRegistryName("salt_ore"));
        event.getRegistry().register(blockIronPan.setRegistryName("iron_pan"));
        // Fluids
        event.getRegistry().register(fluidShit.setRegistryName("fluid_shit"));

        TileEntityLoader.register();
    }
    
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
        EntityLoader.registerEntities(event);
    }
}
