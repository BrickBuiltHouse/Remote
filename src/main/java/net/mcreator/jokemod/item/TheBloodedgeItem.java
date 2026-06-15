package net.mcreator.jokemod.item;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.jokemod.procedures.BloodedgeBloodSliceProcedure;

import java.util.function.Consumer;

public class TheBloodedgeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 6f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("jokemod:the_bloodedge_repair_items")));

	public TheBloodedgeItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 3.5f, -1.5f));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.jokemod.the_bloodedge.description_0"));
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity, InteractionHand hand) {
		boolean retval = super.onEntitySwing(itemstack, entity, hand);
		BloodedgeBloodSliceProcedure.execute(entity.level(), entity, itemstack);
		return retval;
	}
}