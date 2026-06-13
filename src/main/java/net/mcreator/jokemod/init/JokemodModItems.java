/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.jokemod.item.CurdMaceItem;
import net.mcreator.jokemod.JokemodMod;

import java.util.function.Function;

public class JokemodModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(JokemodMod.MODID);
	public static final DeferredItem<Item> CURD_MACE;
	static {
		CURD_MACE = register("curd_mace", CurdMaceItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}