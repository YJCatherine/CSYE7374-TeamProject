package src.BookCategoryManagement;

public class BookDecorator implements BookComponent{
    protected BookComponent decoratedBook;

    public BookDecorator(BookComponent decoratedBook) {
        this.decoratedBook = decoratedBook;
    }

    public void showDetails() {
        decoratedBook.showDetails();
    }
}
