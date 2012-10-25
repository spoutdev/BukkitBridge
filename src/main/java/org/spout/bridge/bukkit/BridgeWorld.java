package org.spout.bridge.bukkit;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
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
import org.bukkit.Sound;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
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

import org.spout.api.geo.LoadOption;
import org.spout.api.geo.cuboid.Region;
import org.spout.api.geo.discrete.Point;
import org.spout.api.geo.discrete.Transform;
import org.spout.api.material.BlockMaterial;
import org.spout.api.math.Quaternion;
import org.spout.api.math.Vector3;

import org.spout.bridge.BukkitUtil;

import org.spout.vanilla.component.world.VanillaSky;
import org.spout.vanilla.configuration.VanillaConfiguration;
import org.spout.vanilla.configuration.WorldConfiguration;
import org.spout.vanilla.data.effect.store.GeneralEffects;
import org.spout.vanilla.data.effect.store.SoundEffects;
import org.spout.vanilla.material.VanillaMaterial;
import org.spout.vanilla.util.explosion.ExplosionModels;
import org.spout.vanilla.world.generator.nether.NetherGenerator;
import org.spout.vanilla.world.generator.object.VanillaObjects;
import org.spout.vanilla.world.generator.theend.TheEndGenerator;

/**
 * BridgeWorld is Bridge's implementation of Bukkit's World.
 */
@SuppressWarnings("deprecation")
public class BridgeWorld implements World {
	private final BridgeServer server;
	private final org.spout.api.geo.World handle;

	public BridgeWorld(BridgeServer server, org.spout.api.geo.World handle) {
		this.server = server;
		this.handle = handle;
	}

	public BridgeServer getServer() {
		return server;
	}

