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
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isPermissionSet(String s) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isPermissionSet(Permission permission) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasPermission(String s) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean hasPermission(Permission permission) {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int i) {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
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
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isOp() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public void setOp(boolean b) {
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
