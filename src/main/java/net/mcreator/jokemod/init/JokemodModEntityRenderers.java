/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.jokemod.client.renderer.WobblerRenderer;
import net.mcreator.jokemod.client.renderer.TripFlareRenderer;
import net.mcreator.jokemod.client.renderer.BloodGusherRenderer;

@EventBusSubscriber(Dist.CLIENT)
public class JokemodModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(JokemodModEntities.TRIPSTUD_THROWN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JokemodModEntities.TRIP_FLARE.get(), TripFlareRenderer::new);
		event.registerEntityRenderer(JokemodModEntities.STEROID_THROWN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JokemodModEntities.BLOOD_GUSHER.get(), BloodGusherRenderer::new);
		event.registerEntityRenderer(JokemodModEntities.WOBBLER.get(), WobblerRenderer::new);
	}
}