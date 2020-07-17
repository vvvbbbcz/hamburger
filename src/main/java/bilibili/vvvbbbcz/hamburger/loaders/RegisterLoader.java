package bilibili.vvvbbbcz.hamburger.loaders;

import bilibili.vvvbbbcz.largeprojectslao8.blocks.*;
import bilibili.vvvbbbcz.largeprojectslao8.blocks.fluid.BlockFluidShit;
import bilibili.vvvbbbcz.largeprojectslao8.items.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemFood;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

@Mod.EventBusSubscriber
public class RegisterLoader {
    public static Block blockWoodWC = new BlockWoodWC();
    public static Block blockStoneWC = new BlockStoneWC();
    public static Block blockIronWC = new BlockIronWC();
    public static Block blockGoldWC = new BlockGoldWC();
    public static Item itemShit = new ItemShit();
    public static Item itemTofu = new ItemTofu();
    public static Item itemChouTofu = new ItemChouTofu();
    public static Item itemFuru = new ItemFuru();
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
    public static void registerItems(RegistryEvent.Register<Item> event) {
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
        event.getRegistry().register(new ItemBlock(blockWoodWC).setRegistryName("wood_wc"));
        event.getRegistry().register(new ItemBlock(blockStoneWC).setRegistryName("stone_wc"));
        event.getRegistry().register(new ItemBlock(blockIronWC).setRegistryName("iron_wc"));
        event.getRegistry().register(new ItemBlock(blockGoldWC).setRegistryName("gold_wc"));
        event.getRegistry().register(new ItemBlock(blockLemonLog).setRegistryName("lemon_log"));
        event.getRegistry().register(new ItemBlock(blockLemonLeaf).setRegistryName("lemon_leaf"));
        event.getRegistry().register(new ItemBlock(blockLemonPlank).setRegistryName("lemon_plank"));
        event.getRegistry().register(new ItemBlock(blockSaltOre).setRegistryName("salt_ore"));
        event.getRegistry().register(new ItemBlock(blockIronPan).setRegistryName("iron_pan"));
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
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

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        reg(blockWoodWC, 0);
        reg(blockStoneWC, 0);
        reg(blockIronWC, 0);
        reg(blockGoldWC, 0);
        reg(itemShit, 0);
        reg(itemTofu, 0);
        reg(itemChouTofu, 0);
        reg(itemFuru, 0);
        reg(itemMother, 0);
        reg(blockSaltOre, 0);
        reg(itemSalt, 0);
        reg(itemWahaha, 0);
        reg(itemLemonSeed, 0);
        reg(blockLemonSapling, 0);
        reg(itemLemon, 0);
        reg(blockLemonLog, 0);
        reg(blockLemonLeaf, 0);
        reg(blockLemonPlank, 0);
        reg(itemDuckEgg, 0);
        reg(blockIronPan, 0);
        reg(itemDuck, 0);
        reg(itemDuckCooked, 0);
        reg(itemHamburger, 0);
        reg(itemHamburger8, 0);
        reg(itemBeforeSleep, 0);
        reg(itemBeforeSleep8, 0);
        reg(itemDuck8, 0);

        EntityLoader.registerEntityRenders();
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        EntityLoader.registerEntities(event);
    }

    @SideOnly(Side.CLIENT)
    private static void reg(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }

    @SideOnly(Side.CLIENT)
    private static void reg(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Objects.requireNonNull(block.getRegistryName()), "inventory"));
    }
}
