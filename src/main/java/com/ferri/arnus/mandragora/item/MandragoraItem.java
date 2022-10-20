package com.ferri.arnus.mandragora.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class MandragoraItem extends BlockItem {

    public MandragoraItem(Block block, Properties pProperties) {
        super(block, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);
        pLevel.playSound(pPlayer, pPlayer.blockPosition(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, 2, 0.6F + pLevel.getRandom().nextFloat() *0.4F);
        pPlayer.getCooldowns().addCooldown(this, this.getUseDuration(itemstack));
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 140;
    }
}
