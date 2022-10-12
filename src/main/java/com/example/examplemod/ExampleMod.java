package com.example.examplemod;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

// The value here should match an entry in the META-INF/mods.toml file
@EventBusSubscriber
@Mod(ExampleMod.MODID)
public class ExampleMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "examplemod";
    // Directly reference a slf4j logger
       
    public ExampleMod() {
        
    }

    
    @SubscribeEvent
    static void blockBreak(BlockEvent.BreakEvent event) {
    	if (event.getState().getBlock() instanceof CropBlock crop) {
    		event.getLevel().playSound(event.getPlayer(), event.getPos(), SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, 2.0F, 0.6F + event.getLevel().getRandom().nextFloat() * 0.4F);
    	}
    	
    }

}
