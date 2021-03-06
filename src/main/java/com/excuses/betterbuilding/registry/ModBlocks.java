package com.excuses.betterbuilding.registry;

import com.excuses.betterbuilding.BetterBuilding;
import com.excuses.betterbuilding.registry.Blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.excuses.betterbuilding.BetterBuildingIdentifiers.*;


public class ModBlocks {

    //BUILDING
    public static final Block FRAMING_BLOCK = new FrameBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).dynamicBounds());
    public static final Block FLOOR_FRAMING_BLOCK = new FloorFrameBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).dynamicBounds());
    public static final Block SHEETROCK_FRAMING_BLOCK = new SheetrockFrameBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).dynamicBounds());

    public static final Block DOOR_BOTTOM = new BBDoorBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());

    public static final Block POCKETDOOR_BOTTOM = new BBPocketDoorBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block POCKETDOORFRAME_BOTTOM = new BBPocketDoorBlock(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());

    public static final Block WINDOW_BLOCK_BASIC = new WindowBlockBasic(FabricBlockSettings.copyOf(Blocks.GLASS));

    //Furniture

    public static final Block CEILING_LIGHT = new CeilingLight(FabricBlockSettings.of(Material.GLASS).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.GLASS).nonOpaque());
    public static final Block CEILING_LIGHT_LIT = new CeilingLightLit(FabricBlockSettings.of(Material.GLASS).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.GLASS).nonOpaque().dynamicBounds().luminance((state)-> 15));

    public static final Block DESK_LAMP_COLORED = new DeskLampColored(FabricBlockSettings.of(Material.GLASS).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.GLASS).nonOpaque());
    public static final Block DESK_LAMP_COLORED_POWERED = new DeskLampColored(FabricBlockSettings.of(Material.GLASS).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.GLASS).nonOpaque().dynamicBounds().luminance((state)-> 15));

    public static final Block BASIC_TABLE_OAK = new BasicFourLegTable(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).dynamicBounds());
    public static final Block BASIC_TABLE_SPRUCE = new BasicFourLegTable(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).dynamicBounds());
    public static final Block BASIC_TABLE_BIRCH = new BasicFourLegTable(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).dynamicBounds());

    public static final Block BASIC_CABINET_OAK = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_CABINET_SPRUCE = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_CABINET_BIRCH = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_CABINET_JUNGLE = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_CABINET_ACACIA = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_CABINET_DARK_OAK = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_CABINET_CRIMSON = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_CABINET_WARPED = new BasicCabinet(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());

    public static final Block BASIC_DRAWER_OAK = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_DRAWER_SPRUCE = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_DRAWER_BIRCH = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_DRAWER_JUNGLE = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_DRAWER_ACACIA = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_DRAWER_DARK_OAK = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_DRAWER_CRIMSON = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());
    public static final Block BASIC_DRAWER_WARPED = new BasicDrawer(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());

    public static final Block OVEN = new Oven(FabricBlockSettings.of(Material.WOOD).breakByTool(FabricToolTags.AXES).requiresTool().strength(1.0f, 1.0f).sounds(BlockSoundGroup.WOOD).nonOpaque().dynamicBounds());


    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "framing_block"), FRAMING_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "floor_framing_block"), FLOOR_FRAMING_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "sheetrock_framing_block"), SHEETROCK_FRAMING_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "window_block_basic"), WINDOW_BLOCK_BASIC);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "door_bottom"), DOOR_BOTTOM);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "pocketdoor_bottom"), POCKETDOOR_BOTTOM);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "pocketdoorframe_bottom"), POCKETDOORFRAME_BOTTOM);

        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "ceiling_light"), CEILING_LIGHT);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "ceiling_light_lit"), CEILING_LIGHT_LIT);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "desk_lamp_colored"),DESK_LAMP_COLORED);
        Registry.register(Registry.BLOCK, new Identifier(BetterBuilding.MOD_ID, "desk_lamp_colored_powered"), DESK_LAMP_COLORED_POWERED);
        Registry.register(Registry.BLOCK, BasicFourLegTableOak, BASIC_TABLE_OAK);
        Registry.register(Registry.BLOCK, BasicFourLegTableSpruce, BASIC_TABLE_SPRUCE);
        Registry.register(Registry.BLOCK, BasicFourLegTableBirch, BASIC_TABLE_BIRCH);

        Registry.register(Registry.BLOCK, OakCabinet, BASIC_CABINET_OAK);
        Registry.register(Registry.BLOCK, SpruceCabinet, BASIC_CABINET_SPRUCE);
        Registry.register(Registry.BLOCK, BirchCabinet, BASIC_CABINET_BIRCH);
        Registry.register(Registry.BLOCK, JungleCabinet, BASIC_CABINET_JUNGLE);
        Registry.register(Registry.BLOCK, AcaciaCabinet, BASIC_CABINET_ACACIA);
        Registry.register(Registry.BLOCK, DarkOakCabinet, BASIC_CABINET_DARK_OAK);
        Registry.register(Registry.BLOCK, CrimsonCabinet, BASIC_CABINET_CRIMSON);
        Registry.register(Registry.BLOCK, WarpedCabinet, BASIC_CABINET_WARPED);

        Registry.register(Registry.BLOCK, OakDrawer, BASIC_DRAWER_OAK);
        Registry.register(Registry.BLOCK, SpruceDrawer, BASIC_DRAWER_SPRUCE);
        Registry.register(Registry.BLOCK, BirchDrawer, BASIC_DRAWER_BIRCH);
        Registry.register(Registry.BLOCK, JungleDrawer, BASIC_DRAWER_JUNGLE);
        Registry.register(Registry.BLOCK, AcaciaDrawer, BASIC_DRAWER_ACACIA);
        Registry.register(Registry.BLOCK, DarkOakDrawer, BASIC_DRAWER_DARK_OAK);
        Registry.register(Registry.BLOCK, CrimsonDrawer, BASIC_DRAWER_CRIMSON);
        Registry.register(Registry.BLOCK, WarpedDrawer, BASIC_DRAWER_WARPED);

        Registry.register(Registry.BLOCK, Oven, OVEN);

    }
}
