package com.epam.aminev.task2;

import lombok.extern.slf4j.Slf4j;

/**
 * Simple class to demonstrate StackOverflowError
 * That error will causes by calling unregulated
 * recursive method that overflow the stack
 *
 * @author Aminev Ramil
 */
@Slf4j
public class StackOverflowExample {
    /**
     * Entry point in demo
     * @param args - input argument. Not used
     */
    public static void main(String[] args) {
        try {
            long maxDeepLevel = recursive(0L);
        } catch (StackOverflowError e) {
            log.error("Зафиксирована ошибка  " + e.toString());
            System.exit(-1);
        }
    }

    /**
     * Recursive function
     * @param level of depth of recursion
     * @return recursive call
     * @throws StackOverflowError when stack will overflowed
     */
    static long recursive(long level) throws StackOverflowError {
        return recursive(level + 1);
    }
}
