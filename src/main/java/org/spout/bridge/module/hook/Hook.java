package org.spout.bridge.module.hook;

import java.util.regex.Pattern;

/**
 * A hook represents is used to send data to the main module. Hooks are identified
 * by their name. The name starts with an alpha-numeric prefix, which identifies the type of query.
 * The rest of the information is hook-specific. The current prefixes are as follows:
 * <ul>
 * <li>{@link ConfigurationQuery Configuration}</li>
 * <li>{@link BlockQuery Block}</li>
 * </ul>
 * 
 * @author Pamelloes
 * @version 2.0
 * @see Query
 * @see NodeQuery
 * @see ConfigurationQuery
 * @see BlockQuery
 */
public class Hook {
	private static final Pattern VALID_NAME = Pattern.compile("\\p{Alnum}+: \\p{Alnum}+");
	private static final Object[] EMPTY_ARRAY = new Object[0];
	private String name;
	private Object[] args;
	
	/**
	 * Creates a new Hook with the given settings.
	 * 
	 * @param name The name of the Hook. Must have an alpha-numeric prefix and an ascii body.
	 * @param args The data the Hook is being used to send.
	 * 
	 * @throws IllegalArgumentException If the name does not match the pattern "\p{Alnum}+: \p{ASCII}".
	 * 
	 * @see #configure(String,Object[])
	 */
	public Hook(String name, Object...args) {
		configure(name, args);
	}

	/**
	 * Configures the Hook to have the given settings.
	 * 
	 * @param name The new name of the Hook.
	 * @param args The new arguments of the Hook.
	 * 
	 * @throws IllegalArgumentException If the name does not match the pattern "\p{Alnum}+: \p{ASCII}".
	 * 
	 * @see #Hook(String,Object[])
	 */
	public void configure(String name, Object ...args) {
		if(!VALID_NAME.matcher(name).find()) throw new IllegalArgumentException("A Hook's name must follow the format \"\\p{ASCII}+: \\p{Alnum}+\"!");
		this.name = name;
		this.args = args == null ? EMPTY_ARRAY : args;
	}
	
	/**
	 * Gets the Hook's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the Hook's arguments.
	 * 
	 * @return An array of the Hooks arguments. Can be empty but not null.
	 */
	public Object[] getArgs() {
		return args;
	}

}
