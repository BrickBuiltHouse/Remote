package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class TripFlareParticlesProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (entity.getX()), (entity.getY()), (entity.getZ()), 0, 1, 0);
	}
}