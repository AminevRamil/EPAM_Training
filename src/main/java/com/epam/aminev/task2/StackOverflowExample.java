package com.epam.aminev.task2;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class StackOverflowExample {
    public static void main(String[] args) {
        recursive(0L);
    }

    static long recursive (long level) {
        return recursive(level+1);
    }
}
