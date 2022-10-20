package com.ferri.arnus.mandragora.network;

import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MandragoraPacketHandler {
    public static void handlePacket(MandragoraPacket message, Supplier<NetworkEvent.Context> ctx) {
        Minecraft.getInstance().level.playLocalSound(message.getPos(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, 2.0F, message.getPitch(), false);
        if (message.hasDarkness()) {
            Minecraft.getInstance().player.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 120, 0, false, false));
        }
    }
}
