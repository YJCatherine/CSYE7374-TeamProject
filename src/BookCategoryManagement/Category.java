package src.BookCategoryManagement;

import java.util.ArrayList;
import java.util.List;

public class Category implements BookComponent{
    private String name;
    private List<BookComponent> books = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addBook(BookComponent book) {
        books.add(book);
    }

    @Override
    public void showDetails() {
        System.out.println("Category: " + name);
        for (BookComponent book : books) {
            book.showDetails();
        }
    }
}
