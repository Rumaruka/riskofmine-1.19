package com.rumaruka.riskofmine.init;

import com.google.common.collect.Lists;
import com.rumaruka.riskofmine.ModSetup;
import com.rumaruka.riskofmine.common.blocks.chest.SmallChestBlock;
import com.rumaruka.riskofmine.common.blocks.shop.MultiShopBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import ru.timeconqueror.timecore.api.registry.BlockRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;

import java.util.ArrayList;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;
import static ru.timeconqueror.timecore.api.util.Hacks.promise;

@AutoRegistrable.Entries("block")
public class ROMBlocks {
    public static SmallChestBlock SMALL_CHEST  ;
    public static MultiShopBlock MULTI_SHOP  ;

    @AutoRegistrable
    private static final BlockRegister REGISTER = new BlockRegister(MODID);

    @AutoRegistrable.Init
    private static void register() {
        REGISTER.register("small_chest", SmallChestBlock::new).oneVarStateAndCubeAllModel().name("small_chest");
        REGISTER.register("multi_shop", MultiShopBlock::new).oneVarStateAndCubeAllModel().name("multi_shop");


    }


}
