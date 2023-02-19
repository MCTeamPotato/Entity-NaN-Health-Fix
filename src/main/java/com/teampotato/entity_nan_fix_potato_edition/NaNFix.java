package com.teampotato.entity_nan_fix_potato_edition;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("entity_nan_fix_potato_edition")
public class NaNFix {
    public NaNFix() {
        MinecraftForge.EVENT_BUS.register(this);
    }
}
