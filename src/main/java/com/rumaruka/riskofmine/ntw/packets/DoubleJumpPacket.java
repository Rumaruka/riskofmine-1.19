package com.rumaruka.riskofmine.ntw.packets;

import com.rumaruka.riskofmine.common.cap.Lunar;
import com.rumaruka.riskofmine.common.cap.Money;
import com.rumaruka.riskofmine.init.ROMDoubleEffect;
import com.rumaruka.riskofmine.init.ROMSounds;
import com.rumaruka.riskofmine.utils.ROMUtils;
import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class DoubleJumpPacket {


    public DoubleJumpPacket(FriendlyByteBuf byteBuf) {

    }

    public DoubleJumpPacket() {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public void handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            Player player = ROMUtils.getPlayer();
            FriendlyByteBuf byteBuf = new FriendlyByteBuf(Unpooled.buffer());
            byteBuf.writeUtf(player.getStringUUID());
            ROMDoubleEffect.play(player);

        });
        ctx.get().setPacketHandled(true);
    }
}
