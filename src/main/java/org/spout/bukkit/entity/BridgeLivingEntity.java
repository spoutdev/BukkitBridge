/*
 * This file is part of BukkitBridge (http://www.spout.org/).
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bukkit.entity;

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

import org.spout.vanilla.controller.living.Living;

public class BridgeLivingEntity extends BridgeEntity implements LivingEntity {
	private final Living spout;

	public BridgeLivingEntity(Living spout) {
		super(spout);
		this.spout = spout;
	}

	@Override
	public int getHealth() {
		return spout.getParent().getHealth();
	}

	@Override
	public void setHealth(int health) {
		spout.getParent().setHealth(health);
	}

	@Override
	public int getMaxHealth() {
		return spout.getParent().getMaxHealth();
	}

	@Override
	public double getEyeHeight() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public double getEyeHeight(boolean b) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Location getEyeLocation() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> bytes, int i) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> bytes, int i) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> bytes, int i) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Egg throwEgg() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Snowball throwSnowball() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Arrow shootArrow() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getRemainingAir() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setRemainingAir(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getMaximumAir() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setMaximumAir(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void damage(int damage) {
		spout.damage(damage, true);
	}

	@Override
	public void damage(int i, Entity entity) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setMaximumNoDamageTicks(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getLastDamage() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setLastDamage(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getNoDamageTicks() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setNoDamageTicks(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Player getKiller() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> potionEffects) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType potionEffectType) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void removePotionEffect(PotionEffectType potionEffectType) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		return null;  //TODO: Adjust for usage with Spout!
	}
}
