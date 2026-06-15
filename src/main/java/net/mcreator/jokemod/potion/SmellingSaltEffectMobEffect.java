package net.mcreator.jokemod.potion;

public class SmellingSaltEffectMobEffect extends MobEffect {
	public SmellingSaltEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.smelling_salt_effect_0"), 0.3, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}