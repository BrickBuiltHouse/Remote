/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.jokemod.item.*;
import net.mcreator.jokemod.JokemodMod;

import java.util.function.Function;

public class JokemodModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(JokemodMod.MODID);
	public static final DeferredItem<Item> TRIPMINE;
	public static final DeferredItem<Item> TRIPSTUD;
	public static final DeferredItem<Item> STUD_SMASHER;
	public static final DeferredItem<Item> STUD_STRIKE;
	public static final DeferredItem<Item> BRICK_WALL_HELMET;
	public static final DeferredItem<Item> BRICK_WALL_CHESTPLATE;
	public static final DeferredItem<Item> BRICK_WALL_LEGGINGS;
	public static final DeferredItem<Item> BRICK_WALL_BOOTS;
	public static final DeferredItem<Item> RAKE;
	public static final DeferredItem<Item> CURD_MACE;
	public static final DeferredItem<Item> CURD;
	public static final DeferredItem<Item> CURD_BLOCK;
	public static final DeferredItem<Item> STEROID;
	public static final DeferredItem<Item> THE_KNIFE;
	public static final DeferredItem<Item> BLOOD_GUSHER_SPAWN_EGG;
	public static final DeferredItem<Item> METAL_BAT;
	public static final DeferredItem<Item> SALT;
	public static final DeferredItem<Item> SMELLING_SALT;
	public static final DeferredItem<Item> SALT_BLOCK;
	public static final DeferredItem<Item> SALT_CRYSTAL;
	public static final DeferredItem<Item> PUNGENT_SWORD;
	static {
		TRIPMINE = block(JokemodModBlocks.TRIPMINE);
		TRIPSTUD = register("tripstud", TripstudItem::new);
		STUD_SMASHER = register("stud_smasher", StudSmasherItem::new);
		STUD_STRIKE = register("stud_strike", StudStrikeItem::new);
		BRICK_WALL_HELMET = register("brick_wall_helmet", BrickWallItem.Helmet::new);
		BRICK_WALL_CHESTPLATE = register("brick_wall_chestplate", BrickWallItem.Chestplate::new);
		BRICK_WALL_LEGGINGS = register("brick_wall_leggings", BrickWallItem.Leggings::new);
		BRICK_WALL_BOOTS = register("brick_wall_boots", BrickWallItem.Boots::new);
		RAKE = register("rake", RakeItem::new);
		CURD_MACE = register("curd_mace", CurdMaceItem::new);
		CURD = register("curd", CurdItem::new);
		CURD_BLOCK = block(JokemodModBlocks.CURD_BLOCK);
		STEROID = register("steroid", SteroidItem::new);
		THE_KNIFE = register("the_knife", TheKnifeItem::new);
		BLOOD_GUSHER_SPAWN_EGG = register("blood_gusher_spawn_egg", properties -> new SpawnEggItem(JokemodModEntities.BLOOD_GUSHER.get(), properties));
		METAL_BAT = register("metal_bat", MetalBatItem::new);
		SALT = register("salt", SaltItem::new);
		SMELLING_SALT = register("smelling_salt", SmellingSaltItem::new);
		SALT_BLOCK = block(JokemodModBlocks.SALT_BLOCK);
		SALT_CRYSTAL = register("salt_crystal", SaltCrystalItem::new);
		PUNGENT_SWORD = register("pungent_sword", PungentSwordItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}