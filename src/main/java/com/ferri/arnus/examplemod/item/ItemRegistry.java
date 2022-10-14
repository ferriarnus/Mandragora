package com.ferri.arnus.examplemod.item;

import com.ferri.arnus.examplemod.Mandragora;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLanguageProvider;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemRegistry {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registry.ITEM_REGISTRY, Mandragora.MODID);

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //public static final RegistryObject<MandragoraItem> MANDRAGORA = ITEMS.register("mandragora", () -> new MandragoraItem(Blocks.WHEAT ,new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));
}
