package revvilo.responsiveshields.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue shieldDelay;
    public static final ForgeConfigSpec.BooleanValue isOverrideEnabled;

    static {
        BUILDER.comment(  " ------------------------------",
        " Vanilla Minecraft has a hard-coded 5 tick delay after right clicking before a shield becomes functional.",
        " Setting Raise Time to 5 has the same effect as disabling the mod using the Enable Delay Override setting below it.",
        " Setting Raise Time to 0 makes shields capable of blocking instantaniously.",
        " The client-side raise animation takes roughly one tick to complete from the POV of the player. So setting Raise Time to 1 is a good balance between tactility and balance.",
        " Use 0 to make shields esports ready lol",
        " ------------------------------"
        ).push("Timing");
        {
            shieldDelay = BUILDER.comment(" The amount of time, in ticks, that it takes for a shield to raise.").defineInRange("Raise Time", 0, 0, 5);
        }
        BUILDER.pop();

        BUILDER.push("Toggles");
        {
            isOverrideEnabled = BUILDER.comment(" Whether or not the mods effect is enabled. (false completely bypasses the mod's delay override code and lets Vanilla do its thing.)").define("Enable Delay Override", true);
        }
        BUILDER.pop();
        
        SPEC = BUILDER.build();
    }
}
