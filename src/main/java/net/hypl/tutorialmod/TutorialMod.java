package net.hypl.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.hypl.tutorialmod.block.ModBlocks;
import net.hypl.tutorialmod.component.ModDataComponentTypes;
import net.hypl.tutorialmod.item.ModItemGroups;
import net.hypl.tutorialmod.item.ModItems;
import net.minecraft.block.dispenser.DispenserBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

		ModDataComponentTypes.registerDataComponentTypes();

        FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,600);
	}
}