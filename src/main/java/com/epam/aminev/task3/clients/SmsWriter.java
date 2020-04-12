package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * The {@code SmsWriter} class is write message
 * to chat and them idle for 20-60 seconds
 *
 * @author Aminev Ramil
 */
@Slf4j
public class SmsWriter extends AbstractClient implements Callable<Message> {

    /**
     * Basic constructor that delegates
     * construction to it's superclass
     *
     * @param chat from which reader will pull messages
     */
    public SmsWriter(ChatService chat) {
        super(chat);
    }

    /**
     * Write random generated message and send it to chat.
     * At the same time log it, and them idle
     *
     * @return updated message
     * @throws InterruptedException in case of interrupting while thread is sleeping
     */
    @Override
    public Message call() throws Exception {
        Message message = generateMessage();
        log.info("Writer from {} generate message: {}", Thread.currentThread().getName(), message);
        long idleTimeInMillis = (long) ((Math.random() * 40 + 20) * 1000);
        log.warn("Writer from {} will idle for {}s.", Thread.currentThread().getName(), idleTimeInMillis / 1000);
        Thread.sleep(idleTimeInMillis);
        return message;
    }

    /**
     * Method that generate random message using streams
     *
     * @return randomly generated Message
     */
    private Message generateMessage() {
        Random random = new Random();
        int stringLength = random.nextInt(10) + 3;

        String generatedString = random.ints(97, 123)
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return new Message(generatedString);
    }
}
