package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

@Slf4j
public class SmsUpdater extends AbstractClient implements Callable<Message> {
    public SmsUpdater(ChatService chat) {
        super(chat, ClientType.UPDATER);
    }

    @Override
    public Message call() throws Exception {
        Message oldMessage = chat.getRandomMessage();
        Message updatedMessage = changeMessage(oldMessage);
        log.info("Updater from {} will update message \"{}\" to \"{}\"",
                Thread.currentThread().getName(), oldMessage, updatedMessage);
        long idleTimeInMillis = (long) ((Math.random() * 20 + 40) * 1000 / 10);
        log.warn("Updater from {} will idle for {}s.", Thread.currentThread().getName(), idleTimeInMillis / 1000);
        Thread.sleep(idleTimeInMillis);
        return oldMessage;
    }

    private Message changeMessage(Message old) {
        Message newMessage = new Message(old);
        StringBuilder builder = new StringBuilder(newMessage.getMessage());
        int toChange = (int) (Math.random() * 4 + 1);
        int stringLen = builder.length();
        for (int i = 0; i < toChange; i++) {
            builder.setCharAt((int) (Math.random() * stringLen), 'a');
        }
        newMessage.setMessage(builder.toString());
        return newMessage;
    }

}
