package com.epam.aminev;

import com.epam.aminev.behavioral.MyIterator;
import com.epam.aminev.structural.proxy.ClientApi;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    private ClientApi repo;
    MyIterator iterator;

    public void configure(ClientApi service){
        this.repo = service;
    }

    /**
     * Imitates client's requests
     */
    public void makeRequest(){
        int id = (int)(Math.random()*100);
        log.info("Requesting account with id " + id);
        repo.getById(id);
    }

    public void bypassRequest(){
        iterator = repo.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getNext().toString());
        }
    }
}
