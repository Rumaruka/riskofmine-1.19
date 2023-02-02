package com.rumaruka.riskofmine;

import com.rumaruka.riskofmine.init.ROMItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static com.rumaruka.riskofmine.RiskOfMine.rl;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static CreativeModeTab MAIN;

    @SubscribeEvent
    public static void onRegisterCreativeTabs(CreativeModeTabEvent.Register event) {
        MAIN = event.registerCreativeModeTab(rl("main"), builder ->
                builder.title(Component.translatable("itemGroup." + RiskOfMine.MODID))
                        .icon(() -> new ItemStack(ROMItems.ARMOR_PIERCING_ROUNDS))
                        .displayItems((pEnabledFeatures, pOutput, pDisplayOperatorCreativeTab) -> {
                            ROMItems.getAllItem().forEach(pOutput::accept);
                        })
        );
    }

}
