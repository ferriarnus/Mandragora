package com.ferri.arnus.mandragora.mixin;

import com.ferri.arnus.mandragora.FeedMandragora;
import com.ferri.arnus.mandragora.block.BlockRegistry;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Animal.class)
public abstract class AnimalMixin extends AgeableMob implements FeedMandragora {

    @Shadow
    protected abstract void usePlayerItem(Player pPlayer, InteractionHand pHand, ItemStack pStack);

    @Unique
    private int mandragora = 0;

    protected AnimalMixin(EntityType<? extends AgeableMob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(at = @At("HEAD"), method = "mobInteract", cancellable = true)
    public void feedMandragora(Player pPlayer, InteractionHand pHand, CallbackInfoReturnable<InteractionResult> cir) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (itemstack.is(BlockRegistry.MANDRAGORA_ITEM.get())) {
            if (this.level.isClientSide) {
                cir.setReturnValue(InteractionResult.CONSUME);
                return;
            }
            this.mandragora = 1 + pPlayer.level.getRandom().nextInt(4);
            this.playHurtSound(DamageSource.playerAttack(pPlayer));
            this.usePlayerItem(pPlayer, pHand, itemstack);
            cir.setReturnValue(InteractionResult.SUCCESS);

        }
    }

    @Override
    public int hasEaten() {
        return this.mandragora;
    }

    @Override
    public void decreaseEaten() {
        this.mandragora --;
    }
}
