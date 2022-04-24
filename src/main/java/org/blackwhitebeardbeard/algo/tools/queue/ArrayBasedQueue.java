package org.blackwhitebeardbeard.algo.tools.queue;

public class ArrayBasedQueue<T> implements Queue<T> {

    private final int size;

    private Integer front;

    private Integer back;

    private final T[] tArray;

    public ArrayBasedQueue(final int size) {
        this.size = size;
        tArray = (T[]) new Object[size];
        front = null;
        back = null;
    }

    @Override
    public void enqueue(T t) {

        if (front == null) {
            // If front is null, then there are no elements in queue.
            front = back = 0;
        } else {
            int newBack = back + 1;
            if (newBack == size) {
                // Wrap around newBack to front of array if newBack == size
                newBack = 0;
            }
            if (front == newBack) {
                // If front == newBack then the array is full and the element can't be added.
                throw new RuntimeException(String.format("Queue is full. Unable to enqueue %s", t));
            }
            back = newBack;
        }
        tArray[back] = t;
    }

    @Override
    public T dequeue() {
        if (front == null) {
            throw new RuntimeException("No element in Queue.");
        }
        final T element = tArray[front];

        // front is equal to back when there's only one element in the queue.
        if (front.equals(back)) {
            // If they're equal, then there's no more elements after de-queuing.
            front = back = null;
        } else {
            front++;
            // If front == size after incrementing then front has reached the end of the array,
            // and it needs to be moved to the front of the array.
            if (front == size) {
                front = 0;
            }
        }
        return element;
    }
}
