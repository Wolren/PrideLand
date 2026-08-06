package net.wolren.land.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    /**
     * Vanilla gates the flight start behind chestStack.isOf(Items.ELYTRA).
     * Redirect so custom elytra start flying and the original method
     * continues normally.
     */
    @Redirect(
            method = "checkFallFlying",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            )
    )
    private boolean redirectIsOfForCheckFallFlying(ItemStack stack, Item item) {
        if (stack.getItem() instanceof ElytraItem && !stack.isOf(Items.ELYTRA)) {
            return true;
        }
        return stack.isOf(item);
    }
}
