package src.AuthenticationSystem;

import java.util.HashMap;
import java.util.Scanner;

public class StandardUserAuthentication extends AuthenticationTemplate {

    private HashMap<String, String> users;

    public StandardUserAuthentication(HashMap<String, String> users) {
        this.users = users;
    }

    @Override
    protected boolean authenticate() {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    @Override
    protected void postLogin(Scanner scanner) {
        showManagementOptions(scanner);
    }

    private void showManagementOptions(Scanner scanner) {
        InventoryManagement inventoryManagement = new InventoryManagement();
        BookCategoryManagement bookCategoryManagement = new BookCategoryManagement();
        LibraryStaffManagement libraryStaffManagement = new LibraryStaffManagement();
        LibraryCardManagement libraryCardManagement = new LibraryCardManagement();

        while (true) {
            System.out.println("\nManagement Options:");
            System.out.println("1. Inventory Management");
            System.out.println("2. Book Category Management");
            System.out.println("3. Library Staff Management");
            System.out.println("4. Library Card Management");
            System.out.println("5. Logout");

            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inventoryManagement.manageInventory();
                    break;
                case "2":
                    bookCategoryManagement.manageBookCategories();
                    break;
                case "3":
                    libraryStaffManagement.manageLibraryStaff();
                    break;
                case "4":
                    libraryCardManagement.manageLibraryCards();
                    break;
                case "5":
                    System.out.println("Logging out...");
                    return;  // Exit management loop
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
