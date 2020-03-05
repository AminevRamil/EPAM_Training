package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.Human.Address;
import aminev.lesson_2.dto.HumanDTO;
import aminev.lesson_2.dto.AddressDTO;

public final class HumanConverter {

    private RepService<Human> db;
    private AddressConverter adConv;

    public HumanConverter(RepService<Human> db){
        this.db = db;
        adConv = new AddressConverter();
    }

    public HumanDTO getDTO(Human human) {
        return new HumanDTO(human.getId(), human.getName(), human.getBirthday(), adConv.getDTO(human.getAddress()));
    }

    public Human getDomainEntity(HumanDTO dto){
        return db.get(dto.getId());
    }

    private class AddressConverter{
        AddressDTO getDTO(Address address){
            return new AddressDTO(address.getCountry(), address.getCity(), address.getStreet(), address.getFlat());
        }
        Address getDomain(AddressDTO address){
            return new Address(address.getCountry(), address.getCity(), address.getStreet(), address.getFlat());
        }
    }
}
