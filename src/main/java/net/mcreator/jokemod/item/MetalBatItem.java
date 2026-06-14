package net.mcreator.jokemod.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.Vec3;

public class MetalBatItem extends Item {
	public MetalBatItem(Item.Properties properties) {
		super(properties.durability(100).attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
				.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()).enchantable(2));
	}

	

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
	
	    Vec3 hitDir = entity.position().subtract(sourceentity.position());
	    double dist = hitDir.length();
	
	    if (dist == 0) return;
	
	    hitDir = hitDir.scale(1.0 / dist); // normalize
	
	    Vec3 relativeVel = entity.getDeltaMovement()
	        .subtract(sourceentity.getDeltaMovement());
	
	    double impactSpeed = relativeVel.dot(hitDir);
	
	    boolean isIncoming = impactSpeed > 0.1;
	
	    double knockback = isIncoming ? 2.5D : 1.5D;
	    double vertical = isIncoming ? 0.9D : 0.7D;
	
	    entity.setDeltaMovement(
	        hitDir.x * knockback,
	        vertical,
	        hitDir.z * knockback
	    );
	
	    entity.hurtMarked = true;
	
	    itemstack.hurtAndBreak(1, entity,
	        LivingEntity.getSlotForHand(entity.getUsedItemHand())
	    );
	}
}