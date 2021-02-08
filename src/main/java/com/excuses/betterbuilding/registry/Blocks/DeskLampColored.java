package com.excuses.betterbuilding.registry.Blocks;

import com.excuses.betterbuilding.registry.Properties.ColorProperty;
import com.excuses.betterbuilding.registry.ModBlocks;
import com.excuses.betterbuilding.registry.ModItems;
import com.excuses.betterbuilding.registry.Items.PaintItem;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
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

public class DeskLampColored extends Block {

    public static final ColorProperty LAMPSHADE = ColorProperty.of("lampshade", 0);
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(LAMPSHADE, POWERED);
    }

    public DeskLampColored(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(LAMPSHADE, 0).with(POWERED, false));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int Lampshade = state.get(LAMPSHADE);
        boolean Powered = state.get(POWERED);
        if(Powered && player.getMainHandStack().getItem() == Items.AIR){
            world.setBlockState(pos, ModBlocks.DESK_LAMP_COLORED.getDefaultState().with(LAMPSHADE, Lampshade).with(POWERED, false), 3);
        }
        else if(!Powered && player.getMainHandStack().getItem() == Items.AIR) {
            world.setBlockState(pos, ModBlocks.DESK_LAMP_COLORED_POWERED.getDefaultState().with(LAMPSHADE, Lampshade).with(POWERED, true), 3);
        }
        if(player.getMainHandStack().getItem() == ModItems.WHITEPAINT || player.getMainHandStack().getItem() == ModItems.ORANGEPAINT || player.getMainHandStack().getItem() == ModItems.MAGENTAPAINT || player.getMainHandStack().getItem() == ModItems.LIGHTBLUEPAINT || player.getMainHandStack().getItem() == ModItems.YELLOWPAINT || player.getMainHandStack().getItem() == ModItems.LIMEPAINT || player.getMainHandStack().getItem() == ModItems.PINKPAINT || player.getMainHandStack().getItem() == ModItems.GRAYPAINT || player.getMainHandStack().getItem() == ModItems.LIGHTGRAYPAINT || player.getMainHandStack().getItem() == ModItems.CYANPAINT || player.getMainHandStack().getItem() == ModItems.PURPLEPAINT || player.getMainHandStack().getItem() == ModItems.BLUEPAINT || player.getMainHandStack().getItem() == ModItems.BROWNPAINT || player.getMainHandStack().getItem() == ModItems.GREENPAINT || player.getMainHandStack().getItem() == ModItems.REDPAINT || player.getMainHandStack().getItem() == ModItems.BLACKPAINT) {
            PaintItem.useOnPaintableBlock(world, pos, player);
        }
        return ActionResult.SUCCESS;
    }

    public float getPowered(BlockState blockState, BlockView blockView, BlockPos pos) {
        boolean Powered = blockState.get(POWERED);
        if(Powered) {
        return 2.0f;
        }
        else {
            return 0.5f;
        }
    }

    public float getColor(BlockState blockState, BlockView blockView, BlockPos pos) {
        int Color = blockState.get(LAMPSHADE);
        return Color;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.2f, 0.0f, 0.2f, 0.8f, 1.0f, 0.8f);
    }
}
