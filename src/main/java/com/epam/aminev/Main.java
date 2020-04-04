package com.epam.aminev;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Main class that demonstrate understanding of Streams API
 *
 * @author Aminev Ramil
 */
public class Main {
    /**
     * Main entry point to demo that was did during lesson 11
     *
     * @param args - input arguments. Not used.
     */
    public static void main(String[] args) {
        StreamsDemo demo = new StreamsDemo();
        String fileName = "UUIDs.txt";
        demo.writeUuidStreamToFile(fileName);
        demo.countUuid(fileName);

        LocalDateTime apocalypse = demo.calcApocalypseDateTime();
        System.out.println(apocalypse.format(DateTimeFormatter.ISO_DATE_TIME));

        demo.readSausageData("File.txt");
    }

}
