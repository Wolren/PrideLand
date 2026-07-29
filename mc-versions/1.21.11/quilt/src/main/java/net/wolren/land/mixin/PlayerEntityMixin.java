package net.wolren.land.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Inject(
            method = "checkFallFlying",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"
            ),
            cancellable = true
    )
    private void onIsOfForCheckFallFlying(CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity self = (PlayerEntity) (Object) this;
        ItemStack chestStack = self.getEquippedStack(EquipmentSlot.CHEST);
        if (!chestStack.isOf(Items.ELYTRA) && chestStack.getItem() instanceof ElytraItem && ElytraItem.isUsable(chestStack)) {
            self.startFallFlying();
            cir.setReturnValue(true);
        }
    }
}
