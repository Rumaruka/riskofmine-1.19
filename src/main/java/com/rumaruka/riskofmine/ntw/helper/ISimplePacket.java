package com.rumaruka.riskofmine.ntw.helper;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public interface ISimplePacket {

    /**
     * Encodes a packet for the buffer
     *
     * @param buf Buffer instance
     */
    void encode(FriendlyByteBuf buf);

    /**
     * Handles receiving the packet
     *
     * @param context Packet context
     */
    void handle(Supplier<NetworkEvent.Context> context);
}
