package com.net.jd.primevoidcraft.item;

import com.net.jd.primevoidcraft.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabPrime {
    public static final CreativeModeTab PRIMEITEMS_TAB = new CreativeModeTab("primeitemstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.OMEGASTAR.get());
        }
    };

    public static final CreativeModeTab PRIMEBLOCKS_TAB = new CreativeModeTab("primeblockstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BLOCK_OMEGA.get());
        }
    };
}
