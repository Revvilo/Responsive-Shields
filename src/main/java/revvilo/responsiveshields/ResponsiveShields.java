package revvilo.responsiveshields;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import revvilo.responsiveshields.config.Config;

@Mod("responsiveshields")
public class ResponsiveShields
{
    public ResponsiveShields() {
        ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "responsive-shields.toml");
    }
}
