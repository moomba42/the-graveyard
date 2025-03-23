package com.finallion.graveyard.entities;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Ravager;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.raid.Raider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;

public abstract class CorruptedIllager extends HordeGraveyardEntity {

    public CorruptedIllager(EntityType<? extends CorruptedIllager> entityType, Level world, String name) {
        super(entityType, world, name);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
       // this.goalSelector.addGoal(2, new PatrolApproachGoal(this, 10.0F));
        this.goalSelector.addGoal(3, new AttackGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this, new Class[]{Raider.class})).setAlertOthers());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, AbstractVillager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, IronGolem.class, true));
        this.goalSelector.addGoal(8, new WaterAvoidingRandomStrollGoal(this, 0.6D));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 3.0F, 1.0F));
        this.goalSelector.addGoal(10, new LookAtPlayerGoal(this, Mob.class, 8.0F));
    }

    // TODO: Reintroduce this
//    @Override
//    public MobType getMobType() {
//        return MobType.ILLAGER;
//    }

    public boolean canAttack(LivingEntity p_186270_) {
        return p_186270_ instanceof AbstractVillager && p_186270_.isBaby() ? false : super.canAttack(p_186270_);
    }

    protected void customServerAiStep() {
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this)) {
            boolean flag = ((ServerLevel)this.level()).isRaided(this.blockPosition());
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(flag);
        }

        super.customServerAiStep();
    }



    public boolean canBeLeader() {
        return false;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.3499999940395355D)
                .add(Attributes.FOLLOW_RANGE, 12.0D)
                .add(Attributes.ATTACK_DAMAGE, 5.0D)
                .add(Attributes.MAX_HEALTH, 24.0D);
    }


    public State getState() {
        if (this.isAggressive()) {
            return State.ATTACKING;
        } else {
            return State.CROSSED;
        }
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        RandomSource randomSource = level.getRandom();
        spawnGroupData = super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
        ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        this.populateDefaultEquipmentSlots(randomSource, difficulty);
        this.populateDefaultEquipmentEnchantments(level, randomSource, difficulty);

        return spawnGroupData;
    }


    public boolean isModelDamaged() {
        return false;
    }

    class AttackGoal extends MeleeAttackGoal {
        public AttackGoal(CorruptedIllager illager) {
            super(illager, 1.0D, false);
        }

        // TODO: Reintroduce this
//        @Override
//        protected double getAttackReachSqr(LivingEntity entity) {
//            if (this.mob.getVehicle() instanceof Ravager) {
//                float f = this.mob.getVehicle().getBbWidth() - 0.1F;
//                return f * 2.0F * f * 2.0F + entity.getBbWidth();
//            } else {
//                return super.getAttackReachSqr(entity);
//            }
//        }
    }

    public enum State {
        CROSSED,
        ATTACKING,
        SPELLCASTING,
        BOW_AND_ARROW,
        CROSSBOW_HOLD,
        CROSSBOW_CHARGE,
        CELEBRATING,
        UNDEAD,
        UNDEAD_ATTACKING,
        NEUTRAL;

        private State() {
        }
    }

}

