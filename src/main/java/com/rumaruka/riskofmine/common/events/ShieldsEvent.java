package com.rumaruka.riskofmine.common.events;

import com.rumaruka.riskofmine.common.cap.Shields;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ShieldsEvent {


    @SubscribeEvent
    public static void onDamageEntity(LivingDamageEvent event) {
        Entity attacked = event.getSource().getEntity();
        LivingEntity attack = event.getEntity();
        if (attacked instanceof LivingEntity livingEntity && !(attacked instanceof Player)) {
            Shields shields = Shields.of(livingEntity);

            if (shields != null) {
                if (shields.hasShields()) {
                    event.setCanceled(true);


                    shields.removeShields(1);
                    if (shields.getCurrentShields()<=0){
                        shields.setShieldsMinus(0);
                        event.setCanceled(false);
                    }
                    shields.detectAndSendChanges();
                }

            }
        }
        Shields shields1 = Shields.of(attack);
        if (shields1 != null) {
            if (shields1.hasShields()) {
                event.setCanceled(true);
                shields1.removeShields(1);
                if (shields1.getCurrentShields()<=0){
                    shields1.setShieldsMinus(0);
                    event.setCanceled(false);
                }
                shields1.detectAndSendChanges();
            }
        }
    }
}
