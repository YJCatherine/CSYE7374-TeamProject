package src.LibraryCardManagement;

public class SuspendedState implements LibraryCardState {
    public void borrowBook(LibraryCard card) {
        System.out.println("Borrowing not allowed. Your card is suspended.");
    }

    public void returnBook(LibraryCard card) {
        System.out.println("Book returned. Please contact administration for further actions.");
    }
}
