package com.net.jd.primevoidcraft.block;

import com.net.jd.primevoidcraft.PrimeVoidCraft;
import com.net.jd.primevoidcraft.block.custom.BlueberryCrop;
import com.net.jd.primevoidcraft.block.custom.JumpyBlock;
import com.net.jd.primevoidcraft.block.custom.LampBlock;
import com.net.jd.primevoidcraft.item.ModCreativeTabPrime;
import com.net.jd.primevoidcraft.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, PrimeVoidCraft.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OMEGA = registerBlock("block_omega",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f)
                    .requiresCorrectToolForDrops()),
                    ModCreativeTabPrime.PRIMEBLOCKS_TAB);

    public static final RegistryObject<Block> OMEGA_ORE = registerBlock("omega_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3,7)),
                    ModCreativeTabPrime.PRIMEBLOCKS_TAB);
    public static final RegistryObject<Block> DEEPSLATE_OMEGA_ORE = registerBlock("deepslate_omega_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f)
                    .requiresCorrectToolForDrops(),UniformInt.of(3,7)),
                    ModCreativeTabPrime.PRIMEBLOCKS_TAB);
    public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
            () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f)
                    .requiresCorrectToolForDrops()), ModCreativeTabPrime.PRIMEBLOCKS_TAB);
    public static final RegistryObject<Block> LAMP_BLOCK = registerBlock("lamp_block",
            () -> new LampBlock(BlockBehaviour.Properties.of(Material.DECORATION).strength(6f)
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(LampBlock.LIT) ? 15 : 0)),
            ModCreativeTabPrime.PRIMEBLOCKS_TAB);
    public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
            () -> new BlueberryCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
