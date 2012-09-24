package org.spout.bridge.bukkit;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bukkit.BlockChangeDelegate;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.LightningStrike;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;
import org.spout.bridge.bukkit.manager.BlockManager;
import org.spout.bridge.bukkit.manager.ChunkManager;
import org.spout.bridge.bukkit.manager.WorldManager;

/**
 * BridgeWorld is Bridge's implementation of Bukkit's World.
 */
@SuppressWarnings("deprecation")
public class BridgeWorld implements World {
	private final BridgeServer server;
	private final UUID id;
	
	public BridgeWorld(BridgeServer server, UUID id) {
		this.server = server;
		this.id = id;
	}
	
	public BridgeServer getServer() {
		return server;
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		return WorldManager.getListeningPluginChannels();
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		WorldManager.sendPluginMessage(source, channel, message);
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return WorldManager.getWorldMetadata(this, metadataKey);
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return WorldManager.hasWorldMetadata(this, metadataKey);
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		WorldManager.removeWorldMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		WorldManager.setWorldMetadata(this, metadataKey, newMetadataValue);
	}

	@Override
	public boolean canGenerateStructures() {
		return WorldManager.canGenerateStructures(this);
	}

	@Override
	public boolean createExplosion(Location loc, float power) {
		return WorldManager.createExplosion(this, loc, power);
	}

	@Override
	public boolean createExplosion(Location loc, float power, boolean setFire) {
		return WorldManager.createExplosion(this, loc, power, setFire);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		return WorldManager.createExplosion(this, x, y, z, power);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		return WorldManager.createExplosion(this, x, y, z, power, setFire);
	}

	@Override
	public Item dropItem(Location location, ItemStack item) {
		return WorldManager.dropItem(this, location, item);
	}

	@Override
	public Item dropItemNaturally(Location location, ItemStack item) {
		return WorldManager.dropItemNaturally(this, location, item);
	}

	@Override
	public boolean generateTree(Location location, TreeType type) {
		return WorldManager.generateTree(this, location, type);
	}

