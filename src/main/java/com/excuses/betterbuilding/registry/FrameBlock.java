package com.excuses.betterbuilding.registry;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.Objects;

public class FrameBlock extends HorizontalConnectingBlock {
    public static final BooleanProperty PLYWOOD = BooleanProperty.of("plywood");
    public static final BooleanProperty PLYWOODVERTICAL = BooleanProperty.of("plywoodvertical");
    public static final DirectionProperty FACING;
    private final VoxelShape[] cullingShapes;

    protected FrameBlock(Settings settings) {
        super(6.0F, 6.0F, 16.0F, 16.0F, 16.0F, settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false).with(PLYWOOD, false).with(PLYWOODVERTICAL, false).with(WATERLOGGED, false));
        this.cullingShapes = this.createShapes(2.0F, 1.0F, 16.0F, 14.0F, 15.0F);
    }

    static {
        FACING = Properties.FACING;
    }

    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return this.cullingShapes[this.getShapeIndex(state)];
    }

    public VoxelShape getVisualShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.getOutlineShape(state, world, pos, context);
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    public boolean canConnect(BlockState state, boolean neighborIsFullSquare) {
        Block block = state.getBlock();
        if (block == ModBlocks.FRAMING_BLOCK || block == ModBlocks.SHEETROCK_FRAMING_BLOCK || block == ModBlocks.WINDOW_BLOCK_BASIC || block == ModBlocks.DOOR_BOTTOM || block == ModBlocks.POCKETDOOR_BOTTOM || block == ModBlocks.POCKETDOORFRAME_BOTTOM) {
            return !cannotConnect(block);
        }
        return cannotConnect(block);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getMainHandStack().getItem() == ModItems.PLYWOOD){
            boolean North = world.getBlockState(pos).get(NORTH);
            boolean South = world.getBlockState(pos).get(SOUTH);
            boolean East = world.getBlockState(pos).get(EAST);
            boolean West = world.getBlockState(pos).get(WEST);
            boolean Plywood = world.getBlockState(pos).get(PLYWOOD);
            boolean PlywoodVertical = world.getBlockState(pos).get(PLYWOODVERTICAL);
            if(!Plywood) {
                world.setBlockState(pos, ModBlocks.FRAMING_BLOCK.getDefaultState().with(PLYWOOD, true).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West).with(PLYWOODVERTICAL, PlywoodVertical));
                world.updateNeighborsAlways(pos, ModBlocks.FRAMING_BLOCK);
            }
            else {
                world.setBlockState(pos, ModBlocks.FRAMING_BLOCK.getDefaultState().with(PLYWOODVERTICAL, true).with(PLYWOOD, true).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
                world.updateNeighborsAlways(pos, ModBlocks.FRAMING_BLOCK);
            }
        }
        if(player.getMainHandStack().getItem() == ModItems.SHEETROCK){
            boolean North = world.getBlockState(pos).get(NORTH);
            boolean South = world.getBlockState(pos).get(SOUTH);
            boolean East = world.getBlockState(pos).get(EAST);
            boolean West = world.getBlockState(pos).get(WEST);
            Direction dir = player.getHorizontalFacing();
            if(dir == Direction.NORTH) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, 3).with(SheetrockFrameBlock.ONSOUTH, 8).with(SheetrockFrameBlock.ONEAST, 8).with(SheetrockFrameBlock.ONWEST, 8).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
            if(dir == Direction.SOUTH) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, 8).with(SheetrockFrameBlock.ONSOUTH, 3).with(SheetrockFrameBlock.ONEAST, 8).with(SheetrockFrameBlock.ONWEST, 8).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
            if(dir == Direction.EAST) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, 8).with(SheetrockFrameBlock.ONSOUTH, 8).with(SheetrockFrameBlock.ONEAST, 3).with(SheetrockFrameBlock.ONWEST, 8).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
            if(dir == Direction.WEST) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, 8).with(SheetrockFrameBlock.ONSOUTH, 8).with(SheetrockFrameBlock.ONEAST, 8).with(SheetrockFrameBlock.ONWEST, 3).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
        }
        return ActionResult.SUCCESS;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        BlockPos blockPos2 = blockPos.north();
        BlockPos blockPos3 = blockPos.east();
        BlockPos blockPos4 = blockPos.south();
        BlockPos blockPos5 = blockPos.west();
        BlockState blockState = blockView.getBlockState(blockPos2);
        BlockState blockState2 = blockView.getBlockState(blockPos3);
        BlockState blockState3 = blockView.getBlockState(blockPos4);
        BlockState blockState4 = blockView.getBlockState(blockPos5);
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(NORTH, this.canConnect(blockState, blockState.isSideSolidFullSquare(blockView, blockPos2, Direction.SOUTH))).with(EAST, this.canConnect(blockState2, blockState2.isSideSolidFullSquare(blockView, blockPos3, Direction.WEST))).with(SOUTH, this.canConnect(blockState3, blockState3.isSideSolidFullSquare(blockView, blockPos4, Direction.NORTH))).with(WEST, this.canConnect(blockState4, blockState4.isSideSolidFullSquare(blockView, blockPos5, Direction.EAST))).with(PLYWOOD, false).with(PLYWOODVERTICAL, false).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        if (state.get(WATERLOGGED)) {
            world.getFluidTickScheduler().schedule(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return direction.getAxis().getType() == Direction.Type.HORIZONTAL ? state.with(FACING_PROPERTIES.get(direction), this.canConnect(newState, newState.isSideSolidFullSquare(world, posFrom, direction.getOpposite()))) : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, PLYWOOD, PLYWOODVERTICAL, WATERLOGGED, FACING);
    }

}
