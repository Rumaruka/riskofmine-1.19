package com.rumaruka.riskofmine.common.events;

import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.common.cap.Lunar;
import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RiskOfMine.MODID)
public class LunarEvents {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {

        if (event.getSource().getEntity() instanceof ServerPlayer player) {
            LivingEntity livingEntity = event.getEntity();
            Level level = livingEntity.level;


            if (!level.isClientSide) {
                if (livingEntity.tickCount % 10 == 0) {
                    ItemEntity itemEntity = new ItemEntity(level, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(), new ItemStack(ROMItems.LUNAR_COIN));
                    level.addFreshEntity(itemEntity);

                }


            }

        }
        if (event.getSource().getEntity() instanceof AmbientCreature livingEntity && event.getEntity() instanceof ServerPlayer player) {
            Level world = player.level;
            Lunar lunar = Lunar.of(player);
            if (!world.isClientSide) {
                if (event.getSource().isBypassInvul()) {
                    return;
                } else {
                    if (lunar != null) {
                        lunar.setLunar(0);
                        lunar.detectAndSendChanges();
                    }


                }


            }
        }
    }
}
