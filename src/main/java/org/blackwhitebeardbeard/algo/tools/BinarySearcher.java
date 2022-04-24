package org.blackwhitebeardbeard.algo.tools;

import lombok.NonNull;

import java.util.Comparator;

/**
 * A class that defines tools to perform Binary Search.
 */
public class BinarySearcher {

    /**
     * Checks if an element is present in an array using binary search.
     * @param tArray input array to check in (non-null)
     * @param t element to search for in the array (can be null if comparator can compare null)
     * @param tComparator {@link Comparator} of T to check <>= for T (non-null)
     * @return true if found in array, false otherwise
     * @param <T> type of array and search element
     */
    public static <T> boolean IsElementPresentInArray(
            @NonNull final T[] tArray, final T t, @NonNull final Comparator<T> tComparator) {

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
