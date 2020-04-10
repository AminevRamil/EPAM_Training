package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;

import java.util.concurrent.Callable;

public abstract class AbstractClient implements Callable<Message> {
    protected final ChatService chat;
    protected ClientType type;

    protected AbstractClient(ChatService chat, ClientType type){
        this.chat = chat;
        this.type = type;
    }
}
