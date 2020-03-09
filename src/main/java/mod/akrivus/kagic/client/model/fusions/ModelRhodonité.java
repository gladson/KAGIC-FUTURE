package mod.akrivus.kagic.client.model.fusions;

import mod.akrivus.kagic.client.model.ModelGem;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

/**
 * Rhodonite - Undefined
 * Created using Tabula 7.1.0
 */
public class ModelRhodonité extends ModelGem {
    //public ModelRenderer bipedBody;
    public ModelRenderer Waist;
    public ModelRenderer bipedNeck;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer right_arm_bottom;
    public ModelRenderer right_leg_bottom;
    public ModelRenderer left_leg_bottom;
    public ModelRenderer left_arm_bottom;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer bipedHead;
    public ModelRenderer bipedNose;

    public ModelRhodonité(float modelSize, boolean isArmor) {
		super(modelSize, 0.0F, 94, 62, false, -2F);
        this.bipedLeftArm = new ModelRenderer(this, 64, 0);
        this.bipedLeftArm.setRotationPoint(7.0F, 0.2F, 0.5F);
        this.bipedLeftArm.addBox(0.0F, 0.0F, 0.0F, 4, 11, 4, 0.0F);
        this.setRotateAngle(bipedLeftArm, 0.0F, 0.0F, -0.4363323129985824F);
        this.bipedNose = new ModelRenderer(this, 0, 0);
        this.bipedNose.setRotationPoint(7.5F, 7.0F, -1.5F);
        this.bipedNose.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.bipedNeck = new ModelRenderer(this, 26, 18);
        this.bipedNeck.setRotationPoint(2.5F, -1.5F, 1.0F);
        this.bipedNeck.addBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F);
        this.right_leg_bottom = new ModelRenderer(this, 0, 38);
        this.right_leg_bottom.setRotationPoint(-1.0F, 5.0F, 0.0F);
        this.right_leg_bottom.addBox(0.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 48);
        this.bipedRightLeg.setRotationPoint(0.5F, 6.0F, 0.5F);
        this.bipedRightLeg.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.bipedBody = new ModelRenderer(this, 0, 18);
        this.bipedBody.setRotationPoint(-4.0F, 0.0F, -2.5F);
        this.bipedBody.addBox(0.0F, 0.0F, 0.0F, 8, 6, 5, 0.0F);
        this.left_leg_bottom = new ModelRenderer(this, 16, 38);
        this.left_leg_bottom.setRotationPoint(3.0F, 5.0F, 0.0F);
        this.left_leg_bottom.addBox(0.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 12, 48);
        this.bipedLeftLeg.setRotationPoint(0.5F, 6.0F, 0.5F);
        this.bipedLeftLeg.addBox(0.0F, 0.0F, 0.0F, 3, 7, 3, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 48, 0);
        this.bipedRightArm.setRotationPoint(-2.5F, -1.5F, 0.5F);
        this.bipedRightArm.addBox(0.0F, 0.0F, 0.0F, 4, 11, 4, 0.0F);
        this.setRotateAngle(bipedRightArm, 0.0F, 0.0F, 0.4363323129985824F);
        this.left_arm_bottom = new ModelRenderer(this, 40, 28);
        this.left_arm_bottom.setRotationPoint(8.6F, 1.5F, -5.0F);
        this.left_arm_bottom.addBox(0.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(left_arm_bottom, 0.0F, -0.6108652381980153F, 0.0F);
        this.right_arm_bottom = new ModelRenderer(this, 40, 18);
        this.right_arm_bottom.setRotationPoint(-4.5F, 1.5F, -4.0F);
        this.right_arm_bottom.addBox(0.0F, 0.0F, 0.0F, 2, 2, 8, 0.0F);
        this.setRotateAngle(right_arm_bottom, 0.0F, 0.6108652381980153F, 0.0F);
        this.bipedHead = new ModelRenderer(this, 0, 0);
        this.bipedHead.setRotationPoint(-6.5F, -10.0F, -2.0F);
        this.bipedHead.addBox(0.0F, 0.0F, 0.0F, 16, 10, 8, 0.0F);
        this.Waist = new ModelRenderer(this, 0, 29);
        this.Waist.setRotationPoint(1.0F, 6.0F, 0.5F);
        this.Waist.addBox(0.0F, 0.0F, 0.0F, 6, 5, 4, 0.0F);
        this.bipedBody.addChild(this.bipedLeftArm);
        this.bipedHead.addChild(this.bipedNose);
        this.bipedBody.addChild(this.bipedNeck);
        this.Waist.addChild(this.right_leg_bottom);
        this.right_leg_bottom.addChild(this.bipedRightLeg);
        this.Waist.addChild(this.left_leg_bottom);
        this.left_leg_bottom.addChild(this.bipedLeftLeg);
        this.bipedBody.addChild(this.bipedRightArm);
        this.Waist.addChild(this.left_arm_bottom);
        this.Waist.addChild(this.right_arm_bottom);
        this.bipedNeck.addChild(this.bipedHead);
        this.bipedBody.addChild(this.Waist);
    }

    	public ModelRhodonité() {
		this(0, false);
	}

