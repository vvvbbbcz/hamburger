package bilibili.vvvbbbcz.hamburger.configure;

import bilibili.vvvbbbcz.largeprojectslao8.LargeprojectsLao8;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = LargeprojectsLao8.MODID)
@Config.LangKey("config.largeprojects.general")
public class ModConfig {
    @Config.Comment("The ID of the GUI when you right click lao8's iron pan.")
    @Config.LangKey("config.largeprojects.general.id_gui_iron_pan")
    @Config.Name("The GUI ID of iron pan")
    @Config.RangeInt(min = 0)
    @Config.RequiresMcRestart
    public static int ID_GUI_IRON_PAN = 100000001;

    @Config.Comment("The ID of the entity duck")
    @Config.LangKey("config.largeprojects.general.id_entity_duck")
    @Config.Name("The entity ID of duck")
    @Config.RangeInt(min = 0)
    @Config.RequiresMcRestart
    public static int ID_ENTITY_DUCK = 100000001;

    @Config.Comment("The ID of the entity duck egg")
    @Config.LangKey("config.largeprojects.general.id_entity_duck_egg")
    @Config.Name("The entity ID of duck egg")
    @Config.RangeInt(min = 0)
    @Config.RequiresMcRestart
    public static int ID_ENTITY_DUCK_EGG = 100000002;

    @Mod.EventBusSubscriber(modid = LargeprojectsLao8.MODID)
    public static class ConfigSyncHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(LargeprojectsLao8.MODID)) {
                ConfigManager.sync(LargeprojectsLao8.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
