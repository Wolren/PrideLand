package net.wolren.land.entity.custom.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.wolren.land.entity.ModEntities;

public class CustomBedBlockEntity extends BlockEntity {

    public CustomBedBlockEntity(BlockPos pos, BlockState state) {
        super(ModEntities.CUSTOM_BED_BLOCK_ENTITY, pos, state);
    }

    public CustomBedBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}