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

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.permissions.Permission;

public class BridgeConsoleCommandSender extends BridgeCommandSender implements ConsoleCommandSender {
	@Override
	public void sendMessage(String s) {
		sendRawMessage(s);
	}

	@Override
	public void sendMessage(String[] strings) {
		for (String msg : strings) {
			sendMessage(msg);
		}
	}

	@Override
	public String getName() {
		return "CONSOLE";
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
	public boolean isOp() {
		return true;
	}

	@Override
	public void setOp(boolean paramBoolean) {
		throw new UnsupportedOperationException("Console op status can not be changed.");
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
		System.out.println(paramString);
	}
}
