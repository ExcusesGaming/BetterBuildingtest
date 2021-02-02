package com.excuses.betterbuilding.registry;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.network.ServerPlayerEntity;

public interface ExtendedScreenHandlerFactory extends NamedScreenHandlerFactory {
    /**
     * Writes additional server -&gt; client screen opening data to the buffer.
     *
     * @param player the player that is opening the screen
     * @param buf    the packet buffer
     */
    void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf);
}
