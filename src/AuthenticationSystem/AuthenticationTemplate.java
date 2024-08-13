package src.AuthenticationSystem;

import java.util.Scanner;

public abstract class AuthenticationTemplate {

    protected String username;
    protected String password;

    // Template method
    public final void login(Scanner scanner) {
        getUserCredentials(scanner);
        if (authenticate()) {
            displayWelcomeMessage();
            postLogin(scanner);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    //Get user credentials
    protected void getUserCredentials(Scanner scanner) {
        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        System.out.print("Enter your password: ");
        password = scanner.nextLine();
    }

    //Authenticate user (abstract - to be implemented by subclasses)
    protected abstract boolean authenticate();

    //Display a welcome message (hook method - can be overridden)
    protected void displayWelcomeMessage() {
        System.out.println("Login successful! Welcome, " + username + ".");
    }

    //Post-login actions (abstract - to be implemented by subclasses)
    protected abstract void postLogin(Scanner scanner);
}
