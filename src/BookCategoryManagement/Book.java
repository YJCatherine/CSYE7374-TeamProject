import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private String description;
    private String releaseDate;
    private List<String> categories;
    private List<String> labels;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.description = builder.description;
        this.releaseDate = builder.releaseDate;
        this.categories = builder.categories;
        this.labels = builder.labels;
    }

    public static class BookBuilder {
        private String title;
        private String author;
        private String description;
        private String releaseDate;
        private List<String> categories = new ArrayList<>();
        private List<String> labels = new ArrayList<>();

        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BookBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public BookBuilder addCategory(String category) {
            this.categories.add(category);
            return this;
        }

        public BookBuilder addLabel(String label) {
            this.labels.add(label);
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Release Date: " + releaseDate + ", Categories: " + categories + ", Labels: " + labels + ", Description: " + description;
    }

}
