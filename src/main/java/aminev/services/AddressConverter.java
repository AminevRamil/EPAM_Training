package aminev.services;

import aminev.Human;
import aminev.dto.AddressDto;
import aminev.exceptions.ConverterException;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@code AddressConverter} class is used to
 * convert Address and AddressDto in both directions
 *
 * @author Aminev Ramil
 * @see aminev.Human.Address
 * @see AddressDto
 */
public class AddressConverter {
    /**
     * Overload method that convert Address domain entity to Data Transfer Object
     *
     * @param entity Address to be converted
     * @return Address Data Transfer Object - instance of {@code AddressDto}
     * @throws ConverterException in case of incoming parameter is null
     */
    AddressDto convert(Human.Address entity) {
        if (entity == null) {
            throw new ConverterException("Can't convert null instance");
        }
        return new AddressDto(entity.getCountry(),
                entity.getCity(),
                entity.getStreet(),
                entity.getFlat());
    }

    /**
     * Overload method that convert Address Data Transfer Object to domain entity
     *
     * @param dto Address Data Transfer Object to be converted
     * @return Address domain entity - instance of {@code Address}
     * @throws ConverterException in case of incoming parameter is null
     */
    Human.Address convert(AddressDto dto) throws ConverterException {
        if (dto == null) {
            throw new ConverterException("Can't convert null instance");
        }
        return new Human.Address(dto.getCountry(),
                dto.getCity(),
                dto.getStreet(),
                dto.getFlat());
    }
}
