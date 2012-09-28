package org.spout.bridge.workbench.server.players;

import java.util.Date;

import net.minecraft.workbench.server.players.BanEntry;

public class WorkbenchBanEntry implements BanEntry {

	private String name;
	private Date created = new Date();
	private String source = "Unknown";
	private Date expires = null;
	private String reason = "Banned from the server";
	
	public WorkbenchBanEntry(String name){
		this.name=name;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public Date getCreated() {
		return created;
	}

	@Override
	public void setCreated(Date created) {
		this.created=created;
	}

	@Override
	public String getSource() {
		return source;
	}

	@Override
	public void setSource(String source) {
		this.source=source;
	}

	@Override
	public Date getExpires() {
		return expires;
	}

	@Override
	public void setExpires(Date expires) {
		this.expires=expires;
	}

	@Override
	public boolean hasExpired() {
		return expires.before(new Date());
	}

	@Override
	public String getReason() {
		return reason;
	}

	@Override
	public void setReason(String reason) {
		this.reason=reason;
	}

}
