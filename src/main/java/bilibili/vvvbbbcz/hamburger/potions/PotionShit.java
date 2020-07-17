package bilibili.vvvbbbcz.hamburger.potions;

import bilibili.vvvbbbcz.largeprojectslao8.LargeprojectsLao8;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionShit extends Potion {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LargeprojectsLao8.MODID + ":textures/gui/effect/shit.png");

    public PotionShit() {
        super(false, 0x660000);
        this.setPotionName(TextFormatting.BLUE + I18n.translateToLocalFormatted("effect.shit.name"));
        this.registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "739a2455-aeca-44de-9bcd-1e92420b47ae", 0.5D, 2);
        this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "8dc33d93-512e-4dda-8b85-1cf35f97b4ad", 2.0D, 2);
        this.setBeneficial();
    }

    @Override
    public boolean hasStatusIcon() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(TEXTURE);
        Gui.drawModalRectWithCustomSizedTexture(x + 7, y + 8, 0, 0, 16, 16, 16, 16);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(TEXTURE);
        Gui.drawModalRectWithCustomSizedTexture(x + 4, y + 4, 0, 0, 16, 16, 16, 16);
    }
}
