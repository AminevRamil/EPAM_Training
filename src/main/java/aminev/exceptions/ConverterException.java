package aminev.exceptions;

/**
 * {@code ConverterException} could be thrown to indicate that
 * something wrong goes with one of the converters
 *
 * @author Aminev Ramil
 */
public class ConverterException extends RuntimeException {
    /**
     * Construct a {@link ConverterException} with exception message
     *
     * @param message message that could be logged and analysed
     */
    public ConverterException(String message) {
        super(message);
    }

}
