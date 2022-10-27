package com.ferri.arnus.mandragora.mixin;

import com.ferri.arnus.mandragora.FeedMandragora;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PanicGoal.class)
public abstract class PanicGoalMixin extends Goal {

    @Shadow @Final protected PathfinderMob mob;

    @Inject(at = @At("RETURN"), method = "shouldPanic", cancellable = true)
    public void panic(CallbackInfoReturnable<Boolean> cir) {
        if (this.mob instanceof FeedMandragora man && man.hasEaten() > 0) {
            cir.setReturnValue(true);
            man.decreaseEaten();
        }
    }
}
