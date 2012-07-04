package org.spout.bridge.bukkit;

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
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.command.CommandException;
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
import org.spout.bridge.bukkit.delegate.ServerDelegate;

import com.avaje.ebean.config.ServerConfig;

@SuppressWarnings("deprecation")
public class BridgeServer implements Server {
	private ServerDelegate delegate;
	
	public BridgeServer() {
		delegate = new ServerDelegate();
		delegate.setDelegator(this);
	}
	
	public ServerDelegate getDelegate() {
		return delegate;
	}
	
	@Override
	public boolean addRecipe(Recipe recipe) {
		return getDelegate().addRecipe(recipe);
	}

	@Override
	public void banIP(String ip) {
		getDelegate().banIP(ip);
	}

	@Override
	public int broadcast(String msg, String perm) {
		return getDelegate().broadcast(msg, perm);
	}

	@Override
	public int broadcastMessage(String msg) {
		return getDelegate().broadcast(msg);
	}

	@Override
	public void clearRecipes() {
		getDelegate().clearRecipes();
	}

	@Override
	public void configureDbConfig(ServerConfig config) {
		getDelegate().configureDbConfig(config);
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, InventoryType type) {
		return getDelegate().createInventory(owner, type);
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size) {
		return getDelegate().createInventory(owner, size);
	}

	@Override
	public Inventory createInventory(InventoryHolder owner, int size, String title) {
		return getDelegate().createInventory(owner, size, title);
	}

	@Override
	public MapView createMap(World world) {
		return getDelegate().createMap(world);
	}

	@Override
	public World createWorld(WorldCreator creator) {
		return getDelegate().createWorld(creator);
	}

	@Override
	public boolean dispatchCommand(CommandSender source, String commandline) throws CommandException {
		return getDelegate().dispatchCommand(source, commandline);
	}

	@Override
	public boolean getAllowEnd() {
		return getDelegate().getAllowEnd();
	}

	@Override
	public boolean getAllowFlight() {
		return getDelegate().getAllowFlight();
	}

	@Override
	public boolean getAllowNether() {
		return getDelegate().getAllowNether();
	}

	@Override
	public int getAnimalSpawnLimit() {
		return getDelegate().getAnimalSpawnLimit();
	}

	@Override
	public Set<OfflinePlayer> getBannedPlayers() {
		return getDelegate().getBannedPlayers();
	}

	@Override
	public String getBukkitVersion() {
		return getDelegate().getBukkitVersion();
	}

	@Override
	public Map<String, String[]> getCommandAliases() {
		return getDelegate().getCommandAliases();
	}

	@Override
	public long getConnectionThrottle() {
		return getDelegate().getConnectionThrottle();
	}

	@Override
	public ConsoleCommandSender getConsoleSender() {
		return getDelegate().getConsoleSender();
	}

	@Override
	public GameMode getDefaultGameMode() {
		return getDelegate().getDefaultGameMode();
	}

	@Override
	public boolean getGenerateStructures() {
		return getDelegate().getGenerateStructures();
	}

	@Override
	public HelpMap getHelpMap() {
		return getDelegate().getHelpMap();
	}

	@Override
	public Set<String> getIPBans() {
		return getDelegate().getIPBans();
	}

	@Override
	public String getIp() {
		return getDelegate().getIp();
	}

	@Override
	public Logger getLogger() {
		return getDelegate().getLogger();
	}

	@Override
	public MapView getMap(short id) {
		return getDelegate().getMap(id);
	}

	@Override
	public int getMaxPlayers() {
		return getDelegate().getMaxPlayers();
	}

	@Override
	public Messenger getMessenger() {
		return getDelegate().getMessenger();
	}

	@Override
	public int getMonsterSpawnLimit() {
		return getDelegate().getMosterSpawnLimit();
	}

	@Override
	public String getName() {
		return getDelegate().getName();
	}

	@Override
	public OfflinePlayer getOfflinePlayer(String name) {
		return getDelegate().getOfflinePlayer(name);
	}

	@Override
	public OfflinePlayer[] getOfflinePlayers() {
		return getDelegate().getOfflinePlayers();
	}

	@Override
	public boolean getOnlineMode() {
		return getDelegate().getOnlineMode();
	}

	@Override
	public Player[] getOnlinePlayers() {
		return getDelegate().getOnlinePlayers();
	}

	@Override
	public Set<OfflinePlayer> getOperators() {
		return getDelegate().getOperators();
	}

	@Override
	public Player getPlayer(String name) {
		return getDelegate().getPlayer(name);
	}

