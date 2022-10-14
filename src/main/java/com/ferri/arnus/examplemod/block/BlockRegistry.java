package com.ferri.arnus.examplemod.block;

import com.ferri.arnus.examplemod.Mandragora;
import com.ferri.arnus.examplemod.item.MandragoraItem;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class BlockRegistry {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registry.BLOCK_REGISTRY, Mandragora.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registry.ITEM_REGISTRY, Mandragora.MODID);

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<MandragoraPlant> MANDRAGORA_PLANT = BLOCKS.register("mandragora", () -> new MandragoraPlant(BlockBehaviour.Properties.of(Material.PLANT)));
    public static final RegistryObject<MandragoraItem> MANDRAGORA_ITEM = ITEMS.register("mandragora", () -> new MandragoraItem(MANDRAGORA_PLANT.get() ,new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));


}
