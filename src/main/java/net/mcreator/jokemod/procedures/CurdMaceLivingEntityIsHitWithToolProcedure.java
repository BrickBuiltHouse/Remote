package net.mcreator.jokemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.jokemod.JokemodMod;

public class CurdMaceLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double bonusDamage = 0;
		double deltaSpeed = 0;
		bonusDamage = 0;
		deltaSpeed = (sourceentity.getDeltaMovement()).length();
		if (deltaSpeed > 1.5) {
			bonusDamage = deltaSpeed * 2;
		}
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), (float) bonusDamage);
		JokemodMod.LOGGER.info(bonusDamage);
	}
}