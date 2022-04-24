package org.blackwhitebeardbeard.algo.tools;

import java.util.Comparator;

/**
 * A class that defines tools to perform Binary Search.
 */
public class BinarySearcher {

    /**
     * Checks if an element is present in an array using binary search.
     * @param tArray input array to check in (non-null)
     * @param t element to search for in the array
     * @param tComparator {@link Comparator} of T to check <>= for T (non-null)
     * @return true if found in array, false otherwise
     * @param <T> type of array and search element
     */
    public static <T> boolean IsElementPresentInArray(final T[] tArray, final T t, final Comparator<T> tComparator) {
        if (tArray == null || tComparator == null) {
            throw new IllegalArgumentException("Expecting input array and comparators to be non-null.");
        }

        int low = 0;
        int high = tArray.length - 1;
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            final int comparisonResult = tComparator.compare(tArray[mid], t);
            if (comparisonResult == 0) {
                return true;
            } else if (comparisonResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
