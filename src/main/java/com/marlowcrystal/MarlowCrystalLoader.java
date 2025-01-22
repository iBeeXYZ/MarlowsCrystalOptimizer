package com.marlowcrystal;

import com.marlowcrystal.packets.OptOutPacket;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;

public class MarlowCrystalLoader implements ModInitializer {

    @Override
    public void onInitialize() {
        PayloadTypeRegistry.playC2S().register(OptOutPacket.TYPE, OptOutPacket.STREAM_CODEC);
    }
}
