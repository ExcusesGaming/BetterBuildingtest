package com.excuses.betterbuilding;


import com.excuses.betterbuilding.registry.*;
import com.excuses.betterbuilding.registry.Entities.Block.TestBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BetterBuilding implements ModInitializer {

    public static final String MOD_ID = "bb";
    public static final Identifier TEST = new Identifier(MOD_ID, "test_block");

    public static final Block TEST_BLOCK = new TestBlock(FabricBlockSettings.copyOf(Blocks.CHEST));
    public static final Item TEST_BLOCK_ITEM = new BlockItem(TEST_BLOCK, new Item.Settings().group(ItemGroup.MISC));
    public static final BlockEntityType<TestBlockEntity> TEST_BLOCK_ENTITY = BlockEntityType.Builder.create(TestBlockEntity::new, TEST_BLOCK).build(null);

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModBlocks.FRAMING_BLOCK)
    );

    public static final ScreenHandlerType<TestScreenHandler> TEST_SCREEN_HANDLER;
    static {
        TEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(TEST, TestScreenHandler::new);
    }

    private static final Identifier FRAMING_BLOCK_LOOT_TABLE_ID = new Identifier(MOD_ID, "blocks/framing_block");

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModBlockEntities.registerBlockEntities();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WINDOW_BLOCK_BASIC, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CEILING_LIGHT, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CEILING_LIGHT_LIT, RenderLayer.getTranslucent());
        modifyLootTables();
        Registry.register(Registry.BLOCK, TEST, TEST_BLOCK);
        Registry.register(Registry.ITEM, TEST, TEST_BLOCK_ITEM);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, TEST, TEST_BLOCK_ENTITY);
    }

    private void modifyLootTables(){
        LootTableLoadingCallback.EVENT.register((((resourceManager, lootManager, id, supplier, setter) -> {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .rolls(ConstantLootTableRange.create(1))
                    .with(LootTableEntry.builder(FRAMING_BLOCK_LOOT_TABLE_ID));
            supplier.withPool(poolBuilder.build());
        })));
    }
}