	public org.spout.api.geo.World getHandle() {
		return handle;
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasMetadata(String metadataKey) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean canGenerateStructures() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean createExplosion(Location loc, float power) {
		return createExplosion(loc, power, false);
	}

	@Override
	public boolean createExplosion(Location loc, float power, boolean setFire) {
		return createExplosion(loc.getX(), loc.getY(), loc.getZ(), power, setFire);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		return createExplosion(x, y, z, power, false);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		ExplosionModels.SPHERICAL.execute(new Point(handle, (float) x, (float) y, (float) z), power, setFire, handle);
		return true;
	}

	@Override
	public Item dropItem(Location location, ItemStack item) {
		return null;
	}

	@Override
	public Item dropItemNaturally(Location location, ItemStack item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean generateTree(Location loc, TreeType type) {
		return generateTree(loc, type, null);
	}

	@Override
	public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
		int x = loc.getBlockX();
		int y = loc.getBlockY();
		int z = loc.getBlockZ();
		switch (type) {
			case TREE:
				VanillaObjects.SMALL_OAK_TREE.placeObject(handle, x, y, z);
				return true;
			case BIG_TREE:
				VanillaObjects.BIG_OAK_TREE.placeObject(handle, x, y, z);
				return true;
			case REDWOOD:
				VanillaObjects.SPRUCE_TREE.placeObject(handle, x, y, z);
				return true;
			case TALL_REDWOOD:
				VanillaObjects.PINE_TREE.placeObject(handle, x, y, z);
				return true;
			case BIRCH:
				VanillaObjects.SMALL_BIRCH_TREE.placeObject(handle, x, y, z);
				return true;
			case JUNGLE:
				VanillaObjects.HUGE_JUNGLE_TREE.placeObject(handle, x, y, z);
				return true;
			case SMALL_JUNGLE:
				VanillaObjects.SMALL_JUNGLE_TREE.placeObject(handle, x, y, z);
				return true;
			case JUNGLE_BUSH:
				VanillaObjects.JUNGLE_SHRUB.placeObject(handle, x, y, z);
				return true;
			case RED_MUSHROOM:
				VanillaObjects.HUGE_RED_MUSHROOM.placeObject(handle, x, y, z);
				return true;
			case BROWN_MUSHROOM:
				VanillaObjects.HUGE_BROWN_MUSHROOM.placeObject(handle, x, y, z);
				return true;
			case SWAMP:
				VanillaObjects.SWAMP_TREE.placeObject(handle, x, y, z);
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean getAllowAnimals() {
		return VanillaConfiguration.WORLDS.getOrCreate(handle).SPAWN_ANIMALS.getBoolean();
	}

	@Override
	public boolean getAllowMonsters() {
		return VanillaConfiguration.WORLDS.getOrCreate(handle).SPAWN_MONSTERS.getBoolean();
	}

	@Override
	public int getAnimalSpawnLimit() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Biome getBiome(int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		return getBlockTypeIdAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		BlockMaterial bm = getHandle().getBlockMaterial(x, y, z);
		if (bm instanceof VanillaMaterial) {
			return ((VanillaMaterial) bm).getMinecraftId();
		}
		return 0;
	}

	@Override
	public Chunk getChunkAt(Location location) {
		return getChunkAt(location.getBlockX() / 16, location.getBlockZ() / 16);
	}

	@Override
	public Chunk getChunkAt(Block block) {
		return getChunkAt(block.getX() / 16, block.getZ() / 16);
	}

	@Override
	public Chunk getChunkAt(int x, int z) {
		return getChunkAt(x, z, LoadOption.LOAD_GEN);
	}

	public BridgeChunk getChunkAt(int x, int z, LoadOption opt) {
		BridgeChunk chunk = new BridgeChunk(this, x, z);
		chunk.getHandle(opt);
		return chunk;
	}

	@Override
	public Difficulty getDifficulty() {
		switch (getEnvironment()) {
			case NORMAL:
				return Difficulty.valueOf(WorldConfiguration.NORMAL.DIFFICULTY.getString().toUpperCase());
			case NETHER:
				return Difficulty.valueOf(WorldConfiguration.NETHER.DIFFICULTY.getString().toUpperCase());
			case THE_END:
				return Difficulty.valueOf(WorldConfiguration.END.DIFFICULTY.getString().toUpperCase());
		}
		return Difficulty.NORMAL;
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Entity> getEntities() {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> cls) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Environment getEnvironment() {
		if (getHandle().getGenerator() instanceof NetherGenerator) {
			return Environment.NETHER;
		} else if (getHandle().getGenerator() instanceof TheEndGenerator) {
			return Environment.THE_END;
		}
		return Environment.NORMAL;
	}

	@Override
	public long getFullTime() {
		return handle.getAge();
	}

	@Override
	public ChunkGenerator getGenerator() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Block getHighestBlockAt(Location location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Block getHighestBlockAt(int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Override
	public double getHumidity(int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		switch (getEnvironment()) {
			case NORMAL:
				return WorldConfiguration.NORMAL.LOADED_SPAWN.getBoolean();
			case NETHER:
				return WorldConfiguration.NETHER.LOADED_SPAWN.getBoolean();
			case THE_END:
				return WorldConfiguration.END.LOADED_SPAWN.getBoolean();
		}
		throw new IllegalStateException("Unknown environment");
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Chunk[] getLoadedChunks() {
		HashSet<BridgeChunk> chunks = new HashSet<BridgeChunk>();
		Iterator<Region> i = handle.getRegions().iterator();
		while (i.hasNext()) {
			Region next = i.next();
			for (int cx = 0; cx < 16; cx++) {
				for (int cz = 0; cz < 16; cz++) {
					chunks.add(new BridgeChunk(this, next.getChunkX() + cx, next.getChunkZ() + cz));
				}
			}
		}
		return chunks.toArray(new BridgeChunk[chunks.size()]);
	}

	@Override
	public int getMaxHeight() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getMonsterSpawnLimit() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
		return handle.getName();
	}

	@Override
	public boolean getPVP() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Player> getPlayers() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getSeaLevel() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getSeed() {
		return handle.getSeed();
	}

	@Override
	public Location getSpawnLocation() {
		return BukkitUtil.fromTransform(handle.getSpawnPoint());
	}

	@Override
	public double getTemperature(int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getThunderDuration() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getTime() {
		return handle.getComponentHolder().get(VanillaSky.class).getTime();
	}

	@Override
	public UUID getUID() {
		return handle.getUID();
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getWeatherDuration() {
		throw new UnsupportedOperationException();
	}

	@Override
	public File getWorldFolder() {
		return handle.getDirectory();
	}

	@Override
	public WorldType getWorldType() {
		return WorldType.getByName(VanillaConfiguration.WORLDS.getOrCreate(handle).GENERATOR.getString());
	}

	@Override
	public boolean hasStorm() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isAutoSave() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isChunkInUse(int x, int z) {
		BridgeChunk chunk = getChunkAt(x, z, LoadOption.NO_LOAD);
		org.spout.api.geo.cuboid.Chunk handle[] = chunk.getHandle(LoadOption.NO_LOAD);
		for (int i = 0; i < handle.length; i++) {
			org.spout.api.geo.cuboid.Chunk c = handle[i];
			if (c != null && c.isLoaded()) {
				if (c.getNumObservers() > 0) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk) {
		return isChunkLoaded(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		Chunk chunk = getChunkAt(x, z, LoadOption.NO_LOAD);
		return chunk.isLoaded();
	}

	@Override
	public boolean isThundering() {
		throw new UnsupportedOperationException();
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
		Chunk chunk = getChunkAt(x, z, generate ? LoadOption.LOAD_GEN : LoadOption.LOAD_ONLY);
		return chunk.isLoaded();
	}

	@Override
	public void playEffect(Location location, Effect effect, int data) {
		Point pos = BukkitUtil.toPoint(location);
		switch (effect) {
			case CLICK1:
				GeneralEffects.RANDOM_CLICK1.playGlobal(pos, data, data);
				break;
			case CLICK2:
				GeneralEffects.RANDOM_CLICK2.playGlobal(pos, data, data);
				break;
			case BOW_FIRE:
				GeneralEffects.RANDOM_BOW.playGlobal(pos, data, data);
				break;
			case DOOR_TOGGLE:
				GeneralEffects.RANDOM_DOOR.playGlobal(pos, data);
				break;
			case EXTINGUISH:
				GeneralEffects.EXTINGUISH.playGlobal(pos);
				break;
			case RECORD_PLAY:
				GeneralEffects.MUSIC_DISC.playGlobal(pos, data);
				break;
			case GHAST_SHRIEK:
				GeneralEffects.GHAST_CHARGE.playGlobal(pos, data);
				break;
			case GHAST_SHOOT:
				GeneralEffects.GHAST_FIREBALL.playGlobal(pos, data);
				break;
			case BLAZE_SHOOT:
				// TODO: Blaze effect
				break;
			case ZOMBIE_CHEW_WOODEN_DOOR:
				GeneralEffects.ZOMBIE_DAMAGE_WOOD.playGlobal(pos, data);
				break;
			case ZOMBIE_CHEW_IRON_DOOR:
				GeneralEffects.ZOMBIE_DAMAGE_METAL.playGlobal(pos, data);
				break;
			case ZOMBIE_DESTROY_DOOR:
				GeneralEffects.ZOMBIE_BREAK.playGlobal(pos, data);
				break;
			case SMOKE:
				GeneralEffects.SMOKE.playGlobal(pos, data);
				break;
			case STEP_SOUND:
				SoundEffects.STEP_STONE.playGlobal(pos, data, data);
				break;
			case POTION_BREAK:
				GeneralEffects.SPLASHPOTION.playGlobal(pos, data);
				break;
			case ENDER_SIGNAL:
				GeneralEffects.ENDEREYE.playGlobal(pos, data);
				break;
			case MOBSPAWNER_FLAMES:
				GeneralEffects.MOBSPAWN.playGlobal(pos, data);
		}
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playEffect(Location location, Effect effect, int data, int radius) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T data, int radius) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void playSound(Location loc, Sound sound, float volume, float pitch) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean refreshChunk(int x, int z) {
		BridgeChunk chunk = getChunkAt(x, z, LoadOption.LOAD_GEN);
		org.spout.api.geo.cuboid.Chunk[] handle = chunk.getHandle(LoadOption.LOAD_GEN);
		for (int i = 0; i < handle.length; i++) {
			for (org.spout.api.entity.Player p : handle[i].getObservingPlayers()) {
				p.getNetworkSynchronizer().sendChunk(handle[i]);
			}
		}
		return true;
	}

	@Override
	public boolean regenerateChunk(int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void save() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAnimalSpawnLimit(int limit) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setAutoSave(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setBiome(int x, int z, Biome bio) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		switch (getEnvironment()) {
			case NORMAL:
				WorldConfiguration.NORMAL.DIFFICULTY.setValue(difficulty.name());
				break;
			case NETHER:
				WorldConfiguration.NETHER.DIFFICULTY.setValue(difficulty.name());
				break;
			case THE_END:
				WorldConfiguration.END.DIFFICULTY.setValue(difficulty.name());
				break;
		}
	}

	@Override
	public void setFullTime(long time) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setKeepSpawnInMemory(boolean keepLoaded) {
		switch (getEnvironment()) {
			case NORMAL:
				WorldConfiguration.NORMAL.LOADED_SPAWN.setValue(keepLoaded);
				break;
			case NETHER:
				WorldConfiguration.NETHER.LOADED_SPAWN.setValue(keepLoaded);
				break;
			case THE_END:
				WorldConfiguration.END.LOADED_SPAWN.setValue(keepLoaded);
				break;
		}
	}

	@Override
	public void setMonsterSpawnLimit(int arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPVP(boolean pvp) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		handle.setSpawnPoint(new Transform(new Point(handle, x, y, z), Quaternion.IDENTITY, Vector3.ZERO));
		return true;
	}

	@Override
	public void setStorm(boolean hasStorm) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setThunderDuration(int duration) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setThundering(boolean thundering) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTime(long time) {
		handle.getComponentHolder().get(VanillaSky.class).setTime(time);
	}

	@Override
	public void setWaterAnimalSpawnLimit(int arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setWeatherDuration(int duration) {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Arrow spawnArrow(Location location, Vector velocity, float speed, float spread) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public LivingEntity spawnCreature(Location loc, EntityType type) {
		throw new UnsupportedOperationException();
	}

	@Override
	@Deprecated
	public LivingEntity spawnCreature(Location loc, CreatureType type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Entity spawnEntity(Location loc, EntityType type) {
		throw new UnsupportedOperationException();
	}

	@Override
	public FallingBlock spawnFallingBlock(Location loc, Material material, byte data) throws IllegalArgumentException {
		return spawnFallingBlock(loc, material.getId(), data);
	}

	@Override
	public FallingBlock spawnFallingBlock(Location loc, int id, byte data) throws IllegalArgumentException {
		throw new UnsupportedOperationException();
	}

	@Override
	public LightningStrike strikeLightning(Location loc) {
		throw new UnsupportedOperationException();
	}

	@Override
	public LightningStrike strikeLightningEffect(Location loc) {
		throw new UnsupportedOperationException();
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
		return unloadChunk(x, z, save, true);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		return unloadChunkRequest(x, z, safe);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z) {
		return unloadChunkRequest(x, z, true);
	}

	@Override
	public boolean unloadChunkRequest(int x, int z, boolean safe) {
		Chunk chunk = getChunkAt(x, z, LoadOption.NO_LOAD);
		return chunk.unload(true, true);
	}
}
