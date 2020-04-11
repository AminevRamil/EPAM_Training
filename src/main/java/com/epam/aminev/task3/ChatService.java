package com.epam.aminev.task3;

import com.epam.aminev.task3.clients.AbstractClient;
import com.epam.aminev.task3.clients.SmsWriter;
import com.epam.aminev.task3.exceptions.ChatException;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * The {@code ChatService} class is simulates chat with
 * some writers, updaters and readers
 * <p>
 * IMPORTANT: Not work
 *
 * @author Aminev Ramil
 */
@Slf4j
public class ChatService {
    private final int MESSAGES_MAX = 25;

    volatile List<Message> messageList;
    private volatile List<Future<Message>> writersFutures;
    private volatile List<Future<Message>> readersFutures;
    private volatile List<Future<Message>> updatersFutures;

    private ExecutorService executorService;

    /**
     * Basic constructor that construct new instance of {@code ChatService}
     * and initialize messageList
     */
    public ChatService() {
        messageList = Collections.synchronizedList(new LinkedList<>());

    }

    /**
     * Method which configure chat with clients and their's FutureTasks
     *
     * @param clients that will use chat's services
     */
    public void addClients(List<AbstractClient> clients) {
        assert (clients != null && !clients.isEmpty());

        int executorSize = clients.size();
        executorService = Executors.newFixedThreadPool(executorSize);

        if (writersFutures == null) writersFutures = Collections.synchronizedList(new LinkedList<>());
        if (readersFutures == null) readersFutures = Collections.synchronizedList(new LinkedList<>());
        if (updatersFutures == null) updatersFutures = Collections.synchronizedList(new LinkedList<>());

        for (AbstractClient client : clients) {
            switch (client.getClass().getSimpleName()) {
                case "SmsWriter":
                    writersFutures.add(executorService.submit(client));
                    break;
                case "SmsReader":
                    readersFutures.add(executorService.submit(client));
                    break;
                case "SmsUpdater":
                    updatersFutures.add(executorService.submit(client));
                    break;
            }
        }
    }

    /**
     * Method that start chat work and checking client's futures
     */
    public void startChat() {
        while (true) {
            try {
                checkFutures();
            } catch (InterruptedException | ExecutionException e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * Checks client's futures and suppose to resend
     * client's future task's but not do it
     *
     * @throws ExecutionException   in case of trouble with executorService
     * @throws InterruptedException in case of interruption of sleeping thread
     */
    private void checkFutures() throws ExecutionException, InterruptedException {
        for (Future<Message> task : writersFutures) {
            if (!task.isDone()) {
                writersFutures.remove(task);
                System.out.println("writer: " + messageList);
                if (messageList.size() < MESSAGES_MAX) {
                    Message newMessage = task.get();
                    addMessage(newMessage);
                    writersFutures.add(executorService.submit(new SmsWriter(this)));
                    //executorService.execute(task);
                } else {
                    System.out.println("Нет места в чате. Сделать ожидания свободного места");
                }
            }
        }
        for (Future<Message> task : readersFutures) {
            if (!task.isDone()) {
                System.out.println("reader: " + messageList);
                //executorService.execute(task);
            }
        }
        for (Future<Message> task : updatersFutures) {
            if (!task.isDone()) {
                System.out.println("updater: " + messageList);
                Message updatedMessage = task.get();
                updateMessage(updatedMessage);
                //executorService.execute(task);
            }
        }
    }

    /**
     * Add message to messageList
     *
     * @param message that to be added
     */
    public void addMessage(Message message) {
        synchronized (messageList) {
            if (messageList.size() < MESSAGES_MAX) {
                messageList.add(message);
            } else {
                throw new ChatException("Exceed max message storage");
            }
        }
    }

    /**
     * Pull first message from messageList
     *
     * @return pulled message
     */
    public Message pullMessage() {
        synchronized (messageList) {
            if (!messageList.isEmpty()) {
                Message pulledMessage = messageList.remove(0);
                log.info("Pulled message: {}", pulledMessage);
                log.info("Messages in chat: {}", messageList.size());
                return pulledMessage;
            } else {
                throw new ChatException("There's no messages");
            }
        }
    }

    /**
     * Returns random message form messageList
     * without pulling it
     *
     * @return random message
     */
    public Message getRandomMessage() {
        if (!messageList.isEmpty()) {
            return messageList.get((int) (Math.random() * messageList.size()));
        } else {
            throw new ChatException("There's no messages");
        }
    }

    /**
     * Replacing old message with new one that was got from updater
     *
     * @param updatedMessage is a new message that replace older one
     */
    public void updateMessage(Message updatedMessage) {
        synchronized (messageList) {
            for (int i = 0; i < messageList.size(); i++) {
                if (messageList.get(i).getId() == updatedMessage.getBaseMessageId()) {
                    messageList.set(i, updatedMessage);
                    break;
                }
            }
        }
    }
}
