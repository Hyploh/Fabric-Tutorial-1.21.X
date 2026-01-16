package net.hypl.tutorialmod.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.DropperBlock;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class GardenMesh extends DropperBlock {
    public GardenMesh(Settings settings) {super(settings); }

        @Override
        protected ActionResult onUse(BlockState state, World world, BlockPos pos,
                                     PlayerEntity player, BlockHitResult hit) {

                world.playSound(
                        null,
                        pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f
                );

            return ActionResult.SUCCESS;
        }
    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.tutorialmod.garden_mesh.tooltip"));
        super.appendTooltip(stack, context, tooltip, options);
    }
}

