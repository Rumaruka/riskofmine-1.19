package com.rumaruka.riskofmine.utils;

import com.google.common.collect.Lists;
import com.rumaruka.riskofmine.api.Category;
import com.rumaruka.riskofmine.api.Types;
import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.client.Minecraft;

import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.EffectCommands;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class ROMUtils {


    private static MobEffectCategory category;
    private final List<Category> categoryEnum = Lists.newArrayList();

    public static int durOld;



    public static ItemStack getStack(Item item) {
        return new ItemStack(item);
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


    public static boolean checkInventory(Player player, Item item) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack itemStack = player.getInventory().getItem(i);
            if (itemStack.getItem() == item) {
                return true;
            }

        }
        return false;
    }

    public static void replaceItem(ItemStack select, ItemStack replaced) {
        select.shrink(1);
        replaced.shrink(-1);

    }

}
