package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.dto.HumanDTO;
import aminev.lesson_2.exceptions.ConverterException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class HumanConverter {

    private AddressConverter adConv;

    public HumanConverter(){
        adConv = new AddressConverter();
        if (adConv != null) log.info("Успешная инициализация конвертера адресов");
        else log.error("Инициализация конвертера адресов не произошла");
    }

    public HumanDTO toDTO(Human human) throws ConverterException{
        log.info("Конвертирование класса Human в класс HumanDTO");
        if (human == null) throw new ConverterException("Попытка конвертировать неинициализированный экземпляр класса Human");
        return new HumanDTO(human.getId(), human.getName(), human.getBirthday(), adConv.convert(human.getAddress()));
    }

    public Human toEntity(HumanDTO dto) throws ConverterException{
        log.info("Конвертирование класса HumanDTO в класс Human");
        if (dto == null) throw new ConverterException("Попытка конвертировать неинициализированный экземпляр класса HumanDTO");
        return new Human(dto.getId(), dto.getName(), dto.getBirthday(), adConv.convert(dto.getAddress()));
    }

}
