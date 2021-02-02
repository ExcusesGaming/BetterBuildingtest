package com.excuses.betterbuilding.registry;

import com.ibm.icu.text.CaseMap;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.datafixer.fix.ChunkPalettedStorageFix;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
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
import net.minecraft.world.WorldView;

public class BBPocketDoorBlock extends DoorBlock {

    public BBPocketDoorBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hitResult) {
        state = state.cycle(OPEN);
        world.setBlockState(pos, state, 10);
        return ActionResult.SUCCESS;
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return true;
    }


    @Override
     public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        Direction dir = state.get(FACING);
        DoorHinge hinge = state.get(HINGE);
        BlockState block = world.getBlockState(pos);
        if (hinge == DoorHinge.LEFT) {
            if (dir == Direction.NORTH) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(+1, 0, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(+1, +1, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
            if (dir == Direction.SOUTH) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(-1, 0, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(-1, +1, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
            if (dir == Direction.EAST) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(0, 0, +1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(0, +1, +1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
            if (dir == Direction.WEST) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(0, 0, -1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(0, +1, -1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
        }
        else if(hinge == DoorHinge.RIGHT)
        {
            if (dir == Direction.NORTH) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(-1, 0, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(-1, +1, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
            if (dir == Direction.SOUTH) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(+1, 0, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(+1, +1, 0), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
                if (dir == Direction.EAST) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(0, 0, -1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(0, +1, -1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
            if (dir == Direction.WEST) {
                world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
                world.setBlockState(pos.add(0, 0, +1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(BBPocketDoorFrameBlock.HALF, block.get(BBPocketDoorBlock.HALF)).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
                world.setBlockState(pos.add(0, +1, +1), ModBlocks.POCKETDOORFRAME_BOTTOM.getDefaultState().with(BBPocketDoorFrameBlock.FACING, block.get(BBPocketDoorBlock.FACING)).with(HALF, DoubleBlockHalf.UPPER).with(BBPocketDoorFrameBlock.HINGE, block.get(BBPocketDoorBlock.HINGE)), 3);
            }
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        Direction dir = state.get(FACING);
        DoorHinge hinge = state.get(HINGE);
        DoubleBlockHalf half = state.get(HALF);
        BlockState block = world.getBlockState(pos);
        if (hinge == DoorHinge.LEFT) {
            if (dir == Direction.NORTH) {
                if (half == DoubleBlockHalf.LOWER) {
                    world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                    world.setBlockState(pos.add(+1, 0, 0), Blocks.AIR.getDefaultState(), 35);
                    world.setBlockState(pos.add(+1, +1, 0), Blocks.AIR.getDefaultState(), 35);
                }
                if (half == DoubleBlockHalf.UPPER) {
                    world.setBlockState(pos.down(), Blocks.AIR.getDefaultState(), 35);
                    world.setBlockState(pos.add(+1, 0, 0), Blocks.AIR.getDefaultState(), 35);
                    world.setBlockState(pos.add(+1, -1, 0), Blocks.AIR.getDefaultState(), 35);
                }
            }
            if (dir == Direction.SOUTH) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(-1, 0, 0), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(-1, +1, 0), Blocks.AIR.getDefaultState(), 35);
            }
            if (dir == Direction.EAST) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, 0, +1), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, +1, +1), Blocks.AIR.getDefaultState(), 35);
            }
            if (dir == Direction.WEST) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, 0, -1), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, +1, -1), Blocks.AIR.getDefaultState(), 35);
            }
        }
        else if(hinge == DoorHinge.RIGHT)
        {
            if (dir == Direction.NORTH) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(-1, 0, 0), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(-1, +1, 0), Blocks.AIR.getDefaultState(), 35);
            }
            if (dir == Direction.SOUTH) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(+1, 0, 0), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(+1, +1, 0), Blocks.AIR.getDefaultState(), 35);
            }
            if (dir == Direction.EAST) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, 0, -1), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, +1, -1), Blocks.AIR.getDefaultState(), 35);
            }
            if (dir == Direction.WEST) {
                world.setBlockState(pos.up(), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, 0, +1), Blocks.AIR.getDefaultState(), 35);
                world.setBlockState(pos.add(0, +1, +1), Blocks.AIR.getDefaultState(), 35);
            }
        }
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
