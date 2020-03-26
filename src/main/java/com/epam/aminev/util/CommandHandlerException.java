package com.epam.aminev.util;

/**
 * {@code CommandException} indicated that command handler
 * isn't able to process command i.g. specified file doesn't exist
 * of filesystem is close for read/write
 *
 * @author Aminev Ramil
 */
public class CommandHandlerException extends RuntimeException {
    /**
     * Construct new {@code CommandException} with exception message
     *
     * @param message that could be logged and analyzed
     */
    public CommandHandlerException(String message) {
        super(message);
    }
}
