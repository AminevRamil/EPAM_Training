package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.dto.HumanDTO;

import java.util.Collection;

import aminev.lesson_2.exceptions.ServiceException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Service<ENTITY extends Human, DTO extends HumanDTO> {
    private Repository<ENTITY> repository;
    private HumanConverter converter;

    public Service() {
        repository = new Repository<>();
        if (repository != null) log.info("Успешное подключение к репозиторию");
        converter = new HumanConverter();
    }

    public DTO getById(int id) throws ServiceException {
        log.info("Запрос сущности с идентификатором " + id);
        if (id < 0 || id > 10) {
            log.error("Сущности с идентификатором " + id + " не существует!");
            throw new ServiceException(this.getClass().toString() + " - Попытка получения несуществующей сущности");
        }
        HumanDTO dto = converter.toDTO(repository.find());
        dto.setId(id);
        return (DTO) dto;
    }

    public void save(DTO dto) {
        if (dto == null) {
            log.error("Попытка сохранить null");
            throw new NullPointerException(this.getClass().toString() + " - Поданный экземпляр не инициализирован");
        }
        repository.save((ENTITY) converter.toEntity(dto));
    }

    public void addAllToRepository(Collection<HumanDTO> humanDtoCollection) {
        log.info("Сохранение всех сущностей в коллекции");
        for (HumanDTO dto : humanDtoCollection) {
            repository.save((ENTITY) converter.toEntity(dto));
        }
    }
}
