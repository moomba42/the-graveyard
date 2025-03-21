package com.finallion.graveyard.init;

import com.finallion.graveyard.TheGraveyard;
import com.finallion.graveyard.client.gui.OssuaryMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class TGScreens {

    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, TheGraveyard.MOD_ID);

    public final static Supplier<MenuType<OssuaryMenu>> OSSUARY_SCREEN_HANDLER = MENUS.register("ossuary_screen_handler", () ->
            new MenuType<>(OssuaryMenu::new, FeatureFlags.VANILLA_SET)
    );
}
