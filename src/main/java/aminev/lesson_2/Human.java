package aminev.lesson_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@ToString
public class Human {
    private int id;
    // Техническая информация, не для фронта
    private float rating;
    private LocalDate regDate;
    // Практические данные
    private String name;
    private LocalDate birthday;
    private Address address;

    public Human (int id, String name, LocalDate birthday, Address address){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    @Data
    @AllArgsConstructor
    @ToString
    public static final class Address {
        private String country;
        private String city;
        private String street;
        private int flat;
    }
}
