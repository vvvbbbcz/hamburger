package bilibili.vvvbbbcz.hamburger.entity;

import bilibili.vvvbbbcz.hamburger.entity.ai.goal.StopFrontPlayerGoal;
import bilibili.vvvbbbcz.hamburger.item.IToiletFood;
import bilibili.vvvbbbcz.hamburger.item.Items;
import bilibili.vvvbbbcz.hamburger.util.SoundEvents;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LaoBaEntity extends CreatureEntity implements INPC {
    private static final DataParameter<Boolean> SPELLING = EntityDataManager.createKey(LaoBaEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> COOLING = EntityDataManager.createKey(LaoBaEntity.class, DataSerializers.BOOLEAN);
    private int waitTime = 0;
    private int coolingDelay = 0;
    private int spellTime = 0;
    private static final int totalWaitTime = 100; // 即5秒
    private static final int totalCoolingDelay = 1200; // 60 Seconds
    private static final int totalSpellTime = 233; // TODO: 还没确定

    protected LaoBaEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(SPELLING, false);
        this.dataManager.register(COOLING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.3D));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F, 1.0F));
        this.goalSelector.addGoal(2, new StopFrontPlayerGoal(this, 6.0F, 1.0F));
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62F;
    }

    @Override
    public boolean canPickUpItem(ItemStack stack) {
        if (!this.isCooling()) {
            if (stack.getItem() instanceof IToiletFood) {
                ItemStack offHandHeld = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);
                if (offHandHeld.isEmpty()) return true;
                return offHandHeld.getCount() < 64 && offHandHeld.isItemEqual(stack);
            } else if (stack.isItemEqual(new ItemStack(Items.SHIT))) {
                ItemStack mainHandHeld = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
                return mainHandHeld.getCount() < 64;
            }
        }
        return false;
    }

    @Override
    protected void dropInventory() {
        for (ItemStack stack : this.getHeldEquipment()) {
            if (!stack.isEmpty()) {
                this.entityDropItem(stack, this.getEyeHeight());
            }
        }
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
        this.setItemStackToSlot(EquipmentSlotType.OFFHAND, ItemStack.EMPTY);
    }

    private void dropEndProduct() {
        Item endProduct = null;
        if (this.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem() instanceof IToiletFood) {
            endProduct = ((IToiletFood) this.getItemStackFromSlot(EquipmentSlotType.OFFHAND).getItem()).getFinalFood();
        }
        for (ItemStack stack : this.getHeldEquipment()) {
            stack.shrink(1);
        }
        if (endProduct != null) {
            this.entityDropItem(new ItemStack(endProduct), this.getEyeHeight() + 1);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            if (!this.isInventoryEmpty()) {
                if (!this.isSpelling()) {
                    if (this.waitTime > 0) {
                        --this.waitTime;
                    }

                    if (this.waitTime <= 0) {
                        this.waitTime = 0;
                        this.dropInventory();
                    }
                }
            }

            if (this.canSpell() && !this.isSpelling()) {
                this.startSpell();
            }

            if (this.isSpelling()) {
                --this.spellTime;
                if (this.spellTime <= 0) {
                    this.endSpell();
                }
            }

            if (this.isCooling()) {
                --this.coolingDelay;
                if (this.coolingDelay <= 0) {
                    this.dataManager.set(COOLING, false);
                }
            }
        }

        if (this.world.isRemote) {
            if (this.isSpelling()) {
                double d0 = 0.4D;
                double d1 = 0.3D;
                double d2 = 0.35D;
                float f = this.renderYawOffset * ((float)Math.PI / 180F) + MathHelper.cos((float)this.ticksExisted * 0.6662F) * 0.25F;
                float f1 = MathHelper.cos(f);
                float f2 = MathHelper.sin(f);
                this.world.addParticle(ParticleTypes.ENTITY_EFFECT, this.getPosX() + (double)f1 * 0.6D, this.getPosY() + 1.8D, this.getPosZ() + (double)f2 * 0.6D, d0, d1, d2);
                this.world.addParticle(ParticleTypes.ENTITY_EFFECT, this.getPosX() - (double)f1 * 0.6D, this.getPosY() + 1.8D, this.getPosZ() - (double)f2 * 0.6D, d0, d1, d2);
            }
            if (this.isCooling()) {
                double d0 = 0.7D;
                double d1 = 0.7D;
                double d2 = 0.8D;
                float f = this.renderYawOffset * ((float)Math.PI / 180F) + MathHelper.cos((float)this.ticksExisted * 0.6662F) * 0.25F;
                float f1 = MathHelper.cos(f);
                float f2 = MathHelper.sin(f);
                this.world.addParticle(ParticleTypes.ENTITY_EFFECT, this.getPosX() + (double)f1 * 0.6D, this.getPosY() + 1.8D, this.getPosZ() + (double)f2 * 0.6D, d0, d1, d2);
                this.world.addParticle(ParticleTypes.ENTITY_EFFECT, this.getPosX() - (double)f1 * 0.6D, this.getPosY() + 1.8D, this.getPosZ() - (double)f2 * 0.6D, d0, d1, d2);
            }
        }
    }

    private boolean isInventoryEmpty() {
        boolean flag = false;
        boolean flag1 = false;
        for (ItemStack stack : this.getHeldEquipment()) {
            if (stack.isEmpty()) {
                if (stack.getItem() instanceof IToiletFood) flag = true;
                if (stack.isItemEqual(new ItemStack(Items.SHIT))) flag1 = true;
            }
        }
        return flag && flag1;
    }

    private void startSpell() {
        this.spellTime = totalSpellTime;
        this.dataManager.set(SPELLING, true);
        this.getNavigator().clearPath();
    }

    private void endSpell() {
        this.dropEndProduct();
        this.dropInventory();
        this.coolingDelay = totalCoolingDelay;
        this.dataManager.set(COOLING, true);
        this.dataManager.set(SPELLING, false);
    }

    public boolean isSpelling() {
        if (this.world.isRemote) {
            return this.dataManager.get(SPELLING);
        } else {
            return this.spellTime > 0;
        }
    }

    private boolean canSpell() {
        if (!this.isCooling()) {
            if (!this.isInventoryEmpty()) {
                boolean flag = false;
                boolean flag1 = false;
                for (ItemStack stack : this.getHeldEquipment()) {
                    if (stack.getItem() instanceof IToiletFood) flag = true;
                    if (stack.isItemEqual(new ItemStack(Items.SHIT))) flag1 = true;
                }
                return flag && flag1;
            }
        }
        return false;
    }

    private boolean isCooling() {
        if (this.world.isRemote) {
            return this.dataManager.get(COOLING);
        } else {
            return this.coolingDelay > 0;
        }
    }

    @Override
    protected void updateEquipmentIfNeeded(ItemEntity itemEntity) {
        if (this.canPickUpItem(itemEntity.getItem())) {
            ItemStack offHandHeld = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);
            ItemStack mainHandHeld = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (itemEntity.getItem().getItem() instanceof IToiletFood) {
                if (!offHandHeld.isEmpty()) {
                    int count = offHandHeld.getCount() + itemEntity.getItem().getCount();
                    this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(offHandHeld.getItem(), count));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.OFFHAND, itemEntity.getItem());
                }
                this.waitTime = totalWaitTime;
                itemEntity.remove();
            } else if (itemEntity.getItem().isItemEqual(new ItemStack(Items.SHIT))) {
                if (!mainHandHeld.isEmpty()) {
                    int count = mainHandHeld.getCount() + itemEntity.getItem().getCount();
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(mainHandHeld.getItem(), count));
                } else {
                    this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemEntity.getItem());
                }
                this.waitTime = totalWaitTime;
                itemEntity.remove();
            }
        }
    }

    public void writeAdditional(@Nonnull CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putInt("WaitTime", this.waitTime);
        compound.putInt("CoolingDelay", this.coolingDelay);
        compound.putInt("SpellTime", this.spellTime);
    }

    public void readAdditional(@Nonnull CompoundNBT compound) {
        super.readAdditional(compound);

        if (compound.contains("WaitTime")) {
            this.waitTime = compound.getInt("WaitTime");
        }
        if (compound.contains("CoolingDelay")) {
            this.coolingDelay = compound.getInt("CoolingDelay");
        }
        if (compound.contains("SpellTime")) {
            this.spellTime = compound.getInt("SpellTime");
        }
    }

    @Override
    public void onDeath(DamageSource cause) {
        this.dropInventory();
        super.onDeath(cause);
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_LAO_BA_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_LAO_BA_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_LAO_BA_DEATH;
    }
}