package com.epam.aminev.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple class to demonstrate OutOfMemoryError
 * Error will be caused by heap overload with string instances
 *
 * @author Aminev Ramil
 */
@Slf4j
public class OutOfMemoryExample {
    /**
     * Entry point in demo
     * You need set JVM -Xmx=20m for this example work
     * @param args - input argument. Not used
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        try {
            for (int i = 0; i < 1000000; i++) {
                stringList.add("string #" + i);
            }
        } catch (OutOfMemoryError e){
            log.error("Поймана ошибка " + e.toString());
            System.exit(-1);
        }
    }
}
