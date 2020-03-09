
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Human> list = new ArrayList<>();
        fillHumanList(list);
        task1(list);
        task2(list);
        task3(list);
        task4(list);
        task5(list);
        task6(list);
    }

    static void fillHumanList(List<Human> list) {
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
        list.add(new Human("Petya F.O.", 15, addresses[0]));
        list.add(new Human("Vasya F.O.", 48, addresses[1]));
        list.add(new Human("Kamina F.O.", 20, addresses[2]));
        list.add(new Human("Kamina F.O.", 20, addresses[3]));
        list.add(new Human("Alexandra F.O.", 35, addresses[4]));
        list.add(new Human("Jack F.O.", 49, addresses[5]));
        list.add(new Human("Jack F.O.", 49, addresses[6]));
        list.add(new Human("Chong F.O.", 23, addresses[7]));
        list.add(new Human("Chong F.O.", 23, addresses[8]));
        list.add(new Human("Baggetue F.O.", 38, addresses[9]));
    }

    static void task1(List<Human> list) {
        System.out.printf("ArrayList людей (%d):\n", list.size());
        for (Human human : list) {
            System.out.println(human);
        }
    }

    static void task2(List<Human> list) {
        System.out.println("Дубли:");
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    System.out.println(list.get(i));
                }
            }
        }
    }

    static void task3(List<Human> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(list.get(i));
                }
            }
        }
        System.out.printf("ArrayList без дублей (%d):\n", list.size());
        for (Human human : list) {
            System.out.println(human);
        }
    }

    static void task4(List<Human> list) {
        list.sort(new NameComparator());
        System.out.println("ArrayList сортированный по ФИО: ");
        for (Human human : list) {
            System.out.println(human);
        }
    }

    static void task5(List<Human> list) {
        list.sort(new AgeComparator());
        System.out.println("ArrayList сортированный по возрасту: ");
        for (Human human : list) {
            System.out.println(human);
        }
    }

    static void task6(List<Human> list) {
        list.sort(new AddressComparator());
        System.out.println("ArrayList сортированный по адресу: ");
        for (Human human : list) {
            System.out.println(human);
        }
    }
}
