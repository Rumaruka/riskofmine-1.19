package com.rumaruka.riskofmine.init;

import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.world.SmallChestFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ROMFeatures {
    private static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, RiskOfMine.MODID);
    public static final RegistryObject<SmallChestFeature>SMALL_CHEST_FEATURE = FEATURES.register("small_chest",()->new SmallChestFeature(NoneFeatureConfiguration.CODEC));
    public static void registerFeatures() {
        FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
