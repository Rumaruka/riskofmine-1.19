package com.rumaruka.riskofmine.init;

import com.rumaruka.riskofmine.client.tesr.MultiShopTESR;
import com.rumaruka.riskofmine.client.tesr.SmallChestTESR;
import com.rumaruka.riskofmine.common.tiles.chest.SmallChestTE;
import com.rumaruka.riskofmine.common.tiles.shop.MultiShopTE;
import net.minecraft.world.level.block.entity.BlockEntityType;
import ru.timeconqueror.timecore.api.registry.TileEntityRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;
import static ru.timeconqueror.timecore.api.util.Hacks.promise;

@AutoRegistrable.Entries("block_entity_type")
public class ROMTiles {
    public static  BlockEntityType<SmallChestTE> SMALL_CHEST = promise();
    public static  BlockEntityType<MultiShopTE> MULTI_SHOP = promise();


    private static class Init {
        @AutoRegistrable
        private static final TileEntityRegister REGISTER = new TileEntityRegister(MODID);

        @AutoRegistrable.Init
        private static void register() {
            REGISTER.registerSingleBound("small_chest", SmallChestTE::new, () -> ROMBlocks.SMALL_CHEST).regCustomRenderer(()-> SmallChestTESR::new);
            REGISTER.registerSingleBound("multi_shop", MultiShopTE::new, () -> ROMBlocks.MULTI_SHOP).regCustomRenderer(()-> MultiShopTESR::new);
        }
    }
}
