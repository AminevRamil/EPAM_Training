package com.epam.aminev.exceptions;

/**
 * Indicates that examined class has no Value annotation
 *
 * @author Aminev Ramil
 */
public class NoValueAnnotationException extends RuntimeException {
    /**
     * Construct NoValueAnnotationException with detailed
     * exception message
     *
     * @param message that could be logged and analyzed
     */
    public NoValueAnnotationException(String message) {
        super(message);
    }
}
