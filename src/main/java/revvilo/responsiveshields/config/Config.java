package revvilo.responsiveshields.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue shieldDelay;
    public static final ForgeConfigSpec.BooleanValue isOverrideEnabled;

    static {
        BUILDER.comment(  " ------------------------------",
        " Vanilla Minecraft has a hard-coded 5 tick delay after right clicking before a shield will block.",
        " Setting Raise Time to 5 is the same as vanilla.",
        " Setting Raise Time to 0 makes shields capable of blocking instantaniously.",
        " The client-side raise animation takes roughly one tick to complete from the POV of the player. So setting Raise Time to 1 is a good balance between tactility and balance.",
        " Use 0 to make shields esports ready lol",
        " ------------------------------"
        ).push("Timing");
        {
            shieldDelay = BUILDER.comment(" The amount of time, in ticks, before a shield will block").defineInRange("Raise Time", 0, 0, Integer.MAX_VALUE);
        }
        BUILDER.pop();

        BUILDER.push("Toggles");
        {
            isOverrideEnabled = BUILDER.comment(" Whether or not the mods effect is enabled.").define("Enable Delay Override", true);
        }
        BUILDER.pop();
        
        SPEC = BUILDER.build();
    }
}
