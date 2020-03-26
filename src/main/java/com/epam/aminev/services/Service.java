package com.epam.aminev.services;

import com.epam.aminev.Human;
import com.epam.aminev.dto.HumanDto;

import java.util.Collection;

import com.epam.aminev.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@code Service} class is wraps work with repository
 * by logging it's errors and converting domain entities to
 * Data Transfer Objects before further processing
 *
 * @param <T> is a type of domain entity with repository must work
 * @param <S> is a type of Data Transfer Object in which {@code Service}
 *            will convert received domain entities before returning
 */
@Slf4j
public class Service<T extends Human, S extends HumanDto> {
    private RepositoryImpl<T> repository;
    private HumanConverter converter;

    /**
     * Construct a basic Service instance with simple repository
     */
    public Service() {
        repository = new RepositoryImpl<>();
        if (repository != null) log.info("Успешное подключение к репозиторию");
        converter = new HumanConverter();
    }

    /**
     * Method that trying to find an entity by it's ID
     *
     * @param id of entity to be found
     * @return Data Transfer Object of found entity
     * @throws ServiceException in case of entity with specified ID doesn't exist
     */
    public S getById(int id) {
        log.info("Запрос сущности с идентификатором " + id);
        if (id < 0 || id > 10) {
            log.error("Repository doesn't have entity with specified id (" + id + ")");
            throw new ServiceException(this.getClass().toString() + " - Попытка получения несуществующей сущности");
        }
        HumanDto dto = converter.convert(repository.find());
        dto.setId(id);
        return (S) dto;
    }

    /**
     * Method that trying to save incoming entity
     *
     * @param dto object to be saved
     * @throws ServiceException in case of incoming entity is null
     */
    public void save(S dto) {
        if (dto == null) {
            log.error("Can't save null");
            throw new ServiceException(this.getClass().toString() + " - Can't save null entity");
        }
        repository.save((T) converter.convert(dto));
    }

    /**
     * Method that trying to save all entities in collection to repository
     * @param humanDtoCollection which entities will be saved
     * @see #save(S)
     */
    public void saveAllToRepository(Collection<HumanDto> humanDtoCollection) {
        log.info("Сохранение всех сущностей в коллекции");
        for (HumanDto dto : humanDtoCollection) {
            repository.save((T) converter.convert(dto));
        }
    }
}
