package aminev.lesson_2.services;

import aminev.lesson_2.Human;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public interface RepInterface<T extends Human> {
    T get();
    void add(T t);
    void remove(T t);
    void addAll(Collection<T> c);

}
