package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public interface RepInterface<T extends Human> {
    T find();
    void save(T t);
    void remove(T t);
    void saveAll(Collection<T> c);

}
