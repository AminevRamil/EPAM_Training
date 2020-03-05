package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public interface RepInterface<T extends Human> {
    T get(int id);
    String getName(int id);
    float getRating(int id);
    LocalDate getRegDate(int id);
    T.Address getAdress(int id);
    LocalDate getDate(int id);
    ArrayList<T> getAll();
    void add(T t);
    void addAll(Collection<T> c);
    int size();

}
