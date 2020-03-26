package com.epam.aminev.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

/**
 * The {@code User} class represents combination of user's name with his role in system
 * That class have visible names and descriptions to roles
 */

@Data
@AllArgsConstructor
public class User {
    public static final HashMap<UserRoles, String> rolesDescriptions;
    public static final HashMap<UserRoles, String> rolesVisibleNames;

    /*
      Static block is used to fill HashMaps with "human-ish" (russian) descriptions
     */
    static {
        rolesDescriptions = new HashMap<>();
        rolesDescriptions.put(UserRoles.ADMIN, "управлять всем");
        rolesDescriptions.put(UserRoles.USER, "пользоваться системой");
        rolesDescriptions.put(UserRoles.MODERATOR, "помогать администратору");

        rolesVisibleNames = new HashMap<>();
        rolesVisibleNames.put(UserRoles.ADMIN, "Администратор");
        rolesVisibleNames.put(UserRoles.USER, "Пользователь");
        rolesVisibleNames.put(UserRoles.MODERATOR, "Модератор");
    }

    String name;
    UserRoles role;
}
