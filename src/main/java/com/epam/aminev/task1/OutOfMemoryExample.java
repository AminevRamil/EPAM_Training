package com.epam.aminev.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OutOfMemoryExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        try {
            for (int i = 0; i < 1000000; i++) {
                stringList.add("string #" + i);
            }
        } catch (OutOfMemoryError e){
            log.error("Поймана ошибка " + e.toString());
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
