package aminev.lesson_2.services;

import aminev.lesson_2.Human;

import java.time.LocalDate;
import java.util.Collection;

public class Repository<ENTITY extends Human> implements RepInterface<ENTITY> {

    public Repository() {

    }

    @Override
    public ENTITY find() {
        //Заполнение базы данных
        String names[] = {"Jonathan", "Joseph", "Jotaro", "Josuke",
                "Joruno", "Jolyne", "Johnny", "David", "Jack", "George"};
        String countries[] = {"Japan", "USA", "Mexica", "Russia", "Italy"};
        String cities[] = {"New-York", "Rome", "Tokio", "Morioh", "Naples", "Tselinoyarsk",};
        String streets[] = {"40 Years of October", "50 Years of October", "60 Years of October", "70 Years of October",};

        int id = (int) (Math.random() * 100);
        float rating = (float) Math.random() * 5;
        int year = (int) (Math.random() * 70) + 1950;
        int month = (int) (Math.random() * 12) + 1;
        int day = (int) (Math.random() * 29) + 1;
        LocalDate regDate = LocalDate.of(year, month, day);
        String name = names[(int) (Math.random() * names.length)];
        year = (int) (Math.random() * 70) + 1950;
        month = (int) (Math.random() * 12) + 1;
        day = (int) (Math.random() * 29) + 1;
        LocalDate birthDate = LocalDate.of(year, month, day);
        ENTITY.Address address = new ENTITY.Address(countries[(int) (Math.random() * countries.length)],
                cities[(int) (Math.random() * cities.length)],
                streets[(int) (Math.random() * streets.length)],
                (int) (Math.random() * 200) + 1);

        return (ENTITY)(new Human(id, rating, regDate, name, birthDate, address));
    }

    @Override
    public void save(ENTITY h) {
        System.out.printf("Добавление: %s\n", h);
    }

    @Override
    public void remove(Human human) {
        System.out.printf("Удаление: %s\n", human);
    }

    @Override
    public void saveAll(Collection<ENTITY> collection) {
        System.out.printf("Добавление %d сущностей в репозиторий\n", collection.size());
        for (ENTITY h : collection) {
            this.save(h);
        }
    }
}
