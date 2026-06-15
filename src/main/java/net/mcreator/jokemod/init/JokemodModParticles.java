/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.jokemod.client.particle.BleedingEffectParticle;

@EventBusSubscriber(Dist.CLIENT)
public class JokemodModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(JokemodModParticleTypes.BLEEDING_EFFECT.get(), BleedingEffectParticle::provider);
	}
}