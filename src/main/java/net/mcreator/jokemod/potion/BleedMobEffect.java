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
import net.mcreator.jokemod.init.JokemodModMobEffects;


public class BleedMobEffect extends MobEffect {
	public BleedMobEffect() {
		super(MobEffectCategory.HARMFUL, -65536, mobEffectInstance -> (SimpleParticleType) (JokemodModParticleTypes.BLEEDING_EFFECT.get()));
		this.addAttributeModifier(Attributes.ARMOR, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.bleed_0"), -1, AttributeModifier.Operation.ADD_VALUE);
	}

	@Override
   	public boolean applyEffectTick(final ServerLevel level, final LivingEntity mob, final int amplification) {
      mob.hurtServer(level, mob.damageSources().magic(), mob instanceof LivingEntity _livEnt && _livEnt.hasEffect(JokemodModMobEffects.BLEED) ? _livEnt.getEffect(JokemodModMobEffects.BLEED).getAmplifier() * 2 : 0);

      return true;
   }

   @Override
   public boolean shouldApplyEffectTickThisTick(final int tickCount, final int amplification) {
      int interval = 20;
      return interval > 0 ? tickCount % interval == 0 : true;
   }
}