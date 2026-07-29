package net.wolren.land.entity.custom.living;

import java.util.Optional;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.wolren.land.block.ModBlocks;

public class MonoColorSheep extends BaseSheep implements Shearable {
    private static final TrackedData<Byte> isSheared = DataTracker.registerData(MonoColorSheep.class, TrackedDataHandlerRegistry.BYTE);
    private final ItemStack wool;

    public MonoColorSheep(EntityType<? extends BaseSheep> type, World world, ItemStack wool) {
        super(type, world);
        this.wool = wool;
    }

    public Optional<RegistryKey<LootTable>> getLootTableKey() {
        if (isSheared()) {
            return Optional.of(RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("minecraft", "entities/sheep")));
        }
        return Optional.of(RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("pride_land", "entities/sheep/rainbow_sheep")));
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(isSheared, (byte) 0);
    }

    public boolean isSheared() {
        return (dataTracker.get(isSheared) & 16) != 0;
    }

    public void setSheared(boolean sheared) {
        byte b0 = dataTracker.get(isSheared);
        if (sheared) {
            dataTracker.set(isSheared, (byte) (b0 | 16));
        } else {
            dataTracker.set(isSheared, (byte) (b0 & -17));
        }
    }

    public boolean isShearable() {
        return isAlive() && !isSheared() && !isBaby();
    }

    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.getItem() instanceof ShearsItem) {
            if (!getEntityWorld().isClient() && isShearable()) {
                sheared(SoundCategory.PLAYERS);
                itemStack.damage(1, player, hand);
                return ActionResult.SUCCESS;
            }
            return ActionResult.CONSUME;
        }
        return super.interactMob(player, hand);
    }

    public void sheared(SoundCategory shearedSoundCategory) {
        getEntityWorld().playSoundFromEntity(null, this, SoundEvents.ENTITY_SHEEP_SHEAR, shearedSoundCategory, 1.0F, 1.0F);
        setSheared(true);
        int i = 1 + random.nextInt(3);
        for (int j = 0; j < i; ++j) {
            ItemEntity itemEntity = dropItem((ServerWorld) getEntityWorld(), wool.getItem());
            if (itemEntity != null) {
                itemEntity.setVelocity(itemEntity.getVelocity().add((random.nextFloat() - random.nextFloat()) * 0.1F, random.nextFloat() * 0.05F, (random.nextFloat() - random.nextFloat()) * 0.1F));
            }
        }
    }

    public static class RainbowSheepEntity extends MonoColorSheep {
        public RainbowSheepEntity(EntityType<? extends RainbowSheepEntity> type, World world) {
            super(type, world, new ItemStack(ModBlocks.RAINBOW_WOOL));
        }
    }
}
