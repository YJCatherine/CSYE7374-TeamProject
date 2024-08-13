package LibraryStaffManagement;

import java.util.*;

public class StaffManager {
    private Map<String, Staff> staffList;

    // Singleton instance
    private static StaffManager instance = null;

    private StaffManager() {
        staffList = new HashMap<>();
    }

    public static StaffManager getInstance() {
        if (instance == null) {
            instance = new StaffManager();
        }
        return instance;
    }

    public void manageStaff(StaffAction action, String staffId, String name, Role role, Staff currentUser) {
        if (RolePermissions.hasPermission(currentUser.getRole(), action.getRequiredPermission())) {
            action.execute(this, staffId, name, role);
        } else {
            System.out.println("Permission denied: You do not have permission to perform this action.");
        }
    }

    protected void addStaff(String staffId, String name, Role role) {
        if (!staffList.containsKey(staffId)) {
            staffList.put(staffId, Staff.createStaff(staffId, name, role));
            System.out.println("Staff added: " + staffList.get(staffId));
        } else {
            System.out.println("Staff with ID " + staffId + " already exists.");
        }
    }

    protected void removeStaff(String staffId) {
        if (staffList.containsKey(staffId)) {
            System.out.println("Removing staff: " + staffList.get(staffId));
            staffList.remove(staffId);
        } else {
            System.out.println("Staff with ID " + staffId + " not found.");
        }
    }

    protected void updateStaffInfo(String staffId, String name, Role role) {
        if (staffList.containsKey(staffId)) {
            Staff staff = staffList.get(staffId);
            staff.setName(name);
            staff.setRole(role);
            System.out.println("Updated staff: " + staff);
        } else {
            System.out.println("Staff with ID " + staffId + " not found.");
        }
    }

    protected Staff findStaff(String staffId) {
        if (staffList.containsKey(staffId)) {
            return staffList.get(staffId);
        } else {
            System.out.println("Staff with ID " + staffId + " not found.");
            return null;
        }
    }
}