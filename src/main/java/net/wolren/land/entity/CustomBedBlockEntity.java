package net.wolren.land.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BedBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;
import net.wolren.land.util.BedTextureProvider;

public class CustomBedBlockEntity extends BlockEntity {
    public final SpriteIdentifier bedTexture;

    public CustomBedBlockEntity(BlockPos pos, BlockState state) {
        super(ModEntities.CUSTOM_BED_BLOCK_ENTITY, pos, state);
        this.bedTexture = BedTextureProvider.getSpriteIdentifierForBed(state.getBlock());
    }

    public CustomBedBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.bedTexture = BedTextureProvider.getSpriteIdentifierForBed(state.getBlock());
    }

    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }
}