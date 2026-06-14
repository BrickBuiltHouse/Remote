package net.mcreator.jokemod.potion;

public class RoidRageMobEffect extends MobEffect {
	public RoidRageMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13312, mobEffectInstance -> ParticleTypes.FLAME);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.enderman.scream")));
		this.addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.roid_rage_0"), 0.2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.roid_rage_1"), 0.2, AttributeModifier.Operation.ADD_VALUE);
		this.addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.roid_rage_2"), 0.2, AttributeModifier.Operation.ADD_VALUE);
	}
}