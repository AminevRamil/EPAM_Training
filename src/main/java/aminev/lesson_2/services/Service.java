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
        HumanDTO dto = converter.toDTO(repository.get());
        dto.setId(id);
        return (DTO)dto;
    }

    public void addToRepository(DTO dto){
        repository.add((ENTITY)converter.toEntity(dto));
    }

    public void addAllToRepository(Collection<HumanDTO> humanDtoCollection) {
        for (HumanDTO dto: humanDtoCollection) {
            repository.add((ENTITY)converter.toEntity(dto));
        }
    }
}
