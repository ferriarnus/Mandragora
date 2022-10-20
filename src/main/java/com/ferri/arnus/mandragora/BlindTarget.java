package com.ferri.arnus.mandragora;

import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.entity.living.LivingChangeTargetEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BlindTarget {

    @SubscribeEvent
    static void blind(LivingChangeTargetEvent event) {
        if (event.getEntity().hasEffect(MobEffects.BLINDNESS)) {
            if (event.getEntity().distanceToSqr(event.getOriginalTarget()) > 9) {
                event.setNewTarget(null);
            }
        }
    }
}
