package net.mcreator.jokemod.item;

import net.minecraft.server.level.ServerLevel;
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

        // Calculate bonus damage (scales with speed) if speed exeeds threshold.
        float bonusDamage = 0f;
        if (speed > SPEED_THRESHOLD) {
            bonusDamage = (float) ((speed - SPEED_THRESHOLD) * 10.0);
        }

        // Remove all effects.
        // (Milk effect since its made of curds :P)
        target.removeAllEffects();

        // Calculate and apply final damage. (base damage + bonus damage)
        float finalDamage = BASE_DAMAGE + bonusDamage;

        if (attacker instanceof Player player) {
            target.hurt(player.damageSources().playerAttack(player), finalDamage);
        } else {
            target.hurt(attacker.damageSources().mobAttack(attacker), finalDamage);
        }

        // Self knockback. (scales with speed)
        if (speed > SPEED_THRESHOLD) {
            attacker.setDeltaMovement(attacker.getDeltaMovement().scale(-0.3));
            attacker.hurtMarked = true;
        }

        // Durability loss on use.
        if (attacker.level() instanceof ServerLevel serverLevel) {
            stack.hurtAndBreak(1, serverLevel, attacker, item -> {});
        }
    }
}