package src.LibraryCardManagement;

public interface LibraryCardState {
    void borrowBook(LibraryCard card);
    void returnBook(LibraryCard card);
}
