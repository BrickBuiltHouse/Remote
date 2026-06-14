package net.mcreator.jokemod.item;

public class CurdItem extends Item {
	public CurdItem(Item.Properties properties) {
		super(properties.stacksTo(16).food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).alwaysEdible().build()));
	}
}