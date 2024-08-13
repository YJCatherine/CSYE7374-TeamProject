package src.LibraryCardManagement;

public class LibraryCard {
    private LibraryCardState state;

    public LibraryCard() {
        this.state = new ActiveState(); // Default state
    }

    public void setState(LibraryCardState state) {
        this.state = state;
    }

    public void borrowBook() {
        state.borrowBook(this);
    }

    public void returnBook() {
        state.returnBook(this);
    }
}
