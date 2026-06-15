package net.mcreator.jokemod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.jokemod.entity.WobblerEntity;
import net.mcreator.jokemod.client.model.Modelwobbler;

public class WobblerRenderer extends MobRenderer<WobblerEntity, LivingEntityRenderState, Modelwobbler> {
	private WobblerEntity entity = null;

	public WobblerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelwobbler(context.bakeLayer(Modelwobbler.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(WobblerEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("jokemod:textures/entities/wobblertexture.png");
	}
}