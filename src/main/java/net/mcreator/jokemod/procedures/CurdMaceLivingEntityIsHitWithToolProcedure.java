package net.mcreator.jokemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

public class CurdMaceLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double bonusDamage = 0;
		bonusDamage = 0;
		if (sourceentity.getDeltaMovement().y() > 1.5) {
			bonusDamage = entity.getDeltaMovement().y() * 2;
		}
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) bonusDamage);
	}
}