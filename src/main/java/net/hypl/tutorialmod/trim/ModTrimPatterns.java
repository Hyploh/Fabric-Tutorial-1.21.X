package net.hypl.tutorialmod.trim;

import net.hypl.tutorialmod.TutorialMod;
import net.hypl.tutorialmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> HYPL = RegistryKey.of(RegistryKeys.TRIM_PATTERN,
            Identifier.of(TutorialMod.MOD_ID, "hypl"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context) {
        register(context, ModItems.HYPL_SMITHING_TEMPLATE, HYPL);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }
}