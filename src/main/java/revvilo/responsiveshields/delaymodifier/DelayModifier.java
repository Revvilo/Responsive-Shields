package revvilo.responsiveshields.delaymodifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class DelayModifier {
    @SubscribeEvent(priority = EventPriority.HIGHEST) // TODO: Understand why this is needed
    public void ModifyShieldDelay(LivingAttackEvent event) {

        // If the attack doesn't bypass armour and the current use item isn't empty (empty meaning not using anything)
        if (!event.getSource().isBypassArmor() && !event.getEntityLiving().getUseItem().isEmpty())
        {
		    LivingEntity entity=event.getEntityLiving();
            ItemStack useItemStack = entity.getUseItem();
            
            if (useItemStack.getUseAnimation() == UseAction.BLOCK)
            {
                // TODO: Add configuration to adjust shield delay
                int raiseDelay = 0; // Our custom amount of ticks that the shield has to be raised before 'blocking' is allowed
                // int tickReduction = 5; // Minecraft's amount of ticks that the shield has to be raised before the game 'blocks'
                
                int baseUseDuration = useItemStack.getUseDuration();
                int shieldRaisedTickCount = baseUseDuration - entity.getUseItemRemainingTicks();

                // Minecraft chooses to block an attack only after the shield has been raised for more than 5 ticks.
                // We can bypass this by skipping the current use time to the base use time minus 5 ticks if they haven't yet passed.

                // Doing it this way enables complete control over how long you have to have had the shield raised for.
                if(shieldRaisedTickCount > raiseDelay)
            	{
                    AllowBlocking(entity, baseUseDuration, 5);
            	} else {
                    DenyBlocking(entity, baseUseDuration);
                }
            }
        }
    }

    private void AllowBlocking(LivingEntity entity, int baseUseDuration, int tickReduction) {
        // Set 'useItemRemaining' of the player to that of the item's use time modified by the set tick count.
        ObfuscationReflectionHelper.setPrivateValue(LivingEntity.class, entity, baseUseDuration - tickReduction, "useItemRemaining");
    }

    private void DenyBlocking(LivingEntity entity, int baseUseDuration) {
        ObfuscationReflectionHelper.setPrivateValue(LivingEntity.class, entity, baseUseDuration, "useItemRemaining");
    }
}
