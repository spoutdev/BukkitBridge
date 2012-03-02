package org.spout.bukkit.bridge;

import com.avaje.ebean.config.ServerConfig;
import org.bukkit.*;
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

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

public class BridgeServer implements Server {

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getVersion() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getBukkitVersion() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Player[] getOnlinePlayers() {
        return new Player[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMaxPlayers() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getPort() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getViewDistance() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getIp() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getServerName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getServerId() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getAllowEnd() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getAllowNether() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasWhitelist() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWhitelist(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<OfflinePlayer> getWhitelistedPlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void reloadWhitelist() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int broadcastMessage(String s) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getUpdateFolder() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public File getUpdateFolderFile() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTicksPerAnimalSpawns() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getTicksPerMonsterSpawns() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Player getPlayer(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Player getPlayerExact(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Player> matchPlayer(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PluginManager getPluginManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public BukkitScheduler getScheduler() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ServicesManager getServicesManager() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<World> getWorlds() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public World createWorld(WorldCreator worldCreator) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadWorld(String s, boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadWorld(World world, boolean b) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public World getWorld(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public World getWorld(UUID uuid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MapView getMap(short i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public MapView createMap(World world) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void reload() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Logger getLogger() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PluginCommand getPluginCommand(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void savePlayers() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean dispatchCommand(CommandSender commandSender, String s) throws CommandException {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void configureDbConfig(ServerConfig serverConfig) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean addRecipe(Recipe recipe) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Recipe> getRecipesFor(ItemStack itemStack) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterator<Recipe> recipeIterator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void clearRecipes() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void resetRecipes() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Map<String, String[]> getCommandAliases() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getSpawnRadius() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setSpawnRadius(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getOnlineMode() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getAllowFlight() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean useExactLoginLocation() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void shutdown() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int broadcast(String s, String s1) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<String> getIPBans() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void banIP(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unbanIP(String s) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<OfflinePlayer> getBannedPlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<OfflinePlayer> getOperators() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public GameMode getDefaultGameMode() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDefaultGameMode(GameMode gameMode) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ConsoleCommandSender getConsoleSender() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public File getWorldContainer() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public OfflinePlayer[] getOfflinePlayers() {
        return new OfflinePlayer[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Messenger getMessenger() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public HelpMap getHelpMap() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Inventory createInventory(InventoryHolder inventoryHolder, InventoryType inventoryType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Inventory createInventory(InventoryHolder inventoryHolder, int i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Inventory createInventory(InventoryHolder inventoryHolder, int i, String s) {
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
