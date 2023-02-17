package com.rumaruka.riskofmine.init;


import com.rumaruka.riskofmine.common.inventory.ChestInventory;
import com.rumaruka.riskofmine.common.inventory.ChestShopInventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.ForgeRegistries;
import ru.timeconqueror.timecore.api.registry.SimpleVanillaRegister;
import ru.timeconqueror.timecore.api.registry.util.AutoRegistrable;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;
import static ru.timeconqueror.timecore.api.util.Hacks.promise;

@AutoRegistrable.Entries("menu")
public class ROMContainerTypes {
    @AutoRegistrable
    private static final SimpleVanillaRegister<MenuType<?>> REGISTER = new SimpleVanillaRegister<>(ForgeRegistries.MENU_TYPES, MODID);

    public static  MenuType<ChestInventory> SMALL_CHEST = promise()  ;
    public static  MenuType<ChestInventory> LARGE_CHEST  = promise()  ;
    public static  MenuType<ChestInventory> LEGENDARY_CHEST   = promise() ;
    public static  MenuType<ChestInventory>LUNAR_CHEST  = promise()  ;

    public static  MenuType<ChestShopInventory>MULTI_SHOP  = promise() ;
    public static  MenuType<ChestShopInventory>EQUIPMENT_TRIPLE_BARREL  = promise()  ;

    @AutoRegistrable.Init
    private static void register() {
        REGISTER.register("small_chest", () -> new MenuType<>(ChestInventory::createCommonContainer));
        REGISTER.register("large_chest", () -> new MenuType<>(ChestInventory::createLargeContainer));
        REGISTER.register("legendary_chest", () -> new MenuType<>(ChestInventory::createLegendaryContainer));
        REGISTER.register("lunar_chest",()->new MenuType<>(ChestInventory::createLunarContainer));
       REGISTER.register("equipment_triple_barrel",()->new MenuType<>(ChestShopInventory::createEquipmentTripleBarrelContainer));
        REGISTER.register("multi_shop",()->new MenuType<>(ChestShopInventory::createMultiShopContainer));
    }
}
