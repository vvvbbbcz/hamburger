package bilibili.vvvbbbcz.hamburger.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.world.World;

public class LaoBaEntity extends CreatureEntity implements INPC {
    private final Inventory inventory = new Inventory(2);

    protected LaoBaEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.62F;
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);

        ListNBT listnbt = new ListNBT();

        for(int i = 0; i < this.inventory.getSizeInventory(); ++i) {
            ItemStack itemstack = this.inventory.getStackInSlot(i);
            if (!itemstack.isEmpty()) {
                listnbt.add(itemstack.write(new CompoundNBT()));
            }
        }

        compound.put("Inventory", listnbt);
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);

        ListNBT listnbt = compound.getList("Inventory", 10);

        for(int i = 0; i < listnbt.size(); ++i) {
            ItemStack itemstack = ItemStack.read(listnbt.getCompound(i));
            if (!itemstack.isEmpty()) {
                this.inventory.addItem(itemstack);
            }
        }
    }

    @Override
    public boolean canBeLeashedTo(PlayerEntity player) {
        return false;
    }
}
