package com.epam.aminev;

import com.epam.aminev.comparators.*;
import com.epam.aminev.entities.Human;
import com.epam.aminev.entities.User;
import com.epam.aminev.entities.UserRoles;

import java.util.*;

/**
 * Main class which runs tasks and demonstrate its in work
 * This class demonstrate the understanding of how collections work
 */
public class Main {
    /**
     * Entry point in Collections demo that did during Lesson 3
     *
     * @param args input arguments. Not used
     */
    public static void main(String[] args) {
        List<Human> humanList = new ArrayList<>();
        runTask1(humanList);
        runTask2(humanList);
        runTask3(humanList);
        runTask4(humanList);
        runTask5(humanList);
        runTask6(humanList);
        runTask8();
        runTask9();
        runTask10();
        runTask11();
    }

    /**
     * An extracted method that creating an example list of Human instances
     *
     * @param humanList will be recreated if it necessary
     */
    static void fillHumanList(List<Human> humanList) {
        if (humanList == null || !humanList.isEmpty()) humanList = new ArrayList<>();
        Human.Address[] addresses = new Human.Address[10];
        addresses[0] = new Human.Address("Russia", "Tol'yatti", "Topolinaya", 15);
        addresses[1] = new Human.Address("Russia", "Toggliatti", "Lenina", 189);
        addresses[2] = new Human.Address("Japan", "Tokio", "Karla M.", 36);
        addresses[3] = new Human.Address("Japan", "Tokio", "Karla M.", 36);
        addresses[4] = new Human.Address("Russia", "Stavropol'", "Mira", 78);
        addresses[5] = new Human.Address("USA", "New-York", "Dzerjinskogo", 15);
        addresses[6] = new Human.Address("USA", "New-York", "Dzerjinskogo", 15);
        addresses[7] = new Human.Address("China", "Honk-Kong", "Botanicheskaya", 48);
        addresses[8] = new Human.Address("China", "Honk-Kong", "Botanicheskaya", 48);
        addresses[9] = new Human.Address("France", "Paris", "70 Years", 97);
        humanList.add(new Human("Petya F.O.", 15, addresses[0]));
        humanList.add(new Human("Vasya F.O.", 48, addresses[1]));
        humanList.add(new Human("Kamina F.O.", 20, addresses[2]));
        humanList.add(new Human("Kamina F.O.", 20, addresses[3]));
        humanList.add(new Human("Alexandra F.O.", 35, addresses[4]));
        humanList.add(new Human("Jack F.O.", 49, addresses[5]));
        humanList.add(new Human("Jack F.O.", 49, addresses[6]));
        humanList.add(new Human("Chong F.O.", 23, addresses[7]));
        humanList.add(new Human("Chong F.O.", 23, addresses[8]));
        humanList.add(new Human("Baggetue F.O.", 38, addresses[9]));
    }

    /**
     * Task 1. Fill an ArrayList with Human instances
     *
     * @param humanList is empty (and maybe null) List that will created in {@code fillHumanList} method
     */
    static void runTask1(List<Human> humanList) {
        fillHumanList(humanList);
        System.out.printf("ArrayList людей (%d):\n", humanList.size());
        for (Human human : humanList) {
            System.out.println(human);
        }
    }

    /**
     * Task 2. Find and print doubles inside coming list
     *
     * @param humanList in which doubles will be found
     */
    static void runTask2(List<Human> humanList) {
        System.out.println("Дубли:");
        for (int i = 0; i < humanList.size() - 1; i++) {
            for (int j = i + 1; j < humanList.size(); j++) {
                if (humanList.get(i).equals(humanList.get(j))) {
                    System.out.println(humanList.get(i));
                }
            }
        }
    }

