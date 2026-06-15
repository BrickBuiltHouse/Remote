package net.mcreator.jokemod.potion;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.jokemod.JokemodMod;

public class SmellingSaltEffectMobEffect extends MobEffect {
	public SmellingSaltEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.smelling_salt_effect_0"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}