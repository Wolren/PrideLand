package net.wolren.land.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(
            method = "tickFallFlying",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            ),
            cancellable = true
    )
    private void onIsOfForTickFallFlying(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        ItemStack chestStack = self.getEquippedStack(EquipmentSlot.CHEST);
        if (!chestStack.isOf(Items.ELYTRA) && canGlide(chestStack)) {
            self.setFlag(7, true);
            ci.cancel();
        }
    }

    private static boolean canGlide(ItemStack stack) {
        return !stack.isEmpty() && stack.getComponents().contains(net.minecraft.component.DataComponentTypes.GLIDER);
    }
}
