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

import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import org.spout.bridge.bukkit.BridgeServer;

public class BridgeConsoleCommandSender implements ConsoleCommandSender {
	private final BridgeServer server;

	public BridgeConsoleCommandSender(BridgeServer b) {
		server = b;
	}

	@Override
	public void sendMessage(String paramString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendMessage(String[] paramArrayOfString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Server getServer() {
		return server;
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPermissionSet(String paramString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isPermissionSet(Permission paramPermission) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPermission(String paramString) {
		return true;
	}

	@Override
	public boolean hasPermission(Permission paramPermission) {
		return true;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin, String paramString, boolean paramBoolean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin, String paramString, boolean paramBoolean, int paramInt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin, int paramInt) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removeAttachment(PermissionAttachment paramPermissionAttachment) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void recalculatePermissions() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOp() {
		return true;
	}

	@Override
	public void setOp(boolean paramBoolean) {
	}

	@Override
	public boolean isConversing() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptConversationInput(String paramString) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean beginConversation(Conversation paramConversation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void abandonConversation(Conversation paramConversation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void abandonConversation(Conversation paramConversation, ConversationAbandonedEvent paramConversationAbandonedEvent) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void sendRawMessage(String paramString) {
		throw new UnsupportedOperationException();
	}
}
