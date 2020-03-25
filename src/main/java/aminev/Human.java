package aminev;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

/**
 * The {@code Human} class represent Human domain entity
 * that will be stored at repository
 *
 * @author Aminev Ramil
 */
@Data
@AllArgsConstructor
@ToString
public class Human {
    private int id;
    private float rating;
    private LocalDate regDate;
    private String name;
    private LocalDate birthday;
    private Address address;

    /**
     * Construct an incomplete instance from Data Transfer Object
     * @param id of entity, must be unique
     * @param name which contains full name
     * @param birthday of concrete human
     * @param address of living
     */
    public Human (int id, String name, LocalDate birthday, Address address){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.address = address;
    }

    /**
     * Inner class {@code Address} that represents a physical address
     * which concrete human lives
     *
     * @author Aminev Ramil
     */
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
