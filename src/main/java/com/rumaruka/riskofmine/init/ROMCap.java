package com.rumaruka.riskofmine.init;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import ru.timeconqueror.timecore.api.registry.CapabilityRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ROMCap {

    @AutoRegistrable
    private static final CapabilityRegister REGISTER = new CapabilityRegister(MODID);



    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event){

    }

}
