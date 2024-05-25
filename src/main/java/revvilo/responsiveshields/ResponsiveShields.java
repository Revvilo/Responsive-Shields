package revvilo.responsiveshields;

import net.minecraftforge.common.config.Config.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
// import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = ResponsiveShields.MOD_ID, name = ResponsiveShields.MOD_NAME, version = ResponsiveShields.MOD_VERSION)
public class ResponsiveShields
{
    public static final String MOD_ID = "responsiveshields";
    public static final String MOD_NAME = "Responsive Shields";
    public static final String MOD_VERSION = "2.3";

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onConfigChangedEvent(OnConfigChangedEvent event)
    {
        if (event.getModID().equals(ResponsiveShields.MOD_ID))
        {
            ConfigManager.sync(ResponsiveShields.MOD_ID, Type.INSTANCE);
        }
    }
    // public ResponsiveShields() {
    //     ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "responsive-shields.toml");
    // }
}

