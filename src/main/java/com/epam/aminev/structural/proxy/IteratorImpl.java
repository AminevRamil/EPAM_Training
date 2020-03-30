package com.epam.aminev.structural.proxy;

import com.epam.aminev.behavioral.MyIterator;

import java.util.Iterator;
import java.util.Set;

/**
 * The {@code IteratorImpl} class allows to bypass
 * a repository starting from cached Accounts
 */

public class IteratorImpl implements MyIterator {

    private ProxyService service;
    private Iterator<Integer> cacheIterator;
    private Iterator<Integer> notCachedIterator;

    /**
     * Construct default iterator with two subiterators
     * @param service which need to bypass
     */
    public IteratorImpl(ProxyService service) {
        this.service = service;
        Set<Integer> cachedId = service.getCachedId();
        cacheIterator = cachedId.iterator();
        Set<Integer> notCachedId = service.getIdSet();
        notCachedId.removeAll(cachedId);
        notCachedIterator = notCachedId.iterator();
    }

    /**
     * Method that give next element in defined order
     * @return copy of next Account
     * @throws ProxyException in case of calling when HasNext() returns false
     */
    @Override
    public Account getNext() {
        if (!hasNext()) throw new ProxyException("There is no more elements in repository");
        if (cacheIterator.hasNext()) return service.getById(cacheIterator.next());
        else return service.getById(notCachedIterator.next());
    }

    /**
     * Check if there next Account in defined order
     * @return true if there is, and false if not
     */
    @Override
    public boolean hasNext() {
        return cacheIterator.hasNext() || notCachedIterator.hasNext();
    }
}
