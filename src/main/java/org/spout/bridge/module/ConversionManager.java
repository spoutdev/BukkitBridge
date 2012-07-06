package org.spout.bridge.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversionManager {
	private static List<Converter<?,?>> converters;
	private static Map<Pair<Class<?>,Class<?>>,Conversion<?,?>> conversions;
	
	public static void init() {
		conversions = new HashMap<Pair<Class<?>,Class<?>>, Conversion<?,?>>();
		converters = new ArrayList<Converter<?,?>>();
	}
	
	@SuppressWarnings("unchecked")
	public static <A,B> Conversion<A,B> getConversion(Class<A> a, Class<B> b) {
		return (Conversion<A, B>) conversions.get(new Pair<Class<A>, Class<B>>(a, b));
	}
	
	public static <A,B> void addConverter(Converter<A,B> converter) {
		for(Converter<?,?> c : converters) if(c.getType().equals(converter.getType()) && c.getResult().equals(converter.getResult())) return; //duplicates make things tricky so we just ignore them.
		converters.add(converter);
	}
	
	/**
	 * Recalculates the possible conversions. This method is resource intensive and should
	 * be called sparingly.
	 */
	public static void process() {
		conversions.clear();
		for(int i = 0; i < converters.size(); i++) {
			Converter<?,?> converter = converters.get(i);
			ArrayList<Converter<?,?>> stack = new ArrayList<Converter<?,?>>();
			stack.add(converter);
			calculateConversions(converter.getType(), converter.getResult(), stack);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void calculateConversions(Class<?> start, Class<?> current, ArrayList<Converter<?,?>> stack) {
		Pair<Class<?>, Class<?>> pair = new Pair<Class<?>, Class<?>>(start, current);
		if(conversions.containsKey(pair)) return;
		conversions.put(new Pair<Class<?>, Class<?>>(start, current), new Conversion(stack.toArray(new Converter<?,?>[stack.size()])));
		for(int i = 0; i < converters.size(); i++) {
			Converter<?,?> add = converters.get(i);
			if(stack.contains(add)) continue;
			Class<?> addtype = add.getType();
			if(addtype.equals(current)) {
				ArrayList<Converter<?,?>> newstack = (ArrayList<Converter<?,?>>) stack.clone();
				newstack.add(add);
				calculateConversions(start, current, newstack);
			}
		}
	}
	
	public static class Conversion<A,B> {
		private Converter<?,?>[] conversions;
		
		public Conversion() {
			this(null);
		}
		
		public Conversion(Converter<?,?>[] conversions) {
			this.conversions = conversions;
		}
		
		public void setConversions(Converter<?,?>[] conversions) {
			this.conversions = conversions;
		}
		
		public Converter<?,?>[] getConversions() {
			return conversions;
		}
		
		public Object convert(Object parameter) {
			Object o = parameter;
			for(int i = 0; i < conversions.length; i++) o = conversions[i].convertType(o);
			return o;
		}
	}
}
