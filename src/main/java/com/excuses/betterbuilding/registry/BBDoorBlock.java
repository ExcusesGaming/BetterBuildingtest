package com.excuses.betterbuilding.registry;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class BBDoorBlock extends DoorBlock {

    public BBDoorBlock(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return true;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        state = state.cycle(OPEN);
        world.setBlockState(pos, state, 10);
        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        Boolean open = state.get(OPEN);
        DoorHinge hinge = state.get(HINGE);
        switch(dir) {

                case NORTH:
                    if (!open) {
                        return VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 1.0f, 0.6f);
                    }
                    switch (hinge) {
                        case LEFT:
                            return VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 0.2f, 1.0f, 1.3f);
                        case RIGHT:
                            return VoxelShapes.cuboid(0.8f, 0.0f, 0.4f, 1.0f, 1.0f, 1.3f);
                    }
            case SOUTH:
                    if (!open) {
                        return VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 1.0f, 0.6f);
                    }
                switch (hinge) {
                    case LEFT:
                        return VoxelShapes.cuboid(0.8f, 0.0f, -0.3f, 1.0f, 1.0f, 0.6f);
                    case RIGHT:
                        return VoxelShapes.cuboid(0.0f, 0.0f, -0.3f, 0.2f, 1.0f, 0.6f);
                }
            case EAST:
                    if (!open) {
                        return VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 1.0f, 1.0f);
                    }
                switch (hinge) {
                    case LEFT:
                        return VoxelShapes.cuboid(-0.3f, 0.0f, 0.0f, 0.6f, 1.0f, 0.2f);
                    case RIGHT:
                        return VoxelShapes.cuboid(-0.3f, 0.0f, 0.8f, 0.6f, 1.0f, 1.0f);
                }
            case WEST:
                    if (!open) {
                        return VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 1.0f, 1.0f);
                    }
                switch (hinge) {
                    case LEFT:
                        return VoxelShapes.cuboid(0.4f, 0.0f, 0.8f, 1.3f, 1.0f, 1.0f);
                    case RIGHT:
                        return VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 1.3f, 1.0f, 0.2f);
                }
            default:
                    return super.getOutlineShape(state, view, pos, context);
        }
    }
}
