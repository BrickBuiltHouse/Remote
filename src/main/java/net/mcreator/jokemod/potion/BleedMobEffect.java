package net.mcreator.jokemod.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.jokemod.procedures.BleedUsDryProcedure;
import net.mcreator.jokemod.init.JokemodModParticleTypes;
import net.mcreator.jokemod.JokemodMod;

public class BleedMobEffect extends MobEffect {
	public BleedMobEffect() {
		super(MobEffectCategory.HARMFUL, -65536, mobEffectInstance -> (SimpleParticleType) (JokemodModParticleTypes.BLEEDING_EFFECT.get()));
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.bleed_0"), -1, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
		BleedUsDryProcedure.execute(level, entity);
		return super.applyEffectTick(level, entity, amplifier);
	}
}