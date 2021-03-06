package com.excuses.betterbuilding.registry;

import com.excuses.betterbuilding.BetterBuilding;
import com.excuses.betterbuilding.registry.Items.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.excuses.betterbuilding.BetterBuildingIdentifiers.*;

public class ModItems {
    //Items
    public static final Item PLYWOOD = new BasicItem();
    public static final Item SHEETROCK = new BasicItem();

    public static final ToolItem IRONHAMMER = new HammerItem(HammerMaterial.INSTANCE,new Item.Settings().group(BetterBuilding.ITEM_GROUP));

    public static final Item PAINTBUCKET = new BasicItem();
    public static final ToolItem WHITEPAINT = new PaintItem(PaintMaterial.INSTANCE, 0, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem ORANGEPAINT = new PaintItem(PaintMaterial.INSTANCE,1, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem MAGENTAPAINT = new PaintItem(PaintMaterial.INSTANCE,2, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem LIGHTBLUEPAINT = new PaintItem(PaintMaterial.INSTANCE,3, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem YELLOWPAINT = new PaintItem(PaintMaterial.INSTANCE,4, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem LIMEPAINT = new PaintItem(PaintMaterial.INSTANCE,5, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem PINKPAINT = new PaintItem(PaintMaterial.INSTANCE,6, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem GRAYPAINT = new PaintItem(PaintMaterial.INSTANCE,7, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem LIGHTGRAYPAINT = new PaintItem(PaintMaterial.INSTANCE,8, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem CYANPAINT = new PaintItem(PaintMaterial.INSTANCE,9, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem PURPLEPAINT = new PaintItem(PaintMaterial.INSTANCE,10, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem BLUEPAINT = new PaintItem(PaintMaterial.INSTANCE,11, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem BROWNPAINT = new PaintItem(PaintMaterial.INSTANCE,12, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem GREENPAINT = new PaintItem(PaintMaterial.INSTANCE,13, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem REDPAINT = new PaintItem(PaintMaterial.INSTANCE,14, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final ToolItem BLACKPAINT = new PaintItem(PaintMaterial.INSTANCE,15, new Item.Settings().group(BetterBuilding.ITEM_GROUP));


    //Block Items
    public static final BlockItem FRAMING_BLOCK = new BlockItem(ModBlocks.FRAMING_BLOCK, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem FLOOR_FRAMING_BLOCK = new BlockItem(ModBlocks.FLOOR_FRAMING_BLOCK, new Item.Settings());
    public static final BlockItem SHEETROCK_FRAMING_BLOCK = new BlockItem(ModBlocks.SHEETROCK_FRAMING_BLOCK, new Item.Settings());
    public static final BlockItem WINDOW_BLOCK_BASIC = new BlockItem(ModBlocks.WINDOW_BLOCK_BASIC, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem DOOR_BOTTOM = new BlockItem(ModBlocks.DOOR_BOTTOM, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem POCKETDOOR_BOTTOM = new BlockItem(ModBlocks.POCKETDOOR_BOTTOM, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem POCKETDOORFRAME_BOTTOM = new BlockItem(ModBlocks.POCKETDOORFRAME_BOTTOM, new Item.Settings());

    public static final BlockItem CEILING_LIGHT = new BlockItem(ModBlocks.CEILING_LIGHT, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem CEILING_LIGHT_LIT = new BlockItem(ModBlocks.CEILING_LIGHT_LIT, new Item.Settings());
    public static final BlockItem DESK_LAMP_COLORED = new BlockItem(ModBlocks.DESK_LAMP_COLORED, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem DESK_LAMP_COLORED_POWERED = new BlockItem(ModBlocks.DESK_LAMP_COLORED_POWERED, new Item.Settings());

    public static final BlockItem BASIC_TABLE_OAK = new BlockItem(ModBlocks.BASIC_TABLE_OAK, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_TABLE_SPRUCE = new BlockItem(ModBlocks.BASIC_TABLE_SPRUCE, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_TABLE_BIRCH = new BlockItem(ModBlocks.BASIC_TABLE_BIRCH, new Item.Settings().group(BetterBuilding.ITEM_GROUP));

    public static final BlockItem BASIC_CABINET_OAK = new BlockItem(ModBlocks.BASIC_CABINET_OAK, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_CABINET_SPRUCE = new BlockItem(ModBlocks.BASIC_CABINET_SPRUCE, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_CABINET_BIRCH = new BlockItem(ModBlocks.BASIC_CABINET_BIRCH, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_CABINET_JUNGLE = new BlockItem(ModBlocks.BASIC_CABINET_JUNGLE, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_CABINET_ACACIA = new BlockItem(ModBlocks.BASIC_CABINET_ACACIA, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_CABINET_DARK_OAK = new BlockItem(ModBlocks.BASIC_CABINET_DARK_OAK, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_CABINET_CRIMSON = new BlockItem(ModBlocks.BASIC_CABINET_CRIMSON, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_CABINET_WARPED = new BlockItem(ModBlocks.BASIC_CABINET_WARPED, new Item.Settings().group(BetterBuilding.ITEM_GROUP));

    public static final BlockItem BASIC_DRAWER_OAK = new BlockItem(ModBlocks.BASIC_DRAWER_OAK, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_DRAWER_SPRUCE = new BlockItem(ModBlocks.BASIC_DRAWER_SPRUCE, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_DRAWER_BIRCH = new BlockItem(ModBlocks.BASIC_DRAWER_BIRCH, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_DRAWER_JUNGLE = new BlockItem(ModBlocks.BASIC_DRAWER_JUNGLE, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_DRAWER_ACACIA = new BlockItem(ModBlocks.BASIC_DRAWER_ACACIA, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_DRAWER_DARK_OAK = new BlockItem(ModBlocks.BASIC_DRAWER_DARK_OAK, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_DRAWER_CRIMSON = new BlockItem(ModBlocks.BASIC_DRAWER_CRIMSON, new Item.Settings().group(BetterBuilding.ITEM_GROUP));
    public static final BlockItem BASIC_DRAWER_WARPED = new BlockItem(ModBlocks.BASIC_DRAWER_WARPED, new Item.Settings().group(BetterBuilding.ITEM_GROUP));

    public static final BlockItem OVEN = new BlockItem(ModBlocks.OVEN, new Item.Settings().group(BetterBuilding.ITEM_GROUP));

    public static void registerItems(){
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "plywood"), PLYWOOD);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "sheetrock"), SHEETROCK);

        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "iron_hammer"), IRONHAMMER);

        //Paints
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "paintbucket"), PAINTBUCKET);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "whitepaint"), WHITEPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "orangepaint"), ORANGEPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "magentapaint"), MAGENTAPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "lightbluepaint"), LIGHTBLUEPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "yellowpaint"), YELLOWPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "limepaint"), LIMEPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "pinkpaint"), PINKPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "graypaint"), GRAYPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "lightgraypaint"), LIGHTGRAYPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "cyanpaint"), CYANPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "purplepaint"), PURPLEPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "bluepaint"), BLUEPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "brownpaint"), BROWNPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "redpaint"), REDPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "greenpaint"), GREENPAINT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "blackpaint"), BLACKPAINT);

        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "framing_block"), FRAMING_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "floor_framing_block"), FLOOR_FRAMING_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "sheetrock_framing_block"), SHEETROCK_FRAMING_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "window_block_basic"), WINDOW_BLOCK_BASIC);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "door_bottom"), DOOR_BOTTOM);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "pocketdoor_bottom"), POCKETDOOR_BOTTOM);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "pocketdoorframe_bottom"), POCKETDOORFRAME_BOTTOM);

        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "ceiling_light"), CEILING_LIGHT);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "ceiling_light_lit"), CEILING_LIGHT_LIT);

        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "desk_lamp_colored"), DESK_LAMP_COLORED);
        Registry.register(Registry.ITEM, new Identifier(BetterBuilding.MOD_ID,  "desk_lamp_colored_powered"), DESK_LAMP_COLORED_POWERED);

        Registry.register(Registry.ITEM, BasicFourLegTableOak, BASIC_TABLE_OAK);
        Registry.register(Registry.ITEM, BasicFourLegTableSpruce, BASIC_TABLE_SPRUCE);
        Registry.register(Registry.ITEM, BasicFourLegTableBirch, BASIC_TABLE_BIRCH);

        Registry.register(Registry.ITEM, OakCabinet, BASIC_CABINET_OAK);
        Registry.register(Registry.ITEM, SpruceCabinet, BASIC_CABINET_SPRUCE);
        Registry.register(Registry.ITEM, BirchCabinet, BASIC_CABINET_BIRCH);
        Registry.register(Registry.ITEM, JungleCabinet, BASIC_CABINET_JUNGLE);
        Registry.register(Registry.ITEM, AcaciaCabinet, BASIC_CABINET_ACACIA);
        Registry.register(Registry.ITEM, DarkOakCabinet, BASIC_CABINET_DARK_OAK);
        Registry.register(Registry.ITEM, CrimsonCabinet, BASIC_CABINET_CRIMSON);
        Registry.register(Registry.ITEM, WarpedCabinet, BASIC_CABINET_WARPED);

        Registry.register(Registry.ITEM, OakDrawer, BASIC_DRAWER_OAK);
        Registry.register(Registry.ITEM, SpruceDrawer, BASIC_DRAWER_SPRUCE);
        Registry.register(Registry.ITEM, BirchDrawer, BASIC_DRAWER_BIRCH);
        Registry.register(Registry.ITEM, JungleDrawer, BASIC_DRAWER_JUNGLE);
        Registry.register(Registry.ITEM, AcaciaDrawer, BASIC_DRAWER_ACACIA);
        Registry.register(Registry.ITEM, DarkOakDrawer, BASIC_DRAWER_DARK_OAK);
        Registry.register(Registry.ITEM, CrimsonDrawer, BASIC_DRAWER_CRIMSON);
        Registry.register(Registry.ITEM, WarpedDrawer, BASIC_DRAWER_WARPED);

        Registry.register(Registry.ITEM, Oven, OVEN);

    }
}
