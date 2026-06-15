package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class BloodedgeBloodSliceProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3((entity.getX() + entity.getLookAngle().x * 2), (entity.getY() + 1), (entity.getZ() + entity.getLookAngle().z * 2));
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (!(entityiterator == entity)) {
					entityiterator.hurt(new DamageSource(world.holderOrThrow(DamageTypes.MOB_ATTACK), entity), 6);
					if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(JokemodModMobEffects.BLEED, (int) (20 + 5 * Math.max(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("kills", 0), 20)), 3));
				}
			}
		}
	}
}