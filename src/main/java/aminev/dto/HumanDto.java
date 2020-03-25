package aminev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

/**
 * The {@code HumanDTO} class represents Data Transfer Object for class {@code Human}
 *
 * @author Aminev Ramil
 * @see aminev.Human
 */
@Data
@AllArgsConstructor
@ToString
public class HumanDto {
    int id;
    private String name;
    LocalDate birthday;
    AddressDto address;
}
