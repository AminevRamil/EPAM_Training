package com.epam.aminev.structural.proxy;

import com.epam.aminev.creational.Prototype;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

/**
 * The {@code Account} class represents some account that
 * record date of last access. It used to caching entities
 * in proxy repository
 */
@Slf4j
@Setter
@Getter
public class Account implements Prototype {
    int id;
    String name;
    LocalDate lastAccess;

    /**
     * Construct basic Account instance
     * @param id of account in repository
     * @param name of entity
     * @param lastAccess date
     */
    public Account(int id, String name, LocalDate lastAccess) {
        this.id = id;
        this.name = name;
        this.lastAccess = lastAccess;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastAccess=" + lastAccess +
                '}';
    }

    @Override
    public Account copy() {
        return new Account(id, name, lastAccess);
    }
}
