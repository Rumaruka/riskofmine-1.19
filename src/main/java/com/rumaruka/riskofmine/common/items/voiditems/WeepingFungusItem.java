package com.rumaruka.riskofmine.common.items.voiditems;

import com.rumaruka.riskofmine.api.Category;
import com.rumaruka.riskofmine.common.items.common.BustlingFungusItem;
import com.rumaruka.riskofmine.events.MovingHandler;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;

public class WeepingFungusItem extends VoidItem{
    public WeepingFungusItem() {
        super(Category.HEALING, 15);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof Player player){
            for (int i=0;i< player.getInventory().getContainerSize();i++){
                ItemStack itemStack = player.getInventory().getItem(i);
                if (itemStack.getItem() instanceof BustlingFungusItem){
                    replaceItem(itemStack,pStack);
                }
            }


            if (!pLevel.isClientSide()){
                if (MovingHandler.isMoving(player)) {
                        player.heal((pStack.getCount() + 0.045f) / 20f);
                }
            }
        }

    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if (slotContext.entity() instanceof Player player){
            for (int i=0;i< player.getInventory().getContainerSize();i++){
                ItemStack itemStack = player.getInventory().getItem(i);
                if (itemStack.getItem() instanceof BustlingFungusItem){
                    replaceItem(itemStack,stack);
                }
            }


            if (!slotContext.entity().level.isClientSide()){
                if (MovingHandler.isMoving(player)) {
                    player.heal((stack.getCount() + 0.045f) / 20f);
                }
            }
        }
    }
}
