package com.epam.aminev.handlers;

import com.epam.aminev.util.CommandHandlerException;

/**
 * The {@code CommandHandler} interface is indicates that implemented
 * class is an command handler that should process user's command
 * and if it need throwing appropriate exception
 *
 * @author Aminev Ramil
 */
public interface CommandHandler {
    void handle(String command)  throws CommandHandlerException;
}
