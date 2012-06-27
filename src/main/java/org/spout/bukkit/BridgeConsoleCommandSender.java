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

import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import org.spout.api.command.CommandSource;

/**
 * @author zml2008
 */
public class BridgeConsoleCommandSender implements ConsoleCommandSender {
	private final CommandSource commandSource;

	public BridgeConsoleCommandSender(CommandSource commandSource) {
		this.commandSource = commandSource;
	}

	public void sendMessage(String s) {
		commandSource.sendMessage(s);
	}

	public void sendMessage(String[] strings) {
		for (String message : strings) {
			sendMessage(message);
		}
	}

	public Server getServer() {
		return Bukkit.getServer();
	}

	public String getName() {
		return "CONSOLE"; // This is necessary for plugins, which use this to identify the CommandSender as Console
	}

	public boolean isConversing() {
		return false; //TODO: Adjust for usage with Spout!
	}

	public void acceptConversationInput(String s) {
		//TODO: Adjust for usage with Spout!
	}

	public boolean beginConversation(Conversation conversation) {
		return false; //TODO: Adjust for usage with Spout!
	}

	public void abandonConversation(Conversation conversation) {
		//TODO: Adjust for usage with Spout!
	}

	public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {
		//TODO: Adjust for usage with Spout!
	}

	public void sendRawMessage(String s) {
		commandSource.sendRawMessage(s);
	}

	public boolean isPermissionSet(String s) {
		return false; //TODO: Adjust for usage with Spout!
	}

	public boolean isPermissionSet(Permission permission) {
		return false; //TODO: Adjust for usage with Spout!
	}

	public boolean hasPermission(String s) {
		return commandSource.hasPermission(s);
	}

	public boolean hasPermission(Permission permission) {
		return hasPermission(permission.getName());
	}

	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		return null; //TODO: Adjust for usage with Spout!
	}

	public PermissionAttachment addAttachment(Plugin plugin) {
		return null; //TODO: Adjust for usage with Spout!
	}

	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		return null; //TODO: Adjust for usage with Spout!
	}

	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		return null; //TODO: Adjust for usage with Spout!
	}

	public void removeAttachment(PermissionAttachment permissionAttachment) {
		//TODO: Adjust for usage with Spout!
	}

	public void recalculatePermissions() {
		 //TODO: Adjust for usage with Spout!
	}

	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return null; //TODO: Adjust for usage with Spout!
	}

	public boolean isOp() {
		return true;
	}

	public void setOp(boolean b) {
		throw new UnsupportedOperationException("Cannot set the op status for the console");
	}
}
