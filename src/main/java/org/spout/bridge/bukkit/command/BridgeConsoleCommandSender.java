package org.spout.bridge.bukkit.command;

import java.util.Set;

import org.bukkit.Server;
import org.bukkit.ChatColor;
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
		System.out.println(paramString);
	}

	@Override
	public void sendMessage(String[] paramArrayOfString) {
		for (String msg : paramArrayOfString) {
			sendMessage(msg);
		}
	}

	@Override
	public Server getServer() {
		return server;
	}

	@Override
	public String getName() {
		return "CONSOLE";
	}

	@Override
	public boolean isPermissionSet(String paramString) {
		return true;
	}

	@Override
	public boolean isPermissionSet(Permission paramPermission) {
		return true;
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
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin) {
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin, String paramString, boolean paramBoolean, int paramInt) {
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin, int paramInt) {
		return null;
	}

	@Override
	public void removeAttachment(PermissionAttachment paramPermissionAttachment) {
	}

	@Override
	public void recalculatePermissions() {
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return null; // TODO: Return null or a Set of all permissions as this is the console?
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void acceptConversationInput(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean beginConversation(Conversation paramConversation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void abandonConversation(Conversation paramConversation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abandonConversation(Conversation paramConversation, ConversationAbandonedEvent paramConversationAbandonedEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendRawMessage(String paramString) {
		System.out.println(ChatColor.stripColor(paramString));
	}
}
