package com.ferri.arnus.examplemod.potion;

import com.ferri.arnus.examplemod.block.BlockRegistry;
import com.ferri.arnus.examplemod.item.ItemRegistry;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber
public class BrewingRegistry {

    @SubscribeEvent
    static void addPotion(FMLCommonSetupEvent event) {
        ItemStack input = new ItemStack(Items.POTION);
        PotionUtils.setPotion(input, Potions.AWKWARD);
        ItemStack output = new ItemStack(Items.POTION);
        PotionUtils.setPotion(output, PotionRegistry.MANDRAGORA.get());
        BrewingRecipeRegistry.addRecipe(Ingredient.of(input), Ingredient.of(BlockRegistry.MANDRAGORA_ITEM.get()), output);
    }
}
