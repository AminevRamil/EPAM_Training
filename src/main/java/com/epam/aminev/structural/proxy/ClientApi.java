package com.epam.aminev.structural.proxy;

import com.epam.aminev.behavioral.MyIterator;

/**
 * The interface to work with repository from client's side
 */
public interface ClientApi {
    /**
     * Method that get domain entity
     * @param id of desired entity
     * @return copy of specified account
     */
    Account getById(int id);

    /**
     * Method that should create an iterator for
     * proxy repository
     * @return new instance of iterator
     */
    MyIterator iterator();
}
