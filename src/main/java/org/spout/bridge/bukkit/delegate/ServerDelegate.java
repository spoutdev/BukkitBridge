package org.spout.bridge.bukkit.delegate;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
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
import org.spout.bridge.bukkit.BridgeChunk;
import org.spout.bridge.bukkit.BridgeChunkSnapshot;
import org.spout.bridge.bukkit.BridgeServer;
import org.spout.bridge.bukkit.BridgeWorld;
import org.spout.bridge.bukkit.block.BridgeBlock;

import com.avaje.ebean.config.ServerConfig;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;

/**
 * The ServerDelegate is delegated to by BridgeServer. Meaning it is indirectly
 * delegated to by the entire API. The ServerDelegate is supposed to write as many
 * of the given functions as possible in terms of other functions. Functions that
 * can not be written in terms of other functions will be handed off to hook delegates
 * which will call hooks to get the necessary data from another API.
 */
@SuppressWarnings("deprecation")
public class ServerDelegate extends Delegate<BridgeServer> {
	private final Map<UUID, BridgeWorld> uworlds = new HashMap<UUID, BridgeWorld>(); //cache worlds via name and uuid for efficiency.
	private final Map<String, BridgeWorld> sworlds = new HashMap<String, BridgeWorld>();
	private final Cache<ChunkKey,BridgeChunk> chunks;
	private final Cache<BlockKey,BridgeBlock> blocks;
	
	private final ChunkKey ckey = new ChunkKey();
	private final BlockKey bkey = new BlockKey();
	
