package net.mcreator.jokemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.jokemod.init.JokemodModMobEffects;

public class SmellingSaltEffectEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)),
				4 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JokemodModMobEffects.SMELLING_SALT_EFFECT) ? _livEnt.getEffect(JokemodModMobEffects.SMELLING_SALT_EFFECT).getAmplifier() : 0) * 2);
	}
}