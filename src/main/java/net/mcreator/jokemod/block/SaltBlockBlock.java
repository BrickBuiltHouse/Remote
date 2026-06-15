package net.mcreator.jokemod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class SaltBlockBlock extends Block {
	public SaltBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.AMETHYST).strength(2f, 10f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}