import java.util.HashMap;
import java.util.Map;

public class LibraryFacade {
    private Map<String, Category> categories = new HashMap<>();

    public void addBook(String title, String author, String description, String releaseDate, String... categories) {
        Book book = BookFactory.createBook(title, author, description, releaseDate, categories);
        for (String category : categories) {
            if (!this.categories.containsKey(category)) {
                this.categories.put(category, new Category(category));
            }
            this.categories.get(category).addBook(new SingleBook(book));
        }
    }

    public void showBooksByCategory(String category) {
        if (categories.containsKey(category)) {
            categories.get(category).showDetails();
        } else {
            System.out.println("Category not found");
        }
    }

    public void createSerial(String serialName, String... categories) {
        Category serial = new Category(serialName);
        for (String category : categories) {
            if (this.categories.containsKey(category)) {
                serial.addBook(this.categories.get(category));
            }
        }
        serial.showDetails();
    }
}
