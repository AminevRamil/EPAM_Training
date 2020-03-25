import aminev.Human;
import aminev.dto.HumanDto;
import aminev.exceptions.ConverterException;
import aminev.exceptions.ServiceException;
import aminev.services.HumanConverter;
import aminev.services.Service;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class that demonstrate understanding of how logging and exceptions work
 */
@Slf4j
public class Main {
    /**
     * Entry point in logging and exceptions demo that was did during lesson 4
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {

        Service<Human, HumanDto> service = new Service<>();

        System.out.println("Получение одной сущности из репозитория:");
        HumanDto singleHuman = service.getById(0);
        System.out.println(singleHuman);

        System.out.println("Добавление одной сущности (DTO) в репозиторий");
        service.save(singleHuman);

        List<HumanDto> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(service.getById(i));
        }

        System.out.println("Добавление списка сущностей (DTO) в репозиторий");
        service.saveAllToRepository(list);

        System.out.println("-----Lesson 4-----\n----Exceptions----");
        try {
            service.getById(11);
        } catch (ServiceException e){
            log.error(e.getMessage());
        }
        try {
            service.save(null);
        } catch (ServiceException e){
            log.error(e.getMessage());
        }
        try {
            HumanConverter conv = new HumanConverter();
            conv.convert((Human) null);
        } catch (ConverterException ce) {
            log.error(ce.getMessage());
        }
    }
}