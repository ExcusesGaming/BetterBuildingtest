package com.excuses.betterbuilding.registry.Items;

import com.excuses.betterbuilding.registry.Blocks.SheetrockFrameBlock;
import com.excuses.betterbuilding.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;

public class HammerItem extends ToolItem {


    public HammerItem(ToolMaterial toolMaterial_1,Settings settings) {
        super(toolMaterial_1, settings);
    }

    public static void useOnHammerableBlock(World world1, BlockPos position, PlayerEntity player) {
        BlockState block = world1.getBlockState(position);
        Direction dir = Objects.requireNonNull(player).getHorizontalFacing();
        int Durability = player.getMainHandStack().getDamage();

        if(Durability < 512) {
            if (block.getBlock() == ModBlocks.SHEETROCK_FRAMING_BLOCK) {
                boolean North = world1.getBlockState(position).get(SheetrockFrameBlock.NORTH);
                boolean South = world1.getBlockState(position).get(SheetrockFrameBlock.SOUTH);
                boolean East = world1.getBlockState(position).get(SheetrockFrameBlock.EAST);
                boolean West = world1.getBlockState(position).get(SheetrockFrameBlock.WEST);
                int OnNorth = world1.getBlockState(position).get(SheetrockFrameBlock.ONNORTH);
                int OnSouth = world1.getBlockState(position).get(SheetrockFrameBlock.ONSOUTH);
                int OnEast = world1.getBlockState(position).get(SheetrockFrameBlock.ONEAST);
                int OnWest = world1.getBlockState(position).get(SheetrockFrameBlock.ONWEST);
            }
        }
        else if(Durability == 512){
            if (block.getBlock() == ModBlocks.SHEETROCK_FRAMING_BLOCK) {
                boolean North = world1.getBlockState(position).get(SheetrockFrameBlock.NORTH);
                boolean South = world1.getBlockState(position).get(SheetrockFrameBlock.SOUTH);
                boolean East = world1.getBlockState(position).get(SheetrockFrameBlock.EAST);
                boolean West = world1.getBlockState(position).get(SheetrockFrameBlock.WEST);
                int OnNorth = world1.getBlockState(position).get(SheetrockFrameBlock.ONNORTH);
                int OnSouth = world1.getBlockState(position).get(SheetrockFrameBlock.ONSOUTH);
                int OnEast = world1.getBlockState(position).get(SheetrockFrameBlock.ONEAST);
                int OnWest = world1.getBlockState(position).get(SheetrockFrameBlock.ONWEST);
            }
        }
    }
}
