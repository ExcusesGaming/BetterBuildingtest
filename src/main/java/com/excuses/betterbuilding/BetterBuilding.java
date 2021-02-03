package com.excuses.betterbuilding;


import com.excuses.betterbuilding.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.*;
import net.minecraft.loot.entry.LootTableEntry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class BetterBuilding implements ModInitializer {

    public static final String MOD_ID = "bb";
    public static final Identifier OakCabinet = new Identifier(MOD_ID, "basic_cabinet_oak");
    public static final Identifier SpruceCabinet = new Identifier(MOD_ID, "basic_cabinet_spruce");

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "general"),
            () -> new ItemStack(ModBlocks.FRAMING_BLOCK)
    );

    public static final ScreenHandlerType<BasicCabinetScreenHandler> BASIC_CABINET_SCREEN_HANDLER;
    static {
        BASIC_CABINET_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(OakCabinet, BasicCabinetScreenHandler::new);
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
    }

    private void modifyLootTables(){
        LootTableLoadingCallback.EVENT.register((((resourceManager, lootManager, id, supplier, setter) -> {
            if (FRAMING_BLOCK_LOOT_TABLE_ID.equals(id)) {
            FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                    .with(LootTableEntry.builder(FRAMING_BLOCK_LOOT_TABLE_ID));
                supplier.withPool(poolBuilder.build());
            }
        })));
    }
}
