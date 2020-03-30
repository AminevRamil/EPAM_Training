package com.epam.aminev.structural.proxy;

import com.epam.aminev.behavioral.MyIterator;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.*;

/**
 *
 */
@Slf4j
public class RealRepository implements ClientApi {

    private int maxId = 100;

    private List<Account> list;

    RealRepository() {
        log.info("Creating RealRepository instance");
        list = new ArrayList<>();
        for (int i = 0; i < maxId; i++) {
            list.add(createRandomAccount(i));
        }
    }

    @Override
    public Account getById(int id) {
        if (id >= maxId) throw new ProxyException("There is no entity with specified id");
        log.info("Getting from repository (id: " + id + ")");
        Account account = list.get(id);
        return account.copy();
    }

    /**
     * Заглушка, обход которой не придумал. В этом классе нет кэша
     * @return null
     */
    @Override
    public MyIterator iterator() {
        return null;
    }

    public int getMaxId() {
        return maxId;
    }

    Set<Integer> getIdSet() {
        Set<Integer> set = new HashSet<>(Collections.emptySet());
        list.forEach(account -> set.add(account.id));
        return set;
    }

    private Account createRandomAccount(int id) {
        return new Account(id, "name",
                LocalDate.now().minusDays((int) (Math.random() * 30)));
    }


}
