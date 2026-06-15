package net.mcreator.jokemod.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.projectile.ProjectileUtil;

public class SwapperItem extends Item {
	public SwapperItem(Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack stack) {
		return ItemUseAnimation.BLOCK;
	}

	@Override
	public int getUseDuration(ItemStack stack, LivingEntity entity) {
		return 20;
	}

	@Override
	public InteractionResult use(Level level, Player player, InteractionHand hand) {
		if (!level.isClientSide()) {
			double range = 32.0D;

			Vec3 eyePos = player.getEyePosition();
			Vec3 lookVec = player.getLookAngle();
			Vec3 endPos = eyePos.add(lookVec.scale(range));

			AABB searchBox = player.getBoundingBox()
					.expandTowards(lookVec.scale(range))
					.inflate(1.0D);

			EntityHitResult hit = ProjectileUtil.getEntityHitResult(
					player,
					eyePos,
					endPos,
					searchBox,
					entity -> entity instanceof LivingEntity && entity != player,
					range * range
			);

			if (hit != null) {
				Entity entity = hit.getEntity();

				if (entity instanceof LivingEntity target) {
					Vec3 playerPos = player.position();
					Vec3 targetPos = target.position();

					float playerYaw = player.getYRot();
					float playerPitch = player.getXRot();

					float targetYaw = target.getYRot();
					float targetPitch = target.getXRot();

					player.teleportTo(targetPos.x, targetPos.y, targetPos.z);
					target.teleportTo(playerPos.x, playerPos.y, playerPos.z);

					player.setYRot(targetYaw);
					player.setXRot(targetPitch);

					target.setYRot(playerYaw);
					target.setXRot(playerPitch);

					return InteractionResult.SUCCESS;
				}
			}
		}

		return InteractionResult.PASS;
	}
}