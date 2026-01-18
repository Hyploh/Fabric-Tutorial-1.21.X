package net.hypl.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.hypl.tutorialmod.TutorialMod;
import net.hypl.tutorialmod.block.ModBlocks;
import net.hypl.tutorialmod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE,
                        ModBlocks.PINK_GARNET_DEEPSLATE_ORE);

                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200,"pink_garnet");
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 100,"pink_garnet");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);

                createShaped(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_PINK_GARNET)
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET),conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                        .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 32)
                        .input(ModBlocks.MAGIC_BLOCK)
                        .criterion(hasItem(ModBlocks.MAGIC_BLOCK), conditionsFromItem(ModBlocks.MAGIC_BLOCK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE,Identifier.of(TutorialMod.MOD_ID,"raw_pink_garnet_from_magic_block")));

                createStairsRecipe(ModBlocks.PINK_GARNET_STAIRS, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK)).criterion(hasItem(ModItems.PINK_GARNET),
                        conditionsFromItem((ModItems.PINK_GARNET))).offerTo(exporter);
                createSlabRecipe(RecipeCategory.MISC, ModBlocks.PINK_GARNET_SLAB, Ingredient.ofItems(ModBlocks.PINK_GARNET_BLOCK)).criterion(hasItem(ModItems.PINK_GARNET),
                        conditionsFromItem((ModItems.PINK_GARNET))).offerTo(exporter);

                createDoorRecipe(ModBlocks.PINK_GARNET_DOOR, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET),
                        conditionsFromItem((ModItems.PINK_GARNET))).offerTo(exporter);
                createTrapdoorRecipe(ModBlocks.PINK_GARNET_TRAPDOOR, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET),
                        conditionsFromItem((ModItems.PINK_GARNET))).offerTo(exporter);

                createFenceRecipe(ModBlocks.PINK_GARNET_FENCE, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET),
                        conditionsFromItem((ModItems.PINK_GARNET))).offerTo(exporter);
                createFenceGateRecipe(ModBlocks.PINK_GARNET_FENCE_GATE, Ingredient.ofItems(ModItems.PINK_GARNET)).criterion(hasItem(ModItems.PINK_GARNET),
                        conditionsFromItem((ModItems.PINK_GARNET))).offerTo(exporter);

                createPressurePlateRecipe(RecipeCategory.MISC, ModBlocks.PINK_GARNET_PRESSURE_PLATE, Ingredient.ofItems(ModItems.PINK_GARNET)) // Pressure Plate
                        .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem((ModItems.PINK_GARNET))).offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModBlocks.PINK_GARNET_BUTTON, 1) // Button
                        .input(ModBlocks.PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModBlocks.PINK_GARNET_WALL) // Wall
                        .pattern("PPP")
                        .pattern("PPP")
                        .input('P', ModBlocks.PINK_GARNET_BLOCK)
                        .criterion(hasItem(ModBlocks.PINK_GARNET_BLOCK),conditionsFromItem(ModBlocks.PINK_GARNET_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.CHISEL) //Chisel
                        .pattern(" P ")
                        .pattern("PSP")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SWORD) // Sword
                        .pattern("P")
                        .pattern("P")
                        .pattern("S")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL) // Shovel
                        .pattern(" P ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE) // Axe
                        .pattern(" PP")
                        .pattern(" SP")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE) // Pickaxe
                        .pattern("PPP")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE) // Hoe
                        .pattern(" PP")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HAMMER) // Hammer
                        .pattern("PPP")
                        .pattern("PSP")
                        .pattern(" S ")
                        .input('P', ModItems.PINK_GARNET)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HELMET) // Helmet
                        .pattern("PPP")
                        .pattern("P P")
                        .input('P', ModItems.PINK_GARNET)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_CHESTPLATE) // Chestplate
                        .pattern("P P")
                        .pattern("PPP")
                        .pattern("PPP")
                        .input('P', ModItems.PINK_GARNET)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_LEGGINGS) // Leggings
                        .pattern("PPP")
                        .pattern("P P")
                        .pattern("P P")
                        .input('P', ModItems.PINK_GARNET)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.PINK_GARNET_BOOTS) // Boots
                        .pattern("P P")
                        .pattern("P P")
                        .input('P', ModItems.PINK_GARNET)
                        .criterion(hasItem(ModItems.PINK_GARNET),conditionsFromItem(ModItems.PINK_GARNET))
                        .offerTo(exporter);

                offerSmithingTrimRecipe(ModItems.HYPL_SMITHING_TEMPLATE, RegistryKey.of(RegistryKeys.RECIPE,
                        Identifier.ofVanilla(getItemPath(ModItems.HYPL_SMITHING_TEMPLATE) + "_smithing_trim")));

            }
        };

    }
    @Override
    public String getName() {
        return "TutorialMod Recipes";
    }
}
