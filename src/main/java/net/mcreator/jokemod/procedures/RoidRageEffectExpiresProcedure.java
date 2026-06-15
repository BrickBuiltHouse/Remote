package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class RoidRageEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 2));
	}
}