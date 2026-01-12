package net.hypl.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.hypl.tutorialmod.block.ModBlocks;
import net.hypl.tutorialmod.item.ModItemGroups;
import net.hypl.tutorialmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Very Important Comment
public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
	}
}