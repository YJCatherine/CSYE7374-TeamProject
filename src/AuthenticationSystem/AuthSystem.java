package src.AuthenticationSystem;

import java.util.HashMap;
import java.util.Scanner;

public class AuthSystem {

    private static AuthSystem instance;
    private HashMap<String, String> users = new HashMap<>();
    private AuthenticationTemplate authTemplate;

    private AuthSystem() {
        users.put("admin", "12345");
    }

    public static AuthSystem getInstance() {
        if (instance == null) {
            instance = new AuthSystem();
        }
        return instance;
    }

    public void authenticateUser(Scanner scanner) {
        authTemplate = new StandardUserAuthentication(users);
        authTemplate.login(scanner);
    }

    public void logout() {
        System.out.println("Logging out...");
        authTemplate = null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthSystem authSystem = AuthSystem.getInstance();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Login");
            System.out.println("2. Logout");
            System.out.println("3. Exit");

            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    authSystem.authenticateUser(scanner);
                    break;
                case "2":
                    authSystem.logout();
                    break;
                case "3":
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
