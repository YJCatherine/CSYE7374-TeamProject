package src.LibraryCardManagement;

import java.text.DecimalFormat;

public class Driver {
    public static void main(String[] args) {
        // Print library borrowing rules
        printBorrowingRules();

        // Create a library card for a student
        LibraryCard studentCard = new LibraryCard();
        System.out.println("\nA new student library card created.");

        // Student borrowing books
        studentCard.borrowBook();
        studentCard.returnBook();

        // Simulate changing state to suspended due to frequent overdue
        studentCard.setState(new SuspendedState());
        System.out.println("\nStudent card is now suspended due to frequent overdue.");

        // Trying to borrow with suspended card
        studentCard.borrowBook();
        studentCard.returnBook();

        // Simulating overdue fine calculation for student
        FineStrategy studentStrategy = new StudentFineStrategy();
        int daysLate = 5; // Student returning book 5 days late
        System.out.println("\nStudent fine for " + daysLate + " days late: " + formatFine(studentStrategy.calculateFine(daysLate)));

        // Create a library card for a staff member
        LibraryCard staffCard = new LibraryCard();
        System.out.println("\nA new staff library card created.");
        staffCard.setState(new ActiveState());

        // Staff borrowing books
        staffCard.borrowBook();
        staffCard.returnBook();

        // Simulating overdue fine calculation for staff
        FineStrategy staffStrategy = new StaffFineStrategy();
        daysLate = 7; // Staff returning book 3 days late
        System.out.println("\nStaff fine for " + daysLate + " days late: " + formatFine(staffStrategy.calculateFine(daysLate)));

        // Create a library card for a public member
        LibraryCard publicCard = new LibraryCard();
        System.out.println("\nA new public library card created.");
        publicCard.setState(new ActiveState());

        // Public member borrowing books
        publicCard.borrowBook();
        publicCard.returnBook();

        // Simulating overdue fine calculation for public
        FineStrategy publicStrategy = new PublicFineStrategy();
        daysLate = 2; // Public returning book 2 days late
        System.out.println("\nPublic fine for " + daysLate + " days late: " + formatFine(publicStrategy.calculateFine(daysLate)));
    }

    // Helper method to format fines to 2 decimal places
    private static String formatFine(double fine) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(fine);
    }

    // Method to print library borrowing rules
    private static void printBorrowingRules() {
        System.out.println("Library Borrowing Rules:");
        System.out.println("Staff: Limit of 20 books per loan, loan duration 365 days.");
        System.out.println("Students: Limit of 5 books per loan, loan duration 21 days.");
        System.out.println("Public: Limit of 3 books per loan, loan duration 15 days.");
    }
}
