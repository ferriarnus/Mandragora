package com.ferri.arnus.examplemod.potion;

import com.ferri.arnus.examplemod.Mandragora;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PotionRegistry {

    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(Registry.POTION_REGISTRY, Mandragora.MODID);

    public static void register() {
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Potion> MANDRAGORA = POTIONS.register("mandragora", () -> new Potion(new MobEffectInstance(MobEffects.DARKNESS, 1200)));
}
