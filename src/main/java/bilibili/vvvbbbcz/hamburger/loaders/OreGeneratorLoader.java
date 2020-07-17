package bilibili.vvvbbbcz.hamburger.loaders;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OreGeneratorLoader {
    private static WorldGenerator genSaltOre = new WorldGenMinable(RegisterLoader.blockSaltOre.getDefaultState(), 24);

    public static void init() {
        MinecraftForge.ORE_GEN_BUS.register(OreGeneratorLoader.class);
    }

    @SubscribeEvent
    public static void onGenerateMinable(OreGenEvent.GenerateMinable event) {
        if (event.getType() != OreGenEvent.GenerateMinable.EventType.IRON)
            return;

        if (!TerrainGen.generateOre(event.getWorld(), event.getRand(), genSaltOre, event.getPos(), OreGenEvent.GenerateMinable.EventType.CUSTOM))
            return;

        for (int i = 0; i < 4; i++) {
            int posX = event.getPos().getX() + event.getRand().nextInt(16);
            int posY = 16 + event.getRand().nextInt(112);
            int posZ = event.getPos().getZ() + event.getRand().nextInt(16);
            BlockPos pos = new BlockPos(posX, posY, posZ);
            genSaltOre.generate(event.getWorld(), event.getRand(), pos);
        }
    }
}
