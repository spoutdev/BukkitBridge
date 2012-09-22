package org.spout.bridge.module.hook;

/**
 * A NodeQuery is a Query identified by a node. This is the
 * standard type of Query in Bridge.
 * 
 * @author Pamelloes
 * @version 1.1
 *
 * @param <T> The return type of the Query.
 * 
 * @see Hook
 * @see Query
 * @see NodeHook
 * @see NodeQueryHandler
 */
public interface NodeQuery<T>  extends Query<T>, NodeHook {}
