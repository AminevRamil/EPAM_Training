package com.epam.aminev.structural.proxy;


import com.epam.aminev.behavioral.MyIterator;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * The {@code ProxyService} class is works with RealRepository
 * but creates cache of recently accessed Accounts.
 * What means "recently" regulates by RECENTLY_THRESHOLD field
 * that consider passed days since last access
 */
@Slf4j
public class ProxyService implements ClientApi {

    private static final int RECENTLY_THRESHOLD = 8;
    private RealRepository repository;

    private HashMap<Integer, Account> cache;

    public ProxyService() {
        log.info("Creating proxy repository");
        repository = new RealRepository();
        createCache();
    }

    /**
     * Creates or updates cache. Should used time by time
     */
    private void createCache() {
        log.info("Creating cache");
        if (cache == null) cache = new HashMap<>();
        else cache.clear();

        Account current;
        LocalDate lastAccess;
        int counter = 0;
        for (int id = 0; id < repository.getMaxId(); id++) {
            current = repository.getById(id);
            lastAccess = current.getLastAccess();
            if (lastAccess.until(LocalDate.now(), DAYS) <= RECENTLY_THRESHOLD) {
                cache.put(current.getId(), current);
                counter++;
            }
        }
        log.info("Cached " + counter + " entities");
    }

    /**
     * Getting Account by it's id. Checks for the
     * specified account in the cache
     *
     * @param id that to be get
     * @return account with specified id
     */
    @Override
    public Account getById(int id) {
        if (isCached(id)) return getFromCache(id);
        else {
            try {
                // Imitates time costs of searching in repository
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return repository.getById(id);
        }
    }

    /**
     * Creates instance of iterator that bypass
     * service starting from cache
     */
    public MyIterator iterator() {
        return new IteratorImpl(this);
    }

    /**
     * Method that tries to get entity from repository
     * @param id of entity to find
     * @return copy of specified entity
     */
    private Account getFromCache(int id) {
        log.info("Getting from cache (id: " + id + ")");
        return cache.get(id);
    }

    /**
     * Check if specified account is in cache
     * @param id of entity to find
     * @return true if entity is cached, and false if not
     */
    private boolean isCached(int id) {
        return cache.containsKey(id);
    }

    /**
     * Need to MyIterator work
     * @return set of cached id
     */
    public Set<Integer> getCachedId() {
        return this.cache.keySet();
    }

    /**
     * Need to MyIterator work
     * @return set of id in repository
     */
    Set<Integer> getIdSet() {
        return repository.getIdSet();
    }
}
