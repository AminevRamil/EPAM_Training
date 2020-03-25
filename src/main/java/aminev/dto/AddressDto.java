package aminev.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * The {@code AddressDTO} class represents a Data Transfer Object for {@code Address} class
 *
 * @author Aminev Ramil
 * @see aminev.Human.Address
 */
@Data
@AllArgsConstructor
@ToString
public class AddressDto {
    private String country;
    private String city;
    private String street;
    private int flat;
}
