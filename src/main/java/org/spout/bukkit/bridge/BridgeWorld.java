package org.spout.bukkit.bridge;

import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class BridgeWorld implements World {

    @Override
    public Block getBlockAt(int x, int y, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getBlockAt(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockTypeIdAt(int x, int y, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getBlockTypeIdAt(Location location) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getHighestBlockYAt(int x, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getHighestBlockYAt(Location location) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getHighestBlockAt(int x, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Block getHighestBlockAt(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk getChunkAt(int x, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk getChunkAt(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk getChunkAt(Block block) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChunkLoaded(Chunk chunk) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Chunk[] getLoadedChunks() {
        return new Chunk[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadChunk(Chunk chunk) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isChunkLoaded(int x, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void loadChunk(int x, int z) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean loadChunk(int x, int z, boolean generate) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(Chunk chunk) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(int x, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(int x, int z, boolean save) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunkRequest(int x, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean unloadChunkRequest(int x, int z, boolean safe) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean regenerateChunk(int x, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean refreshChunk(int x, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Item dropItem(Location location, ItemStack itemStack) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Item dropItemNaturally(Location location, ItemStack itemStack) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Arrow spawnArrow(Location location, Vector vector, float speed, float spread) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean generateTree(Location location, TreeType treeType) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean generateTree(Location location, TreeType treeType, BlockChangeDelegate blockChangeDelegate) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LivingEntity spawnCreature(Location location, EntityType entityType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LivingEntity spawnCreature(Location location, CreatureType creatureType) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LightningStrike strikeLightning(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public LightningStrike strikeLightningEffect(Location location) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Entity> getEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<LivingEntity> getLivingEntities() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> tClass) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Player> getPlayers() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public UUID getUID() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Location getSpawnLocation() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean setSpawnLocation(int x, int y, int z) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getTime() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTime(long l) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getFullTime() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setFullTime(long l) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasStorm() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setStorm(boolean hasStorm) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getWeatherDuration() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWeatherDuration(int duration) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isThundering() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setThundering(boolean thundering) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getThunderDuration() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setThunderDuration(int duration) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power) {
        return createExplosion(x, y, z, power, true);
    }

    @Override
    public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(Location location, float power) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean createExplosion(Location location, float power, boolean setFire) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Environment getEnvironment() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getSeed() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getPVP() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setPVP(boolean pvp) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ChunkGenerator getGenerator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void save() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<BlockPopulator> getPopulators() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T extends Entity> T spawn(Location location, Class<T> tClass) throws IllegalArgumentException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playEffect(Location location, Effect effect, int data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void playEffect(Location location, Effect effect, int data, int radius) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public <T> void playEffect(Location location, Effect effect, T data, int radius) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getAllowAnimals() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getAllowMonsters() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Biome getBiome(int x, int z) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getTemperature(int x, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public double getHumidity(int x, int z) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getMaxHeight() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getSeaLevel() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean getKeepSpawnInMemory() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setKeepSpawnInMemory(boolean keepLoaded) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean isAutoSave() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setAutoSave(boolean value) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDifficulty(Difficulty difficulty) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Difficulty getDifficulty() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public File getWorldFolder() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public WorldType getWorldType() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean canGenerateStructures() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getTicksPerAnimalSpawns() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTicksPerAnimalSpawns(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getTicksPerMonsterSpawns() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setTicksPerMonsterSpawns(int i) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setMetadata(String s, MetadataValue metadataValue) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<MetadataValue> getMetadata(String s) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean hasMetadata(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void removeMetadata(String s, Plugin plugin) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<String> getListeningPluginChannels() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
