package LibraryStaffManagement;

public interface StaffAction {
    void execute(StaffManager manager, String staffId, String name, Role role);
    Permission getRequiredPermission();
}

class AddStaffAction implements StaffAction {
    public void execute(StaffManager manager, String staffId, String name, Role role) {
        manager.addStaff(staffId, name, role);
    }

    public Permission getRequiredPermission() {
        return Permission.ADD_STAFF;
    }
}

class RemoveStaffAction implements StaffAction {
    public void execute(StaffManager manager, String staffId, String name, Role role) {
        manager.removeStaff(staffId);
    }

    public Permission getRequiredPermission() {
        return Permission.REMOVE_STAFF;
    }
}

class UpdateStaffAction implements StaffAction {
    public void execute(StaffManager manager, String staffId, String name, Role role) {
        manager.updateStaffInfo(staffId, name, role);
    }

    public Permission getRequiredPermission() {
        return Permission.UPDATE_STAFF;
    }
}

class FindStaffAction implements StaffAction {
    public void execute(StaffManager manager, String staffId, String name, Role role) {
        Staff staff = manager.findStaff(staffId);
        if (staff != null) {
            System.out.println(staff);
        }
    }

    public Permission getRequiredPermission() {
        return Permission.VIEW_STAFF;
    }
}
