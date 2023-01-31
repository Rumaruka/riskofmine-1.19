package com.rumaruka.riskofmine;

import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;
import static com.rumaruka.riskofmine.RiskOfMine.rl;
import static ru.timeconqueror.timecore.api.util.Hacks.promise;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    public static CreativeModeTab tabRiskofMine;

    @SubscribeEvent
    public static void registerTabs(CreativeModeTabEvent.Register register) {
        tabRiskofMine = register.registerCreativeModeTab(new ResourceLocation(MODID,"riskofmine"),builder -> builder
                .icon(()-> new ItemStack(ROMItems.ARMOR_PIERCING_ROUNDS))
                .title(Component.translatable("itemGroup.riskofmine"))
                .displayItems((featureFlags, output, hasOp) -> {
                   ROMItems.getAllItem().forEach(output::accept);

                })


        );
    }
}
