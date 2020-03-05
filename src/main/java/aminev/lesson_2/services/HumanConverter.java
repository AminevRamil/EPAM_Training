package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.dto.HumanDTO;

public final class HumanConverter {

    private AddressConverter adConv;

    public HumanConverter(){
        adConv = new AddressConverter();
    }

    public HumanDTO toDTO(Human human) {
        return new HumanDTO(human.getId(), human.getName(), human.getBirthday(), adConv.getDTO(human.getAddress()));
    }

    public Human toEntity(HumanDTO dto){
        return new Human(dto.getId(), dto.getName(), dto.getBirthday(), adConv.getDomain(dto.getAddress()));
    }

}
