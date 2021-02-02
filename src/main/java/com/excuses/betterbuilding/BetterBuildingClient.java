package com.excuses.betterbuilding;

import com.excuses.betterbuilding.registry.TestScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class BetterBuildingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(BetterBuilding.TEST_SCREEN_HANDLER, TestScreen::new);
    }
}