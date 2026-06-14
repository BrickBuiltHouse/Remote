package net.mcreator.jokemod.recipe.brewing;

@EventBusSubscriber
public class SteroidRecepieBrewingRecipe implements IBrewingRecipe {

	@SubscribeEvent
	public static void init(RegisterBrewingRecipesEvent event) {
		event.getBuilder().addRecipe(new SteroidRecepieBrewingRecipe());
	}

	@Override
	public boolean isInput(ItemStack input) {
		Item inputItem = input.getItem();
		return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION) && input.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).is(Potions.HEALING);
	}

	@Override
	public boolean isIngredient(ItemStack ingredient) {
		return Ingredient.of(JokemodModItems.CURD.get()).test(ingredient);
	}

	@Override
	public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
		if (isInput(input) && isIngredient(ingredient)) {
			return new ItemStack(JokemodModItems.STEROID.get());
		}
		return ItemStack.EMPTY;
	}

}