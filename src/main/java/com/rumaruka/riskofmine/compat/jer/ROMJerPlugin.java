package com.rumaruka.riskofmine.compat.jer;

import com.rumaruka.riskofmine.datagen.loot.ROMLootTables;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ROMJerPlugin {
//    @JERPlugin
//    public static IJERAPI jerAPI;

    public static void setup(FMLCommonSetupEvent e){
        initDungeonLoot();
    }

    private static void initDungeonLoot() {
//        IDungeonRegistry dungeonRegistry = jerAPI.getDungeonRegistry();
//        dungeonRegistry.registerChest("RiskOfMine: Small Chest", ROMLootTables.SMALL_CHEST);

    }
}
