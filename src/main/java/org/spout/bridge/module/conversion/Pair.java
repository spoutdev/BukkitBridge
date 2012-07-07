package org.spout.bridge.module.conversion;

public class Pair<A, B> {
	private A a;
	private B b;

	public Pair() {
		this(null, null);
	}

	public Pair(A a, B b) {
		this.a = a;
		this.b = b;
	}

	public void setA(A a) {
		this.a = a;
	}

	public A getA() {
		return a;
	}

	public void setB(B b) {
		this.b = b;
	}

	public B getB() {
		return b;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Pair<?, ?>)) return false;
		Pair<?, ?> other = (Pair<?, ?>) o;
		if (!other.a.equals(a)) return false;
		if (!other.b.equals(b)) return false;
		return true;
	}
}
