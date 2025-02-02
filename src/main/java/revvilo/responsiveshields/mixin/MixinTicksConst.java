package revvilo.responsiveshields.mixin;

import net.minecraft.entity.LivingEntity;
import revvilo.responsiveshields.ResponsiveShields;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Constant;

@Mixin(LivingEntity.class)
public class MixinTicksConst {
	@ModifyConstant(method = "isBlocking", constant = @Constant(intValue = 5))
	private int setShieldUseDelay(int constant) {
		if(ResponsiveShields.CONFIG.IS_ENABLED()) return ResponsiveShields.CONFIG.SHIELD_DELAY();
		return constant;
	}
}