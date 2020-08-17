package bilibili.vvvbbbcz.hamburger.potion;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class ShitEffect extends Effect {
    public ShitEffect() {
        super(EffectType.BENEFICIAL, 0x660000);
        this.addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "739a2455-aeca-44de-9bcd-1e92420b47ae", 0.1D, AttributeModifier.Operation.MULTIPLY_BASE);
        this.addAttributesModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "8dc33d93-512e-4dda-8b85-1cf35f97b4ad", 2.0D, AttributeModifier.Operation.ADDITION);
    }
}
