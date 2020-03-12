package aminev.lesson_2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private int flat;
}
