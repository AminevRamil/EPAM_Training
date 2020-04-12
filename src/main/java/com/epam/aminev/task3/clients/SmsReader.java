package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * The {@code SmsReader} class is pull first message
 * from chat and them idle for 20-60 seconds
 *
 * @author Aminev Ramil
 */
@Slf4j
public class SmsReader extends AbstractClient implements Callable<Message> {

    /**
     * Basic constructor that delegates
     * construction to it's superclass
     *
     * @param chat from which reader will pull messages
     */
    public SmsReader(ChatService chat) {
        super(chat);
    }

    /**
     * Pull first message from chat and log it, and them idle
     *
     * @return pulled message
     * @throws InterruptedException in case of interrupting while thread is sleeping
     */
    @Override
    public Message call() throws InterruptedException {
        Message readMessage = chat.pullMessage();
        log.info("Reader from {} read message: {}", Thread.currentThread().getName(), readMessage);
        long idleTimeInMillis = (long) ((Math.random() * 20 + 60) * 1000);
        log.warn("Reader from {} will idle for {}s.", Thread.currentThread().getName(), idleTimeInMillis / 1000);
        Thread.sleep(idleTimeInMillis);
        return readMessage;
    }
}
