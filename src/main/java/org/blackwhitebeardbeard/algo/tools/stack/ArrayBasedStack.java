package org.blackwhitebeardbeard.algo.tools.stack;

import lombok.NonNull;

import java.util.Optional;

/**
 * A Stack based on an array.
 * @param <T> parameter of stored value.
 */
public class ArrayBasedStack<T> implements Stack<T> {

    private final int size;

    private final T[] tArray;

    private Integer headIndex;

    public ArrayBasedStack(final int size) {
        this.size = size;
        tArray = (T[]) new Object[size];
        headIndex = null;
    }

    @Override
    public void push(T t) {
        headIndex = Optional
                .ofNullable(headIndex)
                .map(index -> index + 1)
                .orElse(0);

        if (headIndex == size) {
            throw new RuntimeException(String.format("No more space in stack. Unable to insert %s", t));
        }

        tArray[headIndex] = t;
    }

    @Override
    public T pop() {
        if (headIndex == null) {
            throw new RuntimeException("No elements in stack to pop.");
        }

        final T value = tArray[headIndex];

        if (headIndex == 0) {
            headIndex = null;
        } else {
            headIndex--;
        }

        return value;
    }

    @Override
    public Optional<T> peek() {
        return Optional
                .ofNullable(headIndex)
                .map(index -> tArray[headIndex]);
    }

}
