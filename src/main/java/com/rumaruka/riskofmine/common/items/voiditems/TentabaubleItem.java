package com.rumaruka.riskofmine.common.items.voiditems;

import com.rumaruka.riskofmine.api.Category;
import com.rumaruka.riskofmine.common.items.common.TougherTimesItem;
import com.rumaruka.riskofmine.common.items.uncommon.ChronobaubleItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;

public class TentabaubleItem extends VoidItem {
    public TentabaubleItem() {
        super(Category.HEALING, 15);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player) {
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack itemStack = player.getInventory().getItem(i);
                if (itemStack.getItem() instanceof ChronobaubleItem) {
                    replaceItem(itemStack, pStack);
                }
            }


        }

    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player) {
            for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                ItemStack itemStack = player.getInventory().getItem(i);
                if (itemStack.getItem() instanceof ChronobaubleItem) {
                    replaceItem(itemStack, stack);
                }
            }

        }
    }
}
