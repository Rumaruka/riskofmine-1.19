package com.rumaruka.riskofmine.common.events;

import com.rumaruka.riskofmine.common.cap.Barrier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BarrierEvent {


    @SubscribeEvent
    public static void onDamageEntity(LivingDamageEvent event) {
        Entity attacked = event.getSource().getEntity();
        LivingEntity attack = event.getEntity();
        if (attacked instanceof LivingEntity livingEntity && !(attacked instanceof Player)) {
            Barrier barrier = Barrier.of(livingEntity);

            if (barrier != null) {
                if (barrier.hasBarrier()) {
                    event.setCanceled(true);


                    barrier.removeBarrier(1);
                    if (barrier.getCurrentBarrier()<=0){
                        barrier.setBarrierMinus(0);
                        event.setCanceled(false);
                    }
                    barrier.detectAndSendChanges();
                }

            }
        }
        Barrier barrier1 = Barrier.of(attack);
        if (barrier1 != null) {
            if (barrier1.hasBarrier()) {
                event.setCanceled(true);
                barrier1.removeBarrier(1);
                if (barrier1.getCurrentBarrier()<=0){
                    barrier1.setBarrierMinus(0);
                    event.setCanceled(false);
                }
                barrier1.detectAndSendChanges();
            }
        }
    }
}
