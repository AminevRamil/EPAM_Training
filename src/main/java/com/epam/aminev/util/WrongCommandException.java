package com.epam.aminev.util;

/**
 * {@code WrongCommandException} indicates that {@code Filter}
 * didn't recognize incoming command
 */
public class WrongCommandException extends RuntimeException {
    /**
     * Construct new {@code WrongCommandException} with exception message
     *
     * @param message that could be logged and analyzed
     */
    public WrongCommandException(String message) {
        super(message);
    }
}
