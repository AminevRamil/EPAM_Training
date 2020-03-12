package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.dto.AddressDTO;
import aminev.lesson_2.dto.HumanDTO;
import aminev.lesson_2.exceptions.ConverterException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class HumanConverter {

    private AddressConverter adConv;

    public HumanConverter(){
        adConv = new AddressConverter();
    }

    public HumanDTO toDTO(Human human) throws ConverterException{
        log.info("Конвертирование класса Human в класс HumanDTO");
        if (human == null) throw new ConverterException("Попытка конвертировать неинициализированный экземпляр класса Human");
        AddressDTO addressDTO = null;
        try {
            addressDTO = adConv.convert(human.getAddress());
        } catch (ConverterException e){
            log.error(e.getMessage());
        }
        return new HumanDTO(human.getId(), human.getName(), human.getBirthday(), addressDTO);
    }

    public Human toEntity(HumanDTO dto) throws ConverterException{
        log.info("Конвертирование класса HumanDTO в класс Human");
        if (dto == null) throw new ConverterException("Попытка конвертировать неинициализированный экземпляр класса HumanDTO");
        Human.Address address = null;
        try {
            address = adConv.convert(dto.getAddress());
        } catch (ConverterException e){
            log.error(e.getMessage());
        }
        return new Human(dto.getId(), dto.getName(), dto.getBirthday(), address);
    }

}