	@Override
	public Player getPlayerExact(String name) {
		return getDelegate().getPlayerExact(name);
	}

	@Override
	public PluginCommand getPluginCommand(String name) {
		return getDelegate().getPluginCommand(name);
	}

	@Override
	public PluginManager getPluginManager() {
		return getDelegate().getPluginManager();
	}

	@Override
	public int getPort() {
		return getDelegate().getPort();
	}

	@Override
	public List<Recipe> getRecipesFor(ItemStack result) {
		return getDelegate().getRecipesFor(result);
	}

	@Override
	public BukkitScheduler getScheduler() {
		return getDelegate().getScheduler();
	}

	@Override
	public String getServerId() {
		return getDelegate().getServerId();
	}

	@Override
	public String getServerName() {
		return getDelegate().getServerName();
	}

	@Override
	public ServicesManager getServicesManager() {
		return getDelegate().getServicesManager();
	}

	@Override
	public int getSpawnRadius() {
		return getDelegate().getSpawnRadius();
	}

	@Override
	public int getTicksPerAnimalSpawns() {
		return getDelegate().getTicksPerAnimalSpawns();
	}

	@Override
	public int getTicksPerMonsterSpawns() {
		return getDelegate().getTicksPerMonsterSpawns();
	}

	@Override
	public String getUpdateFolder() {
		return getDelegate().getUpdateFolder();
	}

	@Override
	public File getUpdateFolderFile() {
		return getDelegate().getUpdateFolderFile();
	}

	@Override
	public String getVersion() {
		return getDelegate().getVersion();
	}

	@Override
	public int getViewDistance() {
		return getDelegate().getViewDistance();
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		return getDelegate().getWaterAnimalSpawnLimit();
	}

	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers() {
		return getDelegate().getWhitelistedPlayers();
	}

	@Override
	public World getWorld(String name) {
		return getDelegate().getWorld(name);
	}

	@Override
	public World getWorld(UUID id) {
		return getDelegate().getWorld(id);
	}

	@Override
	public File getWorldContainer() {
		return getDelegate().getWorldContainer();
	}

	@Override
	public String getWorldType() {
		return getDelegate().getWorldType();
	}

	@Override
	public List<World> getWorlds() {
		return getDelegate().getWorlds();
	}

	@Override
	public boolean hasWhitelist() {
		return getDelegate().hasWhitelist();
	}

	@Override
	public boolean isPrimaryThread() {
		return getDelegate().isPrimaryThread();
	}

	@Override
	public List<Player> matchPlayer(String name) {
		return getDelegate().matchPlayer(name);
	}

	@Override
	public Iterator<Recipe> recipeIterator() {
		return getDelegate().recipeIterator();
	}

	@Override
	public void reload() {
		getDelegate().reload();
	}

	@Override
	public void reloadWhitelist() {
		getDelegate().reloadWhitelist();
	}

	@Override
	public void resetRecipes() {
		getDelegate().resetRecipes();
	}

	@Override
	public void savePlayers() {
		getDelegate().savePlayers();
	}

	@Override
	public void setDefaultGameMode(GameMode mode) {
		getDelegate().setDefaultGameMode(mode);
	}

	@Override
	public void setSpawnRadius(int value) {
		getDelegate().setSpawnRadius(value);
	}

	@Override
	public void setWhitelist(boolean enable) {
		getDelegate().setWhitelist(enable);
	}

	@Override
	public void shutdown() {
		getDelegate().shutdown();
	}

	@Override
	public void unbanIP(String ip) {
		getDelegate().unbanIp(ip);
	}

	@Override
	public boolean unloadWorld(String name, boolean save) {
		return getDelegate().unloadWorld(name, save);
	}

	@Override
	public boolean unloadWorld(World world, boolean save) {
		return getDelegate().unloadWorld(world, save);
	}

