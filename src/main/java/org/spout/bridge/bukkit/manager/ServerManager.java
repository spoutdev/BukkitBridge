package org.spout.bridge.bukkit.manager;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
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
import org.spout.bridge.bukkit.command.BridgeConsoleCommandSender;

import com.avaje.ebean.config.ServerConfig;

public class ServerManager {
	private static final BridgeConsoleCommandSender console;
	
	static {
		console = new BridgeConsoleCommandSender((BridgeServer) Bukkit.getServer());
	}
	
	public static void banIP(String ip) {
		BanManager.banIP(ip);
	}

	public static int broadcast(String msg) {
		return broadcast(msg, null);
	}

	public static int broadcast(String msg, String perm) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void clearRecipes() {
		// TODO Auto-generated method stub
		
	}

	public static boolean addRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void configureDbConfig(ServerConfig config) {
		// TODO Auto-generated method stub
		
	}

	public static Inventory createInventory(InventoryHolder owner, InventoryType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Inventory createInventory(InventoryHolder owner, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Inventory createInventory(InventoryHolder owner, int size, String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public static MapView createMap(World world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static World createWorld(WorldCreator creator) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean dispatchCommand(CommandSender source, String commandline) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean getAllowEnd() {
		return ConfigurationManager.getAllowEnd();
	}

	public static boolean getAllowFlight() {
		return ConfigurationManager.getAllowFlight();
	}

	public static boolean getAllowNether() {
		return ConfigurationManager.getAllowNether();
	}

	public static int getAnimalSpawnLimit() {
		return ConfigurationManager.getAnimalSpawnLimit();
	}

	public static Set<OfflinePlayer> getBannedPlayers() {
		return BanManager.getBannedPlayers();
	}

	public static String getBukkitVersion() {
		return "Zl5i:Y3x&G"; //'cuz I can :P
	}

	public static Map<String, String[]> getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	public static long getConnectionThrottle() {
		return ConfigurationManager.getConnectionThrottle();
	}

	public static ConsoleCommandSender getConsoleSender() {
		return console;
	}

	public static GameMode getDefaultGameMode() {
		return ConfigurationManager.getDefaultGameMode();
	}

	public static boolean getGenerateStructures() {
		return ConfigurationManager.getGenerateStructures();
	}

	public static HelpMap getHelpMap() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Set<String> getIPBans() {
		return BanManager.getIPBans();
	}

	public static String getIp() {
		return ConfigurationManager.getIp();
	}

	public static Logger getLogger() {
		// TODO Auto-generated method stub
		return null;
	}

	public static MapView getMap(short id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getMaxPlayers() {
		return ConfigurationManager.getMaxPlayers();
	}

	public static int getMosterSpawnLimit() {
		return ConfigurationManager.getMonsterSpawnLimit();
	}

	public static String getName() {
		return getServerName();
	}

	public static Messenger getMessenger() {
		// TODO Auto-generated method stub
		return null;
	}

	public static OfflinePlayer getOfflinePlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static OfflinePlayer[] getOfflinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean getOnlineMode() {
		return ConfigurationManager.getOnlineMode();
	}

	public static Player[] getOnlinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Set<OfflinePlayer> getOperators() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Player getPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Player getPlayerExact(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static PluginCommand getPluginCommand(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static PluginManager getPluginManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getPort() {
		return ConfigurationManager.getPort();
	}

	public static List<Recipe> getRecipesFor(ItemStack result) {
		// TODO Auto-generated method stub
		return null;
	}

	public static BukkitScheduler getScheduler() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getServerId() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public static ServicesManager getServicesManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getSpawnRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static String getUpdateFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	public static File getUpdateFolderFile() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getViewDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Set<OfflinePlayer> getWhitelistedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public static File getWorldContainer() {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getWorldType() {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<World> getWorlds() {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean hasWhitelist() {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isPrimaryThread() {
		// TODO Auto-generated method stub
		return false;
	}

	public static List<Player> matchPlayer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Iterator<Recipe> recipeIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void reload() {
		// TODO Auto-generated method stub

	}

	public static void reloadWhitelist() {
		// TODO Auto-generated method stub

	}

	public static void resetRecipes() {
		// TODO Auto-generated method stub
		
	}

	public static void savePlayers() {
		// TODO Auto-generated method stub
		
	}

	public static void setDefaultGameMode(GameMode mode) {
		// TODO Auto-generated method stub
		
	}

	public static void setSpawnRadius(int value) {
		// TODO Auto-generated method stub
		
	}

	public static void setWhitelist(boolean enable) {
		// TODO Auto-generated method stub
		
	}

	public static void shutdown() {
		// TODO Auto-generated method stub
		
	}

	public static void unbanIp(String ip) {
		// TODO Auto-generated method stub
		
	}

	public static boolean unloadWorld(String name, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean unloadWorld(World world, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean useExactLoginLocation() {
		// TODO Auto-generated method stub
		return false;
	}

	public static String getMotd() {
		// TODO Auto-generated method stub
		return null;
	}
}
