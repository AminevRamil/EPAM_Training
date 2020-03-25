package aminev.exceptions;

/**
 * {@code ServiceException} could be thrown to indicate that
 * something wrong goes during Service's work
 *
 * @author Aminev Ramil
 */
public class ServiceException extends RuntimeException {
    /**
     * Construct a {@link ServiceException} with exception message
     *
     * @param message that could be logged and analysed
     */
    public ServiceException(String message) {
        super(message);
    }
}
