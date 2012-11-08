package org.spout.bridge.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.spout.api.event.EventHandler;
import org.spout.bridge.BukkitUtil;
import org.spout.bridge.VanillaBridgePlugin;
import org.spout.vanilla.event.block.RedstoneChangeEvent;

public class BlockListener extends AbstractListener{
	public BlockListener(VanillaBridgePlugin plugin) {
		super(plugin);
	}

	@EventHandler
	public void onRedstoneChange(RedstoneChangeEvent event) {
		if (event.isCancelled()) {
			return;
		}

		BlockRedstoneEvent redstoneEvent = new BlockRedstoneEvent(BukkitUtil.fromBlock(event.getBlock()), event.getPreviousPower(), event.getNewPower());
		Bukkit.getPluginManager().callEvent(redstoneEvent);
		if (redstoneEvent.getNewCurrent() != event.getNewPower()) {
			event.setCancelled(true);
		}
	}
}
