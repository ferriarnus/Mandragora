package com.ferri.arnus.mandragora.tag;

import com.ferri.arnus.mandragora.Mandragora;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class MandragoraTags {

    public static void init() {
        EntityTypes.init();
    }

    public static class EntityTypes {

        private static void init() {}

        public static final TagKey<EntityType<?>> DARKNESSIMMUNE = tag("darknessimmune");

        private static TagKey<EntityType<?>> tag(String name)
        {
            return TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(Mandragora.MODID, name));
        }
    }
}
