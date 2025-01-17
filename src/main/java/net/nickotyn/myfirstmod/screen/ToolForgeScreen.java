package net.nickotyn.myfirstmod.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.nickotyn.myfirstmod.MyFirstMod;

public class ToolForgeScreen extends AbstractContainerScreen<ToolForgeMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(MyFirstMod.MOD_ID,"textures/gui/gem_infusing_station_gui.png");

    public ToolForgeScreen(ToolForgeMenu menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

        @Override
    protected void renderBg(PoseStack qPoseStack, float qPartialTick, int qMouseX, int qMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(qPoseStack, x, y, 0, 0, imageWidth, imageHeight);
    }


    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }

}
