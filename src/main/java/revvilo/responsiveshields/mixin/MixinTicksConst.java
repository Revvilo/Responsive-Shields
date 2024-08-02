package revvilo.responsiveshields.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.world.entity.LivingEntity;
import revvilo.responsiveshields.config.Config;

@Mixin(LivingEntity.class)
public class MixinTicksConst {
    @ModifyConstant(method = "isBlocking", constant = @Constant(intValue = 5))
    private int setShieldUseDelay(int constant) {
        if(Config.IS_ENABLED.get()) return Config.SHIELD_DELAY.get();
        return constant;
    }
}
