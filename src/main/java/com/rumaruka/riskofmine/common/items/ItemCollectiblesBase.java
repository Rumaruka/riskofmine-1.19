package com.rumaruka.riskofmine.common.items;

import com.rumaruka.riskofmine.api.Category;
import com.rumaruka.riskofmine.api.Types;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ItemCollectiblesBase extends Item implements ICurioItem {
    private final Types type;
    private final Category categoryEnum;
    private final int sizeStack;
    public int cooldownMinus;

    public ItemCollectiblesBase(Types type, Category category, int size) {
        super(new Properties().stacksTo(size));
        this.type = type;
        this.categoryEnum = category;
        this.sizeStack = size;
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return sizeStack;
    }



    public int getSizeStack() {
        return sizeStack;
    }

    public Types getType() {
        return type;
    }

    public String getTypeName() {
        return type.getName();
    }

    public ChatFormatting getColor() {
        return type.getChatColor();
    }

    public ChatFormatting getColors() {
        return categoryEnum.getChatColor();
    }

    public String getCategoryName() {
        return categoryEnum.getName();
    }
}
