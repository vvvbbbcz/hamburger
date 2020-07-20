package bilibili.vvvbbbcz.hamburger.potions;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectShit extends Effect {
//    private static final ResourceLocation TEXTURE = new ResourceLocation(Hamburger.MODID + ":textures/gui/effect/shit.png");

    public EffectShit() {
        super(EffectType.BENEFICIAL, 0x660000);
        this.addAttributesModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "739a2455-aeca-44de-9bcd-1e92420b47ae", 0.5D, AttributeModifier.Operation.ADDITION);
        this.addAttributesModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "8dc33d93-512e-4dda-8b85-1cf35f97b4ad", 2.0D, AttributeModifier.Operation.ADDITION);
    }

//    @SideOnly(Side.CLIENT)
//    @Override
//    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
//        GlStateManager.color(1.0F, 1.0F, 1.0F);
//        mc.getTextureManager().bindTexture(TEXTURE);
//        Gui.drawModalRectWithCustomSizedTexture(x + 7, y + 8, 0, 0, 16, 16, 16, 16);
//    }
//
//    @Override
//    public void renderInventoryEffect(EffectInstance effect, DisplayEffectsScreen<?> gui, int x, int y, float z) {
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        gui.;
//    }
//
//    @SideOnly(Side.CLIENT)
//    @Override
//    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
//        GlStateManager.color(1.0F, 1.0F, 1.0F);
//        mc.getTextureManager().bindTexture(TEXTURE);
//        Gui.drawModalRectWithCustomSizedTexture(x + 4, y + 4, 0, 0, 16, 16, 16, 16);
//    }
//
//    @OnlyIn(Dist.CLIENT)
//    @Override
//    public void renderHUDEffect(EffectInstance effect, AbstractGui gui, int x, int y, float z, float alpha) {
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        this.mc.getTextureManager().bindTexture(TEXTURE);
//        Gui.drawModalRectWithCustomSizedTexture(x + 7, y + 8, 0, 0, 16, 16, 16, 16);
//    }
}
