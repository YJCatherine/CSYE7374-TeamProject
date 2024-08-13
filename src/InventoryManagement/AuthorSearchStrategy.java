import java.util.List;

public class AuthorSearchStrategy implements SearchStrategy {
    public InventoryItem search(List<InventoryItem> items, String keyword) {
        for (InventoryItem item : items) {
            if (item.author.equalsIgnoreCase(keyword)) {
                return item;
            }
        }
        return null;
    }
}
