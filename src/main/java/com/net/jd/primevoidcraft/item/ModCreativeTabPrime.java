package com.net.jd.primevoidcraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabPrime {
    public static final CreativeModeTab PRIMEITEMS_TAB = new CreativeModeTab("primeitemstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.OMEGASTAR.get());
        }
    };
}
