/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012 Spout LLC <http://www.spout.org/>
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
import org.bukkit.WeatherType;
import org.bukkit.configuration.serialization.DelegateDeserialization;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.Scoreboard;

import org.spout.api.Server;
import org.spout.api.util.access.BanType;

import org.spout.bridge.BukkitUtil;
import org.spout.bridge.bukkit.BridgeOfflinePlayer;

import org.spout.vanilla.component.entity.inventory.PlayerInventory;
import org.spout.vanilla.component.entity.living.Human;
import org.spout.vanilla.component.entity.misc.Hunger;
import org.spout.vanilla.component.entity.misc.Level;
import org.spout.vanilla.data.VanillaData;

@DelegateDeserialization(BridgeOfflinePlayer.class)
public class BridgePlayer extends BridgeHumanEntity implements Player {
	public BridgePlayer(org.spout.api.entity.Player handle) {
		super(handle);
	}

	@Override
	public org.spout.api.entity.Player getHandle() {
		return getHandle();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCompassTarget(Location location) {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void abandonConversation(Conversation conversation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendRawMessage(String message) {
        throw new UnsupportedOperationException();
	}

	@Override
	public void kickPlayer(String msg) {
		getHandle().kick(msg);
	}

	@Override
	public void chat(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean performCommand(String cmd) {
		BukkitUtil.processCommand(getHandle(), cmd);
		return true;
	}

	@Override
	public boolean isSneaking() {
		return getHandle().getData().get(VanillaData.IS_SNEAKING);
	}

	@Override
	public void setSneaking(boolean b) {
		getHandle().getData().put(VanillaData.IS_SNEAKING, b);
	}

	@Override
	public boolean isSprinting() {
		return getHandle().getData().get(VanillaData.IS_SPRINTING);
	}

	@Override
	public void setSprinting(boolean b) {
		getHandle().getData().put(VanillaData.IS_SPRINTING, b);
	}

	@Override
	public void saveData() {
		getHandle().save();
	}

	@Override
	public void loadData() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSleepingIgnored(boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isSleepingIgnored() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playNote(Location location, byte b, byte b1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playNote(Location location, Instrument instrument, Note note) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playSound(Location location, Sound sound, float v, float v1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playEffect(Location location, Effect effect, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T t) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendBlockChange(Location location, Material material, byte b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean sendChunkChange(Location location, int i, int i1, int i2, byte[] bytes) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendBlockChange(Location location, int i, byte b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendMap(MapView mapView) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void updateInventory() {
		getHandle().get(PlayerInventory.class).updateAll();
	}

	@Override
	public void awardAchievement(Achievement achievement) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void incrementStatistic(Statistic statistic) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void incrementStatistic(Statistic statistic, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPlayerTime(long l, boolean b) {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPlayerWeather(WeatherType weatherType) {
		throw new UnsupportedOperationException();
	}

	@Override
	public WeatherType getPlayerWeather() {
		throw new UnsupportedOperationException();
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
		Level level = getHandle().get(Level.class);
		if (level != null) {
			level.addLevel(i);
		}
	}

	@Override
	public float getExp() {
		Level level = getHandle().get(Level.class);
		return level != null ? level.getProgress() : 0;
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
		Level level = getHandle().get(Level.class);
		if (level != null) {
			level.addLevel(i - level.getLevel());
		}
	}

	@Override
	public int getTotalExperience() {
		Level level = getHandle().get(Level.class);
		return level != null ? level.getExperience() : 0;
	}

	@Override
	public void setTotalExperience(int i) {
		Level level = getHandle().get(Level.class);
		if (level != null) {
			level.setExperience((short) i);
		}
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
		return ((Server) getHandle().getEngine()).getAccessManager().isBanned(BanType.PLAYER, getName());
	}

	@Override
	public void setBanned(boolean b) {
		if (b) {
			((Server) getHandle().getEngine()).getAccessManager().ban(BanType.PLAYER, getName());
		} else {
			((Server) getHandle().getEngine()).getAccessManager().unban(BanType.PLAYER, getName());
		}
	}

	@Override
	public boolean isWhitelisted() {
		return ((Server) getHandle().getEngine()).getAccessManager().isWhitelisted(getName());
	}

	@Override
	public void setWhitelisted(boolean b) {
		if (b) {
			((Server) getHandle().getEngine()).getAccessManager().whitelist(getName());
		} else {
			((Server) getHandle().getEngine()).getAccessManager().unwhitelist(getName());
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
	public Scoreboard getScoreboard() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setScoreboard(Scoreboard scoreboard) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isHealthScaled() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setHealthScaled(boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setHealthScale(double v) throws IllegalArgumentException {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getHealthScale() {
		throw new UnsupportedOperationException();
	}

    @Override
	public void sendMessage(String message) {
		getHandle().sendMessage(message);
	}

	@Override
	public void sendMessage(String[] message) {
        throw new UnsupportedOperationException();
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

	@Override
	public void resetPlayerWeather() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
		return getHandle().getName();
	}
}