	@Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.bipedBody.render(f5);
    }
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		boolean flag = entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getTicksElytraFlying() > 4;
		this.bipedHead.rotateAngleY = netHeadYaw * 0.017453292F;

		if (flag)
		{
			this.bipedHead.rotateAngleX = -((float)Math.PI / 4F);
		}
		else
		{
			this.bipedHead.rotateAngleX = headPitch * 0.017453292F;
		}

		this.bipedBody.rotateAngleY = 0.0F;
		/*this.bipedRightArm.rotationPointZ = 0.0F;
		this.bipedRightArm.rotationPointX = -5.0F;
		this.bipedLeftArm.rotationPointZ = 0.0F;
		this.bipedLeftArm.rotationPointX = 5.0F;*/
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

		this.bipedRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.bipedRightArm.rotateAngleZ = 0.0F;
		this.right_arm_bottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.right_arm_bottom.rotateAngleZ = (float)Math.PI / 2F;
		
		this.bipedLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / f;
		this.bipedLeftArm.rotateAngleZ = 0.0F;
		this.left_arm_bottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F / f;
		this.left_arm_bottom.rotateAngleZ = (float)Math.PI / -2F;
		
		this.bipedRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount / f;
		this.bipedLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.7F * limbSwingAmount / f;
		this.bipedRightLeg.rotateAngleY = 0.0F;
		this.bipedLeftLeg.rotateAngleY = 0.0F;
		this.bipedRightLeg.rotateAngleZ = 0.0F;
		this.bipedLeftLeg.rotateAngleZ = 0.0F;

		if (this.isRiding)
		{
			this.bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
			this.bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
			this.bipedRightLeg.rotateAngleX = -1.4137167F;
			this.bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
			this.bipedRightLeg.rotateAngleZ = 0.07853982F;
			this.bipedLeftLeg.rotateAngleX = -1.4137167F;
			this.bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
			this.bipedLeftLeg.rotateAngleZ = -0.07853982F;
		}

		this.bipedRightArm.rotateAngleY = 0.0F;
		this.bipedRightArm.rotateAngleZ = 0.0F;

		switch (this.leftArmPose)
		{
			case EMPTY:
				this.bipedLeftArm.rotateAngleY = 0.0F;
				break;
			case BLOCK:
				this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.9424779F;
				this.bipedLeftArm.rotateAngleY = 0.5235988F;
				break;
			case ITEM:
				this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
				this.bipedLeftArm.rotateAngleY = 0.0F;
			case BOW_AND_ARROW:
				break;
			default:
				break;
		}

		switch (this.rightArmPose)
		{
			case EMPTY:
				this.bipedRightArm.rotateAngleY = 0.0F;
				break;
			case BLOCK:
				this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.9424779F;
				this.bipedRightArm.rotateAngleY = -0.5235988F;
				break;
			case ITEM:
				this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - ((float)Math.PI / 10F);
				this.bipedRightArm.rotateAngleY = 0.0F;
			case BOW_AND_ARROW:
				break;
			default:
				break;
		}

		if (this.swingProgress > 0.0F)
		{
			EnumHandSide enumhandside = this.getMainHand(entityIn);
			ModelRenderer modelrenderer = this.getArmForSide(enumhandside);
			float f1 = this.swingProgress;
			this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float)Math.PI * 2F)) * 0.2F;

			if (enumhandside == EnumHandSide.LEFT)
			{
				this.bipedBody.rotateAngleY *= -1.0F;
			}

			this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
			this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
			this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float)Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
			modelrenderer.rotateAngleX = (float)((double)modelrenderer.rotateAngleX - ((double)f2 * 1.2D + (double)f3));
			modelrenderer.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
			modelrenderer.rotateAngleZ += MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F;
		}

		if (this.isSneak)
		{
			this.bipedBody.rotateAngleX = 0.5F;
			this.bipedRightArm.rotateAngleX += 0.4F;
			this.bipedLeftArm.rotateAngleX += 0.4F;
			this.bipedRightLeg.rotationPointZ = 4.0F;
			this.bipedLeftLeg.rotationPointZ = 4.0F;
			this.bipedRightLeg.rotationPointY = 9.0F;
			this.bipedLeftLeg.rotationPointY = 9.0F;
			this.bipedHead.rotationPointY = 1.0F;
		}
		else
		{
			this.bipedBody.rotateAngleX = 0.0F;
			this.bipedHead.rotationPointY = -2.5F;
		}

		this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.375F;
		this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.right_arm_bottom.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.right_arm_bottom.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F + .9F;

		this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.375F;
		this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.left_arm_bottom.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.left_arm_bottom.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F - .9F;

		if (this.rightArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
		{
			this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY;
			this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY + 0.4F;
			this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
			this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
		}
		else if (this.leftArmPose == ModelBiped.ArmPose.BOW_AND_ARROW)
		{
			this.bipedRightArm.rotateAngleY = -0.1F + this.bipedHead.rotateAngleY - 0.4F;
			this.bipedLeftArm.rotateAngleY = 0.1F + this.bipedHead.rotateAngleY;
			this.bipedRightArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
			this.bipedLeftArm.rotateAngleX = -((float)Math.PI / 2F) + this.bipedHead.rotateAngleX;
		}

		copyModelAngles(this.bipedHead, this.bipedHeadwear);
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
