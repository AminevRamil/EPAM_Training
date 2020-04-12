package com.epam.aminev.task3.exceptions;

/**
 * The {@code ChatException} indicates that something wrong goes in {@code ChatService}
 *
 * @author Aminev Ramil
 */
public class ChatException extends RuntimeException {
    public ChatException(String message) {
        super(message);
    }
}
