package org.spout.bridge.bukkit.manager;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.BlockChangeDelegate;
import org.bukkit.Chunk;
import org.bukkit.ChunkSnapshot;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.TreeType;
import org.bukkit.WorldType;
import org.bukkit.World.Environment;
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
import org.spout.bridge.bukkit.BridgeWorld;

@SuppressWarnings("deprecation")
public class WorldManager {
	private static final Map<UUID, BridgeWorld> uworlds = new HashMap<UUID, BridgeWorld>(); //cache worlds via name and uuid for efficiency.
	private static final Map<String, BridgeWorld> sworlds = new HashMap<String, BridgeWorld>();

	public static BridgeWorld getWorld(String name) {
		if(sworlds.containsKey(name)) return sworlds.get(name);
		return null;//TODO check for new world.
	}

	public static BridgeWorld getWorld(UUID id) {
		if(uworlds.containsKey(id)) return uworlds.get(id);
		return null;//TODO check for new world.
	}
	
	public static Set<String> getListeningPluginChannels() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void sendPluginMessage(Plugin plugin, String channel, byte[] message) {
		// TODO Auto-generated method stub
		
	}

	public static List<MetadataValue> getWorldMetadata(BridgeWorld world, String metadataKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean hasWorldMetadata(BridgeWorld world, String metadataKey) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void removeWorldMetadata(BridgeWorld world, String metadataKey, Plugin owningPlugin) {
		// TODO Auto-generated method stub
		
	}

	public static void setWorldMetadata(BridgeWorld world, String metadataKey, MetadataValue newMetadataValue) {
		// TODO Auto-generated method stub
		
	}

	public static boolean canGenerateStructures(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean createExplosion(BridgeWorld world, Location loc, float power) {
		return createExplosion(world, loc.getX(), loc.getY(), loc.getZ(), power);
	}

	public static boolean createExplosion(BridgeWorld world, Location loc, float power, boolean setFire) {
		return createExplosion(world, loc.getX(), loc.getY(), loc.getZ(), power, setFire);
	}

	public static boolean createExplosion(BridgeWorld world, double x, double y, double z, float power) {
		return createExplosion(world, x, y, z, power, false);
	}

	public static boolean createExplosion(BridgeWorld world, double x, double y, double z, float power, boolean setFire) {
		// TODO Auto-generated method stub
		return false;
	}

	public static Item dropItem(BridgeWorld world, Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Item dropItemNaturally(BridgeWorld world, Location location, ItemStack item) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean generateTree(BridgeWorld world, Location location, TreeType type) {
		return generateTree(world, location, type, null);
	}

	public static boolean generateTree(BridgeWorld world, Location loc, TreeType type, BlockChangeDelegate delegate) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean getAllowAnimals(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean getAllowMonsters(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getAnimalSpawnLimit(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Difficulty getDifficulty(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ChunkSnapshot getEmptyChunkSnapshot(BridgeWorld world, int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<Entity> getEntities(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld world, Class<T> ...classes) {
		// TODO Auto-generated method stub
		return null;
	}

	public static <T extends Entity> Collection<T> getEntitiesByClass(BridgeWorld world, Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static Collection<Entity> getEntitiesByClasses(BridgeWorld world, Class<?>... classes) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Environment getEnvironment(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static long getFullTime(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static ChunkGenerator getGenerator(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Block getHighestBlockAt(BridgeWorld world, Location location) {
		return getHighestBlockAt(world, (int) location.getX(), (int) location.getZ());
	}

	public static Block getHighestBlockAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getHighestBlockYAt(BridgeWorld world, Location location) {
		return getHighestBlockYAt(world, (int) location.getX(), (int) location.getZ());
	}

	public static int getHighestBlockYAt(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static boolean getKeepSpawnInMemory(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static List<LivingEntity> getLivingEntities(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Chunk[] getLoadedChunks(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getMaxHeight(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static String getName(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean getPVP(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getMonsterSpawnLimit(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static List<Player> getPlayers(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static List<BlockPopulator> getPopulators(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getSeaLevel(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static long getSeed(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static Location getSpawnLocation(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getThunderDuration(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static long getTicksPerAnimalSpawns(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static long getTicksPerMonsterSpawns(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static long getTime(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getWaterAnimalSpawnLimit(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getWeatherDuration(BridgeWorld world) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static File getWorldFolder(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static WorldType getWorldType(BridgeWorld world) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean hasStorm(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isAutoSave(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean isThundering(BridgeWorld world) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void playEffect(BridgeWorld world, Location location, Effect effect, int data) {
		playEffect(world, location, effect, data, -1);
	}
	
	public static void playEffect(BridgeWorld world, Location location, Effect effect, int data, int radius) {
		// TODO Auto-generated method stub
		
	}

	public static <T> void playEffect(BridgeWorld world, Location location, Effect effect, T data) {
		playEffect(world, location, effect, data, -1);
	}
	
	public static <T> void playEffect(BridgeWorld world, Location location, Effect effect, T data, int radius) {
		// TODO Auto-generated method stub
		
	}

	public static boolean refreshChunk(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean regenerateChunk(BridgeWorld world, int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void save(BridgeWorld world) {
		// TODO Auto-generated method stub
		
	}

	public static void setAnimalSpawnLimit(BridgeWorld world, int limit) {
		// TODO Auto-generated method stub
		
	}

	public static void setAutoSave(BridgeWorld world, boolean value) {
		// TODO Auto-generated method stub
		
	}

	public static void setDifficulty(BridgeWorld world, Difficulty difficulty) {
		// TODO Auto-generated method stub
		
	}

	public static void setFullTime(BridgeWorld world, long time) {
		// TODO Auto-generated method stub
		
	}

	public static void setKeepSpawnInMemory(BridgeWorld world, boolean keepLoaded) {
		// TODO Auto-generated method stub
		
	}

	public static void setMonsterSpawnLimit(BridgeWorld world, int limit) {
		// TODO Auto-generated method stub
		
	}

	public static void setPVP(BridgeWorld world, boolean pvp) {
		// TODO Auto-generated method stub
		
	}

	public static void setSpawnFlags(BridgeWorld world, boolean allowMonsters, boolean allowAnimals) {
		// TODO Auto-generated method stub
		
	}

	public static boolean setSpawnLocation(BridgeWorld world, int x, int y, int z) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void setStorm(BridgeWorld world, boolean hasStorm) {
		// TODO Auto-generated method stub
		
	}

	public static void setThunderDuration(BridgeWorld world, int duration) {
		// TODO Auto-generated method stub
		
	}

	public static void setThundering(BridgeWorld world, boolean thundering) {
		// TODO Auto-generated method stub
		
	}

	public static void setTicksPerAnimalSpawns(BridgeWorld world, int ticksPerAnimalSpawns) {
		// TODO Auto-generated method stub
		
	}

	public static void setTicksPerMonsterSpawns(BridgeWorld world, int ticksPerMonsterSpawns) {
		// TODO Auto-generated method stub
		
	}

	public static void setTime(BridgeWorld world, long time) {
		// TODO Auto-generated method stub
		
	}

	public static void setWaterAnimalSpawnLimit(BridgeWorld world, int limit) {
		// TODO Auto-generated method stub
		
	}

	public static void setWeatherDuration(BridgeWorld world, int duration) {
		// TODO Auto-generated method stub
		
	}
	
	public static <T extends Entity> T spawn(BridgeWorld world, Location location, Class<T> clazz) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	public static Arrow spawnArrow(BridgeWorld world, Location location, Vector velocity, float speed, float spread) {
		// TODO Auto-generated method stub
		return null;
	}

	public static LivingEntity spawnCreature(BridgeWorld world, Location loc, EntityType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public static LivingEntity spawnCreature(BridgeWorld world, Location loc, CreatureType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Entity spawnEntity(BridgeWorld world, Location loc, EntityType type) {
		// TODO Auto-generated method stub
		return null;
	}

	public static LightningStrike strikeLightning(BridgeWorld world, Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	public static LightningStrike strikeLightningEffect(BridgeWorld world, Location loc) {
		// TODO Auto-generated method stub
		return null;
	}

	public static boolean unloadChunkRequest(BridgeWorld world, int x, int z) {
		return unloadChunkRequest(world, x, z, true);
	}

	public static boolean unloadChunkRequest(BridgeWorld world, int x, int z, boolean safe) {
		// TODO Auto-generated method stub
		return false;
	}
}