	public ServerDelegate() {
		chunks = CacheBuilder.newBuilder().maximumSize(256 * 256 * 256).build(new CacheLoader<ChunkKey,BridgeChunk>() {
			@Override
			public BridgeChunk load(ChunkKey key) {
				BridgeWorld w = getWorld(key.getUUID());
				return new BridgeChunk(w, key.getX(), key.getZ());
			}
		});
		
		blocks = CacheBuilder.newBuilder().maximumSize(256 * 256 * 256).build(new CacheLoader<BlockKey,BridgeBlock>() {
			@Override
			public BridgeBlock load(BlockKey key) {
				BridgeChunk c = getChunkAt(getWorld(key.getUUID()), key.getX() >> 4, key.getZ() >> 4);
				return new BridgeBlock(c, key.getX(), key.getY(), key.getZ());
			}
		});
	}
	
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
		return ConfigurationManager.getAllowEnd(getDelegator());
	}

	public boolean getAllowFlight() {
		return ConfigurationManager.getAllowFlight(getDelegator());
	}

	public boolean getAllowNether() {
		return ConfigurationManager.getAllowNether(getDelegator());
	}

	public int getAnimalSpawnLimit() {
		return ConfigurationManager.getAnimalSpawnLimit(getDelegator());
	}

	public Set<OfflinePlayer> getBannedPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBukkitVersion() {
		return "Zl5i:Y3x&G"; //'cuz I can :P
	}

	public Map<String, String[]> getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getConnectionThrottle() {
		return ConfigurationManager.getConnectionThrottle(getDelegator());
	}

	public ConsoleCommandSender getConsoleSender() {
		// TODO Auto-generated method stub
		return null;
	}

	public GameMode getDefaultGameMode() {
		return ConfigurationManager.getDefaultGameMode(getDelegator());
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
		return ConfigurationManager.getOnlineMode(getDelegator());
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

	public BridgeWorld getWorld(String name) {
		if(sworlds.containsKey(name)) return sworlds.get(name);
		return null;//TODO check for new world.
	}

	public BridgeWorld getWorld(UUID id) {
		if(uworlds.containsKey(id)) return uworlds.get(id);
		return null;//TODO check for new world.
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

	public BridgeChunk getChunkAt(BridgeWorld world, Location location) {
		return getChunkAt(world, (int) location.getX(), (int) location.getZ());
	}

	public BridgeChunk getChunkAt(BridgeWorld world, Block block) {
		return getChunkAt(world, block.getX(), block.getZ());
	}

	public BridgeChunk getChunkAt(BridgeWorld world, int x, int z) {
		return chunks.getUnchecked(ckey.configure(world.getUID().getMostSignificantBits(), world.getUID().getLeastSignificantBits(), x, z));
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
		return getChunkSnapshot(world, x, z, true, false, false);
	}
	
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeChunk Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	public BridgeBlock getBlockAt(BridgeWorld world, int x, int y, int z) {
		return blocks.getUnchecked(bkey.configure(world.getUID().getMostSignificantBits(), world.getUID().getLeastSignificantBits(), x, y, z));
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
		int height = this.getMaxHeight(world);
		int alen = height / 16;
		short[][] sectionBlockIDs = new short[alen][4096];
		byte[][] sectionBlockData = new byte[alen][2048];
		byte[][] sectionSkyLights = new byte[alen][2048];
		byte[][] sectionEmitLights = new byte[alen][2048];
		boolean[] sectionEmpty = new boolean[alen];
		for (int py = 0; py < height; py+=16) {
			boolean empty = true;
			for(int px = 0; x < 16; x++) {
				for(int pz = 0; z < 16; z++) {
					sectionBlockIDs[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = (short) getBlockTypeIdAt(world, px, py, pz);
					sectionBlockData[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = getData(world, px, py, pz);
					sectionSkyLights[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = getLightFromSky(world, px, py, pz);
					//TODO sectionEmitLights[py >> 4][((py & 0xF) << 8) | (pz << 4) | px] = ....?
					empty = empty && getBlockTypeIdAt(world, px, py, pz) == 0;
				}
			}
			sectionEmpty[py >> 4] = empty;
		}

		int[] hmap = null;
		if (includeMaxBlockY) {
			hmap = new int[256]; // Get copy of height map
			for(int px = 0; x < 16; x++) {
				for(int pz = 0; z < 16; z++) {
					hmap[z << 4 | x] = getHighestBlockYAt(world, px, pz);
				}
			}
		}

		Biome[] biome = null;
		double[] biomeTemp = null;
		double[] biomeRain = null;
		if (includeBiome ||includeBiomeTempRain ) {
			if(includeBiome) biome = new Biome[256];
			if (includeBiomeTempRain) {
				biomeTemp = new double[256];
				biomeRain = new double[256];
			}
			for(int px = 0; x < 16; x++) {
				for(int pz = 0; z < 16; z++) {
					if(includeBiome) biome[z << 4 | x] = getBiome(world, px, pz);
					if (includeBiomeTempRain) {
						biomeTemp[z << 4 | x] = getTemperature(world, px, pz);
						biomeRain[z << 4 | x] = getHumidity(world, px, pz);
					}
				}
			}
		}

		return new BridgeChunkSnapshot(x, z, getName(world), getFullTime(world), sectionBlockIDs, sectionBlockData, sectionSkyLights, sectionEmitLights, sectionEmpty, hmap, biome, biomeTemp, biomeRain);
	}

	public Entity[] getEntitiesAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState[] getTileEntitiesAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
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

	public void setBiome(BridgeWorld world, int x, int z) {
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
		return new Location(world, x, y, z);
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
		setTypeIdAndData(world, x, y, z, getBlockTypeIdAt(world, x, y, z), data, applyPhysics);
	}

	public void setType(BridgeWorld world, int x, int y, int z, Material type) {
		setTypeId(world, x, y, z, type.getId(), true);
	}

	public boolean setTypeId(BridgeWorld world, int x, int y, int z, int id, boolean applyPhysics) {
		return setTypeIdAndData(world, x, y, z, id, getData(world, x, y, z), applyPhysics);
	}

	public boolean setTypeIdAndData(BridgeWorld world, int x, int y, int z, int type, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//						Keys							 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
	
	private class ChunkKey {
		private long high;
		private long low;
		
		private int x, z;
		
		public ChunkKey configure(long high, long low, int x, int z) {
			this.high = high;
			this.low = low;
			this.x = x;
			this.z = z;
			return this;
		}
		
		public UUID getUUID() {
			return new UUID(high, low);
		}
		
		public int getX() {
			return x;
		}
		
		public int getZ() {
			return z;
		}
	}
	
	private class BlockKey {
		private long high;
		private long low;
		
		private int x, y, z;
		
		public BlockKey configure(long high, long low, int x, int y, int z) {
			this.high = high;
			this.low = low;
			this.x = x;
			this.y = y;
			this.z = z;
			return this;
		}
		
		public UUID getUUID() {
			return new UUID(high, low);
		}
		
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		
		public int getZ() {
			return z;
		}
	}
}
