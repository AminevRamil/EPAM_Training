package com.epam.aminev.task3.clients;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.Message;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/**
 * The {@code SmsUpdater} class is change random message
 * from chat and them idle for 40 seconds
 *
 * @author Aminev Ramil
 */
@Slf4j
public class SmsUpdater extends AbstractClient implements Callable<Message> {

    /**
     * Basic constructor that delegates
     * construction to it's superclass
     *
     * @param chat from which reader will pull messages
     */
    public SmsUpdater(ChatService chat) {
        super(chat);
    }

    /**
     * Pull update random message from chat and log it, and them idle
     *
     * @return updated message
     * @throws InterruptedException in case of interrupting while thread is sleeping
     */
    @Override
    public Message call() throws Exception {
        Message oldMessage = chat.getRandomMessage();
        Message updatedMessage = changeMessage(oldMessage);
        log.info("Updater from {} will update message \"{}\" to \"{}\"",
                Thread.currentThread().getName(), oldMessage, updatedMessage);
        long idleTimeInMillis = (long) ((Math.random() * 40) * 1000);
        log.warn("Updater from {} will idle for {}s.", Thread.currentThread().getName(), idleTimeInMillis / 1000);
        Thread.sleep(idleTimeInMillis);
        return updatedMessage;
    }

    /**
     * Method that change randoms chars message to 'a'
     * @param old message that need
     * @return updated message
     */
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
