package bilibili.vvvbbbcz.hamburger.world.gen.feature.structure;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructureTypes {
    public static final IStructurePieceType BATHROOM = BathroomPiece::new;

    public static void register() {
        Registry.register(Registry.STRUCTURE_PIECE, "bathroom", BATHROOM);
    }
}
