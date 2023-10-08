package com.ferri.arnus.mandragora.item;

import com.ferri.arnus.mandragora.Mandragora;
import net.minecraft.core.Registry;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mandragora.MODID);

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    //public static final RegistryObject<MandragoraItem> MANDRAGORA = ITEMS.register("mandragora", () -> new MandragoraItem(Blocks.WHEAT ,new Item.Properties().tab(CreativeModeTab.TAB_BREWING)));
}
