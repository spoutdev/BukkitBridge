package org.spout.bridge.bukkit.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public abstract class BridgeLivingEntity extends BridgeEntity implements LivingEntity {
	protected BridgeLivingEntity(org.spout.api.entity.Entity handle) {
		super(handle);
	}

	@Override
	public int getHealth() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setHealth(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getMaxHealth() {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getEyeHeight() {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getEyeHeight(boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Location getEyeLocation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> bytes, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> bytes, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> bytes, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Egg throwEgg() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Snowball throwSnowball() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Arrow shootArrow() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getRemainingAir() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setRemainingAir(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getMaximumAir() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMaximumAir(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void damage(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void damage(int i, Entity entity) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getMaximumNoDamageTicks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMaximumNoDamageTicks(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getLastDamage() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLastDamage(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getNoDamageTicks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setNoDamageTicks(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Player getKiller() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> potionEffects) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType potionEffectType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removePotionEffect(PotionEffectType potionEffectType) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasLineOfSight(Entity entity) {
		throw new UnsupportedOperationException();
	}
}
