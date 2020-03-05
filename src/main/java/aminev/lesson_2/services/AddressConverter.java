package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.dto.AddressDTO;

public class AddressConverter{
    AddressDTO convert(Human.Address address){
        return new AddressDTO(address.getCountry(), address.getCity(), address.getStreet(), address.getFlat());
    }
    Human.Address convert(AddressDTO address){
        return new Human.Address(address.getCountry(), address.getCity(), address.getStreet(), address.getFlat());
    }
}
