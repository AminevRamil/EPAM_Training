package com.epam.aminev.handlers;

/**
 * The {@code ExitCommand} class handle exit command.
 *
 * @author Aminev Ramil
 * @see CommandHandler
 */
public class ExitCommand implements CommandHandler {

    /**
     * Simple escape method that stops application
     */
    @Override
    public void handle(String command) {
        System.exit(0);
    }
}
