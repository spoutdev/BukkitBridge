package org.spout.bridge.bukkit;

import org.spout.bridge.module.BidiConverter;
import org.spout.bridge.module.Converter;
import org.spout.bridge.module.Module;

public class BukkitModule implements Module {

	@Override
	public <T, R> Converter<T, R> getConverter(Class<T> from, Class<R> to) {
		// TODO Add in converters.
		return null;
	}

	@Override
	public <T, R> BidiConverter<T, R> getBidiConverter(Class<T> from, Class<R> to) {
		// TODO Add in converters.
		return null;
	}

	@Override
	public void init() {
		// TODO Setup Bukkit.
	}

}
