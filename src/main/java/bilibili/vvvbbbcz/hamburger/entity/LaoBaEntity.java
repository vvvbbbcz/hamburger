package bilibili.vvvbbbcz.hamburger.entity;

import bilibili.vvvbbbcz.hamburger.item.IToiletFood;
import bilibili.vvvbbbcz.hamburger.item.Items;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;

public class LaoBaEntity extends CreatureEntity implements INPC {
    private int waitTime = 0;
    private final List<Recipe> makeList = NonNullList.create();


    protected LaoBaEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
        this.setCanPickUpLoot(true);
        makeList.add(new Recipe(Items.HAMBURGER, Items.HAMBURGER_8));
        makeList.add(new Recipe(Items.SWEETS_BEFORE_SLEEP, Items.SWEETS_BEFORE_SLEEP_8));
        makeList.add(new Recipe(Items.GRILLED_DUCK, Items.DUCK_BUTT));
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.6D));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 3.0F, 1.0F));
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62F;
    }

    @Override
    public boolean canPickUpItem(ItemStack stack) {
        if (stack.getItem() instanceof IToiletFood) {
            ItemStack offHandHeld = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);
            return offHandHeld.getCount() < 64 && offHandHeld.isItemEqual(stack);
        } else if (stack.isItemEqual(new ItemStack(Items.SHIT))) {
            ItemStack mainHandHeld = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            return mainHandHeld.getCount() < 64;
        } else {
            return false;
        }
    }

    @Override
    protected void dropInventory() {
        for (ItemStack stack : this.getHeldEquipment()) {
            if (!stack.isEmpty()) {
                this.entityDropItem(stack, this.getEyeHeight());
                this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
                this.setItemStackToSlot(EquipmentSlotType.OFFHAND, ItemStack.EMPTY);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.waitTime >= 100) { // 即5秒
            --this.waitTime;
        }

        if (this.waitTime < 0) {
            this.waitTime = 0;
            this.dropInventory();
        }
    }

    @Override
    public void livingTick() {
        super.livingTick();
        this.pickUpItem();
    }

    private void pickUpItem() {
        this.world.getProfiler().startSection("looting");
        if (!this.world.isRemote && this.canPickUpLoot() && this.isAlive() && !this.dead && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this)) {
            for(ItemEntity itemEntity : this.world.getEntitiesWithinAABB(ItemEntity.class, this.getBoundingBox().grow(1.0D, 0.0D, 1.0D))) {
                if (!itemEntity.getItem().isEmpty() && this.canPickUpItem(itemEntity.getItem())) {
                    ItemStack offHandHeld = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);
                    ItemStack mainHandHeld = this.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
                    if (itemEntity.getItem().getItem() instanceof IToiletFood) {
                        if (!offHandHeld.isEmpty()) {
                            int count = offHandHeld.getCount() + itemEntity.getItem().getCount();
                            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(offHandHeld.getItem(), count));
                        } else {
                            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, itemEntity.getItem());
                        }
                        itemEntity.remove();
                    } else if (itemEntity.getItem().isItemEqual(new ItemStack(Items.SHIT))) {
                        if (!mainHandHeld.isEmpty()) {
                            int count = mainHandHeld.getCount() + itemEntity.getItem().getCount();
                            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(mainHandHeld.getItem(), count));
                        } else {
                            this.setItemStackToSlot(EquipmentSlotType.MAINHAND, itemEntity.getItem());
                        }
                        itemEntity.remove();
                    }
                }
            }
        }
        this.world.getProfiler().endSection();
    }

    public void writeAdditional(@Nonnull CompoundNBT compound) {
        super.writeAdditional(compound);

        compound.putInt("WaitTime", this.waitTime);
    }

    public void readAdditional(@Nonnull CompoundNBT compound) {
        super.readAdditional(compound);

        if (compound.contains("WaitTime")) {
            this.waitTime = compound.getInt("WaitTime");
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

    private static class Recipe {
        private final Item input;
        private final Item output;

        public Recipe(Item input, Item output) {
            this.input = input;
            this.output = output;
        }

        public Item getInput() {
            return input;
        }

        public Item getOutput() {
            return output;
        }
    }
}