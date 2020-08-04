package bilibili.vvvbbbcz.hamburger.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.ForgeEventFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ShitItem extends Item {
    private static final Food FOOD = (new Food.Builder())
            .hunger(2)
            .saturation(4.0F)
            .effect(() -> new EffectInstance(bilibili.vvvbbbcz.hamburger.potion.Effects.SHIT, 2400, 0), 1.0F)
            .effect(() -> new EffectInstance(Effects.NAUSEA, 2400, 0), 1.0F)
            .build();

    public ShitItem() {
        super(new Properties().food(FOOD).group(ItemGroups.HAMBURGER));
    }

    @Nonnull
    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getPos();
        BlockPos blockPos1 = blockPos.offset(context.getFace());
        if (makeBlockFertile(world, blockPos)) {
            return ActionResultType.SUCCESS;

        } else if (applyBoneMeal(context.getItem(), world, blockPos, context.getPlayer())) {
            if (!world.isRemote) {
                world.playEvent(2005, blockPos, 0);
            }
            return ActionResultType.SUCCESS;

        } else {
            BlockState blockstate = world.getBlockState(blockPos);
            boolean flag = blockstate.isSolidSide(world, blockPos, context.getFace());
            if (flag && growSeaGrass(context.getItem(), world, blockPos1, context.getFace())) {
                if (!world.isRemote) {
                    world.playEvent(2005, blockPos1, 0);
                }

                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.PASS;
            }
        }
    }

    public static boolean makeBlockFertile(World world, BlockPos blockPos) {
        if (world.getBlockState(blockPos).getBlock() == Blocks.GRASS_BLOCK) {
            if (world instanceof ServerWorld) {
                world.setBlockState(blockPos, bilibili.vvvbbbcz.hamburger.block.Blocks.FERTILE_GRASS_BLOCK.getDefaultState());
            }
            return true;
        } else if (world.getBlockState(blockPos).getBlock() == Blocks.DIRT) {
            if (world instanceof ServerWorld) {
                world.setBlockState(blockPos, bilibili.vvvbbbcz.hamburger.block.Blocks.FERTILE_DIRT.getDefaultState());
                return true;
            }
        } else if (world.getBlockState(blockPos).getBlock() == Blocks.FARMLAND) {
            if (world instanceof ServerWorld) {
                world.setBlockState(blockPos, bilibili.vvvbbbcz.hamburger.block.Blocks.FERTILE_FARMLAND.getDefaultState());
                return true;
            }
        }
        return false;
    }

    public static boolean applyBoneMeal(ItemStack stack, World worldIn, BlockPos pos, net.minecraft.entity.player.PlayerEntity player) {
        BlockState blockstate = worldIn.getBlockState(pos);
        int hook = ForgeEventFactory.onApplyBonemeal(player, worldIn, pos, blockstate, stack);
        if (hook != 0) return hook > 0;
        if (blockstate.getBlock() instanceof IGrowable) {
            IGrowable igrowable = (IGrowable) blockstate.getBlock();
            if (igrowable.canGrow(worldIn, pos, blockstate, worldIn.isRemote)) {
                if (worldIn instanceof ServerWorld) {
                    if (igrowable.canUseBonemeal(worldIn, worldIn.rand, pos, blockstate)) {
                        igrowable.grow((ServerWorld) worldIn, worldIn.rand, pos, blockstate);
                    }
                    stack.shrink(1);
                }

                return true;
            }
        }

        return false;
    }

    public static boolean growSeaGrass(ItemStack stack, World worldIn, BlockPos pos, @Nullable Direction side) {
        if (worldIn.getBlockState(pos).getBlock() == Blocks.WATER && worldIn.getFluidState(pos).getLevel() == 8) {
            if (worldIn instanceof ServerWorld) {
                label80:
                for (int i = 0; i < 128; ++i) {
                    BlockPos blockpos = pos;
                    Biome biome = worldIn.getBiome(pos);
                    BlockState blockstate = Blocks.SEAGRASS.getDefaultState();

                    for (int j = 0; j < i / 16; ++j) {
                        blockpos = blockpos.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                        biome = worldIn.getBiome(blockpos);
                        if (worldIn.getBlockState(blockpos).isCollisionShapeOpaque(worldIn, blockpos)) {
                            continue label80;
                        }
                    }

                    // FORGE: Use BiomeDictionary here to allow modded warm ocean biomes to spawn coral from BoneMeal
                    // Google翻译：在此处使用BiomeDictionary允许改装的温暖海洋生物群落从BoneMeal产卵珊瑚
                    if (net.minecraftforge.common.BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.OCEAN)
                            && net.minecraftforge.common.BiomeDictionary.hasType(biome, net.minecraftforge.common.BiomeDictionary.Type.HOT)) {
                        if (i == 0 && side != null && side.getAxis().isHorizontal()) {
                            blockstate = BlockTags.WALL_CORALS.getRandomElement(worldIn.rand).getDefaultState().with(DeadCoralWallFanBlock.FACING, side);
                        } else if (random.nextInt(4) == 0) {
                            blockstate = BlockTags.UNDERWATER_BONEMEALS.getRandomElement(random).getDefaultState();
                        }
                    }

                    if (blockstate.getBlock().isIn(BlockTags.WALL_CORALS)) {
                        for (int k = 0; !blockstate.isValidPosition(worldIn, blockpos) && k < 4; ++k) {
                            blockstate = blockstate.with(DeadCoralWallFanBlock.FACING, Direction.Plane.HORIZONTAL.random(random));
                        }
                    }

                    if (blockstate.isValidPosition(worldIn, blockpos)) {
                        BlockState blockState1 = worldIn.getBlockState(blockpos);
                        if (blockState1.getBlock() == Blocks.WATER && worldIn.getFluidState(blockpos).getLevel() == 8) {
                            worldIn.setBlockState(blockpos, blockstate, 3);
                        } else if (blockState1.getBlock() == Blocks.SEAGRASS && random.nextInt(10) == 0) {
                            ((IGrowable) Blocks.SEAGRASS).grow((ServerWorld) worldIn, random, blockpos, blockState1);
                        }
                    }
                }

                stack.shrink(1);
            }
            return true;
        } else {
            return false;
        }
    }
}
