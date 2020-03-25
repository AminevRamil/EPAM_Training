package aminev.services;

import aminev.Human;
import aminev.dto.AddressDto;
import aminev.dto.HumanDto;
import aminev.exceptions.ConverterException;
import lombok.extern.slf4j.Slf4j;

/**
 * The {@code HumanConverter} class is used to
 * convert Human and HumanDto in both directions
 *
 * @author Aminev Ramil
 * @see Human
 * @see HumanDto
 */
@Slf4j
public final class HumanConverter {

    private AddressConverter adConv;

    /**
     * Construct basic {@link HumanConverter} with {@link AddressConverter} inside
     */
    public HumanConverter() {
        adConv = new AddressConverter();
    }

    /**
     * Overload method that convert Human domain entity to Data Transfer Object
     *
     * @param entity instance to be converted to Data Transfer Object
     * @return Data Transfer Object - an instance of {@code Human}
     * @throws ConverterException in case of either incoming parameter or it's Address is null
     */
    public HumanDto convert(Human entity) {
        log.info("Конвертирование класса Human в класс HumanDTO");
        if (entity == null) {
            throw new ConverterException("Can't convert null entity");
        }
        AddressDto addressDTO;
        try {
            addressDTO = adConv.convert(entity.getAddress());
        } catch (ConverterException e) {
            log.error(e.getMessage());
            throw e;
        }
        return new HumanDto(entity.getId(), entity.getName(), entity.getBirthday(), addressDTO);
    }

    /**
     * Overload method that convert Human Data Transfer Object to Human domain entity
     *
     * @param dto instance to be converted to domain entity
     * @return domain entity - an instance of {@code Human}
     * @throws ConverterException in case of either incoming parameter or it's Address is null
     */
    public Human convert(HumanDto dto) throws ConverterException {
        log.info("Конвертирование класса HumanDTO в класс Human");
        if (dto == null) {
            throw new ConverterException("Can't convert null entity");
        }
        Human.Address address;
        try {
            address = adConv.convert(dto.getAddress());
        } catch (ConverterException e) {
            log.error(e.getMessage());
            throw e;
        }
        return new Human(dto.getId(), dto.getName(), dto.getBirthday(), address);
    }

}
