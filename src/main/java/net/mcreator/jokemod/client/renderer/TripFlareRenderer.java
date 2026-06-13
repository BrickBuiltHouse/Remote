package net.mcreator.jokemod.client.renderer;

public class TripFlareRenderer extends MobRenderer<TripFlareEntity, LivingEntityRenderState, SlimeModel> {
	private TripFlareEntity entity = null;

	public TripFlareRenderer(EntityRendererProvider.Context context) {
		super(context, new SlimeModel(context.bakeLayer(ModelLayers.SLIME)), 0f);
	}

	@Override
	public LivingEntityRenderState createRenderState() {
		return new LivingEntityRenderState();
	}

	@Override
	public void extractRenderState(TripFlareEntity entity, LivingEntityRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(LivingEntityRenderState state) {
		return ResourceLocation.parse("jokemod:textures/entities/placeholder.png");
	}
}