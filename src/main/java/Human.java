import lombok.*;

import java.util.Comparator;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Human {
    String name;
    int age;
    Address address;

    @Data
    @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    public static final class Address implements Comparable<Address> {
        private String country;
        private String city;
        private String street;
        private int flat;

        @Override
        public int compareTo(Address o) {
            if (!this.country.equals(o.country)) return this.country.compareTo(o.country);
            else if (!this.city.equals(o.city)) return this.city.compareTo(o.city);
            else if (!this.street.equals(o.street)) return this.street.compareTo(o.street);
            else return this.flat - o.flat;
        }
    }

    public static final class NameComparator implements Comparator<Human> {
        @Override
        public int compare(Human o1, Human o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
    public static final class AgeComparator implements Comparator<Human> {
        @Override
        public int compare(Human o1, Human o2) {
            return o1.getAge() - o2.getAge();
        }
    }
}
