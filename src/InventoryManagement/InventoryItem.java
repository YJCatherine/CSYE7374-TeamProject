abstract class InventoryItem {
    protected String title;
    protected String author;

    public InventoryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract String getDescription();
}
