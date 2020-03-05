package aminev.lesson_2.services;

import aminev.lesson_2.dto.HumanDTO;

import java.util.Collection;

public class Service {

    private Repository repository;
    private HumanConverter converter;

    public Service() {
        repository = Repository.getInstance();
        converter = new HumanConverter();
    }

    public HumanDTO getById(int id){
        HumanDTO dto = converter.toDTO(repository.get());
        dto.setId(id);
        return dto;
    }

    public void addToRepository(HumanDTO dto){
        repository.add(converter.toEntity(dto));
    }

    public void addAllToRepository(Collection<HumanDTO> humanDtoCollection) {
        for (HumanDTO dto: humanDtoCollection) {
            repository.add(converter.toEntity(dto));
        }
    }
}
