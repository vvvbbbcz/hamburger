package bilibili.vvvbbbcz.hamburger.tileentity;

import bilibili.vvvbbbcz.hamburger.block.IronPlateBlock;
import bilibili.vvvbbbcz.hamburger.inventory.container.IronPlateContainer;
import bilibili.vvvbbbcz.hamburger.item.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class IronPlateTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {
    private final ItemStackHandler plateItemStacks = new ItemStackHandler(3);
    public static int totalBurnTime = 20;
    protected int burnTime = 0;
    private String customName;
    private final List<Recipe> burnList = NonNullList.create();

    public IronPlateTileEntity() {
        super(TileEntities.IRON_PLATE.get());
        burnList.add(new Recipe(Items.HAMBURGER.get(), Items.HAMBURGER_8.get()));
        burnList.add(new Recipe(Items.SWEETS_BEFORE_SLEEP.get(), Items.SWEETS_BEFORE_SLEEP_8.get()));
        burnList.add(new Recipe(Items.GRILLED_DUCK.get(), Items.DUCK_BUTT.get()));
    }

//    @Override
//    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
//        return oldState.getBlock() != newState.getBlock();
//    }

    @Override
    public void tick() {
        boolean flag = this.isBurning();
        boolean flag1 = false;

        if (!this.getWorld().isRemote) {
            if (this.plateItemStacks.getStackInSlot(2).getCount() < 64) {
                if (this.canBurn()) {
                    flag1 = true;

                    if (this.burnTime < totalBurnTime) {
                        ++this.burnTime;
                        if (this.burnTime >= totalBurnTime) {
                            Item item = this.plateItemStacks.getStackInSlot(1).getItem();
                            for (int i = 0; i < 2; i++) {
                                this.plateItemStacks.getStackInSlot(i).shrink(1);
                            }

                            for (Recipe recipe : burnList) {
                                if (item.equals(recipe.getInput())) {
                                    this.plateItemStacks.insertItem(2, new ItemStack(recipe.getOutput()), false);
                                }
                            }

                            this.burnTime = 0;
                        }
                    }
                }
            }

            if (flag != this.isBurning()) {
                flag1 = true;
                IronPlateBlock.setState(this.isBurning(), this.world, this.pos);
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
        ItemStack itemStack = this.plateItemStacks.getStackInSlot(1);

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

    public ItemStackHandler getPlateItemStacks() {
        return plateItemStacks;
    }

    @Override
    public void read(CompoundNBT compound) {
        this.plateItemStacks.deserializeNBT(compound.getCompound("Inventory"));

        if (compound.contains("CustomName")) {
            this.customName = compound.getString("CustomName");
        }

        super.read(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("Inventory", this.plateItemStacks.serializeNBT());

        if (this.hasCustomName()) {
            compound.putString("CustomName", this.customName);
        }

        return super.write(compound);
    }

    public boolean hasCustomName() {
        return this.customName != null && !this.customName.isEmpty();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            @SuppressWarnings("unchecked")
            T result = (T) this.plateItemStacks;
            return LazyOptional.of(() -> result);
        }
        return super.getCapability(cap, side);
    }

    public boolean isUsableByPlayer(PlayerEntity player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent("iron_plate");
    }

    @Nullable
    @Override
    public Container createMenu(int id, @Nonnull PlayerInventory inventory, @Nonnull PlayerEntity player) {
        return new IronPlateContainer(id, inventory, this.getWorld(), this.getPos());
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