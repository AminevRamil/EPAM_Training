package com.epam.aminev;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The {@code StreamsDemo} class is just performs given tasks
 * using Streams API that was released with Java 8
 *
 * @author Aminev Ramil
 */
@Slf4j
public class StreamsDemo {
    List<String> list;
    private long counter;

    /**
     * Construct new StreamsDemo instance and generate
     * new list of UUID in String form
     */
    StreamsDemo() {
        list = Stream.generate(
                () -> UUID.randomUUID().toString()).
                limit(10000).
                collect(Collectors.toList());
    }

    /**
     * Writes UUIDs into specified file using streams
     *
     * @param fileName of file to write UUIDs
     */
    public void writeUuidStreamToFile(String fileName) {
        Path path = Paths.get(fileName);
        try {
            Files.write(path, list, StandardOpenOption.CREATE);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * Count UUIDs that have sum of digits move that 100
     * from specified file
     *
     * @param fileName of file in which UUIDs be count
     */
    public void countUuid(String fileName) {
        Path path = Paths.get(fileName);
        try {
            counter = Files.lines(path)
                    .filter(line -> line.length() > 0)
                    .filter(uuid -> sumOfDigits(uuid) > 100)
                    .count();
            log.info("Count: {}", counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculates sum of digits within given UUID
     *
     * @param uuid in which digits be summed
     * @return sum of digits
     */
    private int sumOfDigits(String uuid) {
        return uuid.chars().filter(value -> value >= '0' && value <= '9').map(c -> c - 48).sum();
    }

    /**
     * Calculates date and time of apocalypse
     *
     * @return date of predicted apocalypse
     */
    public LocalDateTime calcApocalypseDateTime() {
        long N = counter / 100;
        long M = counter % 100;
        return LocalDateTime.now()
                .plusMonths(N)
                .plusDays(M)
                .atZone(ZoneId.of("America/Los_Angeles"))
                .toLocalDateTime();
    }

    /**
     * Reads data about sausages and creates instances of {@code Sausage}
     * Do it using Streams API
     *
     * @param fileName of file with data
     */
    public Optional<List<Sausage>> readSausageData(String fileName) {
        Path path = Paths.get(fileName);
        Base64.Decoder decoder = Base64.getDecoder();
        List<Sausage> sausageList = null;
        try {
            sausageList = Files.readAllLines(path)
                    .stream()
                    .map(decoder::decode)
                    .map(String::new)
                    .map(line -> line
                            .replace("type=", "")
                            .replace("weight=", "")
                            .replace("cost=", "")
                            .replaceAll("'", "")
                            .replaceAll(",", " "))
                    .map(Sausage::new)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return sausageList != null? Optional.of(sausageList): Optional.empty();
    }
}
