package com.rumaruka.riskofmine.compat.jei;

import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.init.ROMItems;
import jeresources.jei.dungeon.DungeonWrapper;
import jeresources.registry.DungeonRegistry;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.ingredients.IIngredientType;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static com.rumaruka.riskofmine.RiskOfMine.rl;
import static jeresources.jei.JEIConfig.DUNGEON_TYPE;


@JeiPlugin
public class ROMJeiPlugin implements IModPlugin {
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        ROMItems.getAllItem().forEach(item -> {
            registerIngredientInfo(registration, item);
        });
    }


    @Override
    public ResourceLocation getPluginUid() {
        return rl("riskofmine");
    }

    public void registerIngredientInfo(IRecipeRegistration registration, Item ingredient) {

        registration.addIngredientInfo(new ItemStack(ingredient), VanillaTypes.ITEM_STACK,
                Component.translatable("jei." + ingredient.getDescriptionId() + ".desc"));


    }
}
