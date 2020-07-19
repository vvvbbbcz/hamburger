package bilibili.vvvbbbcz.hamburger.gui.container;

import bilibili.vvvbbbcz.hamburger.loaders.GuiLoader;
import bilibili.vvvbbbcz.hamburger.loaders.RegisterLoader;
import bilibili.vvvbbbcz.hamburger.tileentity.TileEntityIronPan;
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

public class ContainerIronPan extends Container {
    private final TileEntityIronPan tileEntity;
    private int burnTime;

    public ContainerIronPan(int id, PlayerInventory inventory, World world, BlockPos pos) {
        super(GuiLoader.IRON_PAN, id);
        this.tileEntity = (TileEntityIronPan) world.getTileEntity(pos);
        IItemHandler handler = this.tileEntity.getPanItemStacks();

        this.addSlot(new SlotItemHandler(handler, 0, 28, 20) {
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return stack.getItem().equals(RegisterLoader.itemShit);
            }
        });

        this.addSlot(new SlotItemHandler(handler, 1, 53, 20));

        this.addSlot(new SlotItemHandler(handler, 2, 129, 20) {
            @Override
            public boolean isItemValid(@Nonnull ItemStack stack) {
                return false;
            }
        });

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 51 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(inventory, i, 8 + i * 18, 109));
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

        switch (id) {
            case 0:
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
        return TileEntityIronPan.totalBurnTime;
    }

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return this.tileEntity.isUsableByPlayer(playerIn);
    }
}
