package net.mcreator.jokemod.client.renderer;

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