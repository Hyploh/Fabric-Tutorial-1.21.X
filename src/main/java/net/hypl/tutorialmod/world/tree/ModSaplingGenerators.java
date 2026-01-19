package net.hypl.tutorialmod.world.tree;

import net.hypl.tutorialmod.TutorialMod;
import net.hypl.tutorialmod.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator DEADWOOD = new SaplingGenerator(TutorialMod.MOD_ID + "deadwood",
            Optional.empty(),Optional.of(ModConfiguredFeatures.DEADWOOD_KEY), Optional.empty());
}
