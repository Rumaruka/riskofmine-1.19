package com.rumaruka.riskofmine.client.screen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

import com.rumaruka.riskofmine.api.Chest;
import com.rumaruka.riskofmine.api.Types;
import com.rumaruka.riskofmine.common.inventory.ChestInventory;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
public class BaseScreen extends AbstractContainerScreen<ChestInventory> implements MenuAccess<ChestInventory> {

    private final Chest chestType;

    private final int textureXSize;

    private final int textureYSize;

    public BaseScreen(ChestInventory container, Inventory playerInventory, Component title) {
        super(container, playerInventory, title);

        this.chestType = container.getChestType();
        this.imageWidth = container.getChestType().xSize;
        this.imageHeight = container.getChestType().ySize;
        this.textureXSize = container.getChestType().textureXSize;
        this.textureYSize = container.getChestType().textureYSize;

        this.passEvents = false;
    }

    @Override
    public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title, 8.0F, 6.0F, 4210752);

        this.font.draw(matrixStack, this.playerInventoryTitle, 8.0F, (float) (this.imageHeight - 96 + 2), 4210752);
    }

    @Override
    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, this.chestType.guiTexture);

        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        blit(poseStack, x, y, 0, 0, this.imageWidth, this.imageHeight, this.textureXSize, this.textureYSize);
    }
}