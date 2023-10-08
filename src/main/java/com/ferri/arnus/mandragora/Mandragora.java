package com.ferri.arnus.mandragora;

import com.ferri.arnus.mandragora.block.BlockRegistry;
import com.ferri.arnus.mandragora.item.ItemRegistry;
import com.ferri.arnus.mandragora.network.MandragoraChannel;
import com.ferri.arnus.mandragora.network.MandragoraPacket;
import com.ferri.arnus.mandragora.potion.PotionRegistry;
import com.ferri.arnus.mandragora.tag.MandragoraTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.network.PacketDistributor;

// The value here should match an entry in the META-INF/mods.toml file
@EventBusSubscriber
@Mod(Mandragora.MODID)
public class Mandragora {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "mandragora";
    // Directly reference a slf4j logger
       
    public Mandragora() {
        ItemRegistry.register();
        BlockRegistry.register();
        PotionRegistry.register();
        MandragoraChannel.register();
        MandragoraTags.init();
    }

    @SubscribeEvent
    static void blockBreak(BlockEvent.BreakEvent event) {
    	if (event.getState().getBlock() instanceof CropBlock crop) {
            if (event.getLevel().getRandom().nextFloat() < 0.1) {
                float pitch = 0.6F + event.getLevel().getRandom().nextFloat() * 0.4F;
                event.getLevel().playSound(event.getPlayer(), event.getPos(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, 2.0F, pitch );
                boolean darkness = false;
                if (event.getLevel().getRandom().nextFloat() < 0.1) {
                    darkness = true;
                }
                MandragoraChannel.INSTANCE.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()), new MandragoraPacket(pitch, event.getPos(), darkness));
                event.getLevel().addFreshEntity(new ItemEntity(event.getPlayer().level(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), new ItemStack(BlockRegistry.MANDRAGORA_ITEM.get())));
            }
    	}
    	
    }

}
