package com.epam.aminev.structural.proxyexample;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class RealRepository implements ClientApi{

    private int maxId = 100;

    private List<Account> list;

    RealRepository(){
        log.info("Creating RealRepository instance");
        list = new ArrayList<>();
        for (int i = 0; i < maxId; i++){
            list.add(createRandomAccount(i));
        }
    }

    private Account createRandomAccount(int id) {
        return new Account(id, "name");
    }

    @Override
    public Account getById(int id) {
        log.info("Getting from repository (id: " + id + ")");
        return list.get(id);
    }

    public int getMaxId() {
        return maxId;
    }
}
