package revvilo.responsiveshields.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class Config {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Integer> shield_delay;

    static {
        BUILDER.push("Timing");
        {
            shield_delay = BUILDER.comment("The amount of time, in ticks, that it takes for a shield to raise.").define("Raise Time", 0);
        }
        BUILDER.pop();
        
        SPEC = BUILDER.build();
    }
}
