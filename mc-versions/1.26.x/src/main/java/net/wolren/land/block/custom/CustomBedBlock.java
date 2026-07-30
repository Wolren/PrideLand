package net.wolren.land.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.wolren.land.entity.custom.block.CustomBedBlockEntity;
import org.jetbrains.annotations.Nullable;

/**
 * Custom bed block for PrideLand.
 */
public class CustomBedBlock extends BedBlock {

    public CustomBedBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CustomBedBlockEntity(pos, state);
    }
}
