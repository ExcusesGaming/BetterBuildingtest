package com.excuses.betterbuilding.registry.Blocks;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Map;

public class SheetrockWallFrameBlock extends Block{
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    protected static final Map<Direction, BooleanProperty> FACING_PROPERTIES;
    protected final VoxelShape[] collisionShapes;
    protected final VoxelShape[] boundingShapes;
    private final Object2IntMap<BlockState> SHAPE_INDEX_CACHE = new Object2IntOpenHashMap();

    protected SheetrockWallFrameBlock(float radius1, float radius2, float boundingHeight1, float boundingHeight2, float collisionHeight, AbstractBlock.Settings settings) {
        super(settings);
        this.collisionShapes = this.createShapes(radius1, radius2, collisionHeight, 0.0F, collisionHeight);
        this.boundingShapes = this.createShapes(radius1, radius2, boundingHeight1, 0.0F, boundingHeight2);

        for (BlockState blockState : this.stateManager.getStates()) {
            this.getShapeIndex(blockState);
        }

    }

    protected VoxelShape[] createShapes(float radius1, float radius2, float height1, float offset2, float height2) {
        float f = 8.0F - radius1;
        float g = 8.0F + radius1;
        float h = 8.0F - radius2;
        float i = 8.0F + radius2;
        VoxelShape voxelShape = Block.createCuboidShape(f, 0.0D, f, g, height1, g);
        VoxelShape voxelShape2 = Block.createCuboidShape(h, offset2, 0.0D, i, height2, i);
        VoxelShape voxelShape3 = Block.createCuboidShape(h, offset2, h, i, height2, 16.0D);
        VoxelShape voxelShape4 = Block.createCuboidShape(0.0D, offset2, h, i, height2, i);
        VoxelShape voxelShape5 = Block.createCuboidShape(h, offset2, h, 16.0D, height2, i);
        VoxelShape voxelShape6 = VoxelShapes.union(voxelShape2, voxelShape5);
        VoxelShape voxelShape7 = VoxelShapes.union(voxelShape3, voxelShape4);
        VoxelShape[] voxelShapes = new VoxelShape[]{VoxelShapes.empty(), voxelShape3, voxelShape4, voxelShape7, voxelShape2, VoxelShapes.union(voxelShape3, voxelShape2), VoxelShapes.union(voxelShape4, voxelShape2), VoxelShapes.union(voxelShape7, voxelShape2), voxelShape5, VoxelShapes.union(voxelShape3, voxelShape5), VoxelShapes.union(voxelShape4, voxelShape5), VoxelShapes.union(voxelShape7, voxelShape5), voxelShape6, VoxelShapes.union(voxelShape3, voxelShape6), VoxelShapes.union(voxelShape4, voxelShape6), VoxelShapes.union(voxelShape7, voxelShape6)};

        for(int j = 0; j < 16; ++j) {
            voxelShapes[j] = VoxelShapes.union(voxelShape, voxelShapes[j]);
        }

        return voxelShapes;
    }


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.boundingShapes[this.getShapeIndex(state)];
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return this.collisionShapes[this.getShapeIndex(state)];
    }

    private static int getDirectionMask(Direction dir) {
        return 1 << dir.getHorizontal();
    }

    protected int getShapeIndex(BlockState state) {
        return this.SHAPE_INDEX_CACHE.computeIntIfAbsent(state, (blockState) -> {
            int i = 0;
            if (blockState.get(NORTH)) {
                i |= getDirectionMask(Direction.NORTH);
            }

            if (blockState.get(EAST)) {
                i |= getDirectionMask(Direction.EAST);
            }

            if (blockState.get(SOUTH)) {
                i |= getDirectionMask(Direction.SOUTH);
            }

            if (blockState.get(WEST)) {
                i |= getDirectionMask(Direction.WEST);
            }

            return i;
        });
    }

    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        switch(rotation) {
            case CLOCKWISE_180:
                return state.with(NORTH, state.get(SOUTH)).with(EAST, state.get(WEST)).with(SOUTH, state.get(NORTH)).with(WEST, state.get(EAST));
            case COUNTERCLOCKWISE_90:
                return state.with(NORTH, state.get(EAST)).with(EAST, state.get(SOUTH)).with(SOUTH, state.get(WEST)).with(WEST, state.get(NORTH));
            case CLOCKWISE_90:
                return state.with(NORTH, state.get(WEST)).with(EAST, state.get(NORTH)).with(SOUTH, state.get(EAST)).with(WEST, state.get(SOUTH));
            default:
                return state;
        }
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        switch(mirror) {
            case LEFT_RIGHT:
                return state.with(NORTH, state.get(SOUTH)).with(SOUTH, state.get(NORTH));
            case FRONT_BACK:
                return state.with(EAST, state.get(WEST)).with(WEST, state.get(EAST));
            default:
                return super.mirror(state, mirror);
        }
    }

    static {
        NORTH = ConnectingBlock.NORTH;
        EAST = ConnectingBlock.EAST;
        SOUTH = ConnectingBlock.SOUTH;
        WEST = ConnectingBlock.WEST;
        FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((entry) -> {
            return entry.getKey().getAxis().isHorizontal();
        }).collect(Util.toMap());
    }
}
