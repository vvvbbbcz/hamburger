package bilibili.vvvbbbcz.hamburger.inventory.container;

import bilibili.vvvbbbcz.hamburger.item.Items;
import bilibili.vvvbbbcz.hamburger.tileentity.IronPlateTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class IronPlateContainer extends Container {
    private final IronPlateTileEntity tileEntity;
    private int burnTime;

    public IronPlateContainer(int id, PlayerInventory inventory, World world, BlockPos pos) {
        super(Containers.IRON_PLATE, id);
        this.tileEntity = (IronPlateTileEntity) world.getTileEntity(pos);
        IItemHandler handler = this.tileEntity.getPlateItemStacks();

        this.addSlot(new SlotItemHandler(handler, 0, 28, 36) {
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return stack.getItem().equals(Items.SHIT);
            }
        });

        this.addSlot(new SlotItemHandler(handler, 1, 53, 36));

        this.addSlot(new SlotItemHandler(handler, 2, 129, 36) {
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return false;
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 67 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 125));
        }
    }

//    @Override
//    public void detectAndSendChanges() { // TODO 可能不需要此方法
//        super.detectAndSendChanges();
//
//        for (IContainerListener i : this.listeners) {
//            i.sendWindowProperty(this, 0, tileEntity.getBurnTime());
//        }
//    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void updateProgressBar(int id, int data) {
        super.updateProgressBar(id, data);

        if (id == 0) {
            this.burnTime = data;
        }
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(@Nonnull PlayerEntity playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if (index >= 0 && index <= 2) {
                if (!this.mergeItemStack(itemStack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(itemStack1, itemStack);
            } else if (index >= 3 && index < 30) {
                if (!this.mergeItemStack(itemStack1, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 30 && index < 39) {
                if (!this.mergeItemStack(itemStack1, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            }

            if (itemStack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemStack1);
        }
        return itemStack;
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    public int getTotalBurnTime() {
        return IronPlateTileEntity.totalBurnTime;
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return this.tileEntity.isUsableByPlayer(playerIn);
    }
}
