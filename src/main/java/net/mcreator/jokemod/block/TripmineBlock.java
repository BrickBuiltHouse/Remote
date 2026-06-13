package net.mcreator.jokemod.block;

import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TripmineBlock extends Block {
	public TripmineBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		TripmineEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}