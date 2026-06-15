package net.mcreator.jokemod.item;

public class TheBloodedgeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 1000, 6f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("jokemod:the_bloodedge_repair_items")));

	public TheBloodedgeItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 3.5f, -1.5f));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.jokemod.the_bloodedge.description_0"));
	}
}