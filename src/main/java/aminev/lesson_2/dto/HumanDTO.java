package aminev.lesson_2.dto;

import aminev.lesson_2.Human;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class HumanDTO {
    int id;
    private String name;
    LocalDate birthday;
    AddressDTO address;
}
