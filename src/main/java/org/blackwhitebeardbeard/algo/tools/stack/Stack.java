package org.blackwhitebeardbeard.algo.tools.stack;

import java.util.Optional;

/**
 * Interface for a stack.
 * @param <T> parameter of value stored in stack.
 */
public interface Stack<T> {

    void push(T t);

    T pop();

    Optional<T> peek();
}
