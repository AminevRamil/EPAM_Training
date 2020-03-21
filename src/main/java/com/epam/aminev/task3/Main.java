package com.epam.aminev.task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        CustomClassLoader classLoader = new CustomClassLoader("C:\\Users\\Optim\\Desktop\\myClasses\\");
        Class<?> clazz;
        try {
            clazz = classLoader.loadClass("TestClass");
            log.info("Loaded " + clazz.getName() + ".class");
            Object obj = clazz.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
