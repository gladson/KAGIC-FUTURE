package mod.akrivus.kagic.entity.gem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Predicate;

import io.netty.buffer.ByteBuf;
import mod.akrivus.kagic.entity.EntityGem;
import mod.akrivus.kagic.entity.ai.EntityAIDiamondHurtByTarget;
import mod.akrivus.kagic.entity.ai.EntityAIDiamondHurtTarget;
import mod.akrivus.kagic.entity.ai.EntityAIFollowDiamond;
import mod.akrivus.kagic.entity.ai.EntityAIProtectionFuse;
import mod.akrivus.kagic.entity.ai.EntityAIStandGuard;
import mod.akrivus.kagic.entity.ai.EntityAIStay;
import mod.akrivus.kagic.entity.gem.fusion.EntityOpal;
import mod.akrivus.kagic.init.KAGIC;
import mod.akrivus.kagic.init.ModItems;
import mod.akrivus.kagic.init.ModSounds;
import mod.akrivus.kagic.skills.SkillBase;
import mod.heimrarnadalr.kagic.util.Colors;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAmethyst extends EntityQuartzSoldier implements IAnimals {
	public static final HashMap<IBlockState, Double> AMETHYST_YIELDS = new HashMap<IBlockState, Double>();
	public static final double AMETHYST_DEFECTIVITY_MULTIPLIER = 1;
	public static final double AMETHYST_DEPTH_THRESHHOLD = 72;
	public static final HashMap<Integer, ResourceLocation> AMETHYST_HAIR_STYLES = new HashMap<Integer, ResourceLocation>();
	public static final HashMap<Integer, ResourceLocation> AMETHYST_UNIFORM_STYLES = new HashMap<Integer, ResourceLocation>();
	public static final HashMap<Integer, ResourceLocation> AMETHYST_GLOVE_STYLES = new HashMap<Integer, ResourceLocation>();
	public static final HashMap<Integer, ResourceLocation> AMETHYST_INSIGNIA_STYLES = new HashMap<Integer, ResourceLocation>();
	private static final DataParameter<Integer> MARK_1_COLOR = EntityDataManager.<Integer>createKey(EntityAmethyst.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> MARK_1 = EntityDataManager.<Integer>createKey(EntityAmethyst.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> MARK_2_COLOR = EntityDataManager.<Integer>createKey(EntityAmethyst.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> MARK_2 = EntityDataManager.<Integer>createKey(EntityAmethyst.class, DataSerializers.VARINT);
	private static final DataParameter<Boolean> CHARGED = EntityDataManager.<Boolean>createKey(EntityAmethyst.class, DataSerializers.BOOLEAN);
	
	private static final Map<Integer, Integer> MARK1S = new LinkedHashMap<Integer, Integer>();
	static {
		MARK1S.put(0, 1);
		MARK1S.put(1, 1);

	}

	private static final Map<Integer, Integer> MARK2S = new LinkedHashMap<Integer, Integer>();
	static {
		MARK2S.put(0, 1);
		MARK2S.put(1, 1);
	}
	public static final Map<Integer, ArrayList<Integer>> SKIN_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0xB898CB);
		normal.add(0xC49EDB);
		normal.add(0xB78DD0);
		normal.add(0x7042A2);
		normal.add(0xB78DD0);
		normal.add(0xA98EC2);
		normal.add(0xD2BFE0);
		normal.add(0xE0A2CC);
		normal.add(0xFF77F5);
		normal.add(0xF5A3FF);
		normal.add(0x8E309C);
		normal.add(0xEDBFFF);
		normal.add(0xB9A7B3);
		normal.add(0xB0347A);
		normal.add(0x9A4786);
		normal.add(0x664B72);
		normal.add(0xB754B7);
		normal.add(0xDD47AF);
		normal.add(0xBB7FB1);
		SKIN_COLORS.put(0, normal);

		ArrayList<Integer> lace = new ArrayList<Integer>();
		lace.add(0xA073C5);
		lace.add(0x9F8CB7);
		lace.add(0x896FBF);
		lace.add(0xFFFBE5);
		lace.add(0xFE97FF);
		lace.add(0x8C34DB);
		SKIN_COLORS.put(1, lace);
	}
	public static final Map<Integer, ArrayList<Integer>> HAIR_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0xDBD3EF);
		normal.add(0xEAE2FF);
		normal.add(0xC1B6DF);
		normal.add(0x4B2B71);
		normal.add(0xF0D5EA);
		normal.add(0xEEE9FA);
		normal.add(0xF9CAF0);
		normal.add(0xFFC7FB);
		normal.add(0xC162D7);
		normal.add(0xF9D3FF);
		normal.add(0xDE7AE1);
		normal.add(0x8E6E98);
		normal.add(0xFFD1F3);
		normal.add(0xC07CA1);
		normal.add(0xB89FC3);
		normal.add(0x493872);
		normal.add(0xFFE9ED);
		normal.add(0xD8B4D9);
		HAIR_COLORS.put(0, normal);
		
		ArrayList<Integer> lace = new ArrayList<Integer>();
		lace.add(0x312B3B);
		lace.add(0x27242B);
		lace.add(0x3B3841);
		lace.add(0x715B88);
		lace.add(0xFCA1FF);
		HAIR_COLORS.put(1, lace);
	}
	private static final Map<Integer, ArrayList<Integer>> GLOVE_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0xFFFCD9);
		normal.add(0xFFE2D9);
		normal.add(0xFFF599);
		normal.add(0x3A1F4A);
		normal.add(0xDCD3EF);
		normal.add(0xAD859F);
		normal.add(0xFFFFFF);
		GLOVE_COLORS.put(0, normal);
		
		ArrayList<Integer> lace = new ArrayList<Integer>();
		lace.add(0xFFFCD9);
		lace.add(0xFFE2D9);
		lace.add(0xFFF599);
		lace.add(0x3A1F4A);
		lace.add(0xDCD3EF);
		lace.add(0xAD859F);
		lace.add(0xFFFFFF);
	    GLOVE_COLORS.put(1, lace);
	}
	private static final Map<Integer, ArrayList<Integer>> EYE_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0xE19BC3);
		normal.add(0xC09BE1);
		normal.add(0x280082);
		normal.add(0xFF73FD);
		normal.add(0xFFC5FD);
		normal.add(0xBE6FC7);
		normal.add(0x000000);
		EYE_COLORS.put(0, normal);
		
		ArrayList<Integer> lace = new ArrayList<Integer>();
		lace.add(0xE19BC3);
		lace.add(0xC09BE1);
		lace.add(0x280082);
		lace.add(0xFF73FD);
		lace.add(0xFFC5FD);
		lace.add(0xBE6FC7);
		lace.add(0x000000);
		EYE_COLORS.put(1, lace);
	}
	private static final Map<Integer, ArrayList<Integer>> MARK_1_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0);
		MARK_1_COLORS.put(0, normal);

		ArrayList<Integer> lace = new ArrayList<Integer>();
		lace.add(0xF9F9F8);
		lace.add(0xFAF6EE);
		lace.add(0xEBE9DD);
		lace.add(0xB670E1);
		lace.add(0xFFFED9);
		MARK_1_COLORS.put(1, lace);

	}
	
	private static final Map<Integer, ArrayList<Integer>> MARK_2_COLORS = new LinkedHashMap<Integer, ArrayList<Integer>>();
	static {
		ArrayList<Integer> normal = new ArrayList<Integer>();
		normal.add(0);
		MARK_2_COLORS.put(0, normal);

		ArrayList<Integer> lace = new ArrayList<Integer>();
		lace.add(0xE4B2E6);
		lace.add(0xE1A6D5);
		lace.add(0xCEA2C6);
		lace.add(0xE3A8D9);
		lace.add(0xD164D3);
		MARK_2_COLORS.put(1, lace);
	}
	
	private static final int NUM_HAIRSTYLES = 5;
	
	private static final int NUM_UNIFORMS = 5;
	
	private static final int NUM_GLOVES = 2;
	
	private static final int NUM_INSIGNIAS = 4;
	
	private int charge_ticks = 0;
	private int hit_count = 0;
	
	public EntityAmethyst(World worldIn) {
		super(worldIn);
		this.nativeColor = 8;
	
	    		
		//Define valid gem cuts and placements
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BACK_OF_HEAD);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.FOREHEAD);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_EYE);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_EYE);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_CHEEK);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_CHEEK);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_SHOULDER);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_SHOULDER);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_HAND);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_HAND);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BACK);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.CHEST);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.BELLY);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_THIGH);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_THIGH);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.LEFT_KNEE);
		this.setCutPlacement(GemCuts.FACETED, GemPlacements.RIGHT_KNEE);

		// Apply entity AI.
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.414D, 32.0F));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(3, new EntityAIProtectionFuse(this, EntityPearl.class, EntityOpal.class, 16D));
        this.tasks.addTask(5, new EntityAIStandGuard(this, 0.6D));
        
        // Apply targeting.
        this.targetTasks.addTask(4, new EntityAINearestAttackableTarget<EntityLiving>(this, EntityLiving.class, 10, true, false, new Predicate<EntityLiving>() {
            public boolean apply(EntityLiving input) {
                return input != null && IMob.VISIBLE_MOB_SELECTOR.apply(input);
            }
        }));
        
        // Apply entity attributes.
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12.0D);
        
        this.droppedGemItem = ModItems.AMETHYST_GEM;
		this.droppedCrackedGemItem = ModItems.CRACKED_AMETHYST_GEM;
        
        // Register entity data.
        this.dataManager.register(CHARGED, false);
    	this.dataManager.register(MARK_1_COLOR, 0);
		this.dataManager.register(MARK_1, 0);
		this.dataManager.register(MARK_2_COLOR, 0);
		this.dataManager.register(MARK_2, 0);
	}
	@Override
	public void itemDataToGemData(int data) {
		if (data == 0) {
			this.nativeColor = 8;
		} else if (data == 1) {
			this.nativeColor = 10;
		}
		this.setCustomNameTag(new TextComponentTranslation(String.format("entity.kagic.amethyst_%1$d.name", data)).getUnformattedComponentText());
		this.setSpecial(data);
		this.setMark1(this.generateMark1());
		this.setMark1Color(this.generateMark1Color());
		this.setInsigniaColor(this.nativeColor);
		this.setUniformColor(this.nativeColor);
		this.setGemColor(this.generateGemColor());
		this.setSkinColor(this.generateSkinColor());
		if (this.hasSecondMarking()) {
			this.setMark2(this.generateMark2());
			this.setMark2Color(this.generateMark2Color());
		}
	}
	/*********************************************************
	 * Methods related to entity loading.                    *
	 *********************************************************/
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		int special = this.rand.nextInt(2);
    	this.itemDataToGemData(special);
		return super.onInitialSpawn(difficulty, livingdata);
    }
	
	public void writeEntityToNBT(NBTTagCompound compound) {
        compound.setBoolean("charged", this.dataManager.get(CHARGED).booleanValue());
        compound.setInteger("charge_ticks", this.charge_ticks);
        compound.setInteger("hit_count", this.hit_count);
		compound.setInteger("mark1color", this.getMark1Color());
		compound.setInteger("mark1", this.getMark1());
		compound.setInteger("mark2color", this.getMark2Color());
		compound.setInteger("mark2", this.getMark2());
        super.writeEntityToNBT(compound);
    }
    public void readEntityFromNBT(NBTTagCompound compound) {
        this.dataManager.set(CHARGED, compound.getBoolean("charged"));
        this.charge_ticks = compound.getInteger("charge_ticks");
        this.hit_count = compound.getInteger("hit_count");
		if (compound.hasKey("mark1color")) {
			this.setMark1Color(compound.getInteger("mark1color"));
		} else {
			this.setMark1Color(this.generateMark1Color());
		}
		if (compound.hasKey("mark1")) {
			this.setMark1(compound.getInteger("mark1"));
		} else {
			this.setMark1(this.generateMark1());
		}

		if (compound.hasKey("mark2color")) {
			this.setMark2Color(compound.getInteger("mark2color"));
		} else {
			this.setMark2Color(this.generateMark2Color());
		}
		if (compound.hasKey("mark2")) {
			this.setMark2(compound.getInteger("mark2"));
		} else {
			this.setMark2(this.generateMark2());
		}
		super.readEntityFromNBT(compound);
       
    }
    protected int generateGemColor() {
		switch (this.getSpecial()) {
		case 0:
			return 0xDC64FD;
		case 1:
			return 0xA75FA9;
		default:
			return 0xDC64FD;
		}
	}
    @Override
    public void convertGems(int placement) {
    	this.setGemCut(GemCuts.FACETED.id);
    	switch (placement) {
    	case 0:
    		this.setGemPlacement(GemPlacements.CHEST.id);
    		break;
    	case 1:
    		this.setGemPlacement(GemPlacements.RIGHT_SHOULDER.id);
    		break;
    	case 2:
    		this.setGemPlacement(GemPlacements.BELLY.id);
    		break;
    	case 3:
    		this.setGemPlacement(GemPlacements.LEFT_SHOULDER.id);
    		break;
    	}
    }
	
	/*********************************************************
	 * Methods related to entity interaction.                *
	*********************************************************/
    public boolean isCharged() {
		return this.dataManager.get(CHARGED);
    }
    
	public void setCharged(boolean charged) {
		this.dataManager.set(CHARGED, charged);
	}
	
	@Override
	public void whenDefective() {
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.0D);
        this.setSize(0.82F, 1.48F);
	}
	
    /*********************************************************
     * Methods related to entity combat.                     *
     *********************************************************/
    public boolean attackEntityFrom(DamageSource source, float amount) {
    	if (source.getTrueSource() instanceof EntityLivingBase && !this.isOwner((EntityLivingBase) source.getTrueSource())) {
			this.charge_ticks += 20;
			this.hit_count += 1;
		}
		return super.attackEntityFrom(source, amount);
	}
	public boolean attackEntityAsMob(Entity entityIn) {
		if (!this.world.isRemote) {
			boolean smite = this.rand.nextInt(3) == 1;
			if (smite) {
				this.isImmuneToFire = true;
			}
			else {
				this.isImmuneToFire = false;
			}
			if (this.isCharged()) {
				AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.posX, this.posY, this.posZ, (this.posX + 1), (this.posY + 1), (this.posZ + 1))).grow(12.0, (double) this.world.getHeight(), 12.0);
	            List<EntityLivingBase> list = this.world.<EntityLivingBase>getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
	            for (EntityLivingBase entity : list) {
	            	if (!this.isOwner(entity)) {
		            	boolean shouldAttack = true;
		            	if (entity instanceof EntityGem) {
		            		EntityGem gem = (EntityGem) entity;
		            		if (this.getServitude() == gem.getServitude()) {
		            			if (this.getServitude() == EntityGem.SERVE_HUMAN) {
		            				shouldAttack = !this.isOwnerId(gem.getOwnerId());
		            			}
		            			else {
		            				shouldAttack = false;
		            			}
		            		}
		            	}
		            	if (shouldAttack) {
			            	if (smite) {
			            		EntityLightningBolt lightningBolt = new EntityLightningBolt(this.world, entity.posX, entity.posY, entity.posZ, true);
			            		this.world.addWeatherEffect(lightningBolt);
			            		entity.setFire(12);
			            	}
		            		entity.addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 80));
		    				entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80));
		    				entity.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 80));
		            	}
	            	}
	            }
	            /*if (this.getServitude() == EntityGem.SERVE_HUMAN && this.getOwner() != null) {
	            	this.getOwner().addStat(ModAchievements.STEP_OFF);
	            }*/
	        }
			else {
				if (smite) {
            		EntityLightningBolt lightningBolt = new EntityLightningBolt(this.world, entityIn.posX, entityIn.posY, entityIn.posZ, true);
            		this.world.addWeatherEffect(lightningBolt);
            		entityIn.setFire(12);
            	}
        		((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.MINING_FATIGUE, 80));
        		((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 80));
        		((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 80));
			}
		}
		
		return super.attackEntityAsMob(entityIn);
	}
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		if (!this.world.isRemote) {
			this.attackEntityAsMob(target);
		}
		super.attackEntityWithRangedAttack(target, distanceFactor);
	}
	
	/*********************************************************
	 * Methods related to entity living.                     *
	 *********************************************************/
	public void onLivingUpdate() {
		if (this.hit_count > 7) {
			this.charge_ticks -= 1;
			this.setCharged(true);

			if (this.charge_ticks < 7) {
				this.hit_count = 0;
				this.setCharged(false);
			}
		}
		super.onLivingUpdate();
	}
	/*********************************************************
     * Methods related to death.                             *
     *********************************************************/
    public void onDeath(DamageSource cause) {
    	switch (this.getSpecial()) {
    	case 0:
    		this.droppedGemItem = ModItems.COMMON_AMETHYST_GEM;
    		this.droppedCrackedGemItem = ModItems.CRACKED_COMMON_AMETHYST_GEM;
    		break;
    	case 1:
    		this.droppedGemItem = ModItems.LACE_AMETHYST_GEM;
    		this.droppedCrackedGemItem = ModItems.CRACKED_LACE_AMETHYST_GEM;
    		break;
    	default:
			this.droppedGemItem = ModItems.AMETHYST_GEM;
			this.droppedCrackedGemItem = ModItems.CRACKED_AMETHYST_GEM;
			break;
    	}
    	super.onDeath(cause);
	}
	/*********************************************************
	 * Methods related to rendering.                         *
	 *********************************************************/
	@Override
	protected int generateHairColor() {
		return Colors.arbiLerp(EntityAmethyst.HAIR_COLORS.get(this.getSpecial()));
	}
	@Override
	protected int generateSkinColor() {
		return Colors.arbiLerp(EntityAmethyst.SKIN_COLORS.get(this.getSpecial()));
	}
	@Override
	protected int generateGloveColor() {
		return Colors.arbiLerp(EntityAmethyst.GLOVE_COLORS.get(this.getSpecial()));
	}
	@Override
	protected int generateEyeColor() {
		return Colors.arbiLerp(EntityAmethyst.EYE_COLORS.get(this.getSpecial()));
	}
	protected int generateMark1Color() {
		return Colors.arbiLerp(EntityAmethyst.MARK_1_COLORS.get(this.getSpecial()));
	}
	
	protected int generateMark1() {
		return this.rand.nextInt(EntityAmethyst.MARK1S.get(this.getSpecial()));
		
	}
	
	protected int generateMark2Color() {
		return Colors.arbiLerp(EntityAmethyst.MARK_2_COLORS.get(this.getSpecial()));
	}	
	protected int generateMark2() {
		if (this.hasSecondMarking()) {
			return this.rand.nextInt(EntityAmethyst.MARK2S.get(this.getSpecial()));
		} else {
			return 0;
		}
	}
	@Override
	protected int generateHairStyle() {
		return this.rand.nextInt(EntityAmethyst.NUM_HAIRSTYLES);
	}
	@Override
	protected int generateUniformStyle() {
		return this.rand.nextInt(EntityAmethyst.NUM_UNIFORMS);
	}
	@Override
	protected int generateInsigniaStyle() {
		return this.rand.nextInt(EntityAmethyst.NUM_INSIGNIAS);
	}
	@Override
	protected int generateGloveStyle() {
		return this.rand.nextInt(EntityAmethyst.NUM_GLOVES);
	}
	@Override
	public boolean hasCape() {
		return true;
	}
	public boolean hasSecondMarking() {
		switch(this.getSpecial()) {
		case 0:
			return false;
		case 1:
			return true;
		default:
			return false;
		}
	}
	@Override
	public int getSpecial() {
		return this.dataManager.get(SPECIAL);
	}
	
	public int getMark1Color() {
		return this.dataManager.get(MARK_1_COLOR);
	}
	
	public void setMark1Color(int mark1Color) {
		this.dataManager.set(MARK_1_COLOR, mark1Color);
	}
	
	public int getMark1() {
		return this.dataManager.get(MARK_1);
	}
	
	public void setMark1(int mark1) {
		this.dataManager.set(MARK_1, mark1);
	}
	
	public int getMark2Color() {
		return this.dataManager.get(MARK_2_COLOR);
	}
	
	public void setMark2Color(int mark2Color) {
		this.dataManager.set(MARK_2_COLOR, mark2Color);
	}
	
	public int getMark2() {
		return this.dataManager.get(MARK_2);
	}
	
	public void setMark2(int mark2) {
		this.dataManager.set(MARK_2, mark2);
	}
	@Override
	public boolean hasHairVariant(GemPlacements placement) {
		switch(placement) {
		case FOREHEAD:
			return true;
		default:
			return false;
		}
	}
	/*********************************************************
	 * Methods related to entity interaction.				*
	 *********************************************************/	
	@Override
	public boolean alternateInteract(EntityPlayer player) {
		super.alternateInteract(player);
		KAGIC.instance.chatInfoMessage("Special is " + this.getSpecial());
		KAGIC.instance.chatInfoMessage("mark1Color is " + this.getMark1Color());
		KAGIC.instance.chatInfoMessage("mark1 is " + this.getMark1());
		KAGIC.instance.chatInfoMessage("mark2Color is " + this.getMark2Color());
		KAGIC.instance.chatInfoMessage("mark2 is " + this.getMark2());
		return false;
	}

	
	@SideOnly(Side.CLIENT)
    public int getBrightnessForRender() {
        return isCharged() ? 15728880 : super.getBrightnessForRender();
	}
	
    public float getBrightness() {
        return isCharged() ? 1.0F : super.getBrightness();
    }
}
