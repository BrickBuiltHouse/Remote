package net.mcreator.jokemod.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CurdMaceItem extends Item {

	private static final double SPEED_THRESHOLD = 1.2;
	private static final float BASE_DAMAGE = 6.0F;

	public CurdMaceItem(Item.Properties properties) {
		super(properties.stacksTo(1).durability(100));
	}

	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		double speed = attacker.getDeltaMovement().length();

		float bonusDamage = 0f;
		if (speed > SPEED_THRESHOLD) {
			bonusDamage = (float) ((speed - SPEED_THRESHOLD) * 10.0);
		}

		float trueDamage = BASE_DAMAGE + bonusDamage;

		DamageSource damageSource = (attacker instanceof Player player)
				? player.damageSources().playerAttack(player)
				: attacker.damageSources().mobAttack(attacker);

		target.hurt(damageSource, trueDamage);

		if (speed > SPEED_THRESHOLD) {
			attacker.setDeltaMovement(attacker.getDeltaMovement().scale(-0.3));
			attacker.hurtMarked = true;
		}

		attacker.removeAllEffects();

		if (attacker.level() instanceof ServerLevel serverLevel) {
			stack.hurtAndBreak(1, serverLevel, attacker, item -> {
			});
		}
	}
}