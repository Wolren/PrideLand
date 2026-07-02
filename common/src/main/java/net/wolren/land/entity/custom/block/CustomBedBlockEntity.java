package net.wolren.land.entity.custom.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.core.BlockPos;
import net.wolren.land.entity.ModEntities;

public class CustomBedBlockEntity extends BlockEntity {

    public CustomBedBlockEntity(BlockPos pos, BlockState state) {
        super(ModEntities.CUSTOM_BED_BLOCK_ENTITY, pos, state);
    }

    public CustomBedBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public ClientboundBlockEntityDataPacket toUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}