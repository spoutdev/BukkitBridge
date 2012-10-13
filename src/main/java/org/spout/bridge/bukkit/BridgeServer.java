package org.spout.bridge.bukkit;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.Warning.WarningState;
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
import org.bukkit.plugin.SimpleServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.spout.api.util.access.BanType;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.bridge.bukkit.scheduler.BridgeScheduler;
import org.spout.vanilla.configuration.VanillaConfiguration;
import org.spout.vanilla.configuration.WorldConfiguration;
import org.spout.vanilla.inventory.recipe.VanillaRecipes;

import com.avaje.ebean.config.ServerConfig;

/**
 * BridgeServer is Bridge's version of Bukkit's Server.
 */
public class BridgeServer implements Server {
	private final VanillaBridgePlugin plugin;
	private final org.spout.api.Server server;
	private final SimpleServicesManager servicesManager = new SimpleServicesManager();
	private final BridgeScheduler scheduler = new BridgeScheduler();
	public BridgeServer(org.spout.api.Server server, VanillaBridgePlugin plugin) {
		this.server = server;
		this.plugin = plugin;
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

	@Override
	public boolean addRecipe(Recipe recipe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void banIP(String ip) {
		server.getAccessManager().ban(BanType.IP, ip);
	}

	@Override
	public int broadcast(String perm, String message) {
		server.broadcastMessage(perm, message);
		return 0;
	}

	@Override
	public int broadcastMessage(String message) {
		server.broadcastMessage(message);
		return 0;
	}

	@Override
	public void clearRecipes() {
		for (org.spout.api.inventory.recipe.Recipe r : server.getRecipeManager().getAllRecipes()) {
			server.getRecipeManager().removeRecipe(r);
		}
	}

	@Override
	public void configureDbConfig(ServerConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Inventory createInventory(InventoryHolder arg0, InventoryType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory createInventory(InventoryHolder arg0, int arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapView createMap(World arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World createWorld(WorldCreator arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean dispatchCommand(CommandSender arg0, String arg1) throws CommandException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowEnd() {
		return WorldConfiguration.END.LOAD.getBoolean();
	}

	@Override
	public boolean getAllowFlight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowNether() {
		return WorldConfiguration.NETHER.LOAD.getBoolean();
	}

	@Override
	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getBukkitVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getConnectionThrottle() {
		return 0;
	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameMode getDefaultGameMode() {
		return GameMode.valueOf(WorldConfiguration.NORMAL.GAMEMODE.getString().toUpperCase());
	}

	@Override
	public boolean getGenerateStructures() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HelpMap getHelpMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getIPBans() {
		throw new UnsupportedOperationException("Not supported");
	}

	@Override
	public String getIp() {
		return "";
	}

	@Override
	public Logger getLogger() {
		return server.getLogger();
	}

	@Override
	public MapView getMap(short arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxPlayers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Messenger getMessenger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMonsterSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMotd() {
		return VanillaConfiguration.MOTD.getString();
	}

	@Override
	public String getName() {
		return server.getName();
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getOnlineMode() {
		return VanillaConfiguration.ONLINE_MODE.getBoolean();
	}

	@Override
	public Player[] getOnlinePlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayerExact(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginCommand getPluginCommand(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PluginManager getPluginManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BukkitScheduler getScheduler() {
		return scheduler;
	}

	@Override
	public String getServerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServicesManager getServicesManager() {
		return servicesManager;
	}

	@Override
	public int getSpawnRadius() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUpdateFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getUpdateFolderFile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getViewDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		HashSet<OfflinePlayer> set = new HashSet<OfflinePlayer>();
		for (String name : server.getAccessManager().getWhitelistedPlayers()) {
			set.add(getOfflinePlayer(name));
		}
		return set;
	}

	@Override
	public World getWorld(String name) {
		for (World w : getWorlds()) {
			if (w.getName().equals(name)) {
				return w;
			}
		}
		return null;
	}

	@Override
	public World getWorld(UUID uid) {
		for (World w : getWorlds()) {
			if (w.getUID().equals(uid)) {
				return w;
			}
		}
		return null;
	}

	@Override
	public File getWorldContainer() {
		return server.getWorldFolder();
	}

	@Override
	public String getWorldType() {
		return "DEFAULT";
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<World> getWorlds() {
		return (List<World>)(List)plugin.getWorldListener().getWorlds();
	}

	@Override
	public boolean hasWhitelist() {
		return server.getAccessManager().isWhitelistEnabled();
	}

	@Override
	public boolean isPrimaryThread() {
		return server.getMainThread() == Thread.currentThread();
	}

	@Override
	public List<Player> matchPlayer(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reload() {
	}

	@Override
	public void reloadWhitelist() {
		server.getAccessManager().load();
	}

	@Override
	public void resetRecipes() {
		this.clearRecipes();
		VanillaRecipes.initialize();
	}

	@Override
	public void savePlayers() {
		for (org.spout.api.entity.Player p : server.getOnlinePlayers()) {
			p.save();
		}
	}

	@Override
	public void setDefaultGameMode(GameMode mode) {
		WorldConfiguration.NORMAL.GAMEMODE.setValue(mode.name().toLowerCase());
		WorldConfiguration.FLAT.GAMEMODE.setValue(mode.name().toLowerCase());
		WorldConfiguration.NETHER.GAMEMODE.setValue(mode.name().toLowerCase());
		WorldConfiguration.END.GAMEMODE.setValue(mode.name().toLowerCase());
	}

	@Override
	public void setSpawnRadius(int r) {
		VanillaConfiguration.SPAWN_PROTECTION_RADIUS.setValue(r);
	}

	@Override
	public void setWhitelist(boolean whitelisted) {
		server.getAccessManager().setWhitelistEnabled(whitelisted);
	}

	@Override
	public void shutdown() {
		server.stop();
	}

	@Override
	public void unbanIP(String ip) {
		server.getAccessManager().unban(BanType.IP, ip);
	}

	@Override
	public boolean unloadWorld(String name, boolean save) {
		return unloadWorld(getWorld(name), save);
	}

	@Override
	public boolean unloadWorld(World world, boolean save) {
		if (world != null) {
			((BridgeWorld)world).getHandle().unload(save);
			return true;
		}
		return false;
	}

	@Override
	public boolean useExactLoginLocation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WarningState getWarningState() {
		return WarningState.DEFAULT;
	}
}
