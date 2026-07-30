package net.wolren.land.forge;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "pride_land")
public class ForgeElytraHandler {
    /**
     * Forge doesn't remap mixin method entries correctly when using Yarn mappings,
     * so we handle custom elytra flight via events instead of mixins.
     *
     * This runs every tick when the entity is fall-flying. If the chest slot
     * contains a custom elytra subclass, keep the fall flying flag active so
     * LivingEntity.tickFallFlying() applies damage and continues flight logic.
     */
    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (!entity.isFallFlying()) return;

        ItemStack chestStack = entity.getEquippedStack(EquipmentSlot.CHEST);
        if (chestStack.isOf(Items.ELYTRA) || !(chestStack.getItem() instanceof ElytraItem)) return;

        entity.setFlag(7, true);
    }
}
