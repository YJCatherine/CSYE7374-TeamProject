public class InventoryItemFactory {
    public static InventoryItem createItem(String type, String title, String author) {
        switch (type) {
            case "Book":
                return new Book(title, author);
            case "Journal":
                return new Journal(title, author);
            default:
                throw new IllegalArgumentException("Invalid item type.");
        }
    }
}
