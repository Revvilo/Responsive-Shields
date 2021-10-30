package revvilo.responsiveshields.server.overrides;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import revvilo.responsiveshields.common.config.Config;

public class OverrideShieldDelay {
    @SubscribeEvent(priority = EventPriority.HIGHEST) // TODO: Understand why this is needed
    public void ModifyShieldDelay(LivingAttackEvent event) {

        // If the attack doesn't bypass armour and the current use item isn't empty (empty meaning not using anything)
        if (!event.getSource().isBypassArmor() && !event.getEntityLiving().getUseItem().isEmpty())
        {
		    LivingEntity entity=event.getEntityLiving();
            ItemStack useItemStack = entity.getUseItem();
            
            if (useItemStack.getUseAnimation() == UseAction.BLOCK)
            {
                int baseUseDuration = useItemStack.getUseDuration();
                int shieldRaisedTickCount = baseUseDuration - entity.getUseItemRemainingTicks();

                // Minecraft chooses to block an attack only after the shield has been raised for more than 5 ticks.
                // We can bypass this by skipping the current use time to the base use time minus 5 ticks if they haven't yet passed.

                // Doing it this way enables complete control over how long the shield takes to work.
                if(shieldRaisedTickCount > Config.shield_delay.get())
            	{
                    ObfuscationReflectionHelper.setPrivateValue(LivingEntity.class, entity, baseUseDuration - 5, "field_184628_bn");
            	} else {
                    ObfuscationReflectionHelper.setPrivateValue(LivingEntity.class, entity, baseUseDuration, "field_184628_bn");
                }
                // Bro, reflection is sick.
            }
        }
    }
}
