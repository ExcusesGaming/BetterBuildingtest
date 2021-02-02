package com.excuses.betterbuilding.registry;

import com.excuses.betterbuilding.BetterBuilding;
import com.excuses.betterbuilding.registry.Entities.Block.TestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;



public class ModBlockEntities {

    public static BlockEntityType<TestBlockEntity> TEST_BLOCK_ENTITY;

    public static void registerBlockEntities() {

        //The parameter of build at the very end is always null, do not worry about it
    }
}
