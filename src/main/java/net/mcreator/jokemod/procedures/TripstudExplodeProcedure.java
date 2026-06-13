package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class TripstudExplodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.BLOCK);
	}
}