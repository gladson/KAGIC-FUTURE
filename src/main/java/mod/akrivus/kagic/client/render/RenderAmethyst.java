package mod.akrivus.kagic.client.render;

import java.util.Iterator;

import mod.akrivus.kagic.client.model.ModelQuartz;
import mod.akrivus.kagic.client.render.layers.LayerAgateBand;
import mod.akrivus.kagic.client.render.layers.LayerAgateHair;
import mod.akrivus.kagic.client.render.layers.LayerAgateItem;
import mod.akrivus.kagic.client.render.layers.LayerBirthdayHat;
import mod.akrivus.kagic.client.render.layers.LayerEye;
import mod.akrivus.kagic.client.render.layers.LayerGemPlacement;
import mod.akrivus.kagic.client.render.layers.LayerGlove;
import mod.akrivus.kagic.client.render.layers.LayerHair;
import mod.akrivus.kagic.client.render.layers.LayerInsignia;
import mod.akrivus.kagic.client.render.layers.LayerLaceMark1;
import mod.akrivus.kagic.client.render.layers.LayerLaceMark2;
import mod.akrivus.kagic.client.render.layers.LayerNoDyeOverlay;
import mod.akrivus.kagic.client.render.layers.LayerQuartzCape;
import mod.akrivus.kagic.client.render.layers.LayerQuartzItem;
import mod.akrivus.kagic.client.render.layers.LayerSantaHat;
import mod.akrivus.kagic.client.render.layers.LayerSkin;
import mod.akrivus.kagic.client.render.layers.LayerUniform;
import mod.akrivus.kagic.client.render.layers.LayerVisor;
import mod.akrivus.kagic.client.render.layers.LayerWitchHat;
import mod.akrivus.kagic.entity.gem.EntityAmethyst;
import mod.akrivus.kagic.entity.gem.EntityJasper;
import mod.akrivus.kagic.init.KAGIC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderAmethyst extends RenderGemBase<EntityAmethyst> {
	public RenderAmethyst() {
        super(Minecraft.getMinecraft().getRenderManager(), new ModelQuartz(), 0.5F);

		this.addLayer(new LayerQuartzItem(this));
        this.addLayer(new LayerSkin(this));
        this.addLayer(new LayerLaceMark1(this));
        this.addLayer(new LayerLaceMark2(this));
        this.addLayer(new LayerEye(this));
        this.addLayer(new LayerUniform(this));
        this.addLayer(new LayerInsignia(this));
        this.addLayer(new LayerHair(this));
        this.addLayer(new LayerVisor(this));
        this.addLayer(new LayerGemPlacement(this));
        this.addLayer(new LayerQuartzCape(this));
		}

	
	@Override
	protected void preRenderCallback(EntityAmethyst amethyst, float partialTickTime) {
		if (amethyst.isDefective()) {
			GlStateManager.scale(0.9F, 0.72F, 0.9F);
		} else if (amethyst.isPrimary()) {
			GlStateManager.scale(1.1F, 1.1F, 1.1F);
		}
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityAmethyst entity) {
		return new ResourceLocation("kagic:textures/entities/amethyst/amethyst.png");
	}
}
