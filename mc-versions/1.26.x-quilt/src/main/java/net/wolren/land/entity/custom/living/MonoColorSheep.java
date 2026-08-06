package net.wolren.land.entity.custom.living;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ItemBasedSteering;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.world.entity.Shearable;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootTable;
import net.wolren.land.block.ModBlocks;
import net.wolren.land.entity.ModEntities;

import java.util.Optional;

public class MonoColorSheep extends BaseSheep implements Shearable {
    private final ItemStack wool;

    public MonoColorSheep(EntityType<? extends BaseSheep> type, Level world, ItemStack wool) {
        super((EntityType<? extends BaseSheep>) type, world);
        this.wool = wool;
    }

    public Optional<ResourceKey<LootTable>> getRainbowLootTableKey() {
        if (isSheared()) {
            return Optional.of(ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("minecraft", "entities/sheep")));
        }
        return Optional.of(ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("pride_land", "entities/sheep/rainbow_sheep")));
    }

    @Override
    public boolean readyForShearing() {
        return isAlive() && !isSheared() && !isBaby();
    }

    @Override
    public void shear(ServerLevel world, SoundSource soundSource, ItemStack item) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, soundSource, 1.0F, 1.0F);
        setSheared(true);
        int i = 1 + random.nextInt(3);
        for (int j = 0; j < i; ++j) {
            spawnAtLocation(world, wool.copy());
        }
        this.gameEvent(GameEvent.SHEAR, this);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() instanceof ShearsItem) {
            if (!level().isClientSide() && readyForShearing()) {
                shear((ServerLevel) level(), SoundSource.PLAYERS, itemStack);
                itemStack.hurtAndBreak(1, player, hand);
                return InteractionResult.SUCCESS;
            }
            return InteractionResult.CONSUME;
        }
        return super.mobInteract(player, hand);
    }

    public static class RainbowSheepEntity extends MonoColorSheep {
        public RainbowSheepEntity(EntityType<? extends RainbowSheepEntity> type, Level world) {
            super((EntityType<? extends BaseSheep>) type, world, new ItemStack(ModBlocks.RAINBOW_WOOL));
        }
    }
}
