package net.hypl.tutorialmod.potion;

import net.hypl.tutorialmod.TutorialMod;
import net.hypl.tutorialmod.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> SLIMY_POTION = registerPotion("slimy_potion",
            new Potion("slimy_potion", new StatusEffectInstance(ModEffects.SLIMY, 1200, 0)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(TutorialMod.MOD_ID, name), potion);
}

    public static void registerPotions() {
        TutorialMod.LOGGER.info("Registering Mod Potions for " + TutorialMod.MOD_ID);
    }
}
