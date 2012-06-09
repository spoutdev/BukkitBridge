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
package org.spout.bukkit.scheduler;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scheduler.BukkitWorker;

import org.spout.api.scheduler.Scheduler;
import org.spout.api.scheduler.TaskPriority;

public class BridgeScheduler implements BukkitScheduler {
	private final Scheduler scheduler;

	public BridgeScheduler(Scheduler scheduler) {
		this.scheduler = scheduler;
	}

	public int scheduleSyncDelayedTask(Plugin plugin, Runnable runnable, long l) {
		return scheduler.scheduleAsyncDelayedTask(plugin, runnable, l, TaskPriority.HIGH);
	}

	public int scheduleSyncDelayedTask(Plugin plugin, Runnable runnable) {
		return scheduler.scheduleSyncDelayedTask(plugin, runnable);
	}

	public int scheduleSyncRepeatingTask(Plugin plugin, Runnable runnable, long l, long l1) {
		return scheduler.scheduleSyncRepeatingTask(plugin, runnable, l, l1, TaskPriority.HIGH);
	}

	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable runnable, long l) {
		return scheduler.scheduleAsyncDelayedTask(plugin, runnable, l, TaskPriority.HIGH);
	}

	public int scheduleAsyncDelayedTask(Plugin plugin, Runnable runnable) {
		return scheduler.scheduleAsyncDelayedTask(plugin, runnable, TaskPriority.HIGH);
	}

	public int scheduleAsyncRepeatingTask(Plugin plugin, Runnable runnable, long l, long l1) {
		return scheduler.scheduleAsyncRepeatingTask(plugin, runnable, l, l1, TaskPriority.HIGH);
	}

	public <T> Future<T> callSyncMethod(Plugin plugin, Callable<T> tCallable) {
		return scheduler.callSyncMethod(plugin, tCallable, TaskPriority.HIGH);
	}

	public void cancelTask(int i) {
		scheduler.cancelTask(i);
	}

	public void cancelTasks(Plugin plugin) {
		scheduler.cancelTasks(plugin);
	}

	public void cancelAllTasks() {
		scheduler.cancelAllTasks();
	}

	public boolean isCurrentlyRunning(int i) {
		return false; //TODO: Adjust for usage with Spout!
	}

	public boolean isQueued(int i) {
		return scheduler.getPendingTasks().contains(i);
	}

	public List<BukkitWorker> getActiveWorkers() {
		return Collections.emptyList(); //TODO: Adjust for usage with Spout!
	}

	public List<BukkitTask> getPendingTasks() {
		return Collections.emptyList(); //TODO: Adjust for usage with Spout!
	}
}
