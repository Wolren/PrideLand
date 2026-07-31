package net.wolren.land.forge;

import net.minecraft.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.wolren.land.LandCommon;

/**
 * Custom elytra flight handler.
 *
 * NeoForge 21.1 doesn't have LivingEvent.LivingTickEvent (added in 21.3+).
 * This handler is disabled for 1.21.1; custom elytra flight is handled via mixins
 * in the common module instead.
 */
//@EventBusSubscriber(modid = LandCommon.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ForgeElytraHandler {
    /**
     * This would run every tick when the entity is fall-flying.
     * Disabled in 1.21.1 because LivingEvent.LivingTickEvent doesn't exist yet.
     */
    /*
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (!entity.isFallFlying()) return;

        ItemStack chestStack = entity.getEquippedStack(EquipmentSlot.CHEST);
        if (chestStack.isOf(Items.ELYTRA) || !(chestStack.getItem() instanceof ElytraItem)) return;

        entity.setFlag(7, true);
    }
    */
}
