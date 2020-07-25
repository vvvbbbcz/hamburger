package bilibili.vvvbbbcz.hamburger.client.gui;

import bilibili.vvvbbbcz.hamburger.Hamburger;
import bilibili.vvvbbbcz.hamburger.inventory.container.IronPlateContainer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiIronPlate extends ContainerScreen<IronPlateContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Hamburger.MODID + ":textures/gui/container/iron_plate.png");
    private final IronPlateContainer container;
    private final int xSize, ySize;

    public GuiIronPlate(IronPlateContainer container, PlayerInventory inventory, ITextComponent titleIn) {
        super(container, inventory, titleIn);
        this.container = container;
        this.xSize = 176;
        this.ySize = 133;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
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

        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        int burnTime = this.container.getBurnTime();
        int textureWidth = 27 * burnTime / this.container.getTotalBurnTime();
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        // 此处使用的函数签名：blit(int x0, int y0, int u0, int v0, int width, int height)
        this.blit(86, 20, 176, 0, textureWidth, 17);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String title = I18n.format("gui.iron_plate.title");
        this.font.drawString(title, (float) (this.xSize - this.font.getStringWidth(title)) / 2, 22.0F, 0xffff00);
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
