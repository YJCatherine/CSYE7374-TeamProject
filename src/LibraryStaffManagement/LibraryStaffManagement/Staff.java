package LibraryStaffManagement;

public class Staff {
    private String staffId;
    private String name;
    private Role role;

    private Staff(String staffId, String name, Role role) {
        this.staffId = staffId;
        this.name = name;
        this.role = role;
    }

    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Role: " + role;
    }

    public static Staff createStaff(String staffId, String name, Role role) {
        return new Staff(staffId, name, role);
    }
}
