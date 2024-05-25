package revvilo.responsiveshields.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import net.minecraft.entity.EntityLivingBase;
import revvilo.responsiveshields.config.ModConfig;

@Mixin(EntityLivingBase.class)
public class MixinTicksConst {
    @ModifyConstant(method = "isActiveItemStackBlocking", constant = @Constant(intValue = 5))
    private int setShieldUseDelay(int constant) {
        if(ModConfig.isOverrideEnabled) return ModConfig.shieldDelay;
        return constant;
    }
}