    /**
     * Task 3. Remove all doubles in coming list
     *
     * @param humanList in which doubles will be removed
     */
    static void runTask3(List<Human> humanList) {
        for (int i = 0; i < humanList.size() - 1; i++) {
            for (int j = i + 1; j < humanList.size(); j++) {
                if (humanList.get(i).equals(humanList.get(j))) {
                    humanList.remove(humanList.get(i));
                }
            }
        }
        System.out.printf("ArrayList без дублей (%d):\n", humanList.size());
        for (Human human : humanList) {
            System.out.println(human);
        }
    }

    /**
     * Task 4. Sort coming list of Human by ФИО
     *
     * @param list that will be sorted by ФИО
     */
    static void runTask4(List<Human> list) {
        list.sort(new NameComparator());
        System.out.println("ArrayList сортированный по ФИО: ");
        for (Human human : list) {
            System.out.println(human);
        }
    }

    /**
     * Task 5. Sort coming list by age
     *
     * @param humanList that will be sorted by age
     */
    static void runTask5(List<Human> humanList) {
        humanList.sort(new AgeComparator());
        System.out.println("ArrayList сортированный по возрасту: ");
        for (Human human : humanList) {
            System.out.println(human);
        }
    }

    /**
     * Task 6. Sort coming list by address (lexicographic sorting of the full address)
     *
     * @param humanList that will be sorted by address
     */
    static void runTask6(List<Human> humanList) {
        humanList.sort(new AddressComparator());
        System.out.println("ArrayList сортированный по адресу: ");
        for (Human human : humanList) {
            System.out.println(human);
        }
    }

    /**
     * Task 8 Demo. Printing of message with user's name, his role and it's description
     */
    static void runTask8() {
        User user = new User("Jack", UserRoles.ADMIN);
        String userName = user.getName();
        String userRoleName = User.rolesVisibleNames.get(user.getRole());
        String userRoleDescription = User.rolesDescriptions.get(user.getRole());
        System.out.printf("Привет, %s. Твоя роль - %s. Твоя задача: %s\n", userName, userRoleName, userRoleDescription);
    }

    /**
     * Task 9. Sort HashMap by key
     *
     * @see KeyComparator
     */
    static void runTask9() {
        System.out.println("До сортировки по ключу:");
        HashMap<Integer, Double> map = new HashMap<>();
        int key;
        double value;
        for (int i = 0; i < 10; i++) {
            key = (int) (Math.random() * 100);
            value = Math.random() * 100;
            System.out.printf("%d\t=\t%.4f\n", key, value);
            map.put(key, value);

        }
        System.out.println("После сортировки по ключу:");
        TreeSet<Map.Entry<Integer, Double>> keySortedSet = new TreeSet<>(new KeyComparator<>());
        keySortedSet.addAll(map.entrySet());
        for (Map.Entry<Integer, Double> entry : keySortedSet) {
            System.out.printf("%d\t=\t%.4f\n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Task 10. Sort HashMap by value
     *
     * @see ValueComparator
     */
    static void runTask10() {
        System.out.println("До сортировки по значению:");
        HashMap<Integer, Double> map = new HashMap<>();
        int key;
        double value;
        for (int i = 0; i < 10; i++) {
            key = (int) (Math.random() * 100);
            value = Math.random() * 100;
            System.out.printf("%d\t=\t%.4f\n", key, value);
            map.put(key, value);
        }
        System.out.println("После сортировки по значению:");
        TreeSet<Map.Entry<Integer, Double>> ValueSortedSet = new TreeSet<>(new ValueComparator<>());
        ValueSortedSet.addAll(map.entrySet());
        for (Map.Entry<Integer, Double> entry : ValueSortedSet) {
            System.out.printf("%d\t=\t%.4f\n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Fill LinkedList with random values, then print whole LinkedList with indexes
     */
    static void runTask11() {
        System.out.println("LinkedList со случайными числами:");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add((int) (Math.random() * 100));
        }
        for (Integer integer : linkedList) {
            System.out.printf("linkedList[%d]=%-3d\n", linkedList.indexOf(integer), integer);
        }
    }
}
