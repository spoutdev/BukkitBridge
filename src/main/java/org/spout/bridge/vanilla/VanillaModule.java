package org.spout.bridge.vanilla;

import java.util.List;

import org.spout.bridge.module.MainModule;
import org.spout.bridge.module.conversion.Converter;
import org.spout.bridge.module.hook.Hook;
import org.spout.bridge.module.query.Query;

public class VanillaModule implements MainModule {

	public void onLoad() {
		// TODO Auto-generated method stub
		
	}

	public List<Hook<?>> getHooks() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Converter<?, ?>> getConverters() {
		// TODO Auto-generated method stub
		return null;
	}

	public void onEnable() {
		// TODO Auto-generated method stub
		
	}
 
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void processQuery(Query<T> query) {
		// TODO Auto-generated method stub
		
	}

}
