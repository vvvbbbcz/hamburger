package bilibili.vvvbbbcz.hamburger.entity.ai.goal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.EntityPredicates;

import java.util.EnumSet;

public class StopFrontPlayerGoal extends Goal {
    private MobEntity entity;
    private Entity closestEntity;
    private float maxDistance;
    private int lookTime;
    private int lookTimeSet;
    private final float chance;
    private final EntityPredicate field_220716_e;

    public StopFrontPlayerGoal(MobEntity entity, int lookTimeSet, float maxDistance, float chance) {
        this.entity = entity;
        this.lookTimeSet = lookTimeSet;
        this.maxDistance = maxDistance;
        this.chance = chance;
        this.setMutexFlags(EnumSet.of(Goal.Flag.LOOK));
        this.field_220716_e = (new EntityPredicate()).setDistance(maxDistance).allowFriendlyFire().allowInvulnerable().setSkipAttackChecks().setCustomPredicate((p_220715_1_) -> EntityPredicates.notRiding(entity).test(p_220715_1_));
    }

    @Override
    public boolean shouldExecute() {
        if (this.entity.getRNG().nextFloat() >= this.chance) {
            return false;
        } else {
            if (this.entity.getAttackTarget() != null) {
                this.closestEntity = this.entity.getAttackTarget();
            }

            this.closestEntity = this.entity.world.getClosestPlayer(this.field_220716_e, this.entity, this.entity.getPosX(), this.entity.getPosYEye(), this.entity.getPosZ());

            return this.closestEntity != null;
        }
    }

    public boolean shouldContinueExecuting() {
        if (!this.closestEntity.isAlive()) {
            return false;
        } else if (this.entity.getDistanceSq(this.closestEntity) > (double)(this.maxDistance * this.maxDistance)) {
            return false;
        } else {
            return this.lookTime > 0;
        }
    }

    public void startExecuting() {
        this.lookTime = this.lookTimeSet + this.entity.getRNG().nextInt(this.lookTimeSet);
    }

    public void resetTask() {
        this.closestEntity = null;
    }

    public void tick() {
        this.entity.getLookController().setLookPosition(this.closestEntity.getPosX(), this.closestEntity.getPosYEye(), this.closestEntity.getPosZ());
        --this.lookTime;
    }
}
