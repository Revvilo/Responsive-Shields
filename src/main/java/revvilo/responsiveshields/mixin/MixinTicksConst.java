package revvilo.responsiveshields.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.entity.LivingEntity;
import revvilo.responsiveshields.config.Config;

@Mixin(LivingEntity.class)
public class MixinTicksConst {
    @ModifyConstant(method = "isBlocking", constant = @Constant(intValue = 5))
    private int setShieldUseDelay(int constant) {
        if(Config.isOverrideEnabled.get()) return Config.shieldDelay.get();
        return constant;
    }
}
