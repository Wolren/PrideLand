package net.wolren.land.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(
            method = "updateFallFlying",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/world/item/Item;)Z"
            ),
            cancellable = true
    )
    private void onIsOfForTickFallFlying(CallbackInfo ci) {
        LivingEntity self = (LivingEntity) (Object) this;
        ItemStack chestStack = self.getItemBySlot(EquipmentSlot.CHEST);
        if (!chestStack.is(Items.ELYTRA) && canGlide(chestStack)) {
            self.setSharedFlag(7, true);
            ci.cancel();
        }
    }

    private static boolean canGlide(ItemStack stack) {
        return !stack.isEmpty() && stack.getComponents().contains(net.minecraft.core.component.DataComponents.GLIDER);
    }
}
