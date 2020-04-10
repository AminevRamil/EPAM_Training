package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
public class SmsWriter extends AbstractClient implements Callable<Message> {
    public SmsWriter(ChatService chat) {
        super(chat, ClientType.WRITER);
    }

    @Override
    public Message call() throws Exception {
        Message message = generateMessage();
        log.info("Writer from {} generate message: {}", Thread.currentThread().getName(), message);
        long idleTimeInMillis = (long) ((Math.random() * 20 + 40) * 1000 / 10);
        log.warn("Writer from {} will idle for {}s.", Thread.currentThread().getName(), idleTimeInMillis / 1000);
        Thread.sleep(idleTimeInMillis);
        return message;
    }


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
