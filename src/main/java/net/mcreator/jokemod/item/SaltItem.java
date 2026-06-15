package net.mcreator.jokemod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.jokemod.procedures.SmellingSaltPlayerFinishesUsingItemProcedure;

public class SaltItem extends Item {
	public SaltItem(Item.Properties properties) {
		super(properties.stacksTo(16));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		SmellingSaltPlayerFinishesUsingItemProcedure.execute(entity, itemstack);
		return retval;
	}
}