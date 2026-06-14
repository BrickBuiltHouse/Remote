package net.mcreator.jokemod.client.renderer;

public class BloodGusherRenderer extends HumanoidMobRenderer<BloodGusherEntity, HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
	private BloodGusherEntity entity = null;

	public BloodGusherRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<HumanoidRenderState>(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getEquipmentRenderer()));
	}

	@Override
	public HumanoidRenderState createRenderState() {
		return new HumanoidRenderState();
	}

	@Override
	public void extractRenderState(BloodGusherEntity entity, HumanoidRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(HumanoidRenderState state) {
		return ResourceLocation.parse("jokemod:textures/entities/bloodgusher.png");
	}

	@Override
	protected boolean isShaking(HumanoidRenderState state) {
		return true;
	}
}