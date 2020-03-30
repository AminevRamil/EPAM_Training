package com.epam.aminev.structural.proxyexample;


import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.HashMap;

import static java.time.temporal.ChronoUnit.DAYS;

@Slf4j
public class ProxyService implements ClientApi {

    private RealRepository repository;

    HashMap<Integer, Account> cache;

    public ProxyService() {
        log.info("Creating proxy repository");
        repository = new RealRepository();
        createCache();
    }

    /**
     * Creates or updates cache
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
            lastAccess = current.getLastAccessDate();
            if (lastAccess.until(LocalDate.now(), DAYS) <= 5) {
                cache.put(current.getId(), current);
                counter++;
            }
        }
        log.info("Cached " + counter + " entities");
    }

    /**
     * @param id that to be get
     * @return account with specified id
     */
    @Override
    public Account getById(int id) {
        if (isCached(id)) return getFromCache(id);
        else return repository.getById(id);

    }

    private Account getFromCache(int id) {
        log.info("Getting from cache (id: " + id + ")");
        return cache.get(id);
    }

    private boolean isCached(int id) {
        return cache.containsKey(id);
    }
}
