import aminev.lesson_2.Human;
import aminev.lesson_2.dto.HumanDTO;
import aminev.lesson_2.services.Service;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Service<Human, HumanDTO> service = new Service<>();

        System.out.println("Получение одной сущности из репозитория:");
        HumanDTO singleHuman = service.getById(0);
        System.out.println(singleHuman);

        System.out.println("Добавление одной сущности (DTO) в репозиторий");
        service.save(singleHuman);

        List<HumanDTO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(service.getById(i));
        }

        System.out.println("Добавление списка сущностей (DTO) в репозиторий");
        service.addAllToRepository(list);

    }
}
