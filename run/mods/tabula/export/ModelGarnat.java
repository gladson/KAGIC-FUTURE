package mod.akrivus.kagic.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Garnets - pezz
 * Created using Tabula 7.1.0
 */
public class ModelGarnat extends ModelBase {
    public ModelRenderer Chest;
    public ModelRenderer Neck;
    public ModelRenderer LegPuffRight;
    public ModelRenderer ShoulderPuffLeft;
    public ModelRenderer ShoulderPuffRight;
    public ModelRenderer LegPuffRight_1;
    public ModelRenderer Body;
    public ModelRenderer CapeTop;
    public ModelRenderer HessoniteHeadHair;
    public ModelRenderer PyropeHair;
    public ModelRenderer DemantoidHair;
    public ModelRenderer LegLeft;
    public ModelRenderer ArmLeft;
    public ModelRenderer ArmPuffLeft;
    public ModelRenderer ArmRight;
    public ModelRenderer ArmPuffRight;
    public ModelRenderer LegRight;
    public ModelRenderer Hips;
    public ModelRenderer Dress;
    public ModelRenderer Cape;

    public ModelGarnat() {
        this.textureWidth = 104;
        this.textureHeight = 130;
        this.HessoniteHeadHair = new ModelRenderer(this, 1, 1);
        this.HessoniteHeadHair.setRotationPoint(-5.0F, -8.7F, -4.0F);
        this.HessoniteHeadHair.addBox(0.0F, 0.0F, 0.0F, 12, 11, 10, 0.0F);
        this.Hips = new ModelRenderer(this, 57, 14);
        this.Hips.setRotationPoint(-1.0F, 8.0F, 0.0F);
        this.Hips.addBox(0.0F, 0.0F, 0.0F, 8, 3, 4, 0.0F);
        this.DemantoidHair = new ModelRenderer(this, 46, 88);
        this.DemantoidHair.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.DemantoidHair.addBox(0.0F, 0.0F, 0.0F, 12, 13, 9, 0.0F);
        this.Body = new ModelRenderer(this, 57, 73);
        this.Body.setRotationPoint(1.0F, 0.0F, 0.5F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 6, 9, 4, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 0);
        this.Neck.setRotationPoint(3.0F, -4.0F, 1.5F);
        this.Neck.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
        this.Dress = new ModelRenderer(this, 42, 26);
        this.Dress.setRotationPoint(-2.5F, 7.9F, -3.5F);
        this.Dress.addBox(0.0F, 0.0F, 0.0F, 11, 17, 11, 0.0F);
        this.LegLeft = new ModelRenderer(this, 0, 48);
        this.LegLeft.setRotationPoint(1.0F, 3.0F, 1.0F);
        this.LegLeft.addBox(0.0F, 0.0F, 0.0F, 3, 15, 3, 0.0F);
        this.ArmRight = new ModelRenderer(this, 12, 48);
        this.ArmRight.mirror = true;
        this.ArmRight.setRotationPoint(0.0F, 1.0F, 1.5F);
        this.ArmRight.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
        this.setRotateAngle(ArmRight, 0.0F, 0.0F, -0.22689280275926282F);
        this.ShoulderPuffRight = new ModelRenderer(this, 44, 0);
        this.ShoulderPuffRight.setRotationPoint(8.0F, -0.8F, 0.0F);
        this.ShoulderPuffRight.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
        this.LegPuffRight_1 = new ModelRenderer(this, 20, 36);
        this.LegPuffRight_1.mirror = true;
        this.LegPuffRight_1.setRotationPoint(4.0F, 8.0F, 0.0F);
        this.LegPuffRight_1.addBox(0.0F, 0.0F, 0.0F, 5, 7, 5, 0.0F);
        this.ArmPuffLeft = new ModelRenderer(this, 40, 55);
        this.ArmPuffLeft.setRotationPoint(-0.5F, 8.0F, -0.5F);
        this.ArmPuffLeft.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.ArmPuffRight = new ModelRenderer(this, 40, 55);
        this.ArmPuffRight.setRotationPoint(-0.5F, 8.0F, -0.5F);
        this.ArmPuffRight.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.LegRight = new ModelRenderer(this, 20, 48);
        this.LegRight.mirror = true;
        this.LegRight.setRotationPoint(1.0F, 3.0F, 1.0F);
        this.LegRight.addBox(0.0F, 0.0F, 0.0F, 3, 15, 3, 0.0F);
        this.CapeTop = new ModelRenderer(this, 0, 66);
        this.CapeTop.setRotationPoint(-4.0F, -4.0F, -0.1F);
        this.CapeTop.addBox(0.0F, 0.0F, 0.0F, 16, 7, 8, 0.0F);
        this.LegPuffRight = new ModelRenderer(this, 0, 36);
        this.LegPuffRight.setRotationPoint(-1.0F, 8.0F, 0.0F);
        this.LegPuffRight.addBox(0.0F, 0.0F, 0.0F, 5, 7, 5, 0.0F);
        this.Cape = new ModelRenderer(this, 54, 54);
        this.Cape.setRotationPoint(0.0F, 5.0F, 5.0F);
        this.Cape.addBox(0.0F, 0.0F, 0.0F, 20, 18, 0, 0.0F);
        this.setRotateAngle(Cape, 0.10471975511965977F, 0.0F, 0.0F);
        this.ShoulderPuffLeft = new ModelRenderer(this, 44, 0);
        this.ShoulderPuffLeft.setRotationPoint(-5.0F, -0.8F, 0.0F);
        this.ShoulderPuffLeft.addBox(0.0F, 0.0F, 0.0F, 5, 5, 5, 0.0F);
        this.PyropeHair = new ModelRenderer(this, 0, 82);
        this.PyropeHair.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.PyropeHair.addBox(0.0F, 0.0F, 0.0F, 12, 16, 10, 0.0F);
        this.ArmLeft = new ModelRenderer(this, 32, 48);
        this.ArmLeft.setRotationPoint(3.5F, 0.5F, 1.5F);
        this.ArmLeft.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
        this.setRotateAngle(ArmLeft, 0.0F, 0.0F, 0.22759093446006054F);
        this.Chest = new ModelRenderer(this, 0, 22);
        this.Chest.setRotationPoint(-4.0F, -2.0F, -2.5F);
        this.Chest.addBox(0.0F, 0.0F, 0.0F, 8, 5, 5, 0.0F);
        this.Neck.addChild(this.HessoniteHeadHair);
        this.Body.addChild(this.Hips);
        this.HessoniteHeadHair.addChild(this.DemantoidHair);
        this.Chest.addChild(this.Body);
        this.Chest.addChild(this.Neck);
        this.Body.addChild(this.Dress);
        this.LegPuffRight.addChild(this.LegLeft);
        this.ShoulderPuffRight.addChild(this.ArmRight);
        this.Chest.addChild(this.ShoulderPuffRight);
        this.Chest.addChild(this.LegPuffRight_1);
        this.ArmLeft.addChild(this.ArmPuffLeft);
        this.ArmRight.addChild(this.ArmPuffRight);
        this.LegPuffRight_1.addChild(this.LegRight);
        this.Chest.addChild(this.CapeTop);
        this.Chest.addChild(this.LegPuffRight);
        this.CapeTop.addChild(this.Cape);
        this.Chest.addChild(this.ShoulderPuffLeft);
        this.HessoniteHeadHair.addChild(this.PyropeHair);
        this.ShoulderPuffLeft.addChild(this.ArmLeft);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Chest.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
