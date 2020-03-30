package com.epam.aminev;

import com.epam.aminev.structural.decorator.ComplexNumber;
import com.epam.aminev.structural.proxy.ProxyService;

/**
 * Main class that demonstrate understanding of design patterns
 */
public class Main {
    /**
     * Entry point in demo that was did during lesson 9
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {
        System.out.println("---Стуктурные паттерны---\nДекоратор на примере комплескных чисел:");
        ComplexNumber cn1 = new ComplexNumber(1.32, -3.11);
        ComplexNumber cn2 = new ComplexNumber(3.01, 1.13);
        System.out.println("cn1: " + cn1);
        System.out.println("cn2: " + cn2);
        System.out.printf("|%s| = %s\n", cn1, cn1.abs());
        System.out.printf("(%s)+(%s) = %s\n", cn1, cn2, cn1.add(cn2));
        System.out.printf("(%s)-(%s) = %s\n", cn1, cn2, cn1.subtract(cn2));
        System.out.printf("(%s)*(%s) = %s\n", cn1, cn2, cn1.multiplication(cn2));

        System.out.println("Прокси на примере кэшируемого репозитория:");
        Client client = new Client();
        client.configure(new ProxyService());
        for (int i = 0; i < 5; i++) client.makeRequest();
        client.bypassRequest();
    }
}
