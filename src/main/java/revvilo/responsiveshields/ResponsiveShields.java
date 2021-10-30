package revvilo.responsiveshields;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import revvilo.responsiveshields.delaymodifier.DelayModifier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("responsiveshields")
public class ResponsiveShields
{
    public ResponsiveShields() {
        MinecraftForge.EVENT_BUS.register(new DelayModifier());
    }
}
