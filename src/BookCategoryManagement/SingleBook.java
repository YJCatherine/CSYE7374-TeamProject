package src.BookCategoryManagement;

public class SingleBook implements BookComponent{
    private Book book;

    public SingleBook(Book book) {
        this.book = book;
    }

    @Override
    public void showDetails() {
        System.out.println(book.toString());
    }
}
