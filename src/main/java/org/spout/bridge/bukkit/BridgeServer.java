package org.spout.bridge.bukkit;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
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
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.spout.bridge.bukkit.manager.ServerManager;
import org.spout.bridge.bukkit.manager.WorldManager;

import com.avaje.ebean.config.ServerConfig;

/**
 * BridgeServer is Bridge's version of Bukkit's Server.
 */
public class BridgeServer implements Server {
	
	public BridgeServer() {
	}
	
	@Override
	public boolean addRecipe(Recipe recipe) {
		return ServerManager.addRecipe(recipe);
	}

	@Override
	public void banIP(String ip) {
		ServerManager.banIP(ip);
	}

	@Override
	public int broadcast(String msg, String perm) {
		return ServerManager.broadcast(msg, perm);
	}

	@Override
	public int broadcastMessage(String msg) {
		return ServerManager.broadcast(msg);
	}

	@Override
	public void clearRecipes() {
		ServerManager.clearRecipes();
	}

	@Override
	public void configureDbConfig(ServerConfig config) {
		ServerManager.configureDbConfig(config);
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type) {
		return ServerManager.createInventory(owner, type);
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size) {
		return ServerManager.createInventory(owner, size);
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size, String title) {
		return ServerManager.createInventory(owner, size, title);
	}

	@Override
	public MapView createMap(World world) {
		return ServerManager.createMap(world);
	}

	@Override
	public World createWorld(WorldCreator creator) {
		return ServerManager.createWorld(creator);
	}

	@Override
	public boolean dispatchCommand(CommandSender source, String commandline) throws CommandException {
		return ServerManager.dispatchCommand(source, commandline);
	}

	@Override
	public boolean getAllowEnd() {
		return ServerManager.getAllowEnd();
	}

	@Override
	public boolean getAllowFlight() {
		return ServerManager.getAllowFlight();
	}

	@Override
	public boolean getAllowNether() {
		return ServerManager.getAllowNether();
	}

	@Override
	public int getAnimalSpawnLimit() {
		return ServerManager.getAnimalSpawnLimit();
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		return ServerManager.getBannedPlayers();
	}

	@Override
	public String getBukkitVersion() {
		return ServerManager.getBukkitVersion();
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		return ServerManager.getCommandAliases();
	}

	@Override
	public long getConnectionThrottle() {
		return ServerManager.getConnectionThrottle();
	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		return ServerManager.getConsoleSender();
	}

	@Override
	public GameMode getDefaultGameMode() {
		return ServerManager.getDefaultGameMode();
	}

	@Override
	public boolean getGenerateStructures() {
		return ServerManager.getGenerateStructures();
	}

	@Override
	public HelpMap getHelpMap() {
		return ServerManager.getHelpMap();
	}

	@Override
	public Set<String> getIPBans() {
		return ServerManager.getIPBans();
	}

	@Override
	public String getIp() {
		return ServerManager.getIp();
	}

	@Override
	public Logger getLogger() {
		return ServerManager.getLogger();
	}

	@Override
	public MapView getMap(short id) {
		return ServerManager.getMap(id);
	}

	@Override
	public int getMaxPlayers() {
		return ServerManager.getMaxPlayers();
	}

	@Override
	public Messenger getMessenger() {
		return ServerManager.getMessenger();
	}

	@Override
	public int getMonsterSpawnLimit() {
		return ServerManager.getMosterSpawnLimit();
	}

	@Override
	public String getName() {
		return ServerManager.getName();
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String name) {
		return ServerManager.getOfflinePlayer(name);
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		return ServerManager.getOfflinePlayers();
	}

	@Override
	public boolean getOnlineMode() {
		return ServerManager.getOnlineMode();
	}

	@Override
	public Player[] getOnlinePlayers() {
		return ServerManager.getOnlinePlayers();
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		return ServerManager.getOperators();
	}

	@Override
	public Player getPlayer(String name) {
		return ServerManager.getPlayer(name);
	}

	@Override
	public Player getPlayerExact(String name) {
		return ServerManager.getPlayerExact(name);
	}

	@Override
	public PluginCommand getPluginCommand(String name) {
		return ServerManager.getPluginCommand(name);
	}

	@Override
	public PluginManager getPluginManager() {
		return ServerManager.getPluginManager();
	}

	@Override
	public int getPort() {
		return ServerManager.getPort();
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack result) {
		return ServerManager.getRecipesFor(result);
	}

	@Override
	public BukkitScheduler getScheduler() {
		return ServerManager.getScheduler();
	}

	@Override
	public String getServerId() {
		return ServerManager.getServerId();
	}

	@Override
	public String getServerName() {
		return ServerManager.getServerName();
	}

	@Override
	public ServicesManager getServicesManager() {
		return ServerManager.getServicesManager();
	}

	@Override
	public int getSpawnRadius() {
		return ServerManager.getSpawnRadius();
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		return ServerManager.getTicksPerAnimalSpawns();
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		return ServerManager.getTicksPerMonsterSpawns();
	}

	@Override
	public String getUpdateFolder() {
		return ServerManager.getUpdateFolder();
	}

	@Override
	public File getUpdateFolderFile() {
		return ServerManager.getUpdateFolderFile();
	}

	@Override
	public String getVersion() {
		return ServerManager.getVersion();
	}

	@Override
	public int getViewDistance() {
		return ServerManager.getViewDistance();
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		return ServerManager.getWaterAnimalSpawnLimit();
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		return ServerManager.getWhitelistedPlayers();
	}

	@Override
	public World getWorld(String name) {
		return WorldManager.getWorld(name);
	}

	@Override
	public World getWorld(UUID id) {
		return WorldManager.getWorld(id);
	}

	@Override
	public File getWorldContainer() {
		return ServerManager.getWorldContainer();
	}

	@Override
	public String getWorldType() {
		return ServerManager.getWorldType();
	}

	@Override
	public List<World> getWorlds() {
		return ServerManager.getWorlds();
	}

	@Override
	public boolean hasWhitelist() {
		return ServerManager.hasWhitelist();
	}

	@Override
	public boolean isPrimaryThread() {
		return ServerManager.isPrimaryThread();
	}

	@Override
	public List<Player> matchPlayer(String name) {
		return ServerManager.matchPlayer(name);
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		return ServerManager.recipeIterator();
	}

	@Override
	public void reload() {
		ServerManager.reload();
	}

	@Override
	public void reloadWhitelist() {
		ServerManager.reloadWhitelist();
	}

	@Override
	public void resetRecipes() {
		ServerManager.resetRecipes();
	}

	@Override
	public void savePlayers() {
		ServerManager.savePlayers();
	}

	@Override
	public void setDefaultGameMode(GameMode mode) {
		ServerManager.setDefaultGameMode(mode);
	}

	@Override
	public void setSpawnRadius(int value) {
		ServerManager.setSpawnRadius(value);
	}

	@Override
	public void setWhitelist(boolean enable) {
		ServerManager.setWhitelist(enable);
	}

	@Override
	public void shutdown() {
		ServerManager.shutdown();
	}

	@Override
	public void unbanIP(String ip) {
		ServerManager.unbanIp(ip);
	}

	@Override
	public boolean unloadWorld(String name, boolean save) {
		return ServerManager.unloadWorld(name, save);
	}

	@Override
	public boolean unloadWorld(World world, boolean save) {
		return ServerManager.unloadWorld(world, save);
	}

	@Override
	public boolean useExactLoginLocation() {
		return ServerManager.useExactLoginLocation();
	}

	@Override
	public String getMotd() {
		return ServerManager.getMotd();
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
		// TODO Auto-generated method stub
		
	}
}
