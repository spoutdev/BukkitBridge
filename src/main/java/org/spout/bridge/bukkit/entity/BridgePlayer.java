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
		throw new UnsupportedOperationException();
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
		//To change body of implemented methods use File | Settings | File Templates.
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
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getExp() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setExp(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getLevel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setLevel(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getTotalExperience() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTotalExperience(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getExhaustion() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setExhaustion(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getSaturation() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSaturation(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getFoodLevel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFoodLevel(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isOnline() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isBanned() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBanned(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isWhitelisted() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWhitelisted(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
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
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getAllowFlight() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAllowFlight(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void hidePlayer(Player player) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void showPlayer(Player player) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean canSee(Player player) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isFlying() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setFlying(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setFlySpeed(float v) throws IllegalArgumentException {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setWalkSpeed(float v) throws IllegalArgumentException {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getFlySpeed() {
		throw new UnsupportedOperationException();
	}

	@Override
	public float getWalkSpeed() {
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
		//To change body of implemented methods use File | Settings | File Templates.
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
