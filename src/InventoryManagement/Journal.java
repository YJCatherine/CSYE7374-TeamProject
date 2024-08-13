public class Journal extends InventoryItem {
    public Journal(String title, String author) {
        super(title, author);
    }

    @Override
    public String getDescription() {
        return "Journal: " + title + " by " + author;
    }
}
