package org.spout.bridge.module.hook;

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
 * @version 2.1
 * @see Query
 * @see NodeHook
 * @see NodeQuery
 * @see ConfigurationQuery
 * @see BlockQuery
 */
public interface Hook {

	/**
	 * Configures the Hook to have the given settings.
	 * 
	 * @param name The new name of the Hook.
	 * @param args The new arguments of the Hook.
	 * 
	 * @throws IllegalArgumentException If the name does not match the pattern "\p{Alnum}+: \p{ASCII}".
	 */
	public void configure(String name, Object ...args);
	
	/**
	 * Gets the Hook's name.
	 * 
	 * @return The Hook's name.
	 */
	public String getName();
	
	/**
	 * Gets the Hook's arguments.
	 * 
	 * @return An array of the Hooks arguments. Can be empty but not null.
	 */
	public Object[] getArgs();

}
