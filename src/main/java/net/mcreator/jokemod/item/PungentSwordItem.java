package net.mcreator.jokemod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.jokemod.procedures.PungentSwordLivingEntityIsHitWithToolProcedure;

public class PungentSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 100, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("jokemod:pungent_sword_repair_items")));

	public PungentSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 3f, -3f));
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		super.hurtEnemy(itemstack, entity, sourceentity);
		PungentSwordLivingEntityIsHitWithToolProcedure.execute(entity);
	}
}