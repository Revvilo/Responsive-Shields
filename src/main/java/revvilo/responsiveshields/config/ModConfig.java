package revvilo.responsiveshields.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeInt;
import revvilo.responsiveshields.ResponsiveShields;

@Config(modid = ResponsiveShields.MOD_ID)
public class ModConfig {
    
    @Name("Enabled")
    @Comment("Whether or not the mods effect is enabled.")
    public static boolean isOverrideEnabled = true;

    @Comment({"The amount of time, in ticks, before a shield will block.",
        "",
        "Info:",
        "- Vanilla Minecraft has a hard-coded 5 tick delay after right clicking before a shield will block.",
        "- Setting Raise Time to 5 is the same as vanilla.",
        "- Setting Raise Time to 0 makes shields capable of blocking instantaniously.",
        "- The client-side raise animation takes roughly one tick to complete from the POV of the player. So setting Raise Time to 1 is a good balance between tactility and balance.",
        "- Use 0 to make shields esports ready lol",
        ""
        })
    @RangeInt(min = 0)
    @Name("Raise Time")
    public static int shieldDelay = 0;
}
