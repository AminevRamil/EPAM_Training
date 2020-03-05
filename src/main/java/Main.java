import aminev.lesson_2.Human;
import aminev.lesson_2.dto.HumanDTO;
import aminev.lesson_2.services.HumanConverter;
import aminev.lesson_2.services.RepService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepService<Human> repository = new RepService<>();

        //Заполнение базы данных
        String names[] = {"Jonathan", "Joseph", "Jotaro", "Josuke",
                "Joruno", "Jolyne", "Johnny",  "David", "Jack", "George"};
        String countries[] = {"Japan", "USA", "Mexica", "Russia", "Italy"};
        String cities[] = {"New-York", "Rome", "Tokio", "Morioh", "Naples", "Tselinoyarsk", };
        String streets[] = {""};

        for (int i = 0; i < 10; i++) {
            repository.add(new Human(i,
                    (float) Math.random() * 5,
                    LocalDate.of((int) (Math.random() * 70) + 1950, (int) (Math.random() * 12) + 1, (int) (Math.random() * 29) + 1),
                    names[(int) (Math.random() * names.length)],
                    LocalDate.of((int) (Math.random() * 70) + 1950, (int) (Math.random() * 12) + 1, (int) (Math.random() * 29) + 1),
                    new Human.Address(countries[(int) (Math.random() * countries.length)],
                            cities[(int) (Math.random() * cities.length)],
                            streets[(int) (Math.random() * streets.length)],
                            (int) (Math.random() * 200)+1)));
        }
        System.out.println("Получение одного экземпляра:");
        Human singleHuman = repository.get(0);
        System.out.println(singleHuman);
        ArrayList<Human> allHumans = repository.getAll();
        System.out.printf("Весь репозиторий (.size()=%d):\n", repository.size());
        for (Human human: allHumans) {
            System.out.println(human);
        }

        Human caesar = new Human(repository.size(), (float)Math.random()*5,
                LocalDate.of(1918, 5, 13), "Caesar",
                LocalDate.now(), new Human.Address("Rome", "Venice", "Street", 12));
        System.out.printf("Создание сущности и добавление в репозиторий:\n%s\n", caesar);
        repository.add(caesar);
        System.out.printf("Размер репозитория после добавления сущности: %d\n", repository.size());
        List<Human> list = new ArrayList<>();
        list.add(new Human(repository.size(), (float)Math.random()*5,
                LocalDate.of(1975, 2, 12), "Human1",
                LocalDate.now(), new Human.Address("Russia", "Tol'yatti", "40 Years", 24)));
        list.add(new Human(repository.size(), (float)Math.random()*5,
                LocalDate.of(1978, 7, 9), "Human2",
                LocalDate.now(), new Human.Address("Russia", "Toggliatti", "50 Years", 12)));
        System.out.println("Добавление списка сущностей к существующему репозиторию: ");
        repository.addAll(list);
        System.out.printf("Размер репозитория после добавления списка сущностей: %d\n", repository.size());

        System.out.println("Преобразование сущности в DTO и обратно:");
        HumanConverter conv = new HumanConverter(repository);
        Human h = repository.get(0);
        System.out.println(h);
        HumanDTO dto = conv.getDTO(h);
        System.out.println(dto);
        Human hTest = conv.getDomainEntity(dto);
        System.out.println(hTest);
    }
}
