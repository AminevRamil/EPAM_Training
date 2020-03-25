package com.epam.aminev.comparators;

import com.epam.aminev.entities.Human;

import java.util.Comparator;

/**
 * The {@code NameComparator} class compare two Human instances by Name
 */
public final class NameComparator implements Comparator<Human> {

    /**
     * Implementation of interface {@code Comparator}
     *
     * @param h1 the first Human to be compared.
     * @param h2 the second Human to be compared.
     * @return a negative integer, zero, or a positive integer as the
     *         first argument is less than, equal to, or greater than the
     *         second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     */
    @Override
    public int compare(Human h1, Human h2) {
        if (h1 == null || h2 == null) throw new NullPointerException("Can't compare null by name");
        return h1.getName().compareTo(h2.getName());
    }
}