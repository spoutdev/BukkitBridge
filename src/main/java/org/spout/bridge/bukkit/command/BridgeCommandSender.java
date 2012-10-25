package org.spout.bridge.bukkit.command;

import java.util.Set;

import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class BridgeCommandSender implements CommandSender {
	@Override
	public void sendMessage(String s) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void sendMessage(String[] strings) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Server getServer() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getName() {
		throw new UnsupportedOperationException();
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
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void recalculatePermissions() {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOp() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setOp(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
