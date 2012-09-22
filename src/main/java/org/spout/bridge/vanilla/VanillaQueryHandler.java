package org.spout.bridge.vanilla;

import org.spout.bridge.module.hook.NodeQuery;
import org.spout.bridge.module.hook.Query;

public class VanillaQueryHandler {
	@SuppressWarnings("unused")
	private final VanillaModule module;
	private final VanillaConfigurationQueryHandler config;
	private final VanillaBlockQueryHandler block;
	
	public VanillaQueryHandler(VanillaModule module) {
		this.module = module;
		config = new VanillaConfigurationQueryHandler(module);
		block = new VanillaBlockQueryHandler(module);
	}
	
	public <T> void processQuery(Query<T> query) {
		if(!(query instanceof NodeQuery)) return;
		NodeQuery<T> nq = (NodeQuery<T>) query;
		String prefix = nq.getBase();
		if(prefix.equals("Configuration")) config.processQuery(nq);
		else if(prefix.equals("Block")) block.processQuery(nq);
		else throw new IllegalArgumentException("The given prefix \"" + prefix + "\" is invalid.");
	}
}
