package com.epam.aminev;

import com.epam.aminev.task3.ChatService;
import com.epam.aminev.task3.clients.AbstractClient;
import com.epam.aminev.task3.clients.SmsReader;
import com.epam.aminev.task3.clients.SmsUpdater;
import com.epam.aminev.task3.clients.SmsWriter;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 * Main class that demonstrate how Java Concurrency API works
 *
 * @author Aminev Ramil
 */
public class Main {

    private final static int N = 2;
    private final static int M = 2;
    private final static int K = 2;

    /**
     * Main entry point to chat demonstration that was did during lesson 12
     * It create list of client of:
     * N SmsWriters
     * M SmsReaders
     * K SmsUpdaters
     *
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {
        ChatService chatService = new ChatService();
        List<AbstractClient> clientList = new ArrayList<>(N + M + K);
        for (int i = 0; i < N; i++) {
            clientList.add(new SmsWriter(chatService));
        }
        for (int i = 0; i < M; i++) {
            clientList.add(new SmsReader(chatService));
        }
        for (int i = 0; i < K; i++) {
            clientList.add(new SmsUpdater(chatService));
        }
        chatService.addClients(clientList);
        try {
            chatService.startChat();
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
