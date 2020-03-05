package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.Human.Address;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Repository implements RepInterface<Human> {

    private ArrayList<Human> db;
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) instance = new Repository();
        return instance;
    }

    private Repository() {

    }

    @Override
    public Human get() {
        //Заполнение базы данных
        String names[] = {"Jonathan", "Joseph", "Jotaro", "Josuke",
                "Joruno", "Jolyne", "Johnny", "David", "Jack", "George"};
        String countries[] = {"Japan", "USA", "Mexica", "Russia", "Italy"};
        String cities[] = {"New-York", "Rome", "Tokio", "Morioh", "Naples", "Tselinoyarsk",};
        String streets[] = {"40 Years of October", "50 Years of October", "60 Years of October", "70 Years of October",};
        return new Human((int) (Math.random() * 100),
                (float) Math.random() * 5,
                LocalDate.of((int) (Math.random() * 70) + 1950, (int) (Math.random() * 12) + 1, (int) (Math.random() * 29) + 1),
                names[(int) (Math.random() * names.length)],
                LocalDate.of((int) (Math.random() * 70) + 1950, (int) (Math.random() * 12) + 1, (int) (Math.random() * 29) + 1),
                new Human.Address(countries[(int) (Math.random() * countries.length)],
                        cities[(int) (Math.random() * cities.length)],
                        streets[(int) (Math.random() * streets.length)],
                        (int) (Math.random() * 200) + 1));
    }

    @Override
    public void add(Human h) {
        System.out.printf("Добавление: %s\n", h);
    }

    @Override
    public void remove(Human human) {
        System.out.printf("Удаление: %s\n", human);
    }

    @Override
    public void addAll(Collection<Human> collection) {
        System.out.printf("Добавление %d сущностей в репозиторий\n", collection.size());
        for (Human h : collection) {
            this.add(h);
        }
    }

    @Override
    public int size() {
        return (int)(Math.random()*100);
    }
}
