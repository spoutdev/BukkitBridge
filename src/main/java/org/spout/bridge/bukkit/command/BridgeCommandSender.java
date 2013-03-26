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
package org.spout.bridge.bukkit.command;

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public abstract class BridgeCommandSender implements CommandSender {
	@Override
	public Server getServer() {
		return Bukkit.getServer();
	}

	@Override
	public boolean isPermissionSet(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPermission(String s) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPermission(Permission permission) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeAttachment(PermissionAttachment permissionAttachment) {

	}

	@Override
	public void recalculatePermissions() {

	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new UnsupportedOperationException();
	}
}
