package net.mcreator.jokemod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class LickerItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 1000, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("jokemod:licker_repair_items")));

	public LickerItem(Item.Properties properties) {
		super(TOOL_MATERIAL, -0.8f, 16f, properties);
	}
}