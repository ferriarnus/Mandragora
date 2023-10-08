package com.ferri.arnus.mandragora.block;

import com.ferri.arnus.mandragora.Mandragora;
import com.ferri.arnus.mandragora.item.MandragoraItem;
import net.minecraft.core.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Mandragora.MODID, value = Dist.CLIENT)
public class BlockRegistry {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Mandragora.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Mandragora.MODID);

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<MandragoraPlant> MANDRAGORA_PLANT = BLOCKS.register("mandragora", () -> new MandragoraPlant(BlockBehaviour.Properties.copy(Blocks.CARROTS)));
    public static final RegistryObject<MandragoraItem> MANDRAGORA_ITEM = ITEMS.register("mandragora", () -> new MandragoraItem(MANDRAGORA_PLANT.get() ,new Item.Properties()));

    @SubscribeEvent
    public static void tab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(MANDRAGORA_ITEM);
        }
    }


}
