package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;

import java.util.concurrent.Callable;

/**
 * The {@code AbstractClient} class is used to add
 * clients in one list without specifying them
 *
 * @author Aminev Ramil
 */
public abstract class AbstractClient implements Callable<Message> {
    protected final ChatService chat;

    /**
     * Basic constructor which created client that attached to
     * specified {@code ChatService}
     *
     * @param chat with which the client works
     */
    protected AbstractClient(ChatService chat) {
        this.chat = chat;
    }
}
