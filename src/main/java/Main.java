import aminev.lesson_2.Human;
import aminev.lesson_2.dto.HumanDTO;
import aminev.lesson_2.exceptions.ConverterException;
import aminev.lesson_2.exceptions.ServiceException;
import aminev.lesson_2.services.HumanConverter;
import aminev.lesson_2.services.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
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

        System.out.println("-----Lesson 4-----\n----Exceptions----");
        try {
            service.getById(11);
        } catch (ServiceException e){
            log.error(e.getMessage());
        }
        try {
            service.save(null);
        } catch (NullPointerException npe){
            log.error(npe.getMessage());
        }
        try {
            HumanConverter conv = new HumanConverter();
            conv.toDTO(null);
        } catch (ConverterException ce) {
            log.error(ce.getMessage());
        }
    }
}