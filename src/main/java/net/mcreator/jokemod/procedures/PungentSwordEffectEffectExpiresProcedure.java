package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class PungentSwordEffectEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)),
				4 + (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JokemodModMobEffects.PUNGENT_SWORD_EFFECT) ? _livEnt.getEffect(JokemodModMobEffects.PUNGENT_SWORD_EFFECT).getAmplifier() : 0) * 2);
	}
}