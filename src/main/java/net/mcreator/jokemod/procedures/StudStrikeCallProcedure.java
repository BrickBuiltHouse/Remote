package net.mcreator.jokemod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.jokemod.init.JokemodModEntities;

public class StudStrikeCallProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity spawnedflate = null;
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = JokemodModEntities.TRIP_FLARE.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				entityToSpawn.push((entity.getLookAngle().x * 3), (entity.getLookAngle().y * 3), (entity.getLookAngle().z * 3));
			}
		}
	}
}