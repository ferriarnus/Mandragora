package com.ferri.arnus.mandragora.network;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MandragoraPacket {

    private float pitch;
    private BlockPos pos;
    private boolean darkness;
    public MandragoraPacket(float pitch, BlockPos pos, boolean darkness) {
        this.pitch = pitch;
        this.pos = pos;
        this.darkness = darkness;
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeFloat(this.pitch);
        buffer.writeBlockPos(this.pos);
        buffer.writeBoolean(this.darkness);
    }

    public static MandragoraPacket decode(FriendlyByteBuf buffer) {
        return new MandragoraPacket(buffer.readFloat(), buffer.readBlockPos(), buffer.readBoolean());
    }

    static void handle(final MandragoraPacket message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() ->
                DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> MandragoraPacketHandler.handlePacket(message, ctx)));
        ctx.get().setPacketHandled(true);
    }

    public float getPitch() {
        return this.pitch;
    }

    public BlockPos getPos() {
        return this.pos;
    }

    public boolean hasDarkness() {
        return this.darkness;
    }
}
