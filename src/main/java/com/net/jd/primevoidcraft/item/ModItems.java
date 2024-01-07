package com.net.jd.primevoidcraft.item;

import com.net.jd.primevoidcraft.PrimeVoidCraft;
import com.net.jd.primevoidcraft.block.ModBlocks;
import com.net.jd.primevoidcraft.item.custom.BallExplosion;
import com.net.jd.primevoidcraft.item.custom.EightBallItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PrimeVoidCraft.MOD_ID);

    public static final RegistryObject<Item> OMEGA = ITEMS.register("omega",
            () -> new Item(new Item.Properties().tab(ModCreativeTabPrime.PRIMEITEMS_TAB)));
    public static final RegistryObject<Item> OMEGASTAR = ITEMS.register("raw_omega",
            () -> new Item(new Item.Properties().tab(ModCreativeTabPrime.PRIMEITEMS_TAB)));
    public static final RegistryObject<Item> EIGTH_BALL = ITEMS.register("eight_ball",
            () -> new EightBallItem(new Item.Properties().tab(ModCreativeTabPrime.PRIMEITEMS_TAB).stacksTo(1)));
    public static final RegistryObject<Item> BALL_EXPLOSION = ITEMS.register("ball_explosion",
            () -> new BallExplosion(new Item.Properties().tab(ModCreativeTabPrime.PRIMEITEMS_TAB).stacksTo(16)));
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties()
                    .tab(ModCreativeTabPrime.PRIMEITEMS_TAB)));
    public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties().tab(ModCreativeTabPrime.PRIMEITEMS_TAB).food(
                    new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
