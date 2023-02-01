package com.rumaruka.riskofmine.client.screen.overlay;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.common.cap.Money;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;
import ru.timeconqueror.timecore.api.util.client.DrawHelper;

import java.awt.*;

@Mod.EventBusSubscriber(modid = RiskOfMine.MODID)
public class ROMOverlayRender {

    public static KeyMapping KEY_SHOW_OVERLAYS = new KeyMapping("Show Overlay",  GLFW.GLFW_KEY_M, "Risk of Mine");

    private static final Minecraft mc = Minecraft.getInstance();

    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent e) {
        e.register(KEY_SHOW_OVERLAYS);
    }

    @SubscribeEvent
    public static void renderOverlay(CustomizeGuiOverlayEvent.Chat event) {
        if (KEY_SHOW_OVERLAYS.isDown()) {
            renderNearbyMoneyDisplay(event.getPoseStack());
        }
    }

    private static void renderNearbyMoneyDisplay(PoseStack stack) {
        stack.pushPose();
        Player player = mc.player;
        Font font = mc.font;
        if (player != null && !player.isDeadOrDying()) {
            Money money = Money.of(player);
            if (money != null) {
                String toDisplay = getMoneyDisplay(money);
                Color color = Color.magenta;
                DrawHelper.drawString(stack, font, toDisplay, 27.5f, 30, color.getRGB());
            }
        }
    }


    private static String getMoneyDisplay(Money money) {
        float currentMoney = money.money.get();
        return I18n.get("riskofmine.currentmoney.name") + currentMoney;

    }
}
