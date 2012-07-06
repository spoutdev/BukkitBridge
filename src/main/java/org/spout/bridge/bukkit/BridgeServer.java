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

/**
 * BridgeServer is the "focus" of the Bukkit module. The entire API delegates its method calls
 * here (eventually). BridgeServer then delegates the method calls to ServerDelegate for further
 * processing.
 */
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

	@Override
	public String getMotd() {
		return getDelegate().getMotd();
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeWorld Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	@Override
	public Set<String> getListeningPluginChannels() {
		return getDelegate().getListeningPluginChannels();
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String channel, byte[] message) {
		getDelegate().sendPluginMessage(plugin, channel, message);
	}

	public List<MetadataValue> getWorldMetadata(BridgeWorld world, String metadataKey) {
		return getDelegate().getWorldMetadata(world, metadataKey);
	}

	public boolean hasWorldMetadata(BridgeWorld world, String metadataKey) {
		return getDelegate().hasWorldMetadata(world, metadataKey);
	}

	public void removeWorldMetadata(BridgeWorld world, String metadataKey, Plugin owningPlugin) {
		getDelegate().removeWorldMetadata(world, metadataKey, owningPlugin);
	}

	public void setWorldMetadata(BridgeWorld world, String metadataKey, MetadataValue newMetadataValue) {
		getDelegate().setWorldMetadata(world, metadataKey, newMetadataValue);
	}

	public boolean canGenerateStructures(BridgeWorld world) {
		return getDelegate().canGenerateStructures(world);
	}

	public boolean createExplosion(BridgeWorld world, Location loc, float power) {
		return createExplosion(world, loc.getX(), loc.getY(), loc.getZ(), power);
	}

	public boolean createExplosion(BridgeWorld world, Location loc, float power, boolean setFire) {
		return createExplosion(world, loc.getX(), loc.getY(), loc.getZ(), power, setFire);
	}

	public boolean createExplosion(BridgeWorld world, double x, double y, double z, float power) {
		return createExplosion(world, x, y, z, power, false);
	}

	public boolean createExplosion(BridgeWorld world, double x, double y, double z, float power, boolean setFire) {
		return getDelegate().createExplosion(world, x, y, z, power, setFire);
	}

	public Item dropItem(BridgeWorld world, Location location, ItemStack item) {
		return getDelegate().dropItem(world, location, item);
	}

	public Item dropItemNaturally(BridgeWorld world, Location location, ItemStack item) {
		return getDelegate().dropItemNaturally(world, location, item);
	}

	public boolean generateTree(BridgeWorld world, Location location, TreeType type) {
		return generateTree(world, location, type, null);
	}

	public boolean generateTree(BridgeWorld world, Location loc, TreeType type, BlockChangeDelegate delegate) {
		return getDelegate().generateTree(world, loc, type, delegate);
	}

	public boolean getAllowAnimals(BridgeWorld world) {
		return getDelegate().getAllowAnimals(world);
	}

	public boolean getAllowMonsters(BridgeWorld world) {
		return getDelegate().getAllowMonsters(world);
	}

	public int getAnimalSpawnLimit(BridgeWorld world) {
		return getDelegate().getAnimalSpawnLimit(world);
	}

	public Chunk getChunkAt(BridgeWorld world, Location location) {
		return getDelegate().getChunkAt(world, location);
	}

	public Chunk getChunkAt(BridgeWorld world, Block block) {
		return getDelegate().getChunkAt(world, block);
	}

	public Chunk getChunkAt(BridgeWorld world, int x, int z) {
		return getDelegate().getChunkAt(world, x, z);
	}

	public Difficulty getDifficulty(BridgeWorld world) {
		return getDelegate().getDifficulty(world);
	}

	public ChunkSnapshot getEmptyChunkSnapshot(BridgeWorld world, int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		return getDelegate().getEmptyChunkSnapshot(world, x, z, includeBiome, includeBiomeTempRain);
	}

	public List<Entity> getEntities(BridgeWorld world) {
		return getDelegate().getEntities(world);
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld world, Class<T> ...classes) {
		return getDelegate().getEntitiesByClass(world, classes);
	}

	public <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld world, Class<T> cls) {
		return getDelegate().getEntitiesByClass(world, cls);
	}

	public Collection<Entity> getEntitiesByClasses(BridgeWorld world, Class<?>... classes) {
		return getDelegate().getEntitiesByClasses(world, classes);
	}

	public Environment getEnvironment(BridgeWorld world) {
		return getDelegate().getEnvironment(world);
	}

	public long getFullTime(BridgeWorld world) {
		return getDelegate().getFullTime(world);
	}

	public ChunkGenerator getGenerator(BridgeWorld world) {
		return getDelegate().getGenerator(world);
	}

	public Block getHighestBlockAt(BridgeWorld world, Location location) {
		return getHighestBlockAt(world, (int) location.getX(), (int) location.getZ());
	}

	public Block getHighestBlockAt(BridgeWorld world, int x, int z) {
		return getDelegate().getHighestBlockAt(world, x, z);
	}

	public int getHighestBlockYAt(BridgeWorld world, Location location) {
		return getHighestBlockYAt(world, (int) location.getX(), (int) location.getZ());
	}

	public int getHighestBlockYAt(BridgeWorld world, int x, int z) {
		return getDelegate().getHighestBlockYAt(world, x, z);
	}

	public boolean getKeepSpawnInMemory(BridgeWorld world) {
		return getDelegate().getKeepSpawnInMemory(world);
	}

	public List<LivingEntity> getLivingEntities(BridgeWorld world) {
		return getDelegate().getLivingEntities(world);
	}

	public Chunk[] getLoadedChunks(BridgeWorld world) {
		return getDelegate().getLoadedChunks(world);
	}

	public int getMaxHeight(BridgeWorld world) {
		return getDelegate().getMaxHeight(world);
	}

	public String getName(BridgeWorld world) {
		return getDelegate().getName(world);
	}

	public boolean getPVP(BridgeWorld world) {
		return getDelegate().getPVP(world);
	}

	public int getMonsterSpawnLimit(BridgeWorld world) {
		return getDelegate().getMonsterSpawnLimit(world);
	}

	public List<Player> getPlayers(BridgeWorld world) {
		return getDelegate().getPlayers(world);
	}

	public List<BlockPopulator> getPopulators(BridgeWorld world) {
		return getDelegate().getPopulators(world);
	}

	public int getSeaLevel(BridgeWorld world) {
		return getDelegate().getSeaLevel(world);
	}

	public long getSeed(BridgeWorld world) {
		return getDelegate().getSeed(world);
	}

	public Location getSpawnLocation(BridgeWorld world) {
		return getDelegate().getSpawnLocation(world);
	}

	public int getThunderDuration(BridgeWorld world) {
		return getDelegate().getThunderDuration(world);
	}

	public long getTicksPerAnimalSpawns(BridgeWorld world) {
		return getDelegate().getTicksPerAnimalSpawns(world);
	}

	public long getTicksPerMonsterSpawns(BridgeWorld world) {
		return getDelegate().getTicksPerMonsterSpawns(world);
	}

	public long getTime(BridgeWorld world) {
		return getDelegate().getTime(world);
	}

	public int getWaterAnimalSpawnLimit(BridgeWorld world) {
		return getDelegate().getWaterAnimalSpawnLimit(world);
	}

	public int getWeatherDuration(BridgeWorld world) {
		return getDelegate().getWeatherDuration(world);
	}

	public File getWorldFolder(BridgeWorld world) {
		return getDelegate().getWorldFolder(world);
	}

	public WorldType getWorldType(BridgeWorld world) {
		return getDelegate().getWorldType(world);
	}

	public boolean hasStorm(BridgeWorld world) {
		return getDelegate().hasStorm(world);
	}

	public boolean isAutoSave(BridgeWorld world) {
		return getDelegate().isAutoSave(world);
	}

	public boolean isThundering(BridgeWorld world) {
		return getDelegate().isThundering(world);
	}

	public void playEffect(BridgeWorld world, Location location, Effect effect, int data) {
		playEffect(world, location, effect, data, -1);
	}

	public void playEffect(BridgeWorld world, Location location, Effect effect, int data, int radius) {
		getDelegate().playEffect(world, location, effect, data, radius);
	}

	public <T> void playEffect(BridgeWorld world, Location location, Effect effect, T data) {
		playEffect(world, location, effect, data, -1);
	}
	
	public <T> void playEffect(BridgeWorld world, Location location, Effect effect, T data, int radius) {
		getDelegate().playEffect(world, location, effect, data, radius);
	}

	public boolean refreshChunk(BridgeWorld world, int x, int z) {
		return getDelegate().refreshChunk(world, x, z);
	}

	public boolean regenerateChunk(BridgeWorld world, int x, int z) {
		return getDelegate().regenerateChunk(world, x, z);
	}

	public void save(BridgeWorld world) {
		getDelegate().save(world);
	}

	public void setAnimalSpawnLimit(BridgeWorld world, int limit) {
		getDelegate().setAnimalSpawnLimit(world, limit);
	}

	public void setAutoSave(BridgeWorld world, boolean value) {
		getDelegate().setAutoSave(world, value);
	}

	public void setDifficuly(BridgeWorld world, Difficulty difficulty) {
		getDelegate().setDifficulty(world, difficulty);
	}

	public void setFullTime(BridgeWorld world, long time) {
		getDelegate().setFullTime(world, time);
	}

	public void setKeepSpawnInMemory(BridgeWorld world, boolean keepLoaded) {
		getDelegate().setKeepSpawnInMemory(world, keepLoaded);
	}

	public void setMonsterSpawnLimit(BridgeWorld world, int limit) {
		getDelegate().setMonsterSpawnLimit(world, limit);
	}

	public void setPVP(BridgeWorld world, boolean pvp) {
		getDelegate().setPVP(world, pvp);
	}

	public void setSpawnFlags(BridgeWorld world, boolean allowMonsters, boolean allowAnimals) {
		getDelegate().setSpawnFlags(world, allowMonsters, allowAnimals);
	}

	public boolean setSpawnLocation(BridgeWorld world, int x, int y, int z) {
		return getDelegate().setSpawnLocation(world, x, y, z);
	}

	public void setStorm(BridgeWorld world, boolean hasStorm) {
		getDelegate().setStorm(world, hasStorm);
	}

	public void setThunderDuration(BridgeWorld world, int duration) {
		getDelegate().setThunderDuration(world, duration);
	}

	public void setThundering(BridgeWorld world, boolean thundering) {
		getDelegate().setThundering(world, thundering);
	}

	public void setTicksPerAnimalSpawns(BridgeWorld world, int ticksPerAnimalSpawns) {
		getDelegate().setTicksPerAnimalSpawns(world, ticksPerAnimalSpawns);
	}

	public void setTicksPerMonsterSpawns(BridgeWorld world, int ticksPerMonsterSpawns) {
		getDelegate().setTicksPerMonsterSpawns(world, ticksPerMonsterSpawns);
	}

	public void setTime(BridgeWorld world, long time) {
		getDelegate().setTime(world, time);
	}

	public void setWaterAnimalSpawnLimit(BridgeWorld world, int limit) {
		getDelegate().setWaterAnimalSpawnLimit(world, limit);
	}

	public void setWeatherDuration(BridgeWorld world, int duration) {
		getDelegate().setWeatherDuration(world, duration);
	}
	
	public <T extends Entity> T spawn(BridgeWorld world, Location location, Class<T> clazz) throws IllegalArgumentException {
		return getDelegate().spawn(world, location, clazz);
	}

	public Arrow spawnArrow(BridgeWorld world, Location location, Vector velocity, float speed, float spread) {
		return getDelegate().spawnArrow(world, location, velocity, speed, spread);
	}

	public LivingEntity spawnCreature(BridgeWorld world, Location loc, EntityType type) {
		return getDelegate().spawnCreature(world, loc, type);
	}

	public LivingEntity spawnCreature(BridgeWorld world, Location loc, CreatureType type) {
		return getDelegate().spawnCreature(world, loc, type);
	}

	public Entity spawnEntity(BridgeWorld world, Location loc, EntityType type) {
		return getDelegate().spawnEntity(world, loc, type);
	}

	public LightningStrike strikeLightning(BridgeWorld world, Location loc) {
		return getDelegate().strikeLightning(world, loc);
	}

	public LightningStrike strikeLightningEffect(BridgeWorld world, Location loc) {
		return getDelegate().strikeLightningEffect(world, loc);
	}

	public boolean unloadChunkRequest(BridgeWorld world, int x, int z) {
		return unloadChunkRequest(world, x, z, true);
	}

	public boolean unloadChunkRequest(BridgeWorld world, int x, int z, boolean safe) {
		return getDelegate().unloadChunkRequest(world, x, z, safe);
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld world, Chunk chunk) {
		return getChunkSnapshot(world, chunk.getX(), chunk.getZ());
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld world, int x, int z) {
		return getDelegate().getChunkSnapshot(world, x, z);
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeChunk Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	public Block getBlockAt(BridgeWorld world, int x, int y, int z) {
		return getDelegate().getBlockAt(world, x, y, z);
	}

	public boolean loadChunk(BridgeWorld world, int x, int z, boolean generate) {
		return getDelegate().loadChunk(world, x, z, generate);
	}

	public boolean isChunkLoaded(BridgeWorld world, int x, int z) {
		return getDelegate().isChunkLoaded(world, x, z);
	}

	public boolean unloadChunk(BridgeWorld world, int x, int z, boolean save, boolean safe) {
		return getDelegate().unloadChunk(world, x, z, save, safe);
	}

	public ChunkSnapshot getChunkSnapshot(BridgeWorld world, int x, int z, boolean includeMaxBlockY, boolean includeBiome, boolean includeBiomeTempRain) {
		return getDelegate().getChunkSnapshot(world, x, z, includeMaxBlockY, includeBiome, includeBiomeTempRain);
	}

	public Entity[] getEntitiesAt(BridgeWorld world, int x, int z) {
		return getDelegate().getEntitiesAt(world, x, z);
	}

	public BlockState[] getTileEntitiesAt(BridgeWorld world, int x, int z) {
		return getDelegate().getTileEntitiesAt(world, x, z);
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeBlock Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	public Biome getBiome(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getHumidity(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getTemperature(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setBiome(BridgeWorld world, int x, int z, Biome bio) {
		// TODO Auto-generated method stub
		
	}

	public int getBlockTypeIdAt(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<MetadataValue> getBlockMetadata(BridgeWorld world, int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasBlockMetadata(BridgeWorld world, int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeBlockMetadata(BridgeWorld world, int x, int y, int z, String key, Plugin owner) {
		// TODO Auto-generated method stub
		
	}

	public void setBlockMetadata(BridgeWorld world, int x, int y, int z, String key, MetadataValue val) {
		// TODO Auto-generated method stub
		
	}

	public boolean breakNaturally(BridgeWorld world, int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getBlockPower(BridgeWorld world, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getData(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<ItemStack> getDrops(BridgeWorld world, int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockFace getFace(BridgeWorld world, int x, int y, int z, int x2, int y2, int z2) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte getLightFromBlocks(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getLightFromSky(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getLightLevel(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Location getLocation(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public PistonMoveReaction getPistonMoveReaction(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Block getRelative(BridgeWorld world, int x, int y, int z, int modX, int modY, int modZ) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState getState(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Material getType(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isBlockFaceIndirectlyPowered(BridgeWorld world, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockFacePowered(BridgeWorld world, int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockIndirectlyPowered(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockPowered(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLiquid(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setData(BridgeWorld world, int x, int y, int z, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub

	}

	public void setType(BridgeWorld world, int x, int y, int z, Material type) {
		// TODO Auto-generated method stub
		
	}

	public boolean setTypeId(BridgeWorld world, int x, int y, int z, int id, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setTypeIdAndData(BridgeWorld world, int x, int y, int z, int type, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}
}
