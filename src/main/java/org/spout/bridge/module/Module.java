package org.spout.bridge.module;

/**
 * A module in the bridge.
 */
public interface Module {
	
	/**
	 * Provides a converter for the specified types.
	 * 
	 * @param <T> The type to convert from.
	 * @param <R> The type to conver to.
	 * @param from The class of the type being converted from.
	 * @param to The class of the type being converted to.
	 * @return A converter for the two types, or null if none exists.
	 */
	public <T,R> Converter<T,R> getConverter(Class<T> from, Class<R> to);
	
	/**
	 * Provides a bidirectional converter for the specified types.
	 * 
	 * @param <T> The type to convert from.
	 * @param <R> The type to conver to.
	 * @param from The class of the type being converted from.
	 * @param to The class of the type being converted to.
	 * @return A bidirectional converter for the two types, or null if none exists.
	 */
	public <T,R> BidiConverter<T,R> getBidiConverter(Class<T> from, Class<R> to);
	
	/**
	 * Called when the module is loaded.
	 */
	public void init();
}
