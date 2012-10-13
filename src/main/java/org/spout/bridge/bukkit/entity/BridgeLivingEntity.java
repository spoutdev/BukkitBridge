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

public class BridgeLivingEntity extends BridgeEntity implements LivingEntity {
	@Override
	public int getHealth() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setHealth(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getMaxHealth() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double getEyeHeight() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public double getEyeHeight(boolean b) {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Location getEyeLocation() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> bytes, int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> bytes, int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> bytes, int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Egg throwEgg() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Snowball throwSnowball() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Arrow shootArrow() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getRemainingAir() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setRemainingAir(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getMaximumAir() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
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
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setMaximumNoDamageTicks(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getLastDamage() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setLastDamage(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getNoDamageTicks() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setNoDamageTicks(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Player getKiller() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> potionEffects) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType potionEffectType) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void removePotionEffect(PotionEffectType potionEffectType) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasLineOfSight(Entity entity) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
