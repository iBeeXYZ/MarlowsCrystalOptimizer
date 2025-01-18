package com.marlowcrystal.mixin;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.common.ServerboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.DiscardedPayload;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPacketListener.class)
public class ServerOptOut {

    @Inject(at = @At("TAIL"), method = "handleLogin")
    private void sendInfoPackage(ClientboundLoginPacket packet, CallbackInfo ci) {
        ClientPacketListener networkHandler = (ClientPacketListener) ((Object) this);
        networkHandler.send(new ServerboundCustomPayloadPacket(new DiscardedPayload(ResourceLocation.parse("mco"))));
    }
}
