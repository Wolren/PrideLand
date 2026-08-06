package net.wolren.land.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    /**
     * 1.20.1 LivingEntity.tickFallFlying gates both the flight flag AND the
     * durability damage behind chestStack.isOf(Items.ELYTRA). The old @Inject +
     * cancel approach short-circuited the whole method for custom elytra, so
     * the damage call (every 10 ticks) never ran. Redirect the isOf instead so
     * the original flow continues into the damage statement.
     */
    @Redirect(
            method = "tickFallFlying",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            )
    )
    private boolean redirectIsOfForTickFallFlying(ItemStack stack, Item item) {
        if (stack.getItem() instanceof ElytraItem && !stack.isOf(Items.ELYTRA)) {
            return true;
        }
        return stack.isOf(item);
    }
}
