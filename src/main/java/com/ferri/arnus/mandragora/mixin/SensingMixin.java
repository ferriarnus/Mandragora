package com.ferri.arnus.mandragora.mixin;

import com.ferri.arnus.mandragora.tag.MandragoraTags;
import it.unimi.dsi.fastutil.ints.IntSet;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.sensing.Sensing;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraftforge.common.Tags;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Sensing.class)
public class SensingMixin {

    @Shadow
    @Final
    private Mob mob;
    @Shadow
    @Final
    private IntSet seen;
    @Shadow
    @Final
    private IntSet unseen;

    @Inject(at = @At("HEAD"), method = "hasLineOfSight", cancellable = true)
    public void blind(Entity pEntity, CallbackInfoReturnable<Boolean> cir) {
        if (this.mob instanceof Warden || this.mob.getType().is(Tags.EntityTypes.BOSSES) || this.mob.getType().is(MandragoraTags.EntityTypes.DARKNESSIMMUNE)) {
            return;
        }
        if (this.mob.hasEffect(MobEffects.DARKNESS)) {
            if (this.mob.distanceToSqr(pEntity) > 60) {
                if (this.seen.contains(pEntity.getId())) {
                    seen.remove(pEntity.getId());
                }
                this.unseen.add(pEntity.getId());
                cir.setReturnValue(false);
            }
        }
    }
}
