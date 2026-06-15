/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.jokemod.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.jokemod.block.TripmineBlock;
import net.mcreator.jokemod.block.SaltBlockBlock;
import net.mcreator.jokemod.block.CurdBlockBlock;
import net.mcreator.jokemod.JokemodMod;

import java.util.function.Function;

public class JokemodModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(JokemodMod.MODID);
	public static final DeferredBlock<Block> TRIPMINE;
	public static final DeferredBlock<Block> CURD_BLOCK;
	public static final DeferredBlock<Block> SALT_BLOCK;
	static {
		TRIPMINE = register("tripmine", TripmineBlock::new);
		CURD_BLOCK = register("curd_block", CurdBlockBlock::new);
		SALT_BLOCK = register("salt_block", SaltBlockBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier);
	}
}