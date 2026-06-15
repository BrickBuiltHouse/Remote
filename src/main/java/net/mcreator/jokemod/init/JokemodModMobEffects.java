/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.jokemod.procedures.SmellingSaltEffectEffectExpiresProcedure;
import net.mcreator.jokemod.procedures.RoidRageEffectExpiresProcedure;
import net.mcreator.jokemod.potion.SmellingSaltEffectMobEffect;
import net.mcreator.jokemod.potion.RoidRageMobEffect;
import net.mcreator.jokemod.potion.JumpLockMobEffect;
import net.mcreator.jokemod.potion.BleedMobEffect;
import net.mcreator.jokemod.JokemodMod;

@EventBusSubscriber
public class JokemodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, JokemodMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> JUMP_LOCK = REGISTRY.register("jump_lock", () -> new JumpLockMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> ROID_RAGE = REGISTRY.register("roid_rage", () -> new RoidRageMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> BLEED = REGISTRY.register("bleed", () -> new BleedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> SMELLING_SALT_EFFECT = REGISTRY.register("smelling_salt_effect", () -> new SmellingSaltEffectMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(ROID_RAGE)) {
			RoidRageEffectExpiresProcedure.execute(entity);
		} else if (effectInstance.getEffect().is(SMELLING_SALT_EFFECT)) {
			SmellingSaltEffectEffectExpiresProcedure.execute(entity.level(), entity);
		}
	}
}