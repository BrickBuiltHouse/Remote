package net.mcreator.jokemod.item;

public class SurpriseJuiceItem extends Item {
	public SurpriseJuiceItem(Item.Properties properties) {
		super(properties.stacksTo(8).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible().build(), Consumables.defaultDrink().consumeSeconds(0.5F).build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.jokemod.surprise_juice.description_0"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		SurpriseJuiceDrankProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return retval;
	}
}