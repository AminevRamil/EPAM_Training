package com.epam.aminev.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * The {@code Human} class represents Human entity.
 *
 * @author Aminev Ramil
 */
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Human {
    String name;
    int age;
    Address address;


    /**
     * Inner class {@code Address} represents information about address which human live
     *
     * @author Aminev Ramil
     */
    @Data
    @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    public static final class Address implements Comparable<Address> {
        private String country;
        private String city;
        private String street;
        private int flat;

        /**
         * Implementation of interface {@code Comparable}
         *
         * @param address which need to be compared with this address
         * @return a negative integer, zero, or a positive integer as this address
         * is less than, equal to, or greater than the specified address.
         * @throws NullPointerException if the specified object is null
         * @see Comparable
         */
        @Override
        public int compareTo(Address address) {
            if (address == null) throw new NullPointerException("Can't compare Address with Null");
            if (!this.country.equals(address.country)) return this.country.compareTo(address.country);
            else if (!this.city.equals(address.city)) return this.city.compareTo(address.city);
            else if (!this.street.equals(address.street)) return this.street.compareTo(address.street);
            else return this.flat - address.flat;
        }
    }


}
