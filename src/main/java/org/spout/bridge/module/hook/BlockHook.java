package org.spout.bridge.module.hook;

import java.util.HashMap;
import java.util.Map;

public abstract class BlockHook<T> extends NodeHook<Object[]> {
	public static Map<Thread, Object[]> args = new HashMap<Thread, Object[]>();
	
	public static <T> void callBlockHook(String node, int x, int y, int z, T arg) {
		Object[] o = args.get(Thread.currentThread());
		if(o == null) {
			args.put(Thread.currentThread(), new Object[4]);
			o = args.get(Thread.currentThread());
		}
		o[0] = x;
		o[1] = y;
		o[2] = z;
		o[3] = arg;
		HookManager.callHook("Block: " + node, o);
	}
	
	public BlockHook(String node) {
		super("Block", node);
	}
	
	public abstract void invoke(int x, int y, int z, T arg); 

	@SuppressWarnings("unchecked")
	@Override
	public final void invoke(Object[] data) {
		int x = (Integer) data[0];
		int y = (Integer) data[1];
		int z = (Integer) data[2];
		invoke(x, y, z, (T) data[3]);
	}

}
