package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class SmellingSaltPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JokemodModMobEffects.SMELLING_SALT_EFFECT, 60,
					(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JokemodModMobEffects.SMELLING_SALT_EFFECT) ? _livEnt.getEffect(JokemodModMobEffects.SMELLING_SALT_EFFECT).getAmplifier() : 0) + 1));
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			itemstack.shrink(1);
		}
	}
}