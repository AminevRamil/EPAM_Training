package com.epam.aminev;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * Main class that demonstrate understanding of Streams API
 *
 * @author Aminev Ramil
 */
@Slf4j
public class Main {
    /**
     * Main entry point to demo that was did during lesson 11
     * It generate file with 10.000 UUIDs, read them, count those
     * that sum of digit more that 100, calculate apocalypse date and time
     * And finally it creates instances of {@code Sausages} from encoded file
     *
     * @param args - input arguments. Not used.
     */
    public static void main(String[] args) {
        StreamsDemo demo = new StreamsDemo();
        String fileName = "UUIDs.txt";
        demo.writeUuidStreamToFile(fileName);
        demo.countUuid(fileName);

        LocalDateTime apocalypse = demo.calcApocalypseDateTime();
        log.info(apocalypse.format(DateTimeFormatter.ISO_DATE_TIME));

        Optional<List<Sausage>> assumedSausages = demo.readSausageData("File.txt");
        if (assumedSausages.isPresent()) {
            assumedSausages.ifPresent(sausages -> sausages.forEach(sausage -> log.info(sausage.toString())));
        } else {
            log.error("Wrong file name with sausage data");
        }
    }

}
