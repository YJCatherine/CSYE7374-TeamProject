package LibraryStaffManagement;

import java.util.*;

public class RolePermissions {
    private static final Map<Role, EnumSet<Permission>> rolePermissionsMap = new HashMap<>();

    static {
        // Define admin permissions
        rolePermissionsMap.put(Role.ADMIN, EnumSet.allOf(Permission.class));

        // Define librarian permissions
        rolePermissionsMap.put(Role.LIBRARIAN, EnumSet.of(Permission.ADD_BOOK, Permission.REMOVE_BOOK, Permission.UPDATE_BOOK));
    }

    public static boolean hasPermission(Role role, Permission permission) {
        return rolePermissionsMap.get(role).contains(permission);
    }
}

