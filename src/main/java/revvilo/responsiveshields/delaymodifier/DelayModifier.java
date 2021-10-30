package revvilo.responsiveshields.delaymodifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class DelayModifier {
    @SubscribeEvent(priority = EventPriority.HIGHEST) // TODO: Understand why this is needed
    
    public void ModifyShieldDelay(LivingAttackEvent event) {
        System.out.println("LivingAttackEvent fired");
        int delayDelta = -5; // TODO: Add configuration to adjust shield delay
		LivingEntity entity=event.getEntityLiving();
		DamageSource damageSourceIn=event.getSource();

        
        if (!damageSourceIn.isBypassArmor() && !entity.getUseItem().isEmpty())
        {
            ItemStack useItemStack = entity.getUseItem();
            Item useItem = useItemStack.getItem();
            
            if (useItem.getUseAnimation(useItemStack) == UseAction.BLOCK)
            {
                System.out.println(String.format("\n\tuseItemStack.getUseDuration() = %s\n\tentity.getUseItemRemainingTicks() = %s", useItemStack.getUseDuration(), entity.getUseItemRemainingTicks()));
                System.out.println(useItemStack.getUseDuration() - entity.getUseItemRemainingTicks());
                if(useItemStack.getUseDuration() - entity.getUseItemRemainingTicks() < 5)
            	{
                    // Minecraft chooses to only say that the player is 'blocking' after the shield has been raised for more than 5 ticks.
                    System.out.println("\n\tUse time delta was less than 5");
                    // Set 'useItemRemaining' of the player to that of the item's use time modified by the delayDelta setting.
                    ObfuscationReflectionHelper.setPrivateValue(LivingEntity.class, entity, useItemStack.getUseDuration() + delayDelta, "useItemRemaining");
            	}
            }
        }
    }
}
