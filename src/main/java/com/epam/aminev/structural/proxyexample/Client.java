package com.epam.aminev.structural.proxyexample;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client {
    private ClientApi repo;

    public void configure(ClientApi service){
        this.repo = service;
    }

    /**
     * Imitates client's requests
     */
    public void makeDummyRequest(){
        int id = (int)(Math.random()*100);
        log.info("Requesting account with id " + id);
        repo.getById(id);
    }
}
