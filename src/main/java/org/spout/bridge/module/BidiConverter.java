package org.spout.bridge.module;

/**
 * A BidiConverter is used to perform a two-way ("A" can be converted to "B" and "B"
 * can be converted to "A") conversion between objects of one API and another.
 *
 * @param <T> Type: The object to be converted from.
 * @param <R> Result: The second object to be converted to. 
 */
public interface BidiConverter<T, R> extends Converter<T, R> {

	/**
	 * Converts an object of type R into type T. Used
	 * for bridging APIs.
	 */
	public T convertResult(R source);
}
