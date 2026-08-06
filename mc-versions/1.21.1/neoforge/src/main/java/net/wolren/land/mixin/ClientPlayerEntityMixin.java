package net.wolren.land.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    /**
     * 1.21.1 ClientPlayerEntity.tickMovement gates elytra flight with a hardcoded
     * chestStack.isOf(Items.ELYTRA) check BEFORE calling checkFallFlying() — the
     * checkFallFlying mixin is never reached for custom elytras, so the
     * START_FALL_FLYING packet is never sent. Redirect the isOf to accept any
     * usable ElytraItem.
     */
    @Redirect(
            method = "tickMovement",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            )
    )
    private boolean redirectIsOfForElytra(ItemStack stack, Item item) {
        if (stack.getItem() instanceof ElytraItem && !stack.isOf(Items.ELYTRA)) {
            return true;
        }
        return stack.isOf(item);
    }
}