	@Override
	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
		return WorldManager.generateTree(this, loc, type, delegate);
	}

	@Override
	public boolean getAllowAnimals() {
		return WorldManager.getAllowAnimals(this);
	}

	@Override
	public boolean getAllowMonsters() {
		return WorldManager.getAllowMonsters(this);
	}

	@Override
	public int getAnimalSpawnLimit() {
		return WorldManager.getAnimalSpawnLimit(this);
	}

	@Override
	public Chunk getChunkAt(Location location) {
		return ChunkManager.getChunkAt(this, location);
	}

	@Override
	public Chunk getChunkAt(Block block) {
		return ChunkManager.getChunkAt(this, block);
	}

	@Override
	public Chunk getChunkAt(int x, int z) {
		return ChunkManager.getChunkAt(this, x, z);
	}

	@Override
	public Difficulty getDifficulty() {
		return WorldManager.getDifficulty(this);
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		return WorldManager.getEmptyChunkSnapshot(this, x, z, includeBiome, includeBiomeTempRain);
	}

	@Override
	public List<Entity> getEntities() {
		return WorldManager.getEntities(this);
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		return WorldManager.getEntitiesByClass(this, classes);
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
		return WorldManager.getEntitiesByClass(this, cls);
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		return WorldManager.getEntitiesByClasses(this, classes);
	}

	@Override
	public Environment getEnvironment() {
		return WorldManager.getEnvironment(this);
	}

	@Override
	public long getFullTime() {
		return WorldManager.getFullTime(this);
	}

	@Override
	public ChunkGenerator getGenerator() {
		return WorldManager.getGenerator(this);
	}

	@Override
	public Block getHighestBlockAt(Location location) {
		return WorldManager.getHighestBlockAt(this, location);
	}

	@Override
	public Block getHighestBlockAt(int x, int z) {
		return WorldManager.getHighestBlockAt(this, x, z);
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		return WorldManager.getHighestBlockYAt(this, location);
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		return WorldManager.getHighestBlockYAt(this, x, z);
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		return WorldManager.getKeepSpawnInMemory(this);
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		return WorldManager.getLivingEntities(this);
	}

	@Override
	public Chunk[] getLoadedChunks() {
		return WorldManager.getLoadedChunks(this);
	}

	@Override
	public int getMaxHeight() {
		return WorldManager.getMaxHeight(this);
	}

	@Override
	public int getMonsterSpawnLimit() {
		return WorldManager.getMonsterSpawnLimit(this);
	}

	@Override
	public String getName() {
		return WorldManager.getName(this);
	}

	@Override
	public boolean getPVP() {
		return WorldManager.getPVP(this);
	}

	@Override
	public List<Player> getPlayers() {
		return WorldManager.getPlayers(this);
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		return WorldManager.getPopulators(this);
	}

	@Override
	public int getSeaLevel() {
		return WorldManager.getSeaLevel(this);
	}

	@Override
	public long getSeed() {
		return WorldManager.getSeed(this);
	}

	@Override
	public Location getSpawnLocation() {
		return WorldManager.getSpawnLocation(this);
	}

	@Override
	public int getThunderDuration() {
		return WorldManager.getThunderDuration(this);
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		return WorldManager.getTicksPerAnimalSpawns(this);
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		return WorldManager.getTicksPerMonsterSpawns(this);
	}

	@Override
	public long getTime() {
		return WorldManager.getTime(this);
	}

	@Override
	public UUID getUID() {
		return id;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		return WorldManager.getWaterAnimalSpawnLimit(this);
	}

	@Override
	public int getWeatherDuration() {
		return WorldManager.getWeatherDuration(this);
	}

	@Override
	public File getWorldFolder() {
		return WorldManager.getWorldFolder(this);
	}

	@Override
	public WorldType getWorldType() {
		return WorldManager.getWorldType(this);
	}

	@Override
	public boolean hasStorm() {
		return WorldManager.hasStorm(this);
	}

	@Override
	public boolean isAutoSave() {
		return WorldManager.isAutoSave(this);
	}

	@Override
	public boolean isThundering() {
		return WorldManager.isThundering(this);
	}

	@Override
	public void playEffect(Location location, Effect effect, int data) {
		WorldManager.playEffect(this, location, effect, data);
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data) {
		WorldManager.playEffect(this, location, effect, data);
	}

	@Override
	public void playEffect(Location location, Effect effect, int data, int radius) {
		WorldManager.playEffect(this, location, effect, data, radius);
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data, int radius) {
		WorldManager.playEffect(this, location, effect, data, radius);
	}

	@Override
	public boolean refreshChunk(int x, int z) {
		return WorldManager.refreshChunk(this, x, z);
	}

	@Override
	public boolean regenerateChunk(int x, int z) {
		return WorldManager.regenerateChunk(this, x, z);
	}

	@Override
	public void save() {
		WorldManager.save(this);
	}

	@Override
	public void setAnimalSpawnLimit(int limit) {
		WorldManager.setAnimalSpawnLimit(this, limit);
	}

	@Override
	public void setAutoSave(boolean value) {
		WorldManager.setAutoSave(this, value);
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		WorldManager.setDifficulty(this, difficulty);
	}

	@Override
	public void setFullTime(long time) {
		WorldManager.setFullTime(this, time);
	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded) {
		WorldManager.setKeepSpawnInMemory(this, keepLoaded);
	}

	@Override
	public void setMonsterSpawnLimit(int limit) {
		WorldManager.setMonsterSpawnLimit(this, limit);
	}

	@Override
	public void setPVP(boolean pvp) {
		WorldManager.setPVP(this, pvp);
	}

	@Override
	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
		WorldManager.setSpawnFlags(this, allowMonsters, allowAnimals);
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		return WorldManager.setSpawnLocation(this, x, y, z);
	}

	@Override
	public void setStorm(boolean hasStorm) {
		WorldManager.setStorm(this, hasStorm);
	}

	@Override
	public void setThunderDuration(int duration) {
		WorldManager.setThunderDuration(this, duration);
	}

	@Override
	public void setThundering(boolean thundering) {
		WorldManager.setThundering(this, thundering);
	}

	@Override
	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
		WorldManager.setTicksPerAnimalSpawns(this, ticksPerAnimalSpawns);
	}

	@Override
	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
		WorldManager.setTicksPerMonsterSpawns(this, ticksPerMonsterSpawns);
	}

	@Override
	public void setTime(long time) {
		WorldManager.setTime(this, time);
	}

	@Override
	public void setWaterAnimalSpawnLimit(int limit) {
		WorldManager.setWaterAnimalSpawnLimit(this, limit);
	}

	@Override
	public void setWeatherDuration(int duration) {
		WorldManager.setWeatherDuration(this, duration);
	}

	@Override
	public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
		return WorldManager.spawn(this, location, clazz);
	}

	@Override
	public Arrow spawnArrow(Location location, Vector velocity, float speed, float spread) {
		return WorldManager.spawnArrow(this, location, velocity, speed, spread);
	}

	@Override
	public LivingEntity spawnCreature(Location loc, EntityType type) {
		return WorldManager.spawnCreature(this, loc, type);
	}

	@Override
	public LivingEntity spawnCreature(Location loc, CreatureType type) {
		return WorldManager.spawnCreature(this, loc ,type);
	}

	@Override
	public Entity spawnEntity(Location loc, EntityType type) {
		return WorldManager.spawnEntity(this, loc, type);
	}

	@Override
	public LightningStrike strikeLightning(Location loc) {
		return WorldManager.strikeLightning(this, loc);
	}

	@Override
	public LightningStrike strikeLightningEffect(Location loc) {
		return WorldManager.strikeLightningEffect(this, loc);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z) {
		return WorldManager.unloadChunkRequest(this, x, z);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		return WorldManager.unloadChunkRequest(this, x, z, safe);
	}

	public ChunkSnapshot getChunkSnapshot(Chunk chunk) {
		return ChunkManager.getChunkSnapshot(this, chunk);
	}

	public ChunkSnapshot getChunkSnapshot(int x, int z) {
		return ChunkManager.getChunkSnapshot(this, x, z);
	}

	@Override
	public Block getBlockAt(Location location) {
		return BlockManager.getBlockAt(this, location);
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		return BlockManager.getBlockAt(this, x, y, z);
	}

	@Override
	public void loadChunk(Chunk chunk) {
		loadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public void loadChunk(int x, int z) {
		ChunkManager.loadChunk(this, x, z);
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate) {
		return ChunkManager.loadChunk(this, x, z, generate);
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk) {
		return ChunkManager.isChunkLoaded(this, chunk);
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		return ChunkManager.isChunkLoaded(this, x, z);
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		return ChunkManager.unloadChunk(this, chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		return ChunkManager.unloadChunk(this, x, z);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		return ChunkManager.unloadChunk(this, x, z, save);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		return ChunkManager.unloadChunk(this, x, z, save, safe);
	}

	@Override
	public Biome getBiome(int x, int z) {
		return BlockManager.getBiome(this, x, z);
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		return BlockManager.getBlockTypeIdAt(this, location);
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		return BlockManager.getBlockTypeIdAt(this, x, y, z);
	}

	@Override
	public double getHumidity(int x, int z) {
		return BlockManager.getHumidity(this, x, z);
	}

	@Override
	public double getTemperature(int x, int z) {
		return BlockManager.getTemperature(this, x, z);
	}

	@Override
	public void setBiome(int x, int z, Biome biome) {
		BlockManager.setBiome(this, x, z, biome);
	}
}
