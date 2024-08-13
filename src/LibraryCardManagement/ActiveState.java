package src.LibraryCardManagement;

public class ActiveState implements LibraryCardState {
    public void borrowBook(LibraryCard card) {
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(LibraryCard card) {
        System.out.println("Book returned successfully.");
    }
}
