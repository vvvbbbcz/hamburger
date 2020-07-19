package bilibili.vvvbbbcz.hamburger.gui;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.gui.container.ContainerIronPan;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiIronPan extends ContainerScreen<ContainerIronPan> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Hamburger.MODID + ":textures/gui/container/iron_pan.png");
    private final ContainerIronPan container;
    private final int xSize, ySize;

    protected GuiIronPan(ContainerIronPan container, PlayerInventory inventory, ITextComponent titleIn) {
        super(container, inventory, titleIn);
        this.container = container;
        this.xSize = 176;
        this.ySize = 133;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) { // TODO 可能不需要此方法
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int offsetX = (this.width - this.xSize) / 2;
        int offsetY = (this.height - this.ySize) / 2;
        // 此处使用的函数签名：blit(int x0, int y0, int u0, int v0, int width, int height)
        this.blit(offsetX, offsetY, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String title = I18n.format("gui.ironPan.title");
        this.font.drawString(title, (this.xSize - this.font.getStringWidth(title)) / 2, 6, 0xffff00);

        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        int burnTime = this.container.getBurnTime();
        int textureWidth = (int) (27 * burnTime / this.container.getTotalBurnTime());
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        // 此处使用的函数签名：blit(int x0, int y0, int u0, int v0, int width, int height)
        this.blit(86, 20, 176, 0, textureWidth, 17);
    }

//    @Override
//    protected void init() {
//        super.init();
//    }
//
//    @Override
//    public void render(int mouseX, int mouseY, float particleTick) {
//        this.renderBackground();
//        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
//        this.minecraft.getTextureManager().bindTexture(TEXTURE);
//        int textureWidth = 176;
//        int textureHeight = 133;
//         // 此处使用的函数签名：blit(int x, int y, float u, float v, int width, int height, int textureHeight, int textureWidth)
//         // 参考图片：https://neutrino.v2mcdev.com/gui/firstgui.assets/ABDAB8F2-7777-4249-9249-2278B64FF5BA.jpeg
//        blit((this.width - textureWidth) / 2, 10, 0, 0, textureWidth, textureHeight, textureWidth, textureHeight); // TODO
//        this.drawString(this.font, this.title.getString(), (textureWidth - this.font.getStringWidth(title.getFormattedText())) / 2, 6, 0xeb0505); // TODO
//        super.render(mouseX, mouseY, particleTick);
//    }
}
