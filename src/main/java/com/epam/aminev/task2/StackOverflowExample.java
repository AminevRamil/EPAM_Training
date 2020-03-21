package com.epam.aminev.task2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StackOverflowExample {
    public static void main(String[] args) {
        try {
            long maxDeepLevel = recursive(0L);
        } catch (StackOverflowError e) {
            log.error("Зафиксирована ошибка  " + e.toString());
            e.printStackTrace();
            System.exit(-1);
        }
    }

    static long recursive(long level) throws StackOverflowError {
        return recursive(level + 1);
    }
}
