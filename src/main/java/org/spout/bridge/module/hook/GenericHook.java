package org.spout.bridge.module.hook;

import java.util.regex.Pattern;

/**
 * The default implementation of Hook.
 * 
 * @author Pamelloes
 * @version 1.0
 */
public class GenericHook implements Hook {
	private static final Pattern VALID_NAME = Pattern.compile("\\p{Alnum}+: \\p{Alnum}+");
	private static final Object[] EMPTY_ARRAY = new Object[0];
	private String name;
	private Object[] args;
	
	/**
	 * Creates a new GenericHook with the given settings.
	 * 
	 * @param name The name of the Hook. Must have an alpha-numeric prefix and an ascii body.
	 * @param args The data the Hook is being used to send.
	 * 
	 * @throws IllegalArgumentException If the name does not match the pattern "\p{Alnum}+: \p{ASCII}".
	 * 
	 * @see #configure(String,Object[])
	 */
	public GenericHook(String name, Object...args) {
		configure(name, args);
	}
	
	@Override
	public void configure(String name, Object ...args) {
		if(!VALID_NAME.matcher(name).find()) throw new IllegalArgumentException("A Hook's name must follow the format \"\\p{ASCII}+: \\p{Alnum}+\"!");
		this.name = name;
		this.args = args == null ? EMPTY_ARRAY : args;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Object[] getArgs() {
		return args;
	}

}
