package org.spout.bridge.bukkit.delegate;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.spout.bridge.bukkit.BridgeServer;

import com.avaje.ebean.config.ServerConfig;

/**
 * The ServerDelegate is delegated to by BridgeServer. It is indirectly delegated to by
 * BridgeWorld, BridgeChunk, and BridgeBlock.
 */
public class ServerDelegate extends Delegate<BridgeServer> {

	public void banIP(String ip) {
		// TODO Auto-generated method stub
		
	}

	public int broadcast(String msg) {
		return broadcast(msg, null);
	}

	public int broadcast(String msg, String perm) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void clearRecipes() {
		// TODO Auto-generated method stub
		
	}

	public boolean addRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	public void configureDbConfig(ServerConfig config) {
		// TODO Auto-generated method stub
		
	}

	public Inventory createInventory(InventoryHolder owner, InventoryType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Inventory createInventory(InventoryHolder owner, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	public Inventory createInventory(InventoryHolder owner, int size, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public MapView createMap(World world) {
		// TODO Auto-generated method stub
		return null;
	}

	public World createWorld(WorldCreator creator) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean dispatchCommand(CommandSender source, String commandline) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllowEnd() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllowFlight() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllowNether() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<OfflinePlayer> getBannedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBukkitVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String[]> getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getConnectionThrottle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ConsoleCommandSender getConsoleSender() {
		// TODO Auto-generated method stub
		return null;
	}

	public GameMode getDefaultGameMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getGenerateStructures() {
		// TODO Auto-generated method stub
		return false;
	}

	public HelpMap getHelpMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getIPBans() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	public Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	public MapView getMap(short id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMaxPlayers() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getMosterSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Messenger getMessenger() {
		// TODO Auto-generated method stub
		return null;
	}

	public OfflinePlayer getOfflinePlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public OfflinePlayer[] getOfflinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getOnlineMode() {
		// TODO Auto-generated method stub
		return false;
	}

	public Player[] getOnlinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<OfflinePlayer> getOperators() {
		// TODO Auto-generated method stub
		return null;
	}

	public Player getPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Player getPlayerExact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public PluginCommand getPluginCommand(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public PluginManager getPluginManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Recipe> getRecipesFor(ItemStack result) {
		// TODO Auto-generated method stub
		return null;
	}

	public BukkitScheduler getScheduler() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServerId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServicesManager getServicesManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSpawnRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getUpdateFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	public File getUpdateFolderFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getViewDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Set<OfflinePlayer> getWhitelistedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public World getWorld(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public World getWorld(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	public File getWorldContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWorldType() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<World> getWorlds() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasWhitelist() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPrimaryThread() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Player> matchPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<Recipe> recipeIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void reload() {
		// TODO Auto-generated method stub

	}

	public void reloadWhitelist() {
		// TODO Auto-generated method stub

	}

	public void resetRecipes() {
		// TODO Auto-generated method stub
		
	}

	public void savePlayers() {
		// TODO Auto-generated method stub
		
	}

	public void setDefaultGameMode(GameMode mode) {
		// TODO Auto-generated method stub
		
	}

	public void setSpawnRadius(int value) {
		// TODO Auto-generated method stub
		
	}

	public void setWhitelist(boolean enable) {
		// TODO Auto-generated method stub
		
	}

	public void shutdown() {
		// TODO Auto-generated method stub
		
	}

	public void unbanIp(String ip) {
		// TODO Auto-generated method stub
		
	}

	public boolean unloadWorld(String name, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unloadWorld(World world, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean useExactLoginLocation() {
		// TODO Auto-generated method stub
		return false;
	}

}
