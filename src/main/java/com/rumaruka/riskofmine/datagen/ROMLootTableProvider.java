package com.rumaruka.riskofmine.datagen;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.blaze3d.MethodsReturnNonnullByDefault;
import com.mojang.datafixers.util.Pair;
import com.mojang.logging.LogUtils;
import com.rumaruka.riskofmine.RiskOfMine;
import com.rumaruka.riskofmine.datagen.chests.ChestLootTableROM;
import com.rumaruka.riskofmine.datagen.loot.ROMLootTables;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.slf4j.Logger;


import javax.annotation.ParametersAreNonnullByDefault;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;


@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ROMLootTableProvider extends LootTableProvider {

    private final List<SubProviderEntry> lootTables = List.of(new LootTableProvider.SubProviderEntry(ChestLootTableROM::new, LootContextParamSets.CHEST));

    public ROMLootTableProvider(PackOutput pOutputs) {
        super(pOutputs, ROMLootTables.all(),  List.of(new LootTableProvider.SubProviderEntry(ChestLootTableROM::new, LootContextParamSets.CHEST)));
    }

    @Override
    public List<SubProviderEntry> getTables() {
        return lootTables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationContext validationcontext) {
        map.forEach((resourceLocation, lootTable) -> LootTables.validate(validationcontext,resourceLocation,lootTable));
    }
}
