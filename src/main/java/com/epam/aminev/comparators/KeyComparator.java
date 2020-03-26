package com.epam.aminev.comparators;

import java.util.Comparator;
import java.util.Map;

/**
 * The {@code KeyComparator} generic class meant to be used to  sort HashMap by key
 *
 * @param <K> the type of Key in map's entry
 * @param <V> the type of value in map's entry
 * @see Comparator
 * @see Map
 */
public class KeyComparator<K extends Comparable<K>, V extends Comparable<V>> implements Comparator<Map.Entry<K, V>> {

    /**
     * Implementation of interface {@code Comparator}
     *
     * @param e1 the first entry to be compared
     * @param e2 the second entry to be compared
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     */
    @Override
    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
        if (e1 == null || e2 == null) throw new NullPointerException("Can't compare null entry by key");
        return e1.getKey().compareTo(e2.getKey());
    }
}
