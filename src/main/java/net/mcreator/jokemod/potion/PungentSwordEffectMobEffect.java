package net.mcreator.jokemod.potion;

public class PungentSwordEffectMobEffect extends MobEffect {
	public PungentSwordEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.pungent_sword_effect_0"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.pungent_sword_effect_1"), 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
	}
}