package net.mcreator.jokemod.procedures;

import net.minecraft.world.item.ItemStack;

public class TripstudDepleteProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.shrink(1);
	}
}