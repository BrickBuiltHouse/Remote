package net.mcreator.jokemod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class RakeRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 4), ((entity.getLookAngle().y + 0.3) * 3), (entity.getLookAngle().z * 4)));
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack, 100);
	}
}