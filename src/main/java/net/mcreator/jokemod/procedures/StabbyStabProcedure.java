package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class StabbyStabProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JokemodModMobEffects.DELETED_MOD_ELEMENT, 120, 4));
	}
}