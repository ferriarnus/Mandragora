package com.ferri.arnus.examplemod.network;

import com.ferri.arnus.examplemod.Mandragora;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class MandragoraChannel {

    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Mandragora.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register() {
        INSTANCE.registerMessage(0, MandragoraPacket.class, MandragoraPacket::encode, MandragoraPacket::decode, MandragoraPacket::handle);
    }
}
