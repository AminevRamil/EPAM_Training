package aminev.services;

import aminev.Human;

import java.util.Collection;

/**
 * The interface that should implement any repository implementations
 * to indicate that they guarantee have minimum of methods to work
 * with databases or any other kind of repositories
 *
 * @param <T> is a type with Repository will work
 * @author Aminev Ramil
 */
public interface Repository<T extends Human> {
    /**
     * That method will generate random domain entity during lesson 4
     *
     * @return instance of domain entity
     */
    T find();

    /**
     * That method should save entity in repository
     *
     * @param t is entity to be saved
     */
    void save(T t);

    /**
     * That method should remove entity from repository
     *
     * @param t is entity to be removed
     */
    void remove(T t);

    /**
     * That method should saving all given entities to repository
     *
     * @param c is a collection of entities
     */
    void saveAll(Collection<T> c);

}
