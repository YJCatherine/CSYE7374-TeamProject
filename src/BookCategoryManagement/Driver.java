package src.BookCategoryManagement;

import src.LibraryCardManagement.*;

public class Driver {
    public static void main(String[] args) {
        // Create a library card for a student
        LibraryCard studentCard = new LibraryCard();
        System.out.println("A new student library card created.");

        // Student borrowing books
        studentCard.borrowBook();
        studentCard.returnBook();

        // Simulate changing state to suspended due to frequent overdue
        studentCard.setState(new SuspendedState());
        System.out.println("Student card is now suspended due to frequent overdue.");

        // Trying to borrow with suspended card
        studentCard.borrowBook();
        studentCard.returnBook();

        // Simulating overdue fine calculation
        FineStrategy studentStrategy = new StudentFineStrategy();
        int daysLate = 5; // Student returning book 5 days late
        double fine = studentStrategy.calculateFine(daysLate);
        System.out.println("Student fine for " + daysLate + " days late: " + fine);

        // Create a library card for a staff member
        LibraryCard staffCard = new LibraryCard();
        System.out.println("A new staff library card created.");
        staffCard.setState(new ActiveState());

        // Staff borrowing books
        staffCard.borrowBook();
        staffCard.returnBook();

        // Simulating overdue fine calculation for staff
        FineStrategy staffStrategy = new StaffFineStrategy();
        daysLate = 3; // Staff returning book 3 days late
        fine = staffStrategy.calculateFine(daysLate);
        System.out.println("Staff fine for " + daysLate + " days late: " + fine);

        // Create a library card for a public member
        LibraryCard publicCard = new LibraryCard();
        System.out.println("A new public library card created.");
        publicCard.setState(new ActiveState());

        // Public member borrowing books
        publicCard.borrowBook();
        publicCard.returnBook();

        // Simulating overdue fine calculation for public
        FineStrategy publicStrategy = new PublicFineStrategy();
        daysLate = 2; // Public returning book 2 days late
        fine = publicStrategy.calculateFine(daysLate);
        System.out.println("Public fine for " + daysLate + " days late: " + fine);
    }
}
