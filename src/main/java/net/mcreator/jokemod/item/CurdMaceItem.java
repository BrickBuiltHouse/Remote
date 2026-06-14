package net.mcreator.jokemod.item;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

import net.minecraft.world.damagesource.DamageSource;

import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import net.minecraft.world.phys.Vec3;

public class CurdMaceItem extends Item {
	private static final double SMASH_SPEED_THRESHOLD = 0.6D;

	public CurdMaceItem(Item.Properties properties) {
		super(properties.durability(250).attributes(
			ItemAttributeModifiers.builder()
				.add(
					Attributes.ATTACK_DAMAGE,
					new AttributeModifier(
						BASE_ATTACK_DAMAGE_ID,
						5.0D,
						AttributeModifier.Operation.ADD_VALUE
					),
					EquipmentSlotGroup.MAINHAND
				)
				.add(
					Attributes.ATTACK_SPEED,
					new AttributeModifier(
						BASE_ATTACK_SPEED_ID,
						-3.4D,
						AttributeModifier.Operation.ADD_VALUE
					),
					EquipmentSlotGroup.MAINHAND
				)
				.build()
		));
	}

	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		if (!(attacker.level() instanceof ServerLevel level))
			return;

		double relativeSpeed = attacker.getDeltaMovement().length();

		if (relativeSpeed > SMASH_SPEED_THRESHOLD
				&& !attacker.isFallFlying()
				&& !attacker.isInWater()
				&& !attacker.onClimbable()) {

			boolean targetOnGround = target.onGround();

			if (targetOnGround && attacker instanceof ServerPlayer player) {
				player.setSpawnExtraParticlesOnFall(true);
			}

			SoundEvent sound;

			if (!targetOnGround) {
				sound = SoundEvents.MACE_SMASH_AIR;
			} else if (relativeSpeed > 1.75D) {
				sound = SoundEvents.MACE_SMASH_GROUND_HEAVY;
			} else {
				sound = SoundEvents.MACE_SMASH_GROUND;
			}

			level.playSound(
				null,
				attacker.getX(),
				attacker.getY(),
				attacker.getZ(),
				sound,
				attacker.getSoundSource(),
				1.0F,
				1.0F
			);

			float bonusDamage = getSmashBonusDamage(relativeSpeed);

			DamageSource damageSource;

			if (attacker instanceof Player player) {
				damageSource = attacker.damageSources().playerAttack(player);
			} else {
				damageSource = attacker.damageSources().mobAttack(attacker);
			}

			target.hurt(damageSource, bonusDamage);

			target.removeAllEffects();

			if (targetOnGround) {
				doMaceKnockback(level, attacker, target, relativeSpeed);
			}
		}
	}

	private static float getSmashBonusDamage(double speed) {
		double damage;

		if (speed <= 1.5D) {
			damage = speed * 8.0D;
		} else if (speed <= 3.0D) {
			damage = 12.0D + (speed - 1.5D) * 6.0D;
		} else {
			damage = 21.0D + (speed - 3.0D) * 4.0D;
		}

		return (float) damage;
	}

	private static void doMaceKnockback(
		ServerLevel level,
		LivingEntity attacker,
		LivingEntity target,
		double relativeSpeed
	) {
		level.levelEvent(2013, target.getOnPos(), 750);

		level.getEntitiesOfClass(
			LivingEntity.class,
			target.getBoundingBox().inflate(3.5D),
			entity -> canKnockback(attacker, target, entity)
		).forEach(nearby -> {

			Vec3 direction = nearby.position().subtract(target.position());

			double power = getKnockbackPower(
				nearby,
				direction,
				relativeSpeed
			);

			if (power > 0.0D) {
				Vec3 knockback = direction.normalize().scale(power);

				nearby.push(
					knockback.x,
					0.7D + (relativeSpeed * 0.15D),
					knockback.z
				);
				
				nearby.removeAllEffects();
			}
		});
	}

	private static boolean canKnockback(
		LivingEntity attacker,
		LivingEntity target,
		LivingEntity nearby
	) {
		if (nearby.isSpectator())
			return false;

		if (nearby == attacker || nearby == target)
			return false;

		if (attacker.isAlliedTo(nearby))
			return false;

		if (nearby instanceof ArmorStand stand && stand.isMarker())
			return false;

		if (nearby instanceof Player player
				&& player.isCreative()
				&& player.getAbilities().flying)
			return false;

		if (nearby instanceof TamableAnimal animal
				&& animal.isTame()
				&& animal.isOwnedBy(attacker))
			return false;

		return target.distanceToSqr(nearby) <= 12.25D;
	}

	private static double getKnockbackPower(
		LivingEntity nearby,
		Vec3 direction,
		double relativeSpeed
	) {
		double distanceFactor = Math.max(0.0D, 3.5D - direction.length());

		return distanceFactor
				* 0.7D
				* Math.max(1.0D, relativeSpeed)
				* (1.0D - nearby.getAttributeValue(
					Attributes.KNOCKBACK_RESISTANCE
				));
	}
}