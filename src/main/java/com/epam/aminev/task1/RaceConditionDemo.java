package com.epam.aminev.task1;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code RaceConditionDemo} class demonstrate how to
 * provoke race condition in java
 *
 * @author Aminev Ramil
 */
@Slf4j
public class RaceConditionDemo {
    static volatile int sharedValue;

    /**
     * Main entry point to demonstration that was did during lesson 12
     * The thread1 supposed to log shared value only
     * in case if this value is multiple of 2.
     * But due to data races it log other values
     *
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 30; i++) {
                if (sharedValue % 2 == 0) {
                    log.info("sharedValue = {}", sharedValue);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000000; i++) {
                sharedValue++;
            }

        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
