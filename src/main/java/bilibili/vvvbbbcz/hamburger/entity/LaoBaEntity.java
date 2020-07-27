package bilibili.vvvbbbcz.hamburger.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.INPC;
import net.minecraft.world.World;

public class LaoBaEntity extends CreatureEntity implements INPC {
    protected LaoBaEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }
}
