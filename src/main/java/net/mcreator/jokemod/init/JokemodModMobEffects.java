/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.jokemod.potion.JumpLockMobEffect;
import net.mcreator.jokemod.JokemodMod;

public class JokemodModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, JokemodMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> JUMP_LOCK = REGISTRY.register("jump_lock", () -> new JumpLockMobEffect());
}