package org.spout.bridge.module.query;

/**
 * A query represents a request for data to the main module.
 * 
 * @param <T> The return type of the query.
 */
public class Query<T> {
	private String name;
	private Object[] args;
	private T result = null;
	
	public Query(String name, Object...args) {
		this.name = name;
		this.args = args;
	}
	
	public String getName() {
		return name;
	}
	
	public Object[] getArgs() {
		return args;
	}
	
	public void setResult(T result) {
		this.result = result;
	}
	
	public T getResult() {
		return result;
	}
}
