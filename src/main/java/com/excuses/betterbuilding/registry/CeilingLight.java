package com.excuses.betterbuilding.registry;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CeilingLight extends Block {

    public static final BooleanProperty HARDENED = BooleanProperty.of("hardened");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(HARDENED);
    }

    public CeilingLight(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(HARDENED, false));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        boolean hardened = state.get(HARDENED);
        if(hardened){
            world.setBlockState(pos, state.with(HARDENED, false));
        }
        else {
            world.setBlockState(pos, state.with(HARDENED, true));
            world.setBlockState(pos, ModBlocks.CEILING_LIGHT_LIT.getDefaultState(), 3);
        }
        return ActionResult.SUCCESS;
    }

    public float getHardness(BlockState blockState, BlockView blockView, BlockPos pos) {
        boolean hardened = blockState.get(HARDENED);
        if(hardened) {
        return 2.0f;
        }
        else {
            return 0.5f;
        }
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.3f, 0.4f, 0.3f, 0.7f, 1.0f, 0.7f);
    }
}
