package net.mcreator.jokemod.procedures;

import net.neoforged.bus.api.Event;

public class SmellingSaltPlayerFinishesUsingItemProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(JokemodModMobEffects.DELETED_MOD_ELEMENT, 60, 1));
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			itemstack.shrink(1);
		}
	}
}