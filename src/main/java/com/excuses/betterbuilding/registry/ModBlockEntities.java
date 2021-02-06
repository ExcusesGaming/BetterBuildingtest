package com.excuses.betterbuilding.registry;


import com.excuses.betterbuilding.registry.Entities.Block.BasicCabinetBlockEntity;
import com.excuses.betterbuilding.registry.Entities.Block.BasicDrawerBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import static com.excuses.betterbuilding.BetterBuildingIdentifiers.*;

public class ModBlockEntities {

    public static final BlockEntityType<BasicCabinetBlockEntity> BASIC_CABINET_OAK_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicCabinetBlockEntity::new, ModBlocks.BASIC_CABINET_OAK).build(null);
    public static final BlockEntityType<BasicCabinetBlockEntity> BASIC_CABINET_SPRUCE_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicCabinetBlockEntity::new, ModBlocks.BASIC_CABINET_SPRUCE).build(null);
    public static final BlockEntityType<BasicCabinetBlockEntity> BASIC_CABINET_BIRCH_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicCabinetBlockEntity::new, ModBlocks.BASIC_CABINET_BIRCH).build(null);
    public static final BlockEntityType<BasicCabinetBlockEntity> BASIC_CABINET_JUNGLE_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicCabinetBlockEntity::new, ModBlocks.BASIC_CABINET_JUNGLE).build(null);

    public static final BlockEntityType<BasicDrawerBlockEntity> BASIC_DRAWER_OAK_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicDrawerBlockEntity::new, ModBlocks.BASIC_DRAWER_OAK).build(null);
    public static final BlockEntityType<BasicDrawerBlockEntity> BASIC_DRAWER_SPRUCE_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicDrawerBlockEntity::new, ModBlocks.BASIC_DRAWER_SPRUCE).build(null);
    public static final BlockEntityType<BasicDrawerBlockEntity> BASIC_DRAWER_BIRCH_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicDrawerBlockEntity::new, ModBlocks.BASIC_DRAWER_BIRCH).build(null);
    public static final BlockEntityType<BasicDrawerBlockEntity> BASIC_DRAWER_JUNGLE_BLOCK_ENTITY = BlockEntityType.Builder.create(BasicDrawerBlockEntity::new, ModBlocks.BASIC_DRAWER_JUNGLE).build(null);

    public static void registerBlockEntities() {

        Registry.register(Registry.BLOCK_ENTITY_TYPE, OakCabinet, BASIC_CABINET_OAK_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, SpruceCabinet, BASIC_CABINET_SPRUCE_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, BirchCabinet, BASIC_CABINET_BIRCH_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, JungleCabinet, BASIC_CABINET_JUNGLE_BLOCK_ENTITY);

        Registry.register(Registry.BLOCK_ENTITY_TYPE, OakDrawer, BASIC_DRAWER_OAK_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, SpruceDrawer, BASIC_DRAWER_SPRUCE_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, BirchDrawer, BASIC_DRAWER_BIRCH_BLOCK_ENTITY);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, JungleDrawer, BASIC_DRAWER_JUNGLE_BLOCK_ENTITY);
    }
}
