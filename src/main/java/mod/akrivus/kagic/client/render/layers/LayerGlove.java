package mod.akrivus.kagic.client.render.layers;

import mod.akrivus.kagic.entity.EntityGem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;

public class LayerGlove extends GemLayer implements LayerRenderer<EntityGem> {
	private final RenderLivingBase<?> gemRenderer;
	private final ModelBase gemModel;
	private float offset;
	private String name;

	public LayerGlove(RenderLivingBase<?> gemRenderer) {
		this(gemRenderer, 0F);
	}

	public LayerGlove(RenderLivingBase<?> gemRenderer, float offset) {
		this(gemRenderer, offset, null);
	}
	
	public LayerGlove(RenderLivingBase<?> gemRenderer, float offset, String name) {
		this.gemRenderer = gemRenderer;
		this.gemModel = gemRenderer.getMainModel();
		this.offset = offset;
		this.name = name;
	}
	
	@Override
	public void doRenderLayer(EntityGem gem, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.gemRenderer.bindTexture(this.getGloveStyle(gem, gem.getGloveStyle()));
		int gloveColor = gem.getGloveColor();
        float r = (float) ((gloveColor & 16711680) >> 16) / 255f;
        float g = (float) ((gloveColor & 65280) >> 8) / 255f;
        float b = (float) ((gloveColor & 255) >> 0) / 255f;
		GlStateManager.color(r + this.offset, g + this.offset, b + this.offset/*, 0.99f*/);
		//GlStateManager.enableBlend();
		//GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);
		this.gemModel.setModelAttributes(this.gemRenderer.getMainModel());
        this.gemModel.render(gem, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		GlStateManager.disableBlend();
	}
	
	public ResourceLocation getGloveStyle(EntityGem gem, int glove) {
		ResourceLocation loc = EntityList.getKey(gem);
			return new ResourceLocation(loc.getResourceDomain() + ":textures/entities/" + this.getName(gem) + "/gloves/glove_" + gem.getGloveStyle() + ".png");
		}
	
	
	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}
