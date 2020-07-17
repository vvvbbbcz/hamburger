package bilibili.vvvbbbcz.hamburger.gui.tileentity;

import bilibili.vvvbbbcz.largeprojectslao8.blocks.BlockIronPan;
import bilibili.vvvbbbcz.largeprojectslao8.loaders.RegisterLoader;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.util.List;

public class TileEntityIronPan extends TileEntity implements ITickable {
    private final ItemStackHandler panItemStacks = new ItemStackHandler(3);
    public static int totalBurnTime = 20;
    protected int burnTime = 0;
    private String customName;
    private final List<Recipe> burnList = NonNullList.create();

    public TileEntityIronPan() {
        burnList.add(new Recipe(RegisterLoader.itemHamburger, RegisterLoader.itemHamburger8));
        burnList.add(new Recipe(RegisterLoader.itemBeforeSleep, RegisterLoader.itemBeforeSleep8));
        burnList.add(new Recipe(RegisterLoader.itemDuckCooked, RegisterLoader.itemDuck8));
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return oldState.getBlock() != newState.getBlock();
    }

    @Override
    public void update() {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (!this.getWorld().isRemote) {
            if (this.panItemStacks.getStackInSlot(2).getCount() < 64) {
                if (this.canBurn()) {
                    flag1 = true;

                    if (this.burnTime < totalBurnTime) {
                        ++this.burnTime;
                        if (this.burnTime >= totalBurnTime) {
                            Item item = this.panItemStacks.getStackInSlot(1).getItem();
                            for (int i = 0; i < 2; i++) {
                                this.panItemStacks.getStackInSlot(i).shrink(1);
                            }

                            for (Recipe recipe : burnList) {
                                if (item.equals(recipe.getInput())) {
                                    this.panItemStacks.insertItem(2, new ItemStack(recipe.getOutput()), false);
                                }
                            }

                            this.burnTime = 0;
                        }
                    }
                }
            }

            if (flag != this.isBurning()) {
                flag1 = true;
                BlockIronPan.setState(this.isBurning(), this.world, this.pos);
            }
        }

        if (flag1) {
            this.markDirty();
        }
    }

    public boolean isBurning() {
        return this.burnTime > 0;
    }

    private boolean canBurn() {
        ItemStack itemStack = this.panItemStacks.getStackInSlot(1);

        if (!itemStack.isEmpty()) {
            for (Recipe recipe : burnList) {
                Item item = recipe.getInput();
                if (itemStack.getItem() == item) {
                    return true;
                }
            }
        }

        this.burnTime = 0;
        return false;
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.panItemStacks.deserializeNBT(compound.getCompoundTag("Inventory"));

        if (compound.hasKey("CustomName", 8)) {
            this.customName = compound.getString("CustomName");
        }
    }

    @Nonnull
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setTag("Inventory", this.panItemStacks.serializeNBT());

        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }

        return compound;
    }

    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            @SuppressWarnings("unchecked")
            T result = (T) this.panItemStacks;
            return result;
        }
        return super.getCapability(capability, facing);
    }

    public boolean isUsableByPlayer(EntityPlayer player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
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