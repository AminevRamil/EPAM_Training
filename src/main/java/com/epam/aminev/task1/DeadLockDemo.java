package com.epam.aminev.task1;

import lombok.extern.slf4j.Slf4j;

/**
 * The {@code DeadLockDemo} class demonstrate how to
 * provoke deadlock in java
 *
 * @author Aminev Ramil
 */
@Slf4j
public class DeadLockDemo {
    public static final Object resource1 = new Object();
    public static final Object resource2 = new Object();

    /**
     * Main entry point to demonstration that was did during lesson 12.
     * Each thread in beginning occupy one of resources.
     * Then they try to occupy second resource and both stuck
     * in dead lock
     *
     * @param args - input arguments. Not used
     */
    public static void main(String args[]) {
        Thread T1 = new Thread(() -> {
            synchronized (resource1) {
                log.info("{} holding resource1", Thread.currentThread().getName());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }

                log.info("{} will try to hold resource2", Thread.currentThread().getName());
                synchronized (resource2) {
                    log.info("{} holding resource1 and resource2", Thread.currentThread().getName());
                }
            }

        });
        Thread T2 = new Thread(() -> {
            synchronized (resource2) {
                log.info("{} holding resource2", Thread.currentThread().getName());

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    log.error(e.getMessage());
                }

                log.info("{} will try to hold resource1", Thread.currentThread().getName());
                synchronized (resource1) {
                    log.info("{} holding resource1 and resource2", Thread.currentThread().getName());
                }
            }
        });
        T1.start();
        T2.start();
    }
}
