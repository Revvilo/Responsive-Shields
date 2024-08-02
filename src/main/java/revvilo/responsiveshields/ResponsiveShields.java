package revvilo.responsiveshields;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig.Type;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import revvilo.responsiveshields.config.Config;

@Mod("responsiveshields")
public class ResponsiveShields
{
    public ResponsiveShields(IEventBus modEventBus, ModContainer container) {
        container.registerConfig(Type.SERVER, Config.SPEC, "responsive-shields.toml");
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}

