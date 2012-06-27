/*
 * This file is part of BukkitBridge.
 *
 * Copyright (c) 2012, VanillaDev <http://www.spout.org/>
 * BukkitBridge is licensed under the GNU General Public License.
 *
 * BukkitBridge is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BukkitBridge is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spout.bukkit;

import java.io.File;
import java.util.ArrayList;
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

import org.spout.api.geo.discrete.Point;
import org.spout.api.math.Vector3;

import org.spout.bukkit.block.BridgeBlock;
import org.spout.bukkit.entity.BridgeEntity;
import org.spout.bukkit.entity.BridgeItem;
import org.spout.bukkit.entity.BridgeLivingEntity;
import org.spout.bukkit.entity.BridgePlayer;
import org.spout.bukkit.util.BridgeUtil;

import org.spout.vanilla.controller.VanillaActionController;
import org.spout.vanilla.controller.living.Living;
import org.spout.vanilla.controller.world.VanillaSky;
import org.spout.vanilla.util.explosion.ExplosionModelSpherical;
import org.spout.vanilla.data.Weather;

@SuppressWarnings("deprecation")
public class BridgeWorld implements World {
	private final org.spout.api.geo.World spoutWorld;

	public BridgeWorld(org.spout.api.geo.World spoutWorld) {
		this.spoutWorld = spoutWorld;
	}

	@Override
	public Block getBlockAt(int x, int y, int z) {
		return new BridgeBlock(spoutWorld.getBlock(x, y, z));
	}

	@Override
	public Block getBlockAt(Location location) {
		return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getBlockTypeIdAt(int x, int y, int z) {
		return spoutWorld.getBlock(x, y, z).getMaterial().getId();
	}

	@Override
	public int getBlockTypeIdAt(Location location) {
		return getBlockTypeIdAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
	}

	@Override
	public int getHighestBlockYAt(int x, int z) {
		for (int y = getMaxHeight(); y >= 0; y--) {
			if (spoutWorld.getBlock(x, y, z) != null) {
				return y;
			}
		}
		return 0;
	}

	@Override
	public int getHighestBlockYAt(Location location) {
		return getHighestBlockYAt(location.getBlockX(), location.getBlockZ());
	}

	@Override
	public Block getHighestBlockAt(int x, int z) {
		return new BridgeBlock(spoutWorld.getBlock(x, getHighestBlockYAt(x, z), z));
	}

	@Override
	public Block getHighestBlockAt(Location location) {
		return getHighestBlockAt(location.getBlockX(), location.getBlockY());
	}

	@Override
	public Chunk getChunkAt(int x, int z) {
		List<org.spout.api.geo.cuboid.Chunk> chunks = new ArrayList<org.spout.api.geo.cuboid.Chunk>();
		for (int y = getHighestBlockYAt(x, z); y >= 0; y--) {
			chunks.add(spoutWorld.getChunk(x, y, z));
		}
		return new BridgeChunk(chunks.toArray(new org.spout.api.geo.cuboid.Chunk[chunks.size()]));
	}

	@Override
	public Chunk getChunkAt(Location location) {
		return getChunkAt(location.getBlockX(), location.getBlockZ());
	}

	@Override
	public Chunk getChunkAt(Block block) {
		return getChunkAt(block.getLocation());
	}

	@Override
	public boolean isChunkLoaded(int x, int z) {
		return getChunkAt(x, z).isLoaded();
	}

	@Override
	public boolean isChunkLoaded(Chunk chunk) {
		return isChunkLoaded(chunk.getX(), chunk.getZ());
	}

	@Override
	public Chunk[] getLoadedChunks() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean loadChunk(int x, int z, boolean generate) {
		return getChunkAt(x, z).load(generate);
	}

	@Override
	public void loadChunk(int x, int z) {
		loadChunk(x, z, true);
	}

	@Override
	public void loadChunk(Chunk chunk) {
		loadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
		return getChunkAt(x, z).unload(save, safe);
	}

	@Override
	public boolean unloadChunk(int x, int z, boolean save) {
		return unloadChunk(x, z, save, true);
	}

	@Override
	public boolean unloadChunk(int x, int z) {
		return unloadChunk(x, z, true, true);
	}

	@Override
	public boolean unloadChunk(Chunk chunk) {
		return unloadChunk(chunk.getX(), chunk.getZ());
	}

	@Override
	public boolean unloadChunkRequest(int i, int i1) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean unloadChunkRequest(int i, int i1, boolean b) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean regenerateChunk(int x, int z) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean refreshChunk(int i, int i1) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Item dropItem(Location location, ItemStack itemStack) {
		Point point = new Point(spoutWorld, location.getBlockX(), location.getBlockY(), location.getBlockZ());
		org.spout.api.inventory.ItemStack spoutItemStack = BridgeUtil.toSpoutItemStack(itemStack);
		org.spout.vanilla.controller.object.moving.Item item = new org.spout.vanilla.controller.object.moving.Item(spoutItemStack, Vector3.ZERO);
		return new BridgeItem((org.spout.vanilla.controller.object.moving.Item) spoutWorld.createAndSpawnEntity(point, item).getController());
	}

	@Override
	public Item dropItemNaturally(Location location, ItemStack itemStack) {
		return dropItem(location, itemStack);
	}

	@Override
	public Arrow spawnArrow(Location location, Vector vector, float v, float v1) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean generateTree(Location location, TreeType treeType) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean generateTree(Location location, TreeType treeType, BlockChangeDelegate blockChangeDelegate) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Entity spawnEntity(Location location, EntityType entityType) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public LivingEntity spawnCreature(Location location, EntityType entityType) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public LivingEntity spawnCreature(Location location, CreatureType creatureType) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public LightningStrike strikeLightning(Location location) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public LightningStrike strikeLightningEffect(Location location) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<Entity>();
		for (org.spout.api.entity.Entity entity : spoutWorld.getAll(VanillaActionController.class)) {
			entities.add(new BridgeEntity((VanillaActionController) entity.getController()));
		}
		return entities;
	}

	@Override
	public List<LivingEntity> getLivingEntities() {
		List<LivingEntity> entities = new ArrayList<LivingEntity>();
		for (org.spout.api.entity.Entity entity : spoutWorld.getAll(Living.class)) {
			entities.add(new BridgeLivingEntity((Living) entity.getController()));
		}
		return entities;
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> tClass) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		for (org.spout.api.player.Player player : spoutWorld.getPlayers()) {
			players.add(new BridgePlayer(player));
		}
		return players;
	}

	@Override
	public String getName() {
		return spoutWorld.getName();
	}

	@Override
	public UUID getUID() {
		return spoutWorld.getUID();
	}

	@Override
	public Location getSpawnLocation() {
		return BridgeUtil.toLocation(spoutWorld.getSpawnPoint());
	}

	@Override
	public boolean setSpawnLocation(int x, int y, int z) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getTime() {
		return VanillaSky.getSky(spoutWorld).getTime();
	}

	@Override
	public void setTime(long time) {
		VanillaSky.getSky(spoutWorld).setTime(time);
	}

	@Override
	public long getFullTime() {
		return getTime();
	}

	@Override
	public void setFullTime(long time) {
		setTime(time);
	}

	@Override
	public boolean hasStorm() {
		return VanillaSky.getSky(spoutWorld).getWeather() == Weather.RAIN;
	}

	@Override
	public void setStorm(boolean storm) {
		Weather weather = storm ? Weather.RAIN : Weather.CLEAR;
		VanillaSky.getSky(spoutWorld).setWeather(weather);
	}

	@Override
	public int getWeatherDuration() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setWeatherDuration(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isThundering() {
		return VanillaSky.getSky(spoutWorld).getWeather() == Weather.THUNDERSTORM;
	}

	@Override
	public void setThundering(boolean thunder) {
		Weather weather = thunder ? Weather.THUNDERSTORM : Weather.CLEAR;
		VanillaSky.getSky(spoutWorld).setWeather(weather);
	}

	@Override
	public int getThunderDuration() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setThunderDuration(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
		// TODO: Set fire
		ExplosionModelSpherical explosionModel = new ExplosionModelSpherical();
		explosionModel.execute(new Point(spoutWorld, (float) x, (float) y, (float) z), power);
		return true;
	}

	@Override
	public boolean createExplosion(Location location, float power, boolean setFire) {
		return createExplosion(location.getX(), location.getY(), location.getZ(), power, setFire);
	}

	@Override
	public boolean createExplosion(double x, double y, double z, float power) {
		return createExplosion(x, y, z, power, false);
	}

	@Override
	public boolean createExplosion(Location location, float power) {
		return createExplosion(location.getX(), location.getY(), location.getZ(), power);
	}

	@Override
	public Environment getEnvironment() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getSeed() {
		return spoutWorld.getSeed();
	}

	@Override
	public boolean getPVP() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setPVP(boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public ChunkGenerator getGenerator() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void save() {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public List<BlockPopulator> getPopulators() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public <T extends Entity> T spawn(Location location, Class<T> tClass) throws IllegalArgumentException {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void playEffect(Location location, Effect effect, int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void playEffect(Location location, Effect effect, int i, int i1) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T t) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public <T> void playEffect(Location location, Effect effect, T t, int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public ChunkSnapshot getEmptyChunkSnapshot(int i, int i1, boolean b, boolean b1) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setSpawnFlags(boolean b, boolean b1) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean getAllowAnimals() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean getAllowMonsters() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public Biome getBiome(int i, int i1) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setBiome(int i, int i1, Biome biome) {

	}

	@Override
	public double getTemperature(int i, int i1) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public double getHumidity(int i, int i1) {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getMaxHeight() {
		return 256;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public int getSeaLevel() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean getKeepSpawnInMemory() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setKeepSpawnInMemory(boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean isAutoSave() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setAutoSave(boolean b) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void setDifficulty(Difficulty difficulty) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Difficulty getDifficulty() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public File getWorldFolder() {
		return spoutWorld.getDirectory();
	}

	@Override
	public WorldType getWorldType() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean canGenerateStructures() {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public long getTicksPerAnimalSpawns() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setTicksPerAnimalSpawns(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public long getTicksPerMonsterSpawns() {
		return 0;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void setTicksPerMonsterSpawns(int i) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public int getMonsterSpawnLimit() {
		return 0;  //TODO Adjust for usage with Spout!
	}

	@Override
	public void setMonsterSpawnLimit(int i) {
		//TODO Adjust for usage with Spout!
	}

	@Override
	public int getAnimalSpawnLimit() {
		return 0;  //TODO Adjust for usage with Spout!
	}

	@Override
	public void setAnimalSpawnLimit(int i) {
		//TODO Adjust for usage with Spout!
	}

	@Override
	public int getWaterAnimalSpawnLimit() {
		return 0;  //TODO Adjust for usage with Spout!
	}

	@Override
	public void setWaterAnimalSpawnLimit(int i) {
		//TODO Adjust for usage with Spout!
	}

	@Override
	public void setMetadata(String s, MetadataValue metadataValue) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public List<MetadataValue> getMetadata(String s) {
		return null;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public boolean hasMetadata(String s) {
		return false;  //TODO: Adjust for usage with Spout!
	}

	@Override
	public void removeMetadata(String s, Plugin plugin) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
		//TODO: Adjust for usage with Spout!
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		return null;  //TODO: Adjust for usage with Spout!
	}

	public org.spout.api.geo.World getSpoutWorld() {
		return spoutWorld;
	}
}
