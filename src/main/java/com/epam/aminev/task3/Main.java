package com.epam.aminev.task3;

import lombok.extern.slf4j.Slf4j;

/**
 * Main class that demonstrate understanding of how class loaders work
 */
@Slf4j
public class Main {
    /**
     * Entry point in demo that was made during lesson 7
     * @param args - input arguments. Not used
     */
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
        }
    }
}
