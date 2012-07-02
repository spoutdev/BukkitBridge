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

@SuppressWarnings("deprecation")
public class BridgeWorld implements World {

	@Override
	public Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canGenerateStructures() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(Location loc, float power) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(Location loc, float power, boolean setFire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Item dropItem(Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item dropItemNaturally(Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean generateTree(Location location, TreeType type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowAnimals() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllowMonsters() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Chunk getChunkAt(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk getChunkAt(Block block) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk getChunkAt(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Difficulty getDifficulty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Environment getEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getFullTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChunkGenerator getGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getHighestBlockAt(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getHighestBlockAt(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Chunk[] getLoadedChunks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMaxHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMonsterSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getPVP() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSeaLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Location getSpawnLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getThunderDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UUID getUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getWeatherDuration() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public File getWorldFolder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WorldType getWorldType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasStorm() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutoSave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isThundering() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void playEffect(Location location, Effect effect, int data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playEffect(Location location, Effect effect, int data, int radius) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data, int radius) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean refreshChunk(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean regenerateChunk(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAnimalSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAutoSave(boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFullTime(long time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMonsterSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPVP(boolean pvp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setStorm(boolean hasStorm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setThunderDuration(int duration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setThundering(boolean thundering) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTime(long time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWaterAnimalSpawnLimit(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWeatherDuration(int duration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Arrow spawnArrow(Location location, Vector velocity, float speed, float spread) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivingEntity spawnCreature(Location loc, EntityType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LivingEntity spawnCreature(Location loc, CreatureType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity spawnEntity(Location arg0, EntityType arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LightningStrike strikeLightning(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LightningStrike strikeLightningEffect(Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean unloadChunkRequest(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}

	public ChunkSnapshot getChunkSnapshot(Chunk chunk) {
		// TODO Auto-generated method stub
		return null;
	}

	public ChunkSnapshot getChunkSnapshot(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeChunk Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	@Override
	public Block getBlockAt(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadChunk(Chunk chunk) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadChunk(int x, int z) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate) {
		// TODO Auto-generated method stub
		return false;
	}

	public ChunkSnapshot getChunkSnapshot(int x, int z, boolean includeMaxBlockY, boolean includeBiome, boolean inlcudeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	public Entity[] getEntitiesAt(Chunk chunk) {
		// TODO Auto-generated method stub
		return null;
	}

	public Entity[] getEntitiesAt(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState[] getTileEntitiesAt(Chunk chunk) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState[] getTileEntitiesAt(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

//----------------------------------------------------------------------//
//----------------------------------------------------------------------//
//----//				BridgeBlock Delegations					 //-----//
//----------------------------------------------------------------------//
//----------------------------------------------------------------------//

	@Override
	public Biome getBiome(int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getHumidity(int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getTemperature(int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBiome(int x, int z, Biome bio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<MetadataValue> getMetadata(int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean hasMetadata(int x, int y, int z, String key) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeMetadata(int x, int y, int z, String key, Plugin owner) {
		// TODO Auto-generated method stub
		
	}

	public void setMetadata(int x, int y, int z, String key, MetadataValue val) {
		// TODO Auto-generated method stub
		
	}

	public boolean breakNaturally(int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getBlockPower(int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getData(int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Collection<ItemStack> getDrops(int x, int y, int z, ItemStack tool) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockFace getFace(int x, int y, int z, int x2, int y2, int z2) {
		// TODO Auto-generated method stub
		return null;
	}

	public byte getLightFromBlocks(int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getLightFromSky(int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public byte getLightLevel(int x, int y, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Location getLocation(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public PistonMoveReaction getPistonMoveReaction(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Block getRelative(int x, int y, int z, int modX, int modY, int modZ) {
		// TODO Auto-generated method stub
		return null;
	}

	public BlockState getState(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public Material getType(int x, int y, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isBlockFaceIndirectlyPowered(int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockFacePowered(int x, int y, int z, BlockFace face) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockIndirectlyPowered(int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isBlockPowered(int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty(int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isLiquid(int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setData(int x, int y, int z, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub
		
	}

	public void setType(int x, int y, int z, Material type) {
		// TODO Auto-generated method stub
		
	}

	public boolean setTypeId(int x, int y, int z, int id, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setTypeIdAndData(int x, int y, int z, int type, byte data, boolean applyPhysics) {
		// TODO Auto-generated method stub
		return false;
	}

}
