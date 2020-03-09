package mod.akrivus.kagic.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

/**
 * Pearl - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelPurl extends ModelGem {
    public ModelRenderer Body;
    public ModelRenderer Head;
    public ModelRenderer LeftArm;
    public ModelRenderer RightArm;
    public ModelRenderer LeftLeg;
    public ModelRenderer RightLeg;
    public ModelRenderer Dress;
    public ModelRenderer Shawl;
    public ModelRenderer Jacket;
    public ModelRenderer Hair;
    public ModelRenderer HatBase;
    public ModelRenderer LongHair;
    public ModelRenderer Nose;
    public ModelRenderer RightHairBun;
    public ModelRenderer RightHairBun_1;
    public ModelRenderer BackHairBun;
    public ModelRenderer hat1;
    public ModelRenderer Hat2;
    public ModelRenderer Hat3;
    public ModelRenderer Hat4;
    public ModelRenderer LeftShoulderPuff;
    public ModelRenderer LeftYellowPearlShoulderPuff;
    public ModelRenderer LeftArmPuff;
    public ModelRenderer RightShoulderPuff;
    public ModelRenderer RightYellowPearlShoulderPuff;
    public ModelRenderer RightArmPuff;

    public ModelPurl() {
    	super(0.0F, 0.0F, 130, 75, false, -1F);
        this.LeftYellowPearlShoulderPuff = new ModelRenderer(this, 24, 52);
        this.LeftYellowPearlShoulderPuff.setRotationPoint(-4.0F, -0.5F, -0.5F);
        this.LeftYellowPearlShoulderPuff.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
        this.LeftArmPuff = new ModelRenderer(this, 22, 34);
        this.LeftArmPuff.setRotationPoint(-2.5F, 7.0F, -0.5F);
        this.LeftArmPuff.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.Head = new ModelRenderer(this, 36, 0);
        this.Head.setRotationPoint(-1.0F, -8.0F, -2.0F);
        this.Head.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8, 0.0F);
        this.Dress = new ModelRenderer(this, 0, 41);
        this.Dress.setRotationPoint(-0.5F, 10.0F, -0.5F);
        this.Dress.addBox(0.0F, 0.0F, 0.0F, 7, 12, 5, 0.0F);
        this.RightShoulderPuff = new ModelRenderer(this, 0, 34);
        this.RightShoulderPuff.mirror = true;
        this.RightShoulderPuff.setRotationPoint(-0.5F, -0.5F, -0.5F);
        this.RightShoulderPuff.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.Nose = new ModelRenderer(this, 0, 0);
        this.Nose.setRotationPoint(3.5F, 4.0F, -2.0F);
        this.Nose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.LongHair = new ModelRenderer(this, 32, 53);
        this.LongHair.setRotationPoint(-0.5F, -0.5F, -0.5F);
        this.LongHair.addBox(0.0F, 0.0F, 0.0F, 9, 13, 9, 0.0F);
        this.Body = new ModelRenderer(this, 0, 18);
        this.Body.setRotationPoint(-3.0F, -1.0F, -2.0F);
        this.Body.addBox(0.0F, 0.0F, 0.0F, 6, 12, 4, 0.0F);
        this.Jacket = new ModelRenderer(this, 56, 18);
        this.Jacket.setRotationPoint(-1.0F, 0.0F, -0.5F);
        this.Jacket.addBox(0.0F, 0.0F, 0.0F, 8, 8, 5, 0.0F);
        this.RightHairBun_1 = new ModelRenderer(this, 74, 40);
        this.RightHairBun_1.setRotationPoint(8.0F, 1.5F, 1.5F);
        this.RightHairBun_1.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.BackHairBun = new ModelRenderer(this, 36, 35);
        this.BackHairBun.setRotationPoint(2.5F, 2.5F, 9.0F);
        this.BackHairBun.addBox(0.0F, 0.0F, 0.0F, 4, 4, 3, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 36, 16);
        this.LeftLeg.setRotationPoint(0.0F, 12.0F, 1.0F);
        this.LeftLeg.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
        this.RightArm = new ModelRenderer(this, 28, 18);
        this.RightArm.setRotationPoint(6.0F, 0.0F, 1.0F);
        this.RightArm.addBox(0.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
        this.Hat4 = new ModelRenderer(this, 114, 43);
        this.Hat4.setRotationPoint(1.0F, -2.0F, 1.0F);
        this.Hat4.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
        this.Shawl = new ModelRenderer(this, 0, 58);
        this.Shawl.setRotationPoint(-2.5F, 0.0F, -0.5F);
        this.Shawl.addBox(0.0F, 0.0F, 0.0F, 11, 12, 5, 0.0F);
        this.LeftArm = new ModelRenderer(this, 20, 18);
        this.LeftArm.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.LeftArm.addBox(-2.0F, 0.0F, 0.0F, 2, 14, 2, 0.0F);
        this.RightArmPuff = new ModelRenderer(this, 22, 34);
        this.RightArmPuff.setRotationPoint(-0.5F, 7.0F, -0.5F);
        this.RightArmPuff.addBox(0.0F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.HatBase = new ModelRenderer(this, 68, 0);
        this.HatBase.setRotationPoint(-3.0F, 0.0F, -3.0F);
        this.HatBase.addBox(0.0F, 0.0F, 0.0F, 14, 1, 14, 0.0F);
        this.RightYellowPearlShoulderPuff = new ModelRenderer(this, 24, 52);
        this.RightYellowPearlShoulderPuff.mirror = true;
        this.RightYellowPearlShoulderPuff.setRotationPoint(0.0F, -0.5F, -0.5F);
        this.RightYellowPearlShoulderPuff.addBox(0.0F, 0.0F, 0.0F, 4, 3, 3, 0.0F);
        this.RightLeg = new ModelRenderer(this, 44, 16);
        this.RightLeg.setRotationPoint(4.0F, 12.0F, 1.0F);
        this.RightLeg.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
        this.Hat2 = new ModelRenderer(this, 98, 27);
        this.Hat2.setRotationPoint(1.0F, -2.0F, 1.0F);
        this.Hat2.addBox(0.0F, 0.0F, 0.0F, 7, 2, 7, 0.0F);
        this.Hat3 = new ModelRenderer(this, 106, 36);
        this.Hat3.setRotationPoint(1.0F, -2.0F, 1.0F);
        this.Hat3.addBox(0.0F, 0.0F, 0.0F, 5, 2, 5, 0.0F);
        this.RightHairBun = new ModelRenderer(this, 55, 40);
        this.RightHairBun.setRotationPoint(-2.0F, 1.5F, 1.5F);
        this.RightHairBun.addBox(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
        this.LeftShoulderPuff = new ModelRenderer(this, 0, 34);
        this.LeftShoulderPuff.setRotationPoint(-2.5F, -0.5F, -0.5F);
        this.LeftShoulderPuff.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.hat1 = new ModelRenderer(this, 90, 15);
        this.hat1.setRotationPoint(2.5F, -3.0F, 2.5F);
        this.hat1.addBox(0.0F, 0.0F, 0.0F, 9, 3, 9, 0.0F);
        this.Hair = new ModelRenderer(this, 0, 0);
        this.Hair.setRotationPoint(-0.5F, -0.5F, -0.5F);
        this.Hair.addBox(0.0F, 0.0F, 0.0F, 9, 9, 9, 0.0F);
        this.LeftArm.addChild(this.LeftYellowPearlShoulderPuff);
        this.LeftArm.addChild(this.LeftArmPuff);
        this.Body.addChild(this.Head);
        this.Body.addChild(this.Dress);
        this.RightArm.addChild(this.RightShoulderPuff);
        this.Head.addChild(this.Nose);
        this.Head.addChild(this.LongHair);
        this.Body.addChild(this.Jacket);
        this.Head.addChild(this.RightHairBun_1);
        this.Hair.addChild(this.BackHairBun);
        this.Body.addChild(this.LeftLeg);
        this.Body.addChild(this.RightArm);
        this.Hat3.addChild(this.Hat4);
        this.Body.addChild(this.Shawl);
        this.Body.addChild(this.LeftArm);
        this.RightArm.addChild(this.RightArmPuff);
        this.Head.addChild(this.HatBase);
        this.RightArm.addChild(this.RightYellowPearlShoulderPuff);
        this.Body.addChild(this.RightLeg);
        this.hat1.addChild(this.Hat2);
        this.Hat2.addChild(this.Hat3);
        this.Head.addChild(this.RightHairBun);
        this.LeftArm.addChild(this.LeftShoulderPuff);
        this.HatBase.addChild(this.hat1);
        this.Head.addChild(this.Hair);
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.Body.render(scale);
    }
    @Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
    	super.copyModelAngles(this.Head, this.Hair);
		
		boolean flag = entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getTicksElytraFlying() > 4;

		this.Body.rotateAngleY = 0.0F;
		/*this.RightArm.rotationPointZ = 0.0F;
		this.RightArm.rotationPointX = -5.0F;
		this.LeftArm.rotationPointZ = 0.0F;
		this.LeftArm.rotationPointX = 5.0F;*/
		float f = 1.0F;

		if (flag)
		{
			f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
			f = f / 0.2F;
			f = f * f * f;
		}

		if (f < 1.0F)
		{
			f = 1.0F;
		}

		this.RightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.LeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.RightArm.rotateAngleZ = 0.0F;
		this.LeftArm.rotateAngleZ = 0.0F;
		this.RightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount / f;
		this.LeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount / f;
		this.RightLeg.rotateAngleY = 0.0F;
		this.LeftLeg.rotateAngleY = 0.0F;
		this.RightLeg.rotateAngleZ = 0.0F;
		this.LeftLeg.rotateAngleZ = 0.0F;

		
		if (this.swingProgress > 0.0F)
		{
			EnumHandSide enumhandside = this.getMainHand(entityIn);
			ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
			float f1 = this.swingProgress;
			this.Body.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float)Math.PI * 2F)) * 0.2F;

			if (enumhandside == EnumHandSide.LEFT)
			{
				this.Body.rotateAngleY *= -1.0F;
			}

			this.RightArm.rotationPointZ = MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotationPointX = -MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointZ = -MathHelper.sin(this.Body.rotateAngleY) * 5.0F;
			this.LeftArm.rotationPointX = MathHelper.cos(this.Body.rotateAngleY) * 5.0F;
			this.RightArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleY += this.Body.rotateAngleY;
			this.LeftArm.rotateAngleX += this.Body.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float)Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.Head.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float)((double)modelrenderer.rotateAngleX - ((double)f2 * 1.2D + (double)f3));
			modelrenderer.rotateAngleY += this.Body.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
		}

		if (this.isSneak)
		{
			this.Body.rotateAngleX = 0.5F;
			this.RightArm.rotateAngleX += 0.4F;
			this.LeftArm.rotateAngleX += 0.4F;
			this.RightLeg.rotationPointZ = 4.0F;
			this.LeftLeg.rotationPointZ = 4.0F;
			this.RightLeg.rotationPointY = 9.0F;
			this.LeftLeg.rotationPointY = 9.0F;
		}
		else
		{
			this.Body.rotateAngleX = 0.0F;
		}

		this.RightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.LeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.RightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.LeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
		{
			this.RightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY;
			this.LeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY + 0.4F;
			this.RightArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
			this.LeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
		}
		else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
		{
			this.RightArm.rotateAngleY = -0.1F + this.Head.rotateAngleY - 0.4F;
			this.LeftArm.rotateAngleY = 0.1F + this.Head.rotateAngleY;
			this.RightArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
			this.LeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.Head.rotateAngleX;
		}

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
