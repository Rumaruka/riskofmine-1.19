package com.rumaruka.riskofmine.common.events;

import com.rumaruka.riskofmine.common.cap.Timer;
import com.rumaruka.riskofmine.init.ROMEffects;
import com.rumaruka.riskofmine.utils.ROMMathFormula;
import com.rumaruka.riskofmine.utils.ROMMathUtils;
import com.rumaruka.riskofmine.utils.ROMUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber
public class ElitesEvent {
    @SubscribeEvent
    public static void addEffect(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        Player player = ROMUtils.getPlayer();
        Level level = entity.level;
        if (!level.isClientSide()) {
            if (player != null) {
                Timer timer = Timer.of(player);
                if (timer != null && !(entity instanceof Player)) {
                    if (timer.getCurrentTime() > 10) {
                        entity.addEffect(new MobEffectInstance(ROMEffects.MENDING.get()));

                    }
                }
            }

        }

    }

    @SubscribeEvent
    public static void addFunctionForEffectsTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();


        Level level = entity.level;
        if (!level.isClientSide()) {
            if (entity.hasEffect(ROMEffects.MENDING.get())) {
                List<LivingEntity> entities = level.getEntitiesOfClass(
                        LivingEntity.class, new AABB(new BlockPos(entity.getX() + 2, entity.getY(), entity.getZ() + 2))
                );
                for (LivingEntity anotherEntity : entities) {
                    if (!(entity instanceof Player)) {


                        System.out.println("Корова спасибо!");
                        entity.heal((float) (0.01));


                    }
                }
            }
            if (entity.hasEffect(ROMEffects.OVERLOADING.get())) {

            }

        }


    }

    @SubscribeEvent
    public static void addFunctionForEffectsAttack(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.getLevel();
        if (!level.isClientSide()) {
            if (entity.hasEffect(ROMEffects.BLAZING.get())) {
                ROMUtils.getPlayer().setRemainingFireTicks(1);

            }

        }
    }
}



