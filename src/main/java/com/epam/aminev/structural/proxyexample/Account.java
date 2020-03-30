package com.epam.aminev.structural.proxyexample;

import java.time.LocalDate;

public class Account {
    int id;
    String name;

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getLastAccessDate() {
        return LocalDate.now().minusDays((int) (Math.random() * 30));
    }
}
