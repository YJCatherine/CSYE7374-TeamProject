package LibraryStaffManagement;

public class Driver {
    public static void main(String[] args) {
        StaffManager staffManager = StaffManager.getInstance();

        // Create users
        Staff admin = Staff.createStaff("000", "Super Admin", Role.ADMIN);
        Staff librarian1 = Staff.createStaff("001", "Alice", Role.LIBRARIAN);
        Staff librarian2 = Staff.createStaff("002", "Bob", Role.LIBRARIAN);

        // Admin adds staff
        System.out.println("== Admin adds staff ==");
        staffManager.manageStaff(new AddStaffAction(), "003", "Charlie", Role.LIBRARIAN, admin);
        staffManager.manageStaff(new AddStaffAction(), "004", "David", Role.LIBRARIAN, admin);

        // Librarian tries to add staff (should be denied)
        System.out.println("\n== Librarian tries to add staff (should be denied) ==");
        staffManager.manageStaff(new AddStaffAction(), "005", "Eve", Role.LIBRARIAN, librarian1);

        // Librarian tries to remove staff (should be denied)
        System.out.println("\n== Librarian tries to remove staff (should be denied) ==");
        staffManager.manageStaff(new RemoveStaffAction(), "004", null, null, librarian1);

        // Admin updates staff information
        System.out.println("\n== Admin updates staff information ==");
        staffManager.manageStaff(new UpdateStaffAction(), "003", "Charlie Smith", Role.LIBRARIAN, admin);

        // Librarian tries to update staff information (should be denied)
        System.out.println("\n== Librarian tries to update staff information (should be denied) ==");
        staffManager.manageStaff(new UpdateStaffAction(), "003", "Charlie Brown", Role.LIBRARIAN, librarian2);

        // Admin finds staff information
        System.out.println("\n== Admin finds staff information ==");
        staffManager.manageStaff(new FindStaffAction(), "003", null, null, admin);

        // Librarian finds staff information
        System.out.println("\n== Librarian finds staff information ==");
        staffManager.manageStaff(new FindStaffAction(), "003", null, null, librarian1);

        // Admin removes staff
        System.out.println("\n== Admin removes staff ==");
        staffManager.manageStaff(new RemoveStaffAction(), "004", null, null, admin);

        // Attempt to find removed staff
        System.out.println("\n== Attempt to find removed staff ==");
        staffManager.manageStaff(new FindStaffAction(), "004", null, null, admin);
    }
}

