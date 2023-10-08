package com.ferri.arnus.mandragora.mixin;

import com.ferri.arnus.mandragora.block.BlockRegistry;
import com.ferri.arnus.mandragora.item.ItemRegistry;
import com.ferri.arnus.mandragora.network.MandragoraChannel;
import com.ferri.arnus.mandragora.network.MandragoraPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.PacketDistributor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    @Shadow
    public abstract ItemStack getItem();

    public ItemEntityMixin(EntityType<?> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void scream(CallbackInfo ci) {
        if (this.getItem().is(BlockRegistry.MANDRAGORA_ITEM.get()) && this.level().getGameTime() % 20 == 0 && !this.level().isClientSide) {
            MandragoraChannel.INSTANCE.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> this), new MandragoraPacket(0.6F + this.level().getRandom().nextFloat() * 0.4F, this.blockPosition(), false));
        }
    }
}
