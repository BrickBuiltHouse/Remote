// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelwobbler<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "wobbler"), "main");
	private final ModelPart FrontWheels;
	private final ModelPart BackWheels;
	private final ModelPart Wobbler;
	private final ModelPart bb_main;

	public Modelwobbler(ModelPart root) {
		this.FrontWheels = root.getChild("FrontWheels");
		this.BackWheels = root.getChild("BackWheels");
		this.Wobbler = root.getChild("Wobbler");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition FrontWheels = partdefinition.addOrReplaceChild("FrontWheels",
				CubeListBuilder.create().texOffs(28, 10).mirror()
						.addBox(3.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(28, 10).addBox(-5.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.5F, -2.0F));

		PartDefinition BackWheels = partdefinition.addOrReplaceChild("BackWheels",
				CubeListBuilder.create().texOffs(28, 10).mirror()
						.addBox(3.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(28, 10).addBox(-5.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 22.5F, 2.0F));

		PartDefinition Wobbler = partdefinition.addOrReplaceChild("Wobbler", CubeListBuilder.create().texOffs(0, 10)
				.addBox(-5.0F, -10.0F, 0.0F, 10.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 7.0F, -2.1F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-4.0F, -4.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(20, 10)
						.addBox(-1.0F, -18.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 16)
						.addBox(-1.0F, -18.0F, -2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		FrontWheels.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackWheels.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Wobbler.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.BackWheels.xRot = ageInTicks;
		this.Wobbler.zRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.FrontWheels.xRot = ageInTicks;
	}
}