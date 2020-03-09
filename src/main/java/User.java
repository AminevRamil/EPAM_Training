import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

enum UserRoles {
    ADMIN, USER, MODERATOR
}

@Data
@AllArgsConstructor
public class User {
    static HashMap<UserRoles, String> rolesDescriptions;
    static HashMap<UserRoles, String> rolesVisibleNames;

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
