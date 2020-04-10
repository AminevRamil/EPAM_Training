package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;


@Slf4j
public class SmsReader extends AbstractClient implements Callable<Message> {


    public SmsReader(ChatService chat) {
        super(chat, ClientType.READER);
    }

    @Override
    public Message call() throws Exception {
        Message readMessage = chat.pullMessage();
        log.info("Reader from {} read message: {}", Thread.currentThread().getName(), readMessage);
        long idleTimeInMillis = (long) ((Math.random() * 20 + 60) * 1000 / 10);
        log.warn("Reader from {} will idle for {}s.", Thread.currentThread().getName(), idleTimeInMillis / 1000);
        Thread.sleep(idleTimeInMillis);
        return readMessage;
    }
}
