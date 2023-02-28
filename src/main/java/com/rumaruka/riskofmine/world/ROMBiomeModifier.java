package com.rumaruka.riskofmine.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.rumaruka.riskofmine.RiskOfMine;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.rumaruka.riskofmine.RiskOfMine.MODID;
@Mod.EventBusSubscriber(modid = RiskOfMine.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ROMBiomeModifier {
    // public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MODID);
//    public static final RegistryObject<Codec<TestModifier>> MODIFY_BIOMES = BIOME_MODIFIER_SERIALIZERS.register("modify_biomes", () ->
//            RecordCodecBuilder.create(builder -> builder.group(
//                    Biome.LIST_CODEC.fieldOf("biomes").forGetter(TestModifier::biomes),
//                    Biome.Precipitation.CODEC.fieldOf("precipitation").forGetter(TestModifier::precipitation),
//                    Codec.INT.fieldOf("water_color").forGetter(TestModifier::waterColor)
//            ).apply(builder, TestModifier::new))
//    );
    public static final ResourceKey<PlacedFeature> SMALL_CHEST = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(MODID, "small_chest"));

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.PLACED_FEATURE, context -> context.register(SMALL_CHEST,
                    new PlacedFeature(
                            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(VegetationFeatures.PATCH_SUNFLOWER),
                            commonOrePlacement(1, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(25),VerticalAnchor.aboveBottom(80))))
            )
                    );


    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event)
    {
        event.getGenerator().addProvider(event.includeServer(), (DataProvider.Factory<BiomeModifiers>) output -> new BiomeModifiers(output, event.getLookupProvider()));
    }
    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }
    private static class BiomeModifiers extends DatapackBuiltinEntriesProvider
    {

        public BiomeModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
        {
            super(output, registries, BUILDER, Set.of(MODID));
        }

        @Override
        public String getName()
        {
            return "Biome Modifier Registries: " + MODID;
        }
    }



//    public record TestModifier(HolderSet<Biome> biomes, Biome.Precipitation precipitation, int waterColor) implements BiomeModifier
//    {
//
//
//        @Override
//        public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
//            if (phase == Phase.MODIFY && this.biomes.contains(biome))
//            {
//                builder.getClimateSettings().setPrecipitation(this.precipitation);
//                builder.getSpecialEffects().waterColor(this.waterColor);
//                if (this.precipitation == Biome.Precipitation.SNOW)
//                    builder.getClimateSettings().setTemperature(0F);
//            }
//        }
//
//        @Override
//        public Codec<? extends BiomeModifier> codec()
//        {
//            return MODIFY_BIOMES.get();
//        }
//    }
}
