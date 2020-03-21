package com.epam.aminev.task1;

import java.util.ArrayList;
import java.util.List;

public class OverloadExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            stringList.add("string #" + i);
        }
    }
}
