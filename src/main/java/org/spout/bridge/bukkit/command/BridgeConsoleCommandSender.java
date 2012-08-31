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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMessage(String[] paramArrayOfString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Server getServer() {
		return server;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPermissionSet(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPermissionSet(Permission paramPermission) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin, String paramString, boolean paramBoolean, int paramInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin paramPlugin, int paramInt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAttachment(PermissionAttachment paramPermissionAttachment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recalculatePermissions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

}
