package net.mcreator.jokemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.jokemod.init.JokemodModMobEffects;

public class BleedUsDryProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DRY_OUT)), entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JokemodModMobEffects.BLEED) ? _livEnt.getEffect(JokemodModMobEffects.BLEED).getAmplifier() : 0);
	}
}