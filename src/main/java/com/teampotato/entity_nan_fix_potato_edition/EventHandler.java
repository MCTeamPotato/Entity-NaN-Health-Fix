package com.teampotato.entity_nan_fix_potato_edition;

import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber()
public class EventHandler {
    @SubscribeEvent
    public static void livingDeath(LivingDeathEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (!entity.world.isRemote && Float.isNaN(entity.getHealth())) entity.setHealth(0.0F);

    }

    @SubscribeEvent
    public static void livingUpdate(LivingEvent.LivingUpdateEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (!entity.world.isRemote && Float.isNaN(entity.getHealth())) entity.setHealth(0.0F);
    }

    @SubscribeEvent
    public static void livingHurt(LivingHurtEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if (entity.world.isRemote) return;
        if (Float.isNaN(entity.getHealth())) entity.setHealth(0.0F);
        if (Float.isNaN(event.getAmount())) event.setCanceled(true);
    }
}
