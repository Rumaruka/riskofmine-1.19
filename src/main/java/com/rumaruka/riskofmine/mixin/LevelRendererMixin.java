package com.rumaruka.riskofmine.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rumaruka.riskofmine.api.entity.IOverloading;
import com.rumaruka.riskofmine.init.ROMEffects;
import com.rumaruka.riskofmine.ntw.ROMNetwork;
import com.rumaruka.riskofmine.ntw.packets.OverloadingPacket;
import com.rumaruka.riskofmine.utils.ROMUtils;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;

import static com.rumaruka.riskofmine.RiskOfMine.rl;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {



    @Inject(method = "renderEntity", at = @At("HEAD"))
    private void renderEntity(Entity pEntity, double pCamX, double pCamY, double pCamZ, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, CallbackInfo ci) {

              if  ( ROMUtils.hasOverloadingOnClient(pEntity)) {
                      Minecraft.getInstance().renderBuffers().outlineBufferSource().setColor(0, 0, 255, 255);
              }


          }



    }



