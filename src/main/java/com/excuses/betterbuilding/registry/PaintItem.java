package com.excuses.betterbuilding.registry;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;

public class PaintItem extends ToolItem {

    private final int Color;
    private int Color1;

    public PaintItem(ToolMaterial toolMaterial_1, int color, Settings settings) {
        super(toolMaterial_1, settings);
        Color = color;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();
        BlockPos pos = context.getBlockPos();
        BlockState block = world.getBlockState(pos);
        Direction dir = Objects.requireNonNull(player).getHorizontalFacing();
        int Durability = player.getMainHandStack().getDamage();

        if(Durability < 16) {
            if (block.getBlock() == ModBlocks.SHEETROCK_FRAMING_BLOCK) {
                boolean North = world.getBlockState(pos).get(SheetrockFrameBlock.NORTH);
                boolean South = world.getBlockState(pos).get(SheetrockFrameBlock.SOUTH);
                boolean East = world.getBlockState(pos).get(SheetrockFrameBlock.EAST);
                boolean West = world.getBlockState(pos).get(SheetrockFrameBlock.WEST);
                int OnNorth = world.getBlockState(pos).get(SheetrockFrameBlock.ONNORTH);
                int OnSouth = world.getBlockState(pos).get(SheetrockFrameBlock.ONSOUTH);
                int OnEast = world.getBlockState(pos).get(SheetrockFrameBlock.ONEAST);
                int OnWest = world.getBlockState(pos).get(SheetrockFrameBlock.ONWEST);
                if (Color == 0) {
                    Color1 = 0;
                } else if (Color == 4) {
                    Color1 = 1;
                } else if (Color == 7) {
                    Color1 = 2;
                } else if (Color == 8) {
                    Color1 = 3;
                } else if (Color == 11) {
                    Color1 = 4;
                } else if (Color == 13) {
                    Color1 = 5;
                } else if (Color == 14) {
                    Color1 = 6;
                } else if (Color == 15) {
                    Color1 = 7;
                }
                if (dir == Direction.NORTH) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, Color1).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                } else if (dir == Direction.SOUTH) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, Color1).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                } else if (dir == Direction.EAST) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, Color1).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                } else if (dir == Direction.WEST) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, Color1).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                }
                return ActionResult.SUCCESS;
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED) {
                boolean Powered = world.getBlockState(pos).get(DeskLampColored.POWERED);
                world.setBlockState(pos, ModBlocks.DESK_LAMP_COLORED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setDamage(Durability + 1);
                return ActionResult.SUCCESS;
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED_POWERED) {
                boolean Powered = world.getBlockState(pos).get(DeskLampColored.POWERED);
                world.setBlockState(pos, ModBlocks.DESK_LAMP_COLORED_POWERED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setDamage(Durability + 1);
                return ActionResult.SUCCESS;
            }
            else {
                return ActionResult.SUCCESS;
            }
        }
        else if(Durability == 16){
            if (block.getBlock() == ModBlocks.SHEETROCK_FRAMING_BLOCK) {
                boolean North = world.getBlockState(pos).get(SheetrockFrameBlock.NORTH);
                boolean South = world.getBlockState(pos).get(SheetrockFrameBlock.SOUTH);
                boolean East = world.getBlockState(pos).get(SheetrockFrameBlock.EAST);
                boolean West = world.getBlockState(pos).get(SheetrockFrameBlock.WEST);
                int OnNorth = world.getBlockState(pos).get(SheetrockFrameBlock.ONNORTH);
                int OnSouth = world.getBlockState(pos).get(SheetrockFrameBlock.ONSOUTH);
                int OnEast = world.getBlockState(pos).get(SheetrockFrameBlock.ONEAST);
                int OnWest = world.getBlockState(pos).get(SheetrockFrameBlock.ONWEST);
                if (Color == 0) {
                    Color1 = 0;
                } else if (Color == 4) {
                    Color1 = 1;
                } else if (Color == 7) {
                    Color1 = 2;
                } else if (Color == 8) {
                    Color1 = 3;
                } else if (Color == 11) {
                    Color1 = 4;
                } else if (Color == 13) {
                    Color1 = 5;
                } else if (Color == 14) {
                    Color1 = 6;
                } else if (Color == 15) {
                    Color1 = 7;
                }
                if (dir == Direction.NORTH) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, Color1).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                } else if (dir == Direction.SOUTH) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, Color1).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                } else if (dir == Direction.EAST) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, Color1).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                } else if (dir == Direction.WEST) {
                    world.setBlockState(pos, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, Color1).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                }
                return ActionResult.SUCCESS;
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED) {
                boolean Powered = world.getBlockState(pos).get(DeskLampColored.POWERED);
                world.setBlockState(pos, ModBlocks.DESK_LAMP_COLORED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setCount(0);
                player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                return ActionResult.SUCCESS;
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED_POWERED) {
                boolean Powered = world.getBlockState(pos).get(DeskLampColored.POWERED);
                world.setBlockState(pos, ModBlocks.DESK_LAMP_COLORED_POWERED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setCount(0);
                player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                return ActionResult.SUCCESS;
            }
            else {
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.SUCCESS;
    }
}
