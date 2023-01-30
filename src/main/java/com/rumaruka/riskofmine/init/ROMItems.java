package com.rumaruka.riskofmine.init;

import com.google.common.collect.Lists;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import ru.timeconqueror.timecore.api.client.resource.location.TextureLocation;
import ru.timeconqueror.timecore.api.registry.ItemRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;

import java.util.ArrayList;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;
import static ru.timeconqueror.timecore.api.util.Hacks.promise;

@AutoRegistrable.Entries("item")
public class ROMItems {
    public static Item TEST_DIAMOND = promise();

    private static class Init {
        @AutoRegistrable
        private static final ItemRegister REGISTER = new ItemRegister(MODID);

        @AutoRegistrable.Init
        private static void register() {
            REGISTER.register("test_diamond", () -> new Item(new Item.Properties())).tab(CreativeModeTabs.REDSTONE_BLOCKS)
                    .defaultModel(new TextureLocation("minecraft", "item/diamond"));
        }
    }

    public static ArrayList<Item> getAllItem() {
        return (Lists.newArrayList(
                TEST_DIAMOND

//                ARMOR_PIERCING_ROUNDS,
//                BUSTLING_FUNGUS,
//                GASOLINE,
//                INFUSION,
//                SHAPED_GLASS,
//                SOLDIER_SYRINGE,
//                MONSTER_TOOTH,
//                CROWBAR,
//                ENERGY_DRINK,
//                BEADS_OF_FEALTY,
//                CHRONOBAUBLE,
//                BLAST_SHOWER,
//                FOCUS_CRYSTAL,
//                DIO_BEST_FRIEND,
//                ALIEN_HEAD,
//                OLD_WAR_STEALTHKIT,
//                TRI_TIP_DAGGER,
//                STUN_GRENADE,
//                WARBANNER,
//                THE_CROWDFUNDER,
//                STICKY_BOMB,
//                TOPAZ_BROOCH,
//                TENTABAUBLE,
//                BISON_STEAK,
//                COMMON_ITEM_SCRAP,
//                UNCOMMON_ITEM_SCRAP,
//                WEEPING_FUNGUS,
//                POWER_ELIXIR,
//                EMPTY_ELIXIR,
//                TOUGHER_TIMES,
//                SAFER_SPACES,
//                LUNAR_COIN
        ));
    }
}
