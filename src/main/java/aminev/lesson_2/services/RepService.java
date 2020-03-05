package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import aminev.lesson_2.Human.Address;
import aminev.lesson_2.dto.AddressDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class RepService<T extends Human> implements RepInterface<T> {

    private ArrayList<T> db;

    public RepService(){
        db = new ArrayList<>();
    }

    @Override
    public T get(int id) {
        return db.get(id);
    }

    @Override
    public String getName(int id) {
        return db.get(id).getName();
    }

    @Override
    public float getRating(int id) {
        return db.get(id).getRating();
    }

    @Override
    public LocalDate getRegDate(int id) {
        return db.get(id).getRegDate();
    }

    @Override
    public Address getAdress(int id) {
        return db.get(id).getAddress();
    }

    @Override
    public LocalDate getDate(int id) {
        return db.get(id).getBirthday();
    }

    @Override
    public ArrayList<T> getAll() {
        return db;
    }

    @Override
    public void add(T t) {
        System.out.printf("Добавление: %s\n", t);
        db.add(t);
    }

    @Override
    public void addAll(Collection<T> collection) {
        System.out.printf("Добавление %d сущностей в репозиторий\n", collection.size());
        for (T t: collection) {
            this.add(t);
        }
    }

    @Override
    public int size() {
        return db.size();
    }
}
