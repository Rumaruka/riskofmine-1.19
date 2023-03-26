package com.rumaruka.riskofmine.gen.smallchestgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public record SmallChestFeatureConfig(int tries, int xzSpread, int ySpread,
                                      Holder<PlacedFeature> feature) implements FeatureConfiguration {
    public static final Codec<SmallChestFeatureConfig> CODEC = RecordCodecBuilder.create((p_191312_) -> {
        return p_191312_.group(ExtraCodecs.POSITIVE_INT.fieldOf("tries").orElse(128).forGetter(SmallChestFeatureConfig::tries), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("xz_spread").orElse(7).forGetter(SmallChestFeatureConfig::xzSpread), ExtraCodecs.NON_NEGATIVE_INT.fieldOf("y_spread").orElse(3).forGetter(SmallChestFeatureConfig::ySpread), PlacedFeature.CODEC.fieldOf("feature").forGetter(SmallChestFeatureConfig::feature)).apply(p_191312_, SmallChestFeatureConfig::new);
    });
}