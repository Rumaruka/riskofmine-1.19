package com.rumaruka.riskofmine.init;

import com.rumaruka.riskofmine.RiskOfMine;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ObjectHolder;
import ru.timeconqueror.timecore.api.registry.BlockRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;
import static ru.timeconqueror.timecore.api.util.Hacks.promise;

@AutoRegistrable.Entries("block")
public class ROMBlocks {
    @AutoRegistrable
    private static final BlockRegister REGISTER = new BlockRegister(MODID);

    @AutoRegistrable.Init
    private static void register() {


    }
}
