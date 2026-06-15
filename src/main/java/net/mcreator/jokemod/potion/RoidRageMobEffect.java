package net.mcreator.jokemod.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.jokemod.JokemodMod;

public class RoidRageMobEffect extends MobEffect {
	public RoidRageMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13312, mobEffectInstance -> ParticleTypes.CLOUD);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.enderman.scream")));
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.roid_rage_0"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.roid_rage_1"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.roid_rage_2"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.roid_rage_3"), 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}