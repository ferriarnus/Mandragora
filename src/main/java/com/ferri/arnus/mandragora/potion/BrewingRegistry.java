package com.ferri.arnus.mandragora.potion;

import com.ferri.arnus.mandragora.Mandragora;
import com.ferri.arnus.mandragora.block.BlockRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Mandragora.MODID)
public class BrewingRegistry {

    @SubscribeEvent
    static void addPotion(FMLCommonSetupEvent event) {
        ItemStack awkward = new ItemStack(Items.POTION);
        PotionUtils.setPotion(awkward, Potions.AWKWARD);
        ItemStack blindness = new ItemStack(Items.POTION);
        PotionUtils.setPotion(blindness, PotionRegistry.MANDRAGORA.get());
        event.enqueueWork(() ->  BrewingRecipeRegistry.addRecipe(Ingredient.of(awkward), Ingredient.of(BlockRegistry.MANDRAGORA_PLANT.get()), blindness));
    }
}
