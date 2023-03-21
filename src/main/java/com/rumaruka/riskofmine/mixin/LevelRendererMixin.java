package com.rumaruka.riskofmine.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rumaruka.riskofmine.init.ROMEffects;
import com.rumaruka.riskofmine.utils.ROMUtils;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
@OnlyIn(Dist.CLIENT)
public abstract class LevelRendererMixin {


        @Inject(method = "renderLevel", at = @At("TAIL"))
    public void renderLevel(PoseStack pPoseStack, float pPartialTick, long pFinishNanoTime, boolean pRenderBlockOutline, Camera pCamera, GameRenderer pGameRenderer, LightTexture pLightTexture, Matrix4f pProjectionMatrix, CallbackInfo ci) {
        if (ROMUtils.getMc().level != null) {
            for (Entity entity : ROMUtils.getMc().level.entitiesForRendering()) {
                MultiBufferSource multibuffersource;
                if (entity instanceof LivingEntity living) {
                    if (living.hasEffect(ROMEffects.OVERLOADING.get())) {
                        OutlineBufferSource outlinebuffersource = ROMUtils.getMc().renderBuffers().outlineBufferSource();
                        multibuffersource = outlinebuffersource;

                        int i = entity.getTeamColor();
                        int j = 255;
                        int k = i >> 4 & 255;
                        int l = i >> 2 & 255;
                        int i1 = i & 255;
                        outlinebuffersource.setColor(k, l, i1, 255);
                    }

                }
            }

        }
    }


}
