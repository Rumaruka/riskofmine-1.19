package com.rumaruka.riskofmine.common.events;

import com.rumaruka.riskofmine.common.entity.StickyBombEntity;
import com.rumaruka.riskofmine.init.ROMItems;
import com.rumaruka.riskofmine.init.ROMParticles;
import com.rumaruka.riskofmine.utils.ROMMathFormula;
import com.rumaruka.riskofmine.utils.ROMUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;

@Mod.EventBusSubscriber
public class ItemsEvent {
    /**
     * onPlayerHurt  - for hurt entites without Player event
     *
     * @param event
     */
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onEntityHurt(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof ServerPlayer player) {
            LivingEntity livingEntity = event.getEntity();
            Level level = livingEntity.level;
            if (!level.isClientSide) {
                for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                    ItemStack itemStack = player.getInventory().getItem(i);
                    if (itemStack.getItem() == ROMItems.ARMOR_PIERCING_ROUNDS && (event.getEntity() instanceof WitherBoss || event.getEntity() instanceof EnderDragon || !event.getEntity().canChangeDimensions())) {
                        event.getEntity().hurt(DamageSource.MAGIC, itemStack.getCount() * 2 - 1);

                    }

                    if (itemStack.getItem() == ROMItems.CROWBAR && event.getEntity() instanceof AmbientCreature) {
                        if (((AmbientCreature) event.getEntity()).getHealth() > (((AmbientCreature) event.getEntity()).getMaxHealth() * 90 / 100)) {

                            event.getEntity().hurt(DamageSource.MAGIC, (float) (itemStack.getCount() * 1.00115d));
                        }
                    }

                }
                if (CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.ARMOR_PIERCING_ROUNDS).isPresent()) {
                    ItemStack curioStack = CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.ARMOR_PIERCING_ROUNDS).get().stack();
                    if (curioStack.getItem() == ROMItems.ARMOR_PIERCING_ROUNDS && event.getEntity() instanceof AmbientCreature) {
                        if (curioStack.getItem() == ROMItems.ARMOR_PIERCING_ROUNDS && (event.getEntity() instanceof WitherBoss || event.getEntity() instanceof EnderDragon || !event.getEntity().canChangeDimensions())) {
                            event.getEntity().hurt(DamageSource.MAGIC, curioStack.getCount() * 2 - 1);
                        }
                    }
                }
                if (CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.CROWBAR).isPresent()) {
                    ItemStack curioStack = CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.CROWBAR).get().stack();
                    if (curioStack.getItem() == ROMItems.CROWBAR && event.getEntity() instanceof AmbientCreature) {
                        if (((AmbientCreature) event.getEntity()).getHealth() > (((AmbientCreature) event.getEntity()).getMaxHealth() * 90 / 100)) {

                            event.getEntity().hurt(DamageSource.MAGIC, (float) (curioStack.getCount() * 1.00115d));
                        }
                    }
                }

            }
            if (ROMUtils.checkInventory(player, ROMItems.STICKY_BOMB)) {
                StickyBombEntity entityStickyBomb = new StickyBombEntity(level, livingEntity.getX() + 0.5d, livingEntity.getY() + 0.5d, livingEntity.getZ() + 0.5d, player, (Mob) event.getEntity());
                level.addFreshEntity(entityStickyBomb);
            }
            if (CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.STICKY_BOMB).isPresent()) {
                ItemStack curioStack = CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.STICKY_BOMB).get().stack();
                if (curioStack.getItem() == ROMItems.STICKY_BOMB) {


                    StickyBombEntity entityStickyBomb = new StickyBombEntity(level, livingEntity.getX() + 0.5d, livingEntity.getY() + 0.5d, livingEntity.getZ() + 0.5d, player, (Mob) event.getEntity());
                    level.addFreshEntity(entityStickyBomb);


                }
            }
        }
    }

    /**
     * onPlayerHurt  - for hurt player event
     *
     * @param event
     */
    @SubscribeEvent(priority = EventPriority.LOW)
    public static void onPlayerHurt(LivingHurtEvent event) {

        if (event.getSource().getEntity() instanceof Mob && event.getEntity() instanceof ServerPlayer player) {


            Level world = player.level;
            if (!world.isClientSide) {

                for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                    ItemStack itemStack = player.getInventory().getItem(i);
                    if (itemStack.getItem() == ROMItems.OLD_WAR_STEALTHKIT) {
                        if (player.getHealth() >= 2.5f) {
                            player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1000, 1, false, false));
                            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 1, false, false));
                        }

                    }

                }
                if (CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.OLD_WAR_STEALTHKIT).isPresent()) {
                    ItemStack curioStack = CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.OLD_WAR_STEALTHKIT).get().stack();
                    if (curioStack.getItem() == ROMItems.OLD_WAR_STEALTHKIT) {
                        if (curioStack.getItem() == ROMItems.OLD_WAR_STEALTHKIT) {
                            if (player.getHealth() >= 2.5f) {
                                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1000, 1, false, false));
                                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1000, 1, false, false));
                            }
                        }
                    }
                }

            }


        }
    }

    @SubscribeEvent
    public static void onEntityUpdate(LivingEvent.LivingTickEvent event) {
        Player player = ROMUtils.getPlayer();

        LivingEntity livingEntity = event.getEntity();
        Level level = livingEntity.level;
        if (!level.isClientSide) {
            if (player != null) {
                for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                    ItemStack itemStack = player.getInventory().getItem(i);
                    if (itemStack.getItem() == ROMItems.FOCUS_CRYSTAL) {
                        if (livingEntity instanceof Mob) {
                            float distance = player.distanceTo(livingEntity);

                            if (distance <= 3.5) {
                                livingEntity.hurt(DamageSource.MAGIC, ROMMathFormula.powerIncreasing(itemStack.getCount(), 5.0f));
                               Minecraft.getInstance().particleEngine.createTrackingEmitter(livingEntity, ROMParticles.FOCUS_CRYSTAL.get());
                            }


                        }
                    }


                }
                if (livingEntity instanceof Mob) {
                    float distance = player.distanceTo(livingEntity);
                    if (CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.FOCUS_CRYSTAL).isPresent()) {
                        ItemStack curioStack = CuriosApi.getCuriosHelper().findFirstCurio(player, ROMItems.FOCUS_CRYSTAL).get().stack();
                        ;
                        if (curioStack.getItem() == ROMItems.FOCUS_CRYSTAL) {

                            if (distance <= 3.5) {
                                livingEntity.hurt(DamageSource.MAGIC, curioStack.getCount());
                                Minecraft.getInstance().particleEngine.createTrackingEmitter(livingEntity, ROMParticles.FOCUS_CRYSTAL.get(),20);
                            }
                        }

                    }
                }

            }
        }
    }
}
