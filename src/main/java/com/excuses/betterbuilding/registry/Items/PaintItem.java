package com.excuses.betterbuilding.registry.Items;

import com.excuses.betterbuilding.registry.Blocks.DeskLampColored;
import com.excuses.betterbuilding.registry.Blocks.SheetrockFrameBlock;
import com.excuses.betterbuilding.registry.ModBlocks;
import com.excuses.betterbuilding.registry.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.Objects;

public class PaintItem extends ToolItem {

    private static int Color1;
    private static int Color2;

    public PaintItem(ToolMaterial toolMaterial_1, int color, Settings settings) {
        super(toolMaterial_1, settings);
        Color1 = color;
    }

    public static int GetColor(Item item) {
        if(item == ModItems.WHITEPAINT){
            return 0;
        }
        else if(item == ModItems.ORANGEPAINT){
            return 1;
        }
        else if(item == ModItems.MAGENTAPAINT){
            return 2;
        }
        else if(item == ModItems.LIGHTBLUEPAINT){
            return 3;
        }
        else if(item == ModItems.YELLOWPAINT){
            return 4;
        }
        else if(item == ModItems.LIMEPAINT){
            return 5;
        }
        else if(item == ModItems.PINKPAINT){
            return 6;
        }
        else if(item == ModItems.GRAYPAINT){
            return 7;
        }
        else if(item == ModItems.LIGHTGRAYPAINT){
            return 8;
        }
        else if(item == ModItems.CYANPAINT){
            return 9;
        }
        else if(item == ModItems.PURPLEPAINT){
            return 10;
        }
        else if(item == ModItems.BLUEPAINT){
            return 11;
        }
        else if(item == ModItems.BROWNPAINT){
            return 12;
        }
        else if(item == ModItems.GREENPAINT){
            return 13;
        }
        else if(item == ModItems.REDPAINT){
            return 14;
        }
        else if(item == ModItems.BLACKPAINT){
            return 15;
        }
        else {
            return 0;
        }
    }

    public static void useOnPaintableBlock(World world1, BlockPos position, PlayerEntity player) {
        BlockState block = world1.getBlockState(position);
        Direction dir = Objects.requireNonNull(player).getHorizontalFacing();
        int Durability = player.getMainHandStack().getDamage();
        int Color = PaintItem.GetColor(player.getMainHandStack().getItem());

        if(Durability < 16) {
            if (block.getBlock() == ModBlocks.SHEETROCK_FRAMING_BLOCK) {
                boolean North = world1.getBlockState(position).get(SheetrockFrameBlock.NORTH);
                boolean South = world1.getBlockState(position).get(SheetrockFrameBlock.SOUTH);
                boolean East = world1.getBlockState(position).get(SheetrockFrameBlock.EAST);
                boolean West = world1.getBlockState(position).get(SheetrockFrameBlock.WEST);
                int OnNorth = world1.getBlockState(position).get(SheetrockFrameBlock.ONNORTH);
                int OnSouth = world1.getBlockState(position).get(SheetrockFrameBlock.ONSOUTH);
                int OnEast = world1.getBlockState(position).get(SheetrockFrameBlock.ONEAST);
                int OnWest = world1.getBlockState(position).get(SheetrockFrameBlock.ONWEST);
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
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, Color1).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                } else if (dir == Direction.SOUTH) {
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, Color1).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                } else if (dir == Direction.EAST) {
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, Color1).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                } else if (dir == Direction.WEST) {
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, Color1).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setDamage(Durability + 1);
                }
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED) {
                boolean Powered = world1.getBlockState(position).get(DeskLampColored.POWERED);
                world1.setBlockState(position, ModBlocks.DESK_LAMP_COLORED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setDamage(Durability + 1);
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED_POWERED) {
                boolean Powered = world1.getBlockState(position).get(DeskLampColored.POWERED);
                world1.setBlockState(position, ModBlocks.DESK_LAMP_COLORED_POWERED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setDamage(Durability + 1);
            }
        }
        else if(Durability == 16){
            if (block.getBlock() == ModBlocks.SHEETROCK_FRAMING_BLOCK) {
                boolean North = world1.getBlockState(position).get(SheetrockFrameBlock.NORTH);
                boolean South = world1.getBlockState(position).get(SheetrockFrameBlock.SOUTH);
                boolean East = world1.getBlockState(position).get(SheetrockFrameBlock.EAST);
                boolean West = world1.getBlockState(position).get(SheetrockFrameBlock.WEST);
                int OnNorth = world1.getBlockState(position).get(SheetrockFrameBlock.ONNORTH);
                int OnSouth = world1.getBlockState(position).get(SheetrockFrameBlock.ONSOUTH);
                int OnEast = world1.getBlockState(position).get(SheetrockFrameBlock.ONEAST);
                int OnWest = world1.getBlockState(position).get(SheetrockFrameBlock.ONWEST);
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
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, Color1).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                } else if (dir == Direction.SOUTH) {
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, Color1).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                } else if (dir == Direction.EAST) {
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, Color1).with(SheetrockFrameBlock.ONWEST, OnWest).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                } else if (dir == Direction.WEST) {
                    world1.setBlockState(position, ModBlocks.SHEETROCK_FRAMING_BLOCK.getDefaultState().with(SheetrockFrameBlock.ONNORTH, OnNorth).with(SheetrockFrameBlock.ONSOUTH, OnSouth).with(SheetrockFrameBlock.ONEAST, OnEast).with(SheetrockFrameBlock.ONWEST, Color1).with(SheetrockFrameBlock.NORTH, North).with(SheetrockFrameBlock.SOUTH, South).with(SheetrockFrameBlock.EAST, East).with(SheetrockFrameBlock.WEST, West));
                    player.getMainHandStack().setCount(0);
                    player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
                }
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED) {
                boolean Powered = world1.getBlockState(position).get(DeskLampColored.POWERED);
                world1.setBlockState(position, ModBlocks.DESK_LAMP_COLORED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setCount(0);
                player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
            } else if (block.getBlock() == ModBlocks.DESK_LAMP_COLORED_POWERED) {
                boolean Powered = world1.getBlockState(position).get(DeskLampColored.POWERED);
                world1.setBlockState(position, ModBlocks.DESK_LAMP_COLORED_POWERED.getDefaultState().with(DeskLampColored.LAMPSHADE, Color).with(DeskLampColored.POWERED, Powered));
                player.getMainHandStack().setCount(0);
                player.giveItemStack(ModItems.PAINTBUCKET.getDefaultStack());
            }
        }
    }
}
