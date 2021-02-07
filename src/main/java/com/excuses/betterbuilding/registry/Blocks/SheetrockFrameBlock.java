package com.excuses.betterbuilding.registry.Blocks;

import com.excuses.betterbuilding.registry.*;
import com.excuses.betterbuilding.registry.Items.PaintItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
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

public class SheetrockFrameBlock extends SheetrockWallFrameBlock {
    public static final EightColorProperty ONNORTH = EightColorProperty.of("onnorth", 0);
    public static final EightColorProperty ONSOUTH = EightColorProperty.of("onsouth", 0);
    public static final EightColorProperty ONEAST = EightColorProperty.of("oneast", 0);
    public static final EightColorProperty ONWEST = EightColorProperty.of("onwest", 0);
    private final VoxelShape[] cullingShapes;

    public SheetrockFrameBlock(Settings settings) {
        super(6.0F, 6.0F, 16.0F, 16.0F, 16.0F, settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false).with(ONNORTH, 0).with(ONSOUTH, 0).with(ONEAST, 0).with(ONWEST, 0));
        this.cullingShapes = this.createShapes(2.0F, 1.0F, 16.0F, 14.0F, 15.0F);
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(player.getMainHandStack().getItem() == ModItems.SHEETROCK){
            boolean North = world.getBlockState(pos).get(NORTH);
            boolean South = world.getBlockState(pos).get(SOUTH);
            boolean East = world.getBlockState(pos).get(EAST);
            boolean West = world.getBlockState(pos).get(WEST);
            int OnNorth = world.getBlockState(pos).get(ONNORTH);
            int OnSouth = world.getBlockState(pos).get(ONSOUTH);
            int OnEast = world.getBlockState(pos).get(ONEAST);
            int OnWest = world.getBlockState(pos).get(ONWEST);
            Direction dir = player.getHorizontalFacing();
            if(dir == Direction.NORTH && OnNorth == 8) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(ONNORTH, 3).with(ONSOUTH, OnSouth).with(ONEAST, OnEast).with(ONWEST, OnWest).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
            if(dir == Direction.SOUTH && OnSouth == 8) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(ONNORTH, OnNorth).with(ONSOUTH, 3).with(ONEAST, OnEast).with(ONWEST, OnWest).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
            if(dir == Direction.EAST && OnEast == 8) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(ONNORTH, OnNorth).with(ONSOUTH, OnSouth).with(ONEAST, 3).with(ONWEST, OnWest).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
            if(dir == Direction.WEST && OnWest == 8) {
                world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(ONNORTH, OnNorth).with(ONSOUTH, OnSouth).with(ONEAST, OnEast).with(ONWEST, 3).with(NORTH, North).with(SOUTH, South).with(EAST, East).with(WEST, West));
            }
        }
        if(player.getMainHandStack().getItem() == ModItems.WHITEPAINT || player.getMainHandStack().getItem() == ModItems.ORANGEPAINT || player.getMainHandStack().getItem() == ModItems.MAGENTAPAINT || player.getMainHandStack().getItem() == ModItems.LIGHTBLUEPAINT || player.getMainHandStack().getItem() == ModItems.YELLOWPAINT || player.getMainHandStack().getItem() == ModItems.LIMEPAINT || player.getMainHandStack().getItem() == ModItems.PINKPAINT || player.getMainHandStack().getItem() == ModItems.GRAYPAINT || player.getMainHandStack().getItem() == ModItems.LIGHTGRAYPAINT || player.getMainHandStack().getItem() == ModItems.CYANPAINT || player.getMainHandStack().getItem() == ModItems.PURPLEPAINT || player.getMainHandStack().getItem() == ModItems.BLUEPAINT || player.getMainHandStack().getItem() == ModItems.BROWNPAINT || player.getMainHandStack().getItem() == ModItems.GREENPAINT || player.getMainHandStack().getItem() == ModItems.REDPAINT || player.getMainHandStack().getItem() == ModItems.BLACKPAINT) {
            PaintItem.useOnPaintableBlock(world, pos, player);
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
        return Objects.requireNonNull(super.getPlacementState(ctx)).with(NORTH, this.canConnect(blockState, blockState.isSideSolidFullSquare(blockView, blockPos2, Direction.SOUTH))).with(EAST, this.canConnect(blockState2, blockState2.isSideSolidFullSquare(blockView, blockPos3, Direction.WEST))).with(SOUTH, this.canConnect(blockState3, blockState3.isSideSolidFullSquare(blockView, blockPos4, Direction.NORTH))).with(WEST, this.canConnect(blockState4, blockState4.isSideSolidFullSquare(blockView, blockPos5, Direction.EAST)));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction.getAxis().getType() == Direction.Type.HORIZONTAL ? state.with(FACING_PROPERTIES.get(direction), this.canConnect(newState, newState.isSideSolidFullSquare(world, posFrom, direction.getOpposite()))) : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, ONNORTH, ONSOUTH, ONEAST, ONWEST);
    }
}
