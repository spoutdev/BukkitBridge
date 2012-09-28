package org.spout.bridge.workbench.server.players;

import java.util.HashMap;
import java.util.Map;

import org.spout.api.Spout;
import org.spout.api.Server;
import org.spout.api.util.access.AccessManager;
import org.spout.api.util.access.BanType;

import net.minecraft.workbench.server.players.BanEntry;
import net.minecraft.workbench.server.players.BanList;

public class WorkbenchBanList implements BanList {

	private AccessManager manager=((Server) Spout.getEngine()).getAccessManager();
	private boolean enabled=true;
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) {
		this.enabled=enabled;
	}

	@Override
	public Map<String, BanEntry> getEntries() {
		Map<String, BanEntry> map =new HashMap<String, BanEntry>();
		for(String name:manager.getBanned(BanType.PLAYER)){
			map.put(name, new WorkbenchBanEntry(name));
		//}for(String ip:manager.getBanned(BanType.IP)){
		//	map.put(ip, new WorkbenchBanEntry(ip));
		}
		return map;
	}

	@Override
	public boolean isBanned(String name) {
		return manager.isBanned(BanType.PLAYER, name)||manager.isBanned(BanType.IP, name);
	}

	@Override
	public void add(BanEntry entry) {
		manager.ban(BanType.PLAYER, entry.getName());
	}

	@Override
	public BanEntry remove(String name) {
		manager.unban(BanType.PLAYER, name);
		return new WorkbenchBanEntry(name);
	}

}
