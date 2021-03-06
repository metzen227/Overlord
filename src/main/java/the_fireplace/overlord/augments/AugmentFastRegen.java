package the_fireplace.overlord.augments;

import net.minecraft.entity.Entity;
import the_fireplace.overlord.entity.EntityArmyMember;
import the_fireplace.overlord.tools.Augment;

import javax.annotation.Nonnull;

/**
 * @author The_Fireplace
 */
public class AugmentFastRegen extends Augment {
	@Override
	public void onStrike(@Nonnull EntityArmyMember attacker, @Nonnull Entity entityAttacked) {

	}

	@Nonnull
	@Override
	public String augmentId() {
		return "fast_regen";
	}

	@Override
	public void onEntityTick(@Nonnull EntityArmyMember entity) {
		if (entity.getHealth() < entity.getMaxHealth() && entity.ticksExisted % 100 == 0) {
			entity.heal(1.0F);
		}
	}
}
