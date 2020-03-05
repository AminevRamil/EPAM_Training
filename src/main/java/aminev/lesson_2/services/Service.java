package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.dto.HumanDTO;

import java.util.Collection;

public class Service<ENTITY extends Human, DTO extends HumanDTO> {

    private Repository<ENTITY> repository;
    private HumanConverter converter;

    public Service() {
        repository = new Repository<>();
        converter = new HumanConverter();
    }

    public DTO getById(int id){
        HumanDTO dto = converter.toDTO(repository.find());
        dto.setId(id);
        return (DTO)dto;
    }

    public void save(DTO dto){
        repository.save((ENTITY)converter.toEntity(dto));
    }

    public void addAllToRepository(Collection<HumanDTO> humanDtoCollection) {
        for (HumanDTO dto: humanDtoCollection) {
            repository.save((ENTITY)converter.toEntity(dto));
        }
    }
}
