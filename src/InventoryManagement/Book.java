public class Book extends InventoryItem {
    public Book(String title, String author) {
        super(title, author);
    }

    @Override
    public String getDescription() {
        return "Book: " + title + " by " + author;
    }
}
