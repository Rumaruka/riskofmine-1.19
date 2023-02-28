package com.rumaruka.riskofmine.gen.smallchestgen;

import com.mojang.serialization.Codec;
import com.rumaruka.riskofmine.datagen.loot.ROMLootTables;
import com.rumaruka.riskofmine.init.ROMBlocks;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

import java.util.stream.IntStream;

public class SmallChestFeature<C>extends Feature<SmallChestFeatureConfig> {
    public SmallChestFeature(Codec<SmallChestFeatureConfig> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<SmallChestFeatureConfig> pContext) {
        RandomSource randomsource = pContext.random();
        WorldGenLevel worldgenlevel = pContext.level();
        ChunkPos chunkpos = new ChunkPos(pContext.origin());
        IntArrayList intarraylist = Util.toShuffledList(IntStream.rangeClosed(chunkpos.getMinBlockX(), chunkpos.getMaxBlockX()), randomsource);
        IntArrayList intarraylist1 = Util.toShuffledList(IntStream.rangeClosed(chunkpos.getMinBlockZ(), chunkpos.getMaxBlockZ()), randomsource);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(Integer integer : intarraylist) {
            for(Integer integer1 : intarraylist1) {
                blockpos$mutableblockpos.set(integer, 0, integer1);
                BlockPos blockpos = worldgenlevel.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, blockpos$mutableblockpos);
                if (worldgenlevel.isEmptyBlock(blockpos) || worldgenlevel.getBlockState(blockpos).getCollisionShape(worldgenlevel, blockpos).isEmpty()) {
                    worldgenlevel.setBlock(blockpos, ROMBlocks.SMALL_CHEST.defaultBlockState(), 2);
                    RandomizableContainerBlockEntity.setLootTable(worldgenlevel, randomsource, blockpos, ROMLootTables.SMALL_CHEST);
                    BlockState blockstate = Blocks.TORCH.defaultBlockState();

                    for(Direction direction : Direction.Plane.HORIZONTAL) {
                        BlockPos blockpos1 = blockpos.relative(direction);
                        if (blockstate.canSurvive(worldgenlevel, blockpos1)) {
                            worldgenlevel.setBlock(blockpos1, blockstate, 2);
                        }
                    }

                    return true;
                }
            }
        }

        return false;
    }
}
