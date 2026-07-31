package net.wolren.land.forge;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.wolren.land.item.custom.CustomElytraItem;

@EventBusSubscriber(modid = "pride_land")
public class ForgeElytraHandler {
    @SubscribeEvent
    public static void onLivingTick(EntityTickEvent.Post event) {
        if (!(event.getEntity() instanceof LivingEntity entity)) return;

        ItemStack chestStack = entity.getEquippedStack(EquipmentSlot.CHEST);
        if (chestStack.isOf(Items.ELYTRA) || !(chestStack.getItem() instanceof CustomElytraItem)) return;

        entity.setFlag(7, true);
    }
}
