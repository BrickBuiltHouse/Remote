package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class StudSmasherLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (entity.isOnFire()) {
			entity.clearFire();
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), 3, Level.ExplosionInteraction.MOB);
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level, EntitySpawnReason.TRIGGERED);
				entityToSpawn.snapTo(Vec3.atBottomCenterOf(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		} else {
			entity.igniteForSeconds(8);
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack, 60);
		}
	}
}