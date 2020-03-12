package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.dto.AddressDTO;
import aminev.lesson_2.exceptions.ConverterException;

public class AddressConverter{
    AddressDTO convert(Human.Address address) throws ConverterException {
        if (address == null) throw new ConverterException("Попытка конвертировать неинициализированный экземпляр класса Address");
        return new AddressDTO(address.getCountry(), address.getCity(), address.getStreet(), address.getFlat());
    }
    Human.Address convert(AddressDTO address) throws ConverterException {
        if (address == null) throw new ConverterException("Попытка конвертировать неинициализированный экземпляр класса AddressDTO");
        return new Human.Address(address.getCountry(), address.getCity(), address.getStreet(), address.getFlat());
    }
}
