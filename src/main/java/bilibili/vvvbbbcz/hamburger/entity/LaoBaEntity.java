package bilibili.vvvbbbcz.hamburger.entity;

import bilibili.vvvbbbcz.hamburger.entity.ai.goal.StopFrontPlayerGoal;
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
    private int spellTime = 0;
    private boolean spelling = false;
    private static final int totalWaitTime = 100; // 即5秒
    private static final int totalSpellTime = 0; // TODO: 还没确定
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
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.3D));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F, 1.0F));
        this.goalSelector.addGoal(2, new StopFrontPlayerGoal(this, 80, 6.0F, 1.0F));
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62F;
    }

    @Override
    public boolean canPickUpItem(ItemStack stack) {
        if (stack.getItem() instanceof IToiletFood) {
            ItemStack offHandHeld = this.getItemStackFromSlot(EquipmentSlotType.OFFHAND);
            if (offHandHeld.isEmpty()) return true;
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
            }
        }
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
        this.setItemStackToSlot(EquipmentSlotType.OFFHAND, ItemStack.EMPTY);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.world.isRemote) {
            if (!this.isInventoryEmpty()) {
                if (this.waitTime > 0) {
                    --this.waitTime;
                }

                if (this.waitTime <= 0) {
                    this.waitTime = 0;
                    this.dropInventory();
                }
            }

//            if (this.canSpell() && !this.spelling) {
//
//            }
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

    private boolean canSpell() {
        if (!this.isInventoryEmpty()) {
            boolean flag = false;
            boolean flag1 = false;
            for (ItemStack stack : this.getHeldEquipment()) {
                if (stack.getItem() instanceof IToiletFood) flag = true;
                if (stack.isItemEqual(new ItemStack(Items.SHIT))) flag1 = true;
            }
            return flag && flag1;
        }
        return false;
    }

    private void spell() {

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
        compound.putInt("SpellTime", this.spellTime);
        compound.putBoolean("Spelling", this.spelling);
    }

    public void readAdditional(@Nonnull CompoundNBT compound) {
        super.readAdditional(compound);

        if (compound.contains("WaitTime")) {
            this.waitTime = compound.getInt("WaitTime");
        }
        if (compound.contains("Spelling")) {
            this.spelling = compound.getBoolean("Spelling");
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