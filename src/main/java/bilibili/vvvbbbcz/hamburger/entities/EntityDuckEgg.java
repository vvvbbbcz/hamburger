package bilibili.vvvbbbcz.hamburger.entities;

import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityDuckEgg extends ProjectileItemEntity {
    public EntityDuckEgg(EntityType<? extends ProjectileItemEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityDuckEgg(EntityType<? extends ProjectileItemEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public EntityDuckEgg(LivingEntity livingEntityIn, World worldIn) {
        super(null, livingEntityIn, worldIn); // TODO
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            double d0 = 0.08D;

            for (int i = 0; i < 8; ++i) {
                this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX, this.posY, this.posZ, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, ((double) this.rand.nextFloat() - 0.5D) * 0.08D, Item.getIdFromItem(RegisterLoader.itemDuckEgg));
            }
        }
    }

    protected void onImpact(RayTraceResult result) {
        if (result.entityHit != null) {
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.world.isRemote) {
            if (this.rand.nextInt(8) == 0) {
                int i = 1;

                if (this.rand.nextInt(32) == 0) {
                    i = 4;
                }

                for (int j = 0; j < i; ++j) {
                    EntityDuck entityDuck = new EntityDuck(this.world);
                    entityDuck.setGrowingAge(-24000);
                    entityDuck.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
                    this.world.spawnEntity(entityDuck);
                }
            }

            this.world.setEntityState(this, (byte) 3);
            this.setDead();
        }
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }
}
