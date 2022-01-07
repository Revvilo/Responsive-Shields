package revvilo.responsiveshields.server.overrides;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import revvilo.responsiveshields.common.config.Config;

public class OverrideShieldDelay {
    // TODO: Find a way to set the current use time when the item is first right clicked
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void ModifyShieldDelay(LivingAttackEvent event) {

        // If the attack doesn't bypass armour and the player is currently using an item
        if (Config.isOverrideEnabled.get() && !event.getSource().isBypassArmor() && !event.getEntityLiving().getUseItem().isEmpty())
        {
            LivingEntity entity = event.getEntityLiving();
            ItemStack useItemStack = entity.getUseItem();
            
            // If the item in use 'blocks' like a shield
            if (useItemStack.getUseAnimation() == UseAnim.BLOCK)
            {
                int baseUseDuration = useItemStack.getUseDuration();
                int useItemRemainingTicks = entity.getUseItemRemainingTicks();
                int shieldRaisedTickCount = baseUseDuration - useItemRemainingTicks;

                // Minecraft chooses to block an attack only after the shield has been raised for more than 5 ticks.
                    // It checks this by looking at the difference between the current use time countdown and the base use time
                // We can bypass this by skipping the current use time to the base use time minus 5 ticks; the point where the game will block attacks.

                if(shieldRaisedTickCount > Config.shieldDelay.get() && shieldRaisedTickCount > Config.shieldDelay.get())
                {
                    ObfuscationReflectionHelper.setPrivateValue(LivingEntity.class, entity, baseUseDuration - 5, "f_20936_");
                }
                // Bro, reflection is sick.
            }
        }
    }
}
