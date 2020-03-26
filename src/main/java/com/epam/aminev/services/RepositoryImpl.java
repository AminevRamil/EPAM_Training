package com.epam.aminev.services;

import com.epam.aminev.Human;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Collection;

/**
 * The {@code RepositoryImpl} is a implementation of a {@code Repository} interface
 * used to encapsulate work with repository e.g. database
 * In Lesson 4 there is no real repository
 *
 * @param <T> is type with repository will work
 * @author Aminev Ramil
 */
@Slf4j
public class RepositoryImpl<T extends Human> implements Repository<T> {

    /**
     * Method that should find entity in repository
     * instead it generate new instance randomly
     *
     * @return instance of domain entity
     */
    @Override
    public T find() {
        log.info("Поиск сущности в репозитории");
        String names[] = {"Jonathan", "Joseph", "Jotaro", "Josuke",
                "Joruno", "Jolyne", "Johnny", "David", "Jack", "George"};
        String countries[] = {"Japan", "USA", "Mexica", "Russia", "Italy"};
        String cities[] = {"New-York", "Rome", "Tokio", "Morioh", "Naples", "Tselinoyarsk",};
        String streets[] = {"40 Years of October", "50 Years of October", "60 Years of October", "70 Years of October",};

        int id = (int) (Math.random() * 100);
        float rating = (float) Math.random() * 5;
        /* Мы разбирали этот пример, и там решали что можно генерировать
        случайное число типа long и по нему создавать Date, но я читал, что
        лучше использовать LocalDate, а в нём нельзя генерировать по числу типа long,
        и нельзя создавать LocalDate используя Date в качастве аргумента конструктора */
        int year = (int) (Math.random() * 70) + 1950;
        int month = (int) (Math.random() * 12) + 1;
        int day = (int) (Math.random() * 29) + 1;
        LocalDate registationDate = LocalDate.of(year, month, day);
        String name = names[(int) (Math.random() * names.length)];
        year = (int) (Math.random() * 70) + 1950;
        month = (int) (Math.random() * 12) + 1;
        day = (int) (Math.random() * 29) + 1;
        LocalDate birthDate = LocalDate.of(year, month, day);
        T.Address address = new T.Address(countries[(int) (Math.random() * countries.length)],
                cities[(int) (Math.random() * cities.length)],
                streets[(int) (Math.random() * streets.length)],
                (int) (Math.random() * 200) + 1);
        T entity = (T) (new Human(id,
                rating,
                registationDate,
                name, birthDate,
                address));
        log.info("Найденная сущность: {}", entity);
        return entity;
    }

    /**
     * That method should save entity in repository
     * instead it just log it
     *
     * @param t is entity to be saved
     */
    @Override
    public void save(T t) {
        log.info("Сохранение сущности в репозиторий: {}", t);
    }

    /**
     * That method should remove entity from repository
     * instead it just log it
     *
     * @param t is entity to be removed
     */
    @Override
    public void remove(T t) {
        log.info("Удаление сущности из репозитория: {}", t);
    }

    /**
     * That method should saving all given entities to repository
     * instead they all will be logged
     *
     * @param collection of entities to be saved
     */
    @Override
    public void saveAll(Collection<T> collection) {
        log.info("Добавление {} сущностей в репозиторий", collection.size());

        for (T h : collection) {
            this.save(h);
        }
    }
}
