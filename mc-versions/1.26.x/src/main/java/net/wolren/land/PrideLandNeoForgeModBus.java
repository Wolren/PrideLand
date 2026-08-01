package net.wolren.land;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.wolren.land.entity.ModEntities;
import net.minecraft.world.entity.animal.sheep.Sheep;

/**
 * NeoForge mod-bus event handler for PrideLand.
 * Handles entity attribute registration (mod event bus).
 */
@EventBusSubscriber(modid = PrideLand.MOD_ID)
public class PrideLandNeoForgeModBus {

    @SubscribeEvent
    public static void onAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntities.RAINBOW_SHEEP.get(), Sheep.createAttributes().build());
    }
}
