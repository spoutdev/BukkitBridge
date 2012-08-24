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
package org.spout.bukkit.entity;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Set;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Statistic;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import org.spout.api.chat.ChatArguments;
import org.spout.bukkit.BridgeServer;
import org.spout.bukkit.util.BridgeUtil;

import org.spout.vanilla.chat.style.VanillaStyleHandler;
import org.spout.vanilla.controller.living.Living;
import org.spout.vanilla.controller.living.player.VanillaPlayer;

public class BridgePlayer extends BridgeLivingEntity implements Player {
	private final org.spout.api.player.Player spoutPlayer;

	public BridgePlayer(org.spout.api.player.Player spoutPlayer) {
		super((Living) spoutPlayer);
		this.spoutPlayer = spoutPlayer;
	}

	public VanillaPlayer getSpoutController() {
		return (VanillaPlayer) super.getSpoutController();
	}

	@Override
	public String getDisplayName() {
		return spoutPlayer.getDisplayName();
	}

	@Override
	public void setDisplayName(String s) {
		spoutPlayer.setDisplayName(s);
	}

	@Override
	public String getPlayerListName() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setPlayerListName(String s) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void setCompassTarget(Location location) {
		getSpoutController().setCompassTarget(BridgeUtil.toPoint(location));
	}

	@Override
	public Location getCompassTarget() {
		return BridgeUtil.toLocation(getSpoutController().getCompassTarget());
	}

	@Override
	public InetSocketAddress getAddress() {
		return spoutPlayer.getSession().getAddress();
	}

	@Override
	public boolean isConversing() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void acceptConversationInput(String s) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void abandonConversation(Conversation conversation) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void sendRawMessage(String s) {
		spoutPlayer.sendRawMessage(s);
	}

	@Override
	public void kickPlayer(String s) {
		spoutPlayer.kick(s);
	}

	@Override
	public void chat(String s) {
		spoutPlayer.processCommand("say", ChatArguments.fromString(s, VanillaStyleHandler.ID));
	}

	@Override
	public boolean performCommand(String s) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isSneaking() {
		return getSpoutController().isCrouching();
	}

	@Override
	public void setSneaking(boolean b) {
		getSpoutController().setCrouching(b);
	}

	@Override
	public boolean isSprinting() {
		return getSpoutController().isSprinting();
	}

	@Override
	public void setSprinting(boolean b) {
		getSpoutController().setSprinting(b);
	}

	@Override
	public void saveData() {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void loadData() {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void setSleepingIgnored(boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isSleepingIgnored() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void playNote(Location location, byte b, byte b1) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void playNote(Location location, Instrument instrument, Note note) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void playEffect(Location location, Effect effect, int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T t) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void sendBlockChange(Location location, Material material, byte b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean sendChunkChange(Location location, int i, int i1, int i2, byte[] bytes) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void sendBlockChange(Location location, int i, byte b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void sendMap(MapView mapView) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void updateInventory() {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void awardAchievement(Achievement achievement) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void incrementStatistic(Statistic statistic) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void incrementStatistic(Statistic statistic, int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void setPlayerTime(long l, boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public long getPlayerTime() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getPlayerTimeOffset() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isPlayerTimeRelative() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void resetPlayerTime() {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void giveExp(int i) {
		setExp(getExp() + i);
	}

	@Override
	public float getExp() {
		return 0;
	}

	@Override
	public void setExp(float v) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getLevel() {
		return 0; //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setLevel(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getTotalExperience() {
		return 0; //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setTotalExperience(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public float getExhaustion() {
		return getSpoutController().getExhaustion();
	}

	@Override
	public void setExhaustion(float v) {
		getSpoutController().setExhaustion(v);
	}

	@Override
	public float getSaturation() {
		return getSpoutController().getFoodSaturation();
	}

	@Override
	public void setSaturation(float v) {
		getSpoutController().setFoodSaturation(v);
	}

	@Override
	public int getFoodLevel() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setFoodLevel(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Location getBedSpawnLocation() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setBedSpawnLocation(Location location) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean getAllowFlight() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setAllowFlight(boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void hidePlayer(Player player) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void showPlayer(Player player) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean canSee(Player player) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isFlying() {
		return getSpoutController().isFlying();
	}

	@Override
	public void setFlying(boolean b) {
		getSpoutController().setFlying(b);
	}

	@Override
	public void sendMessage(String s) {
		spoutPlayer.sendMessage(s);
	}

	@Override
	public void sendMessage(String[] strings) {
		if (strings == null) {
			return;
		}
		for (String s : strings) {
			spoutPlayer.sendMessage(s);
		}
	}

	@Override
	public boolean isOnline() {
		return spoutPlayer.isOnline();
	}

	@Override
	public String getName() {
		return spoutPlayer.getName();
	}

	@Override
	public boolean isBanned() {
		return BridgeServer.getSpoutServer().isPlayerBanned(getName());
	}

	@Override
	public void setBanned(boolean banned) {
		if (banned == isBanned()) {
			return;
		}
		if (banned) {
			BridgeServer.getSpoutServer().banPlayer(getName());
		} else {
			BridgeServer.getSpoutServer().unbanPlayer(getName());
		}
	}

	@Override
	public boolean isWhitelisted() {
		for (String whitelisted : BridgeServer.getSpoutServer().getWhitelistedPlayers()) {
			if (whitelisted.equals(getName())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setWhitelisted(boolean whitelisted) {
		if (whitelisted == isWhitelisted()) {
			return;
		}
		if (whitelisted) {
			BridgeServer.getSpoutServer().whitelist(getName());
		} else {
			BridgeServer.getSpoutServer().unWhitelist(getName());
		}
	}

	@Override
	public Player getPlayer() {
		return this;
	}

	@Override
	public long getFirstPlayed() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getLastPlayed() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public PlayerInventory getInventory() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean setWindowProperty(Property property, int i) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public InventoryView getOpenInventory() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public InventoryView openInventory(Inventory itemStacks) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean b) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean b) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void openInventory(InventoryView inventoryView) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void closeInventory() {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public ItemStack getItemInHand() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setItemInHand(ItemStack itemStack) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public ItemStack getItemOnCursor() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setItemOnCursor(ItemStack itemStack) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isSleeping() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getSleepTicks() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public GameMode getGameMode() {
		return BridgeUtil.toGameMode(getSpoutController().getGameMode());
	}

	@Override
	public void setGameMode(GameMode gameMode) {
		getSpoutController().setGameMode(BridgeUtil.toVanillaGameMode(gameMode));
	}

	@Override
	public Map<String, Object> serialize() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isPermissionSet(String s) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean hasPermission(String s) {
		return spoutPlayer.hasPermission(s);
	}

	@Override
	public boolean hasPermission(Permission permission) {
		return spoutPlayer.hasPermission(permission.getName());
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void removeAttachment(PermissionAttachment permissionAttachment) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void recalculatePermissions() {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isOp() {
		return getSpoutController().isOp();
	}

	@Override
	public void setOp(boolean b) {
		getSpoutController().setOp(b);
	}

	@Override
	public boolean isBlocking() {
		return false;
		//TODO Again...Vanilla will eventually provide the answer here.
	}

	@Override
	public boolean isValid() {
		return true;  //TODO Um, not sure exactly what this means 100% but TODO :p
	}

	@Override
	public int getExpToLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getFlySpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWalkSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setFlySpeed(float arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWalkSpeed(float arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}
}
