package net.hypl.tutorialmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.hypl.tutorialmod.block.ModBlocks;
import net.hypl.tutorialmod.component.ModDataComponentTypes;
import net.hypl.tutorialmod.effect.ModEffects;
import net.hypl.tutorialmod.enchantment.ModEnchantmentEffects;
import net.hypl.tutorialmod.item.ModItemGroups;
import net.hypl.tutorialmod.item.ModItems;
import net.hypl.tutorialmod.potion.ModPotions;
import net.hypl.tutorialmod.sound.ModSounds;
import net.hypl.tutorialmod.util.HammerUsageEvent;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

public class TutorialMod implements ModInitializer {
    public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModDataComponentTypes.registerDataComponentTypes();
        ModSounds.registerSounds();
        ModEffects.registerEffects();
        ModPotions.registerPotions();

        ModEnchantmentEffects.registerEnchantmentEffects();

        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.STARLIGHT_ASHES, 600);
        });

        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

        AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult)
                -> {
                if (entity instanceof SheepEntity sheepEntity && world.isClient()) {
                    if(playerEntity.getMainHandStack().getItem() == Items.END_ROD){
                        playerEntity.sendMessage(Text.literal("What are you doing to that sheep??"), false);
                        playerEntity.getMainHandStack().decrement(1);
                    }

                    return ActionResult.PASS;
                }

            return ActionResult.PASS;
        });

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMY_POTION);
        });

        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
        CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);
    }
}