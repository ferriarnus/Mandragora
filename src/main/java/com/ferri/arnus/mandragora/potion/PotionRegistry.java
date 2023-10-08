package com.ferri.arnus.mandragora.potion;

import com.ferri.arnus.mandragora.Mandragora;
import net.minecraft.core.Registry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PotionRegistry {

    private static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Mandragora.MODID);

    public static void register() {
        POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<Potion> MANDRAGORA = POTIONS.register("mandragora", () -> new Potion(new MobEffectInstance(MobEffects.DARKNESS, 1200)));
}
