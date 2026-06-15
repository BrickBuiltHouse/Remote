package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class PungentSwordLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JokemodModMobEffects.PUNGENT_SWORD_EFFECT, 60,
					(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JokemodModMobEffects.PUNGENT_SWORD_EFFECT) ? _livEnt.getEffect(JokemodModMobEffects.PUNGENT_SWORD_EFFECT).getAmplifier() : 0) + 1));
	}
}