package com.finallion.graveyard;

import com.finallion.graveyard.config.GraveyardConfig;
import com.finallion.graveyard.init.*;
import com.finallion.graveyard.item.VialOfBlood;
import com.finallion.graveyard.recipe.TGRecipeTypes;
import com.finallion.graveyard.util.SpawnRules;
import com.finallion.graveyard.util.TGTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;


@Mod("graveyard")
public class TheGraveyard {
    public static final String MOD_ID = "graveyard";

    public TheGraveyard(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::setup);

        TGCreativeModeTabs.CREATIVE_MODE_TAB.register(modEventBus);
        TGBlocks.BLOCKS.register(modEventBus);
        TGItems.ITEMS.register(modEventBus);
        TGSounds.SOUNDS.register(modEventBus);
        TGEntities.ENTITIES.register(modEventBus);
        TGConfiguredStructureFeatures.STRUCTURES.register(modEventBus);
        TGScreens.MENUS.register(modEventBus);
        TGRecipeTypes.RECIPE_TYPES.register(modEventBus);
        TGRecipeTypes.RECIPE_SERIALIZERS.register(modEventBus);
        TGTileEntities.TILE_ENTITIES.register(modEventBus);
        TGParticles.PARTICLES.register(modEventBus);

        modEventBus.addListener(this::setupClient);

        final DeferredRegister<MapCodec<? extends BiomeModifier>> serializers = DeferredRegister.create(NeoForgeRegistries.BIOME_MODIFIER_SERIALIZERS, MOD_ID);
        serializers.register(modEventBus);
        serializers.register("mobspawns", SpawnRules.ModSpawnModifier::makeCodec);

        modContainer.registerConfig(ModConfig.Type.COMMON, GraveyardConfig.COMMON_SPEC, MOD_ID + "-1.19.x-common.toml");
        modEventBus.register(GraveyardConfig.class);
    }

    public void setupClient(final FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            /* CHANGING ITEM TEXTURE */
            // TODO Fix resource locations
            ItemProperties.register(TGItems.VIAL_OF_BLOOD.get(), ResourceLocation.withDefaultNamespace("charged"), (stack, world, entity, seed) -> {
                if (entity != null && stack.is(TGItems.VIAL_OF_BLOOD.get())) {
                    return VialOfBlood.getBlood(stack);
                }
                return 0.0F;
            });

        });
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            TGAdvancements.init();
            TGTags.init();
            TGStructureType.init();
            TGProcessors.registerProcessors();
        });
    }
}
