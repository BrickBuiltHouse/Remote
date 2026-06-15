package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class SmellingSaltEffectEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 4);
	}
}