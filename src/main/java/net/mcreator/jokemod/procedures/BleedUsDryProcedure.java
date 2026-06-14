package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class BleedUsDryProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.DRY_OUT)),
				entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JokemodModMobEffects.DELETED_MOD_ELEMENT) ? _livEnt.getEffect(JokemodModMobEffects.DELETED_MOD_ELEMENT).getAmplifier() : 0);
	}
}