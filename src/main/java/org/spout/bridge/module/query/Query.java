package org.spout.bridge.module.query;

/**
 * A query represents a request for data to the main module. Queries are identified
 * by their name. The name starts with a prefix, which identifies the type of query.
 * The rest of the information is query-specific. The valid queries are as follows:
 * <ul>
 * <li>Configuration:^</li>
 * </ul>
 * Note that "^" is used to represent a space.
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
