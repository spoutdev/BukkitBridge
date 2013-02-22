/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
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
package org.spout.bridge.bukkit.entity;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;

import org.spout.bridge.bukkit.BridgeOfflinePlayer;

import org.spout.api.Server;
import org.spout.api.util.access.BanType;

import org.spout.vanilla.component.entity.inventory.PlayerInventory;
import org.spout.vanilla.component.entity.living.neutral.Human;
import org.spout.vanilla.component.entity.misc.Hunger;
import org.spout.vanilla.component.entity.misc.Level;

@DelegateDeserialization(BridgeOfflinePlayer.class)
public class BridgePlayer extends BridgeHumanEntity implements Player {
	public BridgePlayer(org.spout.api.entity.Player handle) {
		super(handle);
	}

	@Override
	public org.spout.api.entity.Player getHandle() {
		return (org.spout.api.entity.Player) getHandle();
	}

	@Override
	public String getDisplayName() {
		return getHandle().getDisplayName();
	}

	@Override
	public void setDisplayName(String name) {
		getHandle().setDisplayName(name);
	}

	@Override
	public String getPlayerListName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPlayerListName(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setCompassTarget(Location location) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Location getCompassTarget() {
		throw new UnsupportedOperationException();
	}

	@Override
	public InetSocketAddress getAddress() {
		return getHandle().getSession().getAddress();
	}

	@Override
	public boolean isConversing() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptConversationInput(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void abandonConversation(Conversation conversation) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void sendRawMessage(String message) {
		getHandle().sendRawMessage(message);
	}

	@Override
	public void kickPlayer(String msg) {
		getHandle().kick(msg);
	}

	@Override
	public void chat(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean performCommand(String cmd) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSneaking() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSneaking(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSprinting() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSprinting(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void saveData() {
		getHandle().save();
	}

	@Override
	public void loadData() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSleepingIgnored(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSleepingIgnored() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playNote(Location location, byte b, byte b1) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void playNote(Location location, Instrument instrument, Note note) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void playSound(Location location, Sound sound, float v, float v1) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void playEffect(Location location, Effect effect, int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T t) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void sendBlockChange(Location location, Material material, byte b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean sendChunkChange(Location location, int i, int i1, int i2, byte[] bytes) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendBlockChange(Location location, int i, byte b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void sendMap(MapView mapView) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void updateInventory() {
		getHandle().get(PlayerInventory.class).updateAll();
	}

	@Override
	public void awardAchievement(Achievement achievement) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void incrementStatistic(Statistic statistic) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void incrementStatistic(Statistic statistic, int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setPlayerTime(long l, boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public long getPlayerTime() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getPlayerTimeOffset() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPlayerTimeRelative() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void resetPlayerTime() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void giveExp(int i) {
		Level level = getHandle().get(Level.class);
		if (level != null) {
			level.addExperience(i);
		}
	}

	@Override
	public void giveExpLevels(int i) {
		throw new UnsupportedOperationException();
		/*
		Level level = getHandle().get(Level.class);
		if (level != null) {
			//TODO: currently no way to add a sepcific number of levels worth of exp
		}
		*/
	}

	@Override
	public float getExp() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setExp(float v) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getLevel() {
		Level level = getHandle().get(Level.class);
		return level != null ? level.getLevel() : 0;
	}

	@Override
	public void setLevel(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getTotalExperience() {
		Level level = getHandle().get(Level.class);
		return level != null ? level.getExperience() : 0;
	}

	@Override
	public void setTotalExperience(int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getExhaustion() {
		Hunger hunger = getHandle().get(Hunger.class);
		return hunger != null ? hunger.getExhaustion() : 0;
	}

	@Override
	public void setExhaustion(float v) {
		Hunger hunger = getHandle().get(Hunger.class);
		if (hunger != null) {
			hunger.setExhaustion(v);
		}
	}

	@Override
	public float getSaturation() {
		Hunger hunger = getHandle().get(Hunger.class);
		return hunger != null ? hunger.getExhaustion() : 0;
	}

	@Override
	public void setSaturation(float v) {
		Hunger hunger = getHandle().get(Hunger.class);
		if (hunger != null) {
			hunger.setFoodSaturation(v);
		}
	}

	@Override
	public int getFoodLevel() {
		Hunger hunger = getHandle().get(Hunger.class);
		return hunger != null ? hunger.getHunger() : 0;
	}

	@Override
	public void setFoodLevel(int i) {
		Hunger hunger = getHandle().get(Hunger.class);
		if (hunger != null) {
			hunger.setHunger(i);
		}
	}

	@Override
	public boolean isOnline() {
		return true;
	}

	@Override
	public boolean isBanned() {
		return ((Server) org.spout.api.Spout.getEngine()).getAccessManager().isBanned(BanType.PLAYER, getName());
	}

	@Override
	public void setBanned(boolean b) {
		if (b) {
		((Server) org.spout.api.Spout.getEngine()).getAccessManager().ban(BanType.PLAYER, getName());
		} else {
			((Server) org.spout.api.Spout.getEngine()).getAccessManager().unban(BanType.PLAYER, getName());
		}
	}

	@Override
	public boolean isWhitelisted() {
		return ((Server) org.spout.api.Spout.getEngine()).getAccessManager().isWhitelisted(getName());
	}

	@Override
	public void setWhitelisted(boolean b) {
		if (b) {
			((Server) org.spout.api.Spout.getEngine()).getAccessManager().whitelist(getName());
		} else {
			((Server) org.spout.api.Spout.getEngine()).getAccessManager().unwhitelist(getName());
		}
	}

	@Override
	public Player getPlayer() {
		return this;
	}

	@Override
	public long getFirstPlayed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getLastPlayed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPlayedBefore() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Location getBedSpawnLocation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBedSpawnLocation(Location location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBedSpawnLocation(Location location, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean getAllowFlight() {
		return getHandle().get(Human.class).canFly();
	}

	@Override
	public void setAllowFlight(boolean b) {
		getHandle().get(Human.class).setCanFly(b, true);
	}

	@Override
	public void hidePlayer(Player player) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void showPlayer(Player player) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean canSee(Player player) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isFlying() {
		return getHandle().get(Human.class).isFlying();
	}

	@Override
	public void setFlying(boolean b) {
		getHandle().get(Human.class).setFlying(b, true);
	}

	@Override
	public void setFlySpeed(float v) throws IllegalArgumentException {
		getHandle().get(Human.class).setFlyingSpeed((byte) v, true); //TODO: Check speed conversion loss float -> byte
	}

	@Override
	public void setWalkSpeed(float v) throws IllegalArgumentException {
		getHandle().get(Human.class).setWalkingSpeed((byte) v, true); //TODO: Check speed conversion loss float -> byte
	}

	@Override
	public float getFlySpeed() {
		return getHandle().get(Human.class).getFlyingSpeed(); //TODO: possible speed conversion issue
	}

	@Override
	public float getWalkSpeed() {
		return getHandle().get(Human.class).getWalkingSpeed(); //TODO: possible speed conversion issue
	}

	@Override
	public void setTexturePack(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendMessage(String message) {
		getHandle().sendMessage(message);
	}

	@Override
	public void sendMessage(String[] message) {
		getHandle().sendMessage((Object[]) message);
	}

	@Override
	public Map<String, Object> serialize() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		throw new UnsupportedOperationException();
	}

	@Override
	public EntityType getType() {
		return EntityType.PLAYER;
	}
}
