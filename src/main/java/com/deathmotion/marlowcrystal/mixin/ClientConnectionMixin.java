package com.deathmotion.marlowcrystal.mixin;

import com.deathmotion.marlowcrystal.handler.InteractHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Connection.class)
public class ClientConnectionMixin {

    @Inject(method = "send(Lnet/minecraft/network/protocol/Packet;)V", at = @At("HEAD"))
    private void onPacketSend(Packet<?> packet, CallbackInfo ci) {
        Minecraft client = Minecraft.getInstance();

        if (packet instanceof ServerboundInteractPacket interactionPacket) {
            interactionPacket.dispatch(new InteractHandler(client));
        }
    }
}
