package net.mcreator.jokemod.potion;

public class BleedMobEffect extends MobEffect {
	public BleedMobEffect() {
		super(MobEffectCategory.HARMFUL, -65536, mobEffectInstance -> ParticleTypes.DRIPPING_DRIPSTONE_LAVA);
		this.addAttributeModifier(Attributes.MAX_HEALTH, ResourceLocation.fromNamespaceAndPath(JokemodMod.MODID, "effect.bleed_0"), -1, AttributeModifier.Operation.ADD_VALUE);
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