package net.wolren.land.entity.custom.living;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Shearable;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.wolren.land.block.ModBlocks;

public class MonoColorSheep extends BaseSheep implements Shearable {
    private static final EntityDataAccessor<Byte> isSheared = SynchedEntityData.defineId(MonoColorSheep.class, EntityDataSerializers.BYTE);
    private final ItemStack wool;

    public MonoColorSheep(EntityType<? extends BaseSheep> type, Level world, ItemStack wool) {
        super(type, world);
        this.wool = wool;
    }

    public ResourceLocation getLootTableId() {
        if (isSheared()) {
            return new ResourceLocation("minecraft", "entities/sheep");
        }
        return new ResourceLocation("pride_land", "entities/sheep/rainbow_sheep");
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(isSheared, (byte) 0);
    }

    public boolean isSheared() {
        return (entityData.get(isSheared) & 16) != 0;
    }

    public void setSheared(boolean sheared) {
        byte b0 = entityData.get(isSheared);
        if (sheared) {
            entityData.set(isSheared, (byte) (b0 | 16));
        } else {
            entityData.set(isSheared, (byte) (b0 & -17));
        }
    }

    public boolean readyForShearing() {
        return isAlive() && !isSheared() && !isBaby();
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() instanceof ShearsItem) {
            if (!level().isClientSide && readyForShearing()) {
                shear(SoundSource.PLAYERS);
                itemStack.hurtAndBreak(1, player, (playerEntity) -> playerEntity.broadcastBreakEvent(hand));
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return super.mobInteract(player, hand);
    }

    public void shear(SoundSource shearedSoundCategory) {
        level().playSound(null, this, SoundEvents.SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        setSheared(true);
        int i = 1 + random.nextInt(3);
        for (int j = 0; j < i; ++j) {
            ItemEntity itemEntity = spawnAtLocation(wool.getItem(), 1);
            if (itemEntity != null) {
                itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().add((random.nextFloat() - random.nextFloat()) * 0.1F, random.nextFloat() * 0.05F, (random.nextFloat() - random.nextFloat()) * 0.1F));
            }
        }
    }

    public static class RainbowSheepEntity extends MonoColorSheep {
        public RainbowSheepEntity(EntityType<? extends RainbowSheepEntity> type, Level world) {
            super(type, world, new ItemStack(ModBlocks.RAINBOW_WOOL));
        }
    }
}
