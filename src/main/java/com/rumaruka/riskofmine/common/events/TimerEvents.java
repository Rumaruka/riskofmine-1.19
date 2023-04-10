package com.rumaruka.riskofmine.common.events;

import com.rumaruka.riskofmine.common.cap.Timer;
import com.rumaruka.riskofmine.init.ROMEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class TimerEvents {

//    @SubscribeEvent
//    public static void addTimer(LivingEvent.LivingTickEvent event) {
//        LivingEntity entity = event.getEntity();
//        if (entity instanceof Player player) {
//            Level level = player.getLevel();
//            if (!level.isClientSide()) {
//                Timer timer = Timer.of(player);
//                if (player.tickCount % 2 == 0) {
//                    if (timer != null) {
//                        timer.addTime(0);
//                        timer.detectAndSendChanges();
//                    }
//                }
//            }
//        }
//    }
//    @SubscribeEvent
//    public static void giveElites(LivingEvent.LivingTickEvent event) {
//        LivingEntity entity = event.getEntity();
//
//        Level level = entity.getLevel();
//        if (!level.isClientSide()) {
//            if (entity instanceof Player player) {
//                Timer timer = Timer.of(player);
//                if (timer != null) {
//                    if (  timer.getCurrentTime() > 100){
//
//                        entity.addEffect(new MobEffectInstance(ROMEffects.OVERLOADING.get(),1,1,false,false));
//                        timer.detectAndSendChanges();
//                    }
//
//                }
//            }
//        }
//    }

}
