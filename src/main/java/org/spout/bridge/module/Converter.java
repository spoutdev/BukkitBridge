package org.spout.bridge.module;

/**
 * A Converter is used to perform a one-way ("A" can be converted to "B" but "B"
 * can't be converted to "A") conversion between an object in one API to an object
 * in another.
 *
 * @param <T> Type: The object to be converted from.
 * @param <R> Result: The second object to be converted to. 
 */
public interface Converter<T,R> {
	/**
	 * Converts an object of type T into type R. Used
	 * for bridging APIs.
	 */
	public R convertType(T source);
}
