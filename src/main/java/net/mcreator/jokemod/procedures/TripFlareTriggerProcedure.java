package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class TripFlareTriggerProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		JokemodMod.queueServerWork(80, () -> {
			for (int index0 = 0; index0 < 16; index0++) {
				if (world instanceof ServerLevel projectileLevel) {
					Projectile _entityToSpawn = initArrowProjectile(new TripstudThrownEntity(JokemodModEntities.DELETED_MOD_ELEMENT.get(), projectileLevel), null, 0, true, false, false, AbstractArrow.Pickup.DISALLOWED);
					_entityToSpawn.setPos((entity.getX() + Mth.nextDouble(RandomSource.create(), -10, 10)), (entity.getY() + 40), (entity.getZ() + Mth.nextDouble(RandomSource.create(), -10, 10)));
					_entityToSpawn.shoot(0, (-1), 0, 3, 0);
					projectileLevel.addFreshEntity(_entityToSpawn);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		});
	}

	private static AbstractArrow initArrowProjectile(AbstractArrow entityToSpawn, Entity shooter, float damage, boolean silent, boolean fire, boolean particles, AbstractArrow.Pickup pickup) {
		entityToSpawn.setOwner(shooter);
		entityToSpawn.setBaseDamage(damage);
		if (silent)
			entityToSpawn.setSilent(true);
		if (fire)
			entityToSpawn.igniteForSeconds(100);
		if (particles)
			entityToSpawn.setCritArrow(true);
		entityToSpawn.pickup = pickup;
		return entityToSpawn;
	}
}