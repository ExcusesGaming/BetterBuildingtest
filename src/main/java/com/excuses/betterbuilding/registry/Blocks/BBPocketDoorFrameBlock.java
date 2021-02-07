package com.excuses.betterbuilding.registry.Blocks;

import com.excuses.betterbuilding.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class BBPocketDoorFrameBlock extends DoorBlock {

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        return ActionResult.SUCCESS;
    }

    public BBPocketDoorFrameBlock(Settings settings) {
        super(settings);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (posFrom.equals(pos.add(+1, 0, 0))) {
            if (newState.getBlock() == ModBlocks.POCKETDOOR_BOTTOM) {
                Direction state1 = newState.get(FACING);
                if(state1 == Direction.NORTH) {
                    return state.with(FACING, Direction.NORTH);
                }
            }
        }
        if (posFrom.equals(pos.add(-1, 0, 0))) {
            if (newState.getBlock() == ModBlocks.POCKETDOOR_BOTTOM) {
                Direction state1 = newState.get(FACING);
                if(state1 == Direction.SOUTH) {
                    return state.with(FACING, Direction.SOUTH);
                }
            }
        }
        return state;
    }

    @Override
     public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
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
                    if (open) {
                        switch (hinge) {
                            case LEFT:
                                return VoxelShapes.cuboid(0.92f, 0.0f, 0.4f, 1.8f, 1.0f, 0.6f);
                            case RIGHT:
                                return VoxelShapes.cuboid(-0.8f, 0.0f, 0.4f, 0.08f, 1.0f, 0.6f);
                        }
                    }
                case SOUTH:
                    if (!open) {
                        return VoxelShapes.cuboid(0.0f, 0.0f, 0.4f, 1.0f, 1.0f, 0.6f);
                    }
                    if (open) {
                        switch (hinge) {
                            case LEFT:
                                return VoxelShapes.cuboid(-0.8f, 0.0f, 0.4f, 0.08f, 1.0f, 0.6f);
                            case RIGHT:
                                return VoxelShapes.cuboid(0.92f, 0.0f, 0.4f, 1.8f, 1.0f, 0.6f);
                        }
                    }
                case EAST:
                    if (!open) {
                        return VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 1.0f, 1.0f);
                    }
                    if (open) {
                        switch (hinge) {
                            case LEFT:
                                return VoxelShapes.cuboid(0.9f, 0.0f, 0.4f, 0.2f, 1.0f, 0.6f);
                            case RIGHT:
                                return VoxelShapes.cuboid(-1.0f, 0.0f, 0.4f, 0.1f, 1.0f, 0.6f);
                        }
                    }
                case WEST:
                    if (!open) {
                        return VoxelShapes.cuboid(0.4f, 0.0f, 0.0f, 0.6f, 1.0f, 1.0f);
                    }
                    if (open) {
                        switch (hinge) {
                            case LEFT:
                                return VoxelShapes.cuboid(-1.0f, 0.0f, 0.4f, 0.1f, 1.0f, 0.6f);
                            case RIGHT:
                                return VoxelShapes.cuboid(0.9f, 0.0f, 0.4f, 0.2f, 1.0f, 0.6f);
                        }
                    }
                default:
                    return super.getOutlineShape(state, view, pos, context);
        }
    }
}
