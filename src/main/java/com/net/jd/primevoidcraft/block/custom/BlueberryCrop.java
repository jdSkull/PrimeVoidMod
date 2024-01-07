package com.net.jd.primevoidcraft.block.custom;

import com.net.jd.primevoidcraft.item.ModItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BlueberryCrop extends CropBlock {
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 6);
    public BlueberryCrop(Properties properties) {
        super(properties);
    }

    protected ItemLike getBaseSeedId(){
        return ModItems.BLUEBERRY_SEEDS.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge(){
        return 6;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
