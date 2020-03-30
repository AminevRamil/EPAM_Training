package com.epam.aminev.creational;

import com.epam.aminev.structural.proxy.Account;

/**
 * Prototype pattern that implemented in {@link com.epam.aminev.structural.proxy.Account}
 * @param <T> is type of object to clone
 */
public interface Prototype {
    Account copy();
}
