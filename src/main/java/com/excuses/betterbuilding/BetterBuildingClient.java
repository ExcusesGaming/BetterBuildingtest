package com.excuses.betterbuilding;

import com.excuses.betterbuilding.registry.BasicCabinetScreen;
import com.excuses.betterbuilding.registry.BasicDrawerScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class BetterBuildingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(BetterBuilding.BASIC_CABINET_SCREEN_HANDLER, BasicCabinetScreen::new);
        ScreenRegistry.register(BetterBuilding.BASIC_DRAWER_SCREEN_HANDLER, BasicDrawerScreen::new);
    }
}