	@Override
	public boolean useExactLoginLocation() {
		return getDelegate().useExactLoginLocation();
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeWorld Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	@Override
	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendPluginMessage(Plugin arg0, String arg1, byte[] arg2) {
		// TODO Auto-generated method stub
		
	}

	public List<MetadataValue> getWorldMetadata(BridgeWorld bridgeWorld, String metadataKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasWorldMetdata(BridgeWorld bridgeWorld, String metadataKey) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeWorldMetadata(BridgeWorld bridgeWorld, String metadataKey, Plugin owningPlugin) {
		// TODO Auto-generated method stub
		
	}

	public void setWorldMetadata(BridgeWorld bridgeWorld, String metadataKey, MetadataValue newMetadataValue) {
		// TODO Auto-generated method stub
		
	}

	public boolean canGenerateStructures(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createExplosion(BridgeWorld bridgeWorld, Location loc, float power) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createExplosion(BridgeWorld bridgeWorld, Location loc, float power, boolean setFire) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createExplosion(BridgeWorld bridgeWorld, double x, double y, double z, float power) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean createExplosion(BridgeWorld bridgeWorld, double x, double y, double z, float power, boolean setFire) {
		// TODO Auto-generated method stub
		return false;
	}

	public Item dropItem(BridgeWorld bridgeWorld, Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	public Item dropItemNaturally(BridgeWorld bridgeWorld, Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean generateTree(BridgeWorld bridgeWorld, Location location, TreeType type) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean generateTree(BridgeWorld bridgeWorld, Location loc, TreeType type, BlockChangeDelegate delegate) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllowAnimals(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAllowMonsters(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getAnimalSpawnLimit(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Chunk getChunkAt(BridgeWorld bridgeWorld, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chunk getChunkAt(BridgeWorld bridgeWorld, Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chunk getChunkAt(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Difficulty getDifficulty(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChunkSnapshot getEmptyChunkSnapshot(BridgeWorld bridgeWorld, int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Entity> getEntities(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld bridgeWorld, Class<T> ...classes) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld bridgeWorld, Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection<Entity> getEntitiesByClasses(BridgeWorld bridgeWorld, Class<?>[] classes) {
		// TODO Auto-generated method stub
		return null;
	}

	public Environment getEnvironment(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getFullTime(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ChunkGenerator getGenerator(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public Block getHighestBlockAt(BridgeWorld bridgeWorld, Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	public Block getHighestBlockAt(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getHighestBlockYAt(BridgeWorld bridgeWorld, Location location) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHighestBlockYAt(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean getKeepSpawnInMemory(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<LivingEntity> getLivingEntities(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chunk[] getLoadedChunks(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMaxHeight(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getName(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getPVP(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getMonsterSpawnLimit(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Player> getPlayers(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BlockPopulator> getPopulators(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSeaLevel(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getSeed(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Location getSpawnLocation(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getThunderDuration(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTicksPerAnimalSpawns(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTicksPerMonsterSpawns(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public long getTime(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWaterAnimalSpawnLimit(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getWeatherDuration(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public File getWorldFolder(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public WorldType getWorldType(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasStorm(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAutoSave(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public void playEffect(BridgeWorld bridgeWorld, Location location, Effect effect, int data) {
		// TODO Auto-generated method stub
		
	}

	public <T> void playEffect(BridgeWorld bridgeWorld, Location location, Effect effect, T data) {
		// TODO Auto-generated method stub
		
	}

	public void playEffect(BridgeWorld bridgeWorld, Location location, Effect effect, int data, int radius) {
		// TODO Auto-generated method stub
		
	}

	public boolean isThundering(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public <T> void playEffect(BridgeWorld bridgeWorld, Location location, Effect effect, T data, int radius) {
		// TODO Auto-generated method stub
		
	}

	public boolean refreshChunk(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean regenerateChunk(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public void save(BridgeWorld bridgeWorld) {
		// TODO Auto-generated method stub
		
	}

	public void setAnimalSpawnLimit(BridgeWorld bridgeWorld, int limit) {
		// TODO Auto-generated method stub
		
	}

	public void setAutoSave(BridgeWorld bridgeWorld, boolean value) {
		// TODO Auto-generated method stub
		
	}

	public void setDifficuly(BridgeWorld bridgeWorld, Difficulty difficulty) {
		// TODO Auto-generated method stub
		
	}

	public void setFullTime(BridgeWorld bridgeWorld, long time) {
		// TODO Auto-generated method stub
		
	}

	public void setKeepSpawnInMemory(BridgeWorld bridgeWorld, boolean keepLoaded) {
		// TODO Auto-generated method stub
		
	}

	public void setMonsterSpawnLimit(BridgeWorld bridgeWorld, int limit) {
		// TODO Auto-generated method stub
		
	}

	public void setPVP(BridgeWorld bridgeWorld, boolean pvp) {
		// TODO Auto-generated method stub
		
	}

	public void setSpawnFlags(BridgeWorld bridgeWorld, boolean allowMonsters, boolean allowAnimals) {
		// TODO Auto-generated method stub
		
	}

	public boolean setSpawnLocation(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setStorm(BridgeWorld bridgeWorld, boolean hasStorm) {
		// TODO Auto-generated method stub
		
	}

	public void setThunderDuration(BridgeWorld bridgeWorld, int duration) {
		// TODO Auto-generated method stub
		
	}

	public void setThundering(BridgeWorld bridgeWorld, boolean thundering) {
		// TODO Auto-generated method stub
		
	}

	public void setTicksPerAnimalSpawns(BridgeWorld bridgeWorld, int ticksPerAnimalSpawns) {
		// TODO Auto-generated method stub
		
	}

	public void setTicksPerMonsterSpawns(BridgeWorld bridgeWorld, int ticksPerMonsterSpawns) {
		// TODO Auto-generated method stub
		
	}

	public void setTime(BridgeWorld bridgeWorld, long time) {
		// TODO Auto-generated method stub
		
	}

	public void setWaterAnimalSpawnLimit(BridgeWorld bridgeWorld, int limit) {
		// TODO Auto-generated method stub
		
	}

	public void setWeatherDuration(BridgeWorld bridgeWorld, int duration) {
		// TODO Auto-generated method stub
		
	}
	
	public <T extends Entity> T spawn(BridgeWorld bridgeWorld, Location location, Class<T> clazz) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public Arrow spawnArrow(BridgeWorld bridgeWorld, Location location, Vector velocity, float speed, float spread) {
		// TODO Auto-generated method stub
		return null;
	}

	public LivingEntity spawnCreature(BridgeWorld bridgeWorld, Location loc, EntityType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public LivingEntity spawnCreature(BridgeWorld bridgeWorld, Location loc, CreatureType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Entity spawnEntity(BridgeWorld bridgeWorld, Location loc, EntityType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public LightningStrike strikeLightning(BridgeWorld bridgeWorld, Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	public LightningStrike strikeLightningEffect(BridgeWorld bridgeWorld, Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean unloadChunkRequest(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unloadChunkRequest(BridgeWorld bridgeWorld, int x, int z, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld bridgeWorld, Chunk chunk) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeChunk Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	public Block getBlockAt(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean loadChunk(BridgeWorld bridgeWorld, int x, int z, boolean generate) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isChunkLoaded(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unloadChunk(BridgeWorld bridgeWorld, int x, int z, boolean save, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld bridgeWorld, int x, int z, boolean includeMaxBlockY, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	public Entity[] getEntitiesAt(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState[] getTileEntitiesAt(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeBlock Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	public Biome getBiome(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getHumidity(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getTemperature(BridgeWorld bridgeWorld, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setBiome(BridgeWorld bridgeWorld, int x, int z, Biome bio) {
		// TODO Auto-generated method stub
		
	}

	public int getBlockTypeIdAt(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<MetadataValue> getBlockMetadata(BridgeWorld bridgeWorld, int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasBlockMetadata(BridgeWorld bridgeWorld, int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeBlockMetadata(BridgeWorld bridgeWorld, int x, int y, int z, String key, Plugin owner) {
		// TODO Auto-generated method stub
		
	}

	public void setBlockMetadata(BridgeWorld bridgeWorld, int x, int y, int z, String key, MetadataValue val) {
		// TODO Auto-generated method stub
		
	}

	public boolean breakNaturally(BridgeWorld bridgeWorld, int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getBlockPower(BridgeWorld bridgeWorld, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getData(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<ItemStack> getDrops(BridgeWorld bridgeWorld, int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockFace getFace(BridgeWorld bridgeWorld, int x, int y, int z, int x2, int y2, int z2) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte getLightFromBlocks(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getLightFromSky(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getLightLevel(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Location getLocation(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public PistonMoveReaction getPistonMoveReaction(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Block getRelative(BridgeWorld bridgeWorld, int x, int y, int z, int modX, int modY, int modZ) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState getState(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Material getType(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isBlockFaceIndirectlyPowered(BridgeWorld bridgeWorld, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockFacePowered(BridgeWorld bridgeWorld, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockIndirectlyPowered(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockPowered(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLiquid(BridgeWorld bridgeWorld, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setData(BridgeWorld bridgeWorld, int x, int y, int z, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub

	}

	public void setType(BridgeWorld bridgeWorld, int x, int y, int z, Material type) {
		// TODO Auto-generated method stub
		
	}

	public boolean setTypeId(BridgeWorld bridgeWorld, int x, int y, int z, int id, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setTypeIdAndData(BridgeWorld bridgeWorld, int x, int y, int z, int type, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}
}
