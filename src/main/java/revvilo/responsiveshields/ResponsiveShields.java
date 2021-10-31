package revvilo.responsiveshields;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.network.FMLNetworkConstants;
import revvilo.responsiveshields.common.config.Config;
import revvilo.responsiveshields.server.overrides.OverrideShieldDelay;

@Mod("responsiveshields")
public class ResponsiveShields
{
    public ResponsiveShields() {
        ModLoadingContext.get().registerConfig(Type.COMMON, Config.SPEC, "responsive-shields.toml");
        ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST, () -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (a, b) -> true));

        MinecraftForge.EVENT_BUS.register(new OverrideShieldDelay());
    }
}
