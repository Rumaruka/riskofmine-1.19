package com.rumaruka.riskofmine.utils;

import com.google.common.collect.Lists;
import com.rumaruka.riskofmine.api.Category;
import com.rumaruka.riskofmine.common.items.BaseCollectablesItem;
import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.AmbientCreature;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.EntityBasedExplosionDamageCalculator;
import net.minecraft.world.level.ExplosionDamageCalculator;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.ArrayList;
import java.util.List;


public class ROMUtils {


    private static MobEffectCategory category;
    private final List<Category> categoryEnum = Lists.newArrayList();
    private static final Minecraft mc = Minecraft.getInstance();
    public static int durOld;


    public static Minecraft getMc() {
        return mc;
    }


    public static Player getPlayer() {
        return mc.player;
    }


    public boolean hasCategory(Category categoryEnum) {
        return this.categoryEnum.contains(categoryEnum);
    }


    public static int getDurOld() {
        return durOld;
    }

    /**
     * set the movespeed used for the new AI system
     */
    public static int setDurOld(int durNew) {
        return durOld = durNew;
    }


    public static void sendMessage(String msg) {
        Player player = Minecraft.getInstance().player;

        if (player != null) {
            player.sendSystemMessage(Component.translatable(msg));

        }

    }


    public static void removeNegativeEffect(LivingEntity entity) {
        List<MobEffect> potions = new ArrayList<>();
        potions.addAll(entity.getActiveEffectsMap().keySet());
        potions.stream().filter(potion -> isBadEffect()).forEach(entity::removeEffect);
    }

    public static boolean isBadEffect() {
        return category == MobEffectCategory.HARMFUL;
    }

    public static int counting (Player player, Item item)
       {


            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack itemStack = player.getInventory().getItem(i);
                if (itemStack.getItem() == item) {

                    return itemStack.getCount();
                }

            }
            return 0;
    }
    public static int countingCurio (Player player, Item item)
    {



            ItemStack itemStack = curiosItemStack(player, item);
            if (itemStack.getItem() == item) {

                return itemStack.getCount();


        }
        return 0;
    }
    public static boolean checkInventory(Player player, Item item) {

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack itemStack = player.getInventory().getItem(i);
            if (itemStack.getItem() == item) {
                return true;
            }

        }
        return false;
    }
    public static ItemStack curiosItemStack(Player player, Item item) {
        if (CuriosApi.getCuriosHelper().findFirstCurio(player, item).isPresent()) {
            return CuriosApi.getCuriosHelper().findFirstCurio(player, item).get().stack();
        } else {
            return ItemStack.EMPTY;
        }
    }

    public static boolean checkCurios(Player player, Item item) {
        if (CuriosApi.getCuriosHelper().findFirstCurio(player, item).isPresent()) {
            ItemStack curioStack = CuriosApi.getCuriosHelper().findFirstCurio(player, item).get().stack();
            if (curioStack.getItem() == item) {
                return true;
            }

        }
        return false;
    }
    private ExplosionDamageCalculator makeNewEDC(Entity entity){
        return new EntityBasedExplosionDamageCalculator(entity);
    }
    public static void replaceItem(ItemStack used, ItemStack scrap) {
        used.shrink(1);
        scrap.shrink(-1);
    }


    public static int getCountInItem(Item item){
        return new ItemStack(item).getCount();
    }

}
