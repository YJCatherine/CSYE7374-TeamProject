public class Drive {
    public static void main(String[] args) {
        InventoryManager inventoryManager = InventoryManager.getInstance();

        InventoryObserver logger = new InventoryLogger();
        InventoryObserver notifier = new InventoryNotifier();
        inventoryManager.registerObserver(logger);
        inventoryManager.registerObserver(notifier);

        InventoryItem book = InventoryItemFactory.createItem("Book", "Effective Java", "Joshua Bloch");
        InventoryItem journal = InventoryItemFactory.createItem("Journal", "Computer Science Review", "John Doe");

        System.out.println("=== Adding Items ===");
        inventoryManager.addItem(book);
        inventoryManager.addItem(journal);
        System.out.println();

        System.out.println("=== Searching Items by Title ===");
        SearchStrategy titleSearch = new TitleSearchStrategy();
        InventoryItem foundBook = inventoryManager.searchItem("Effective Java", titleSearch);

        if (foundBook != null) {
            System.out.println("Found: " + foundBook.getDescription());
        } else {
            System.out.println("Item not found.");
        }
        System.out.println();

        System.out.println("=== Searching Items by Author ===");
        SearchStrategy authorSearch = new AuthorSearchStrategy();
        InventoryItem foundJournal = inventoryManager.searchItem("John Doe", authorSearch);

        if (foundJournal != null) {
            System.out.println("Found: " + foundJournal.getDescription());
        } else {
            System.out.println("Item not found.");
        }
        System.out.println();

        System.out.println("=== Removing Item ===");
        inventoryManager.removeItem(book);
        System.out.println();
    }
}
