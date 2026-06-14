package net.mcreator.jokemod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CurdBlockBlock extends Block {
	public CurdBlockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GRAVEL).strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}