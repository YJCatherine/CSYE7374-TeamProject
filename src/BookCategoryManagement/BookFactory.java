package src.BookCategoryManagement;

public class BookFactory {
    public static Book createBook(String title, String author, String description, String releaseDate, String... categories) {
        Book.BookBuilder builder = new Book.BookBuilder()
                .setTitle(title)
                .setAuthor(author)
                .setDescription(description)
                .setReleaseDate(releaseDate);
        for (String category : categories) {
            builder.addCategory(category);
        }
        return builder.build();
    }
}
