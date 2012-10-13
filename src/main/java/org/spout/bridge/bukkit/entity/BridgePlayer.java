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
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Player;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;

public class BridgePlayer extends BridgeHumanEntity implements Player {
	@Override
	public String getDisplayName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setDisplayName(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getPlayerListName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
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
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public InetSocketAddress getAddress() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isConversing() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void acceptConversationInput(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean beginConversation(Conversation conversation) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
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
	public void sendRawMessage(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void kickPlayer(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void chat(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean performCommand(String s) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSneaking() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSneaking(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSprinting() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSprinting(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void saveData() {
		//To change body of implemented methods use File | Settings | File Templates.
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
		return false;  //To change body of implemented methods use File | Settings | File Templates.
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
		return false;  //To change body of implemented methods use File | Settings | File Templates.
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
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public long getPlayerTimeOffset() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isPlayerTimeRelative() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
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
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setExp(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getLevel() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setLevel(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getTotalExperience() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setTotalExperience(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getExhaustion() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setExhaustion(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getSaturation() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setSaturation(float v) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public int getFoodLevel() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setFoodLevel(int i) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isOnline() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isBanned() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setBanned(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isWhitelisted() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setWhitelisted(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Player getPlayer() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public long getFirstPlayed() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public long getLastPlayed() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasPlayedBefore() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Location getBedSpawnLocation() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setBedSpawnLocation(Location location) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean getAllowFlight() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
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
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isFlying() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
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
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public float getWalkSpeed() {
		return 0;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void sendMessage(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void sendMessage(String[] strings) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Map<String, Object> serialize() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}
}
