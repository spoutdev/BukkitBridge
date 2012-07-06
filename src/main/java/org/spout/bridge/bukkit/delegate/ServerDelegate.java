package org.spout.bridge.bukkit.delegate;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.BlockChangeDelegate;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;
import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.bukkit.BridgeWorld;

import com.avaje.ebean.config.ServerConfig;

/**
 * The ServerDelegate is delegated to by BridgeServer. Meaning it is indirectly
 * delegated to by the entire API. The ServerDelegate is supposed to write as many
 * of the given functions as possible in terms of other functions. Functions that
 * can not be written in terms of other functions will be handed off to hook delegates
 * which will call hooks to get the necessary data from another API.
 */
@SuppressWarnings("deprecation")
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

	public String getMotd() {
		// TODO Auto-generated method stub
		return null;
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeWorld Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	public void sendPluginMessage(Plugin plugin, String channel, byte[] message) {
		// TODO Auto-generated method stub
		
	}

	public List<MetadataValue> getWorldMetadata(BridgeWorld world, String metadataKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasWorldMetadata(BridgeWorld world, String metadataKey) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeWorldMetadata(BridgeWorld world, String metadataKey, Plugin owningPlugin) {
		// TODO Auto-generated method stub
		
	}

	public void setWorldMetadata(BridgeWorld world, String metadataKey, MetadataValue newMetadataValue) {
		// TODO Auto-generated method stub
		
	}

	public boolean canGenerateStructures(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createExplosion(BridgeWorld world, double x, double y, double z, float power, boolean setFire) {
		// TODO Auto-generated method stub
		return false;
	}

	public Item dropItem(BridgeWorld world, Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item dropItemNaturally(BridgeWorld world, Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean generateTree(BridgeWorld world, Location loc, TreeType type, BlockChangeDelegate delegate) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllowAnimals(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllowMonsters(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getAnimalSpawnLimit(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Chunk getChunkAt(BridgeWorld world, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chunk getChunkAt(BridgeWorld world, Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chunk getChunkAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Difficulty getDifficulty(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChunkSnapshot getEmptyChunkSnapshot(BridgeWorld world, int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Entity> getEntities(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld world, Class<T> ...classes) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld world, Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Collection<Entity> getEntitiesByClasses(BridgeWorld world, Class<?>... classes) {
		// TODO Auto-generated method stub
		return null;
	}

	public Environment getEnvironment(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getFullTime(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ChunkGenerator getGenerator(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public Block getHighestBlockAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHighestBlockYAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean getKeepSpawnInMemory(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<LivingEntity> getLivingEntities(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chunk[] getLoadedChunks(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMaxHeight(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getPVP(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getMonsterSpawnLimit(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Player> getPlayers(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BlockPopulator> getPopulators(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSeaLevel(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getSeed(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Location getSpawnLocation(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getThunderDuration(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTicksPerAnimalSpawns(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTicksPerMonsterSpawns(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTime(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWaterAnimalSpawnLimit(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWeatherDuration(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public File getWorldFolder(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public WorldType getWorldType(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasStorm(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAutoSave(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isThundering(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public <T> void playEffect(BridgeWorld world, Location location, Effect effect, int data, int radius) {
		// TODO Auto-generated method stub
		
	}
	
	public <T> void playEffect(BridgeWorld world, Location location, Effect effect, T data, int radius) {
		// TODO Auto-generated method stub
		
	}

	public boolean refreshChunk(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean regenerateChunk(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public void save(BridgeWorld world) {
		// TODO Auto-generated method stub
		
	}

	public void setAnimalSpawnLimit(BridgeWorld world, int limit) {
		// TODO Auto-generated method stub
		
	}

	public void setAutoSave(BridgeWorld world, boolean value) {
		// TODO Auto-generated method stub
		
	}

	public void setDifficulty(BridgeWorld world, Difficulty difficulty) {
		// TODO Auto-generated method stub
		
	}

	public void setFullTime(BridgeWorld world, long time) {
		// TODO Auto-generated method stub
		
	}

	public void setKeepSpawnInMemory(BridgeWorld world, boolean keepLoaded) {
		// TODO Auto-generated method stub
		
	}

	public void setMonsterSpawnLimit(BridgeWorld world, int limit) {
		// TODO Auto-generated method stub
		
	}

	public void setPVP(BridgeWorld world, boolean pvp) {
		// TODO Auto-generated method stub
		
	}

	public void setSpawnFlags(BridgeWorld world, boolean allowMonsters, boolean allowAnimals) {
		// TODO Auto-generated method stub
		
	}

	public boolean setSpawnLocation(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setStorm(BridgeWorld world, boolean hasStorm) {
		// TODO Auto-generated method stub
		
	}

	public void setThunderDuration(BridgeWorld world, int duration) {
		// TODO Auto-generated method stub
		
	}

	public void setThundering(BridgeWorld world, boolean thundering) {
		// TODO Auto-generated method stub
		
	}

	public void setTicksPerAnimalSpawns(BridgeWorld world, int ticksPerAnimalSpawns) {
		// TODO Auto-generated method stub
		
	}

	public void setTicksPerMonsterSpawns(BridgeWorld world, int ticksPerMonsterSpawns) {
		// TODO Auto-generated method stub
		
	}

	public void setTime(BridgeWorld world, long time) {
		// TODO Auto-generated method stub
		
	}

	public void setWaterAnimalSpawnLimit(BridgeWorld world, int limit) {
		// TODO Auto-generated method stub
		
	}

	public void setWeatherDuration(BridgeWorld world, int duration) {
		// TODO Auto-generated method stub
		
	}
	
	public <T extends Entity> T spawn(BridgeWorld world, Location location, Class<T> clazz) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public Arrow spawnArrow(BridgeWorld world, Location location, Vector velocity, float speed, float spread) {
		// TODO Auto-generated method stub
		return null;
	}

	public LivingEntity spawnCreature(BridgeWorld world, Location loc, EntityType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public LivingEntity spawnCreature(BridgeWorld world, Location loc, CreatureType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Entity spawnEntity(BridgeWorld world, Location loc, EntityType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public LightningStrike strikeLightning(BridgeWorld world, Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	public LightningStrike strikeLightningEffect(BridgeWorld world, Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean unloadChunkRequest(BridgeWorld world, int x, int z, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}
	
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeChunk Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	public Block getBlockAt(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean loadChunk(BridgeWorld world, int x, int z, boolean generate) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isChunkLoaded(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unloadChunk(BridgeWorld world, int x, int z, boolean save, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld world, int x, int z, boolean includeMaxBlockY, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	public Entity[] getEntitiesAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState[] getTileEntitiesAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}
}
