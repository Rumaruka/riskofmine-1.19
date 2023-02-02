package com.rumaruka.riskofmine.common.blocks.shop;

import com.rumaruka.riskofmine.api.Chest;
import com.rumaruka.riskofmine.api.Types;
import com.rumaruka.riskofmine.common.tiles.shop.GenericShopTE;
import com.rumaruka.riskofmine.common.tiles.shop.MultiShopTE;
import com.rumaruka.riskofmine.init.ROMTiles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class MultiShopBlock extends GenericShopBlock{
    public MultiShopBlock() {
        super( Properties.of(Material.STONE).strength(5.0F, 5.0F),  ROMTiles.MULTI_SHOP,Chest.MULTI_SHOP);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new MultiShopTE(pPos,pState);
    }
}
