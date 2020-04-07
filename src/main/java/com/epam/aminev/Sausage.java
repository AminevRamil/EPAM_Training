package com.epam.aminev;

import java.util.Scanner;

public class Sausage {
    String type;
    int weight;
    long cost;

    public Sausage(String parameters) {
        Scanner scanner = new Scanner(parameters);

        this.type = scanner.next();
        this.weight = scanner.nextInt();
        this.cost = scanner.nextInt();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Sausage{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
