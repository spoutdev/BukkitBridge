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
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
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

/**
 * BridgeWorld is Bridge's implementation of Bukkit's World. It is delegated to by
 * BridgeChunk and BridgeBlock. It delegates to BridgeServer.
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
		return getServer().getListeningPluginChannels();
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		getServer().sendPluginMessage(source, channel, message);
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		return getServer().getWorldMetadata(this, metadataKey);
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		return getServer().hasWorldMetadata(this, metadataKey);
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		getServer().removeWorldMetadata(this, metadataKey, owningPlugin);
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		getServer().setWorldMetadata(this, metadataKey, newMetadataValue);
	}

	@Override
	public boolean canGenerateStructures() {
		return getServer().canGenerateStructures(this);
	}

	@Override
	public boolean createExplosion(Location loc, float power) {
		return getServer().createExplosion(this, loc, power);
	}

	@Override
	public boolean createExplosion(Location loc, float power, boolean setFire) {
		return getServer().createExplosion(this, loc, power, setFire);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		return getServer().createExplosion(this, x, y, z, power);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		return getServer().createExplosion(this, x, y, z, power, setFire);
	}

	@Override
	public Item dropItem(Location location, ItemStack item) {
		return getServer().dropItem(this, location, item);
	}

	@Override
	public Item dropItemNaturally(Location location, ItemStack item) {
		return getServer().dropItemNaturally(this, location, item);
	}

	@Override
	public boolean generateTree(Location location, TreeType type) {
		return getServer().generateTree(this, location, type);
	}

	@Override
	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
		return getServer().generateTree(this, loc, type, delegate);
	}

	@Override
	public boolean getAllowAnimals() {
		return getServer().getAllowAnimals(this);
	}

	@Override
	public boolean getAllowMonsters() {
		return getServer().getAllowMonsters(this);
	}

	@Override
	public int getAnimalSpawnLimit() {
		return getServer().getAnimalSpawnLimit(this);
	}

	@Override
	public Chunk getChunkAt(Location location) {
		return getServer().getChunkAt(this, location);
	}

	@Override
	public Chunk getChunkAt(Block block) {
		return getServer().getChunkAt(this, block);
	}

	@Override
	public Chunk getChunkAt(int x, int z) {
		return getServer().getChunkAt(this, x, z);
	}

	@Override
	public Difficulty getDifficulty() {
		return getServer().getDifficulty(this);
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		return getServer().getEmptyChunkSnapshot(this, x, z, includeBiome, includeBiomeTempRain);
	}

	@Override
	public List<Entity> getEntities() {
		return getServer().getEntities(this);
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		return getServer().getEntitiesByClass(this, classes);
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
		return getServer().getEntitiesByClass(this, cls);
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		return getServer().getEntitiesByClasses(this, classes);
	}

	@Override
	public Environment getEnvironment() {
		return getServer().getEnvironment(this);
	}

	@Override
	public long getFullTime() {
		return getServer().getFullTime(this);
	}

	@Override
	public ChunkGenerator getGenerator() {
		return getServer().getGenerator(this);
	}

	@Override
	public Block getHighestBlockAt(Location location) {
		return getServer().getHighestBlockAt(this, location);
	}

	@Override
	public Block getHighestBlockAt(int x, int z) {
		return getServer().getHighestBlockAt(this, x, z);
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		return getServer().getHighestBlockYAt(this, location);
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		return getServer().getHighestBlockYAt(this, x, z);
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		return getServer().getKeepSpawnInMemory(this);
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		return getServer().getLivingEntities(this);
	}

	@Override
	public Chunk[] getLoadedChunks() {
		return getServer().getLoadedChunks(this);
	}

	@Override
	public int getMaxHeight() {
		return getServer().getMaxHeight(this);
	}

	@Override
	public int getMonsterSpawnLimit() {
		return getServer().getMonsterSpawnLimit(this);
	}

	@Override
	public String getName() {
		return getServer().getName(this);
	}

	@Override
	public boolean getPVP() {
		return getServer().getPVP(this);
	}

	@Override
	public List<Player> getPlayers() {
		return getServer().getPlayers(this);
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		return getServer().getPopulators(this);
	}

	@Override
	public int getSeaLevel() {
		return getServer().getSeaLevel(this);
	}

	@Override
	public long getSeed() {
		return getServer().getSeed(this);
	}

	@Override
	public Location getSpawnLocation() {
		return getServer().getSpawnLocation(this);
	}

	@Override
	public int getThunderDuration() {
		return getServer().getThunderDuration(this);
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		return getServer().getTicksPerAnimalSpawns(this);
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		return getServer().getTicksPerMonsterSpawns(this);
	}

	@Override
	public long getTime() {
		return getServer().getTime(this);
	}

	@Override
	public UUID getUID() {
		return id;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		return getServer().getWaterAnimalSpawnLimit(this);
	}

	@Override
	public int getWeatherDuration() {
		return getServer().getWeatherDuration(this);
	}

	@Override
	public File getWorldFolder() {
		return getServer().getWorldFolder(this);
	}

	@Override
	public WorldType getWorldType() {
		return getServer().getWorldType(this);
	}

	@Override
	public boolean hasStorm() {
		return getServer().hasStorm(this);
	}

	@Override
	public boolean isAutoSave() {
		return getServer().isAutoSave(this);
	}

	@Override
	public boolean isThundering() {
		return getServer().isThundering(this);
	}

	@Override
	public void playEffect(Location location, Effect effect, int data) {
		getServer().playEffect(this, location, effect, data);
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data) {
		getServer().playEffect(this, location, effect, data);
	}

	@Override
	public void playEffect(Location location, Effect effect, int data, int radius) {
		getServer().playEffect(this, location, effect, data, radius);
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data, int radius) {
		getServer().playEffect(this, location, effect, data, radius);
	}

	@Override
	public boolean refreshChunk(int x, int z) {
		return getServer().refreshChunk(this, x, z);
	}

	@Override
	public boolean regenerateChunk(int x, int z) {
		return getServer().regenerateChunk(this, x, z);
	}

	@Override
	public void save() {
		getServer().save(this);
	}

	@Override
	public void setAnimalSpawnLimit(int limit) {
		getServer().setAnimalSpawnLimit(this, limit);
	}

	@Override
	public void setAutoSave(boolean value) {
		getServer().setAutoSave(this, value);
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		getServer().setDifficuly(this, difficulty);
	}

	@Override
	public void setFullTime(long time) {
		getServer().setFullTime(this, time);
	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded) {
		getServer().setKeepSpawnInMemory(this, keepLoaded);
	}

	@Override
	public void setMonsterSpawnLimit(int limit) {
		getServer().setMonsterSpawnLimit(this, limit);
	}

	@Override
	public void setPVP(boolean pvp) {
		getServer().setPVP(this, pvp);
	}

	@Override
	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
		getServer().setSpawnFlags(this, allowMonsters, allowAnimals);
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		return getServer().setSpawnLocation(this, x, y, z);
	}

	@Override
	public void setStorm(boolean hasStorm) {
		getServer().setStorm(this, hasStorm);
	}

	@Override
	public void setThunderDuration(int duration) {
		getServer().setThunderDuration(this, duration);
	}

	@Override
	public void setThundering(boolean thundering) {
		getServer().setThundering(this, thundering);
	}

	@Override
	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
		getServer().setTicksPerAnimalSpawns(this, ticksPerAnimalSpawns);
	}

	@Override
	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
		getServer().setTicksPerMonsterSpawns(this, ticksPerMonsterSpawns);
	}

	@Override
	public void setTime(long time) {
		getServer().setTime(this, time);
	}

	@Override
	public void setWaterAnimalSpawnLimit(int limit) {
		getServer().setWaterAnimalSpawnLimit(this, limit);
	}

	@Override
	public void setWeatherDuration(int duration) {
		getServer().setWeatherDuration(this, duration);
	}

	@Override
	public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
		return getServer().spawn(this, location, clazz);
	}

	@Override
	public Arrow spawnArrow(Location location, Vector velocity, float speed, float spread) {
		return getServer().spawnArrow(this, location, velocity, speed, spread);
	}

	@Override
	public LivingEntity spawnCreature(Location loc, EntityType type) {
		return getServer().spawnCreature(this, loc, type);
	}

	@Override
	public LivingEntity spawnCreature(Location loc, CreatureType type) {
		return getServer().spawnCreature(this, loc ,type);
	}

	@Override
	public Entity spawnEntity(Location loc, EntityType type) {
		return getServer().spawnEntity(this, loc, type);
	}

	@Override
	public LightningStrike strikeLightning(Location loc) {
		return getServer().strikeLightning(this, loc);
	}

	@Override
	public LightningStrike strikeLightningEffect(Location loc) {
		return getServer().strikeLightningEffect(this, loc);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z) {
		return getServer().unloadChunkRequest(this, x, z);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		return getServer().unloadChunkRequest(this, x, z, safe);
	}

	public ChunkSnapshot getChunkSnapshot(Chunk chunk) {
		return getServer().getChunkSnapshot(this, chunk);
	}

	public ChunkSnapshot getChunkSnapshot(int x, int z) {
		return getServer().getChunkSnapshot(this, x, z);
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeChunk Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	@Override
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		return getServer().getBlockAt(this, x, y, z);
	}

	@Override
	public void loadChunk(Chunk chunk) {
		loadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public void loadChunk(int x, int z) {
		loadChunk(x, z, true);
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate) {
		return getServer().loadChunk(this, x, z, generate);
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk) {
		return isChunkLoaded(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		return getServer().isChunkLoaded(this, x, z);
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		return unloadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		return unloadChunk(x, z, true);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		return unloadChunk(x, z, save, false);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		return getServer().unloadChunk(this, x, z, save, safe);
	}

	public ChunkSnapshot getChunkSnapshot(int x, int z, boolean includeMaxBlockY, boolean includeBiome, boolean includeBiomeTempRain) {
		return getServer().getChunkSnapshot(this, x, z, includeMaxBlockY, includeBiome, includeBiomeTempRain);
	}

	public Entity[] getEntitiesAt(Chunk chunk) {
		return getEntitiesAt(chunk.getX(), chunk.getZ());
	}

	public Entity[] getEntitiesAt(int x, int z) {
		return getServer().getEntitiesAt(this, x, z);
	}

	public BlockState[] getTileEntitiesAt(Chunk chunk) {
		return getTileEntitiesAt(chunk.getX(), chunk.getZ());
	}

	public BlockState[] getTileEntitiesAt(int x, int z) {
		return getServer().getTileEntitiesAt(this, x, z);
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeBlock Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	@Override
	public Biome getBiome(int x, int z) {
		return getServer().getBiome(this, x, z);
	}

	@Override
	public double getHumidity(int x, int z) {
		return getServer().getHumidity(this, x, z);
	}

	@Override
	public double getTemperature(int x, int z) {
		return getServer().getTemperature(this, x, z);
	}

	@Override
	public void setBiome(int x, int z, Biome bio) {
		getServer().setBiome(this, x, z, bio);
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		return getBlockTypeIdAt((int) location.getX(), (int) location.getY(), (int) location.getZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		return getServer().getBlockTypeIdAt(this, x, y, z);
	}

	public List<MetadataValue> getBlockMetadata(int x, int y, int z, String key) {
		return getServer().getBlockMetadata(this, x, y, z, key);
	}

	public boolean hasBlockMetadata(int x, int y, int z, String key) {
		return getServer().hasBlockMetadata(this, x, y, z, key);
	}

	public void removeBlockMetadata(int x, int y, int z, String key, Plugin owner) {
		getServer().removeBlockMetadata(this, x, y, z, key, owner);
	}

	public void setBlockMetadata(int x, int y, int z, String key, MetadataValue val) {
		getServer().setBlockMetadata(this, x, y, z, key, val);
	}

	public boolean breakNaturally(int x, int y, int z, ItemStack tool) {
		return getServer().breakNaturally(this, x, y, z, tool);
	}

	public int getBlockPower(int x, int y, int z, BlockFace face) {
		return getServer().getBlockPower(this, x, y, z, face);
	}

	public byte getData(int x, int y, int z) {
		return getServer().getData(this, x, y, z);
	}

	public Collection<ItemStack> getDrops(int x, int y, int z, ItemStack tool) {
		return getServer().getDrops(this, x, y, z, tool);
	}

	public BlockFace getFace(int x, int y, int z, int x2, int y2, int z2) {
		return getServer().getFace(this, x, y, z, x2, y2, z2);
	}

	public byte getLightFromBlocks(int x, int y, int z) {
		return getServer().getLightFromBlocks(this, x, y, z);
	}

	public byte getLightFromSky(int x, int y, int z) {
		return getServer().getLightFromSky(this, x, y, z);
	}

	public byte getLightLevel(int x, int y, int z) {
		return getServer().getLightLevel(this, x, y, z);
	}

	public Location getLocation(int x, int y, int z) {
		return getServer().getLocation(this, x, y, z);
	}

	public PistonMoveReaction getPistonMoveReaction(int x, int y, int z) {
		return getServer().getPistonMoveReaction(this, x, y, z);
	}

	public Block getRelative(int x, int y, int z, int modX, int modY, int modZ) {
		return getServer().getRelative(this, x, y, z, modX, modY, modZ);
	}

	public BlockState getState(int x, int y, int z) {
		return getServer().getState(this, x, y, z);
	}

	public Material getType(int x, int y, int z) {
		return getServer().getType(this, x, y, z);
	}

	public boolean isBlockFaceIndirectlyPowered(int x, int y, int z, BlockFace face) {
		return getServer().isBlockFaceIndirectlyPowered(this, x, y, z, face);
	}

	public boolean isBlockFacePowered(int x, int y, int z, BlockFace face) {
		return getServer().isBlockFacePowered(this, x, y, z, face);
	}

	public boolean isBlockIndirectlyPowered(int x, int y, int z) {
		return getServer().isBlockIndirectlyPowered(this, x, y, z);
	}

	public boolean isBlockPowered(int x, int y, int z) {
		return getServer().isBlockPowered(this, x, y, z);
	}

	public boolean isEmpty(int x, int y, int z) {
		return getServer().isEmpty(this, x, y, z);
	}

	public boolean isLiquid(int x, int y, int z) {
		return getServer().isLiquid(this, x, y, z);
	}

	public void setData(int x, int y, int z, byte data, boolean applyPhysics) {
		getServer().setData(this, x, y, z, data, applyPhysics);
	}

	public void setType(int x, int y, int z, Material type) {
		getServer().setType(this, x, y, z, type);
	}

	public boolean setTypeId(int x, int y, int z, int id, boolean applyPhysics) {
		return getServer().setTypeId(this, x, y, z, id, applyPhysics);
	}

	public boolean setTypeIdAndData(int x, int y, int z, int type, byte data, boolean applyPhysics) {
		return getServer().setTypeIdAndData(this, x, y, z, type, data, applyPhysics);
	}

}
