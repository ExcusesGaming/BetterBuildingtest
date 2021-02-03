package com.excuses.betterbuilding.registry;


import com.excuses.betterbuilding.registry.Entities.Block.BasicCabinetBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import static com.excuses.betterbuilding.BetterBuilding.OakCabinet;
import static com.excuses.betterbuilding.BetterBuilding.SpruceCabinet;

public class ModBlockEntities {

    public static final BlockEntityType<BasicCabinetBlockEntity> BASIC_CABINET_OAK_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicCabinetBlockEntity::new, ModBlocks.BASIC_CABINET_OAK).build(null);
    public static final BlockEntityType<BasicCabinetBlockEntity> BASIC_CABINET_SPRUCE_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicCabinetBlockEntity::new, ModBlocks.BASIC_CABINET_SPRUCE).build(null);

    public static void registerBlockEntities() {

        Registry.register(Registry.BLOCK_ENTITY_TYPE, OakCabinet, BASIC_CABINET_OAK_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, SpruceCabinet, BASIC_CABINET_SPRUCE_BLOCK_ENTITY);
    }
}
