package bilibili.vvvbbbcz.hamburger.gui;

import bilibili.vvvbbbcz.largeprojectslao8.gui.container.ContainerIronPan;
import bilibili.vvvbbbcz.largeprojectslao8.LargeprojectsLao8;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;

public class GuiIronPan extends GuiContainer {
    private static final ResourceLocation TEXTURE = new ResourceLocation(LargeprojectsLao8.MODID + ":textures/gui/container/iron_pan.png");
    private final ContainerIronPan container;

    public GuiIronPan(ContainerIronPan inventorySlotsIn) {
        super(inventorySlotsIn);
        this.container = inventorySlotsIn;
        this.xSize = 176;
        this.ySize = 133;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2;
        int offsetY = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String title = I18n.format("gui.ironPan.title");
        this.fontRenderer.drawString(title, (this.xSize - this.fontRenderer.getStringWidth(title)) / 2, 6, 0xffff00);

        GlStateManager.color(1.0F, 1.0F, 1.0F);
        int burnTime = this.container.getBurnTime();
        int textureWidth = (int) (27 * burnTime / this.container.getTotalBurnTime());
        this.mc.getTextureManager().bindTexture(TEXTURE);
        this.drawTexturedModalRect(86, 20, 176, 0, textureWidth, 17);
    }
}
