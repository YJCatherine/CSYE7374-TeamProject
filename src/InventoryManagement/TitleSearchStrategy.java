import java.util.List;

public class TitleSearchStrategy implements SearchStrategy {
    public InventoryItem search(List<InventoryItem> items, String keyword) {
        for (InventoryItem item : items) {
            if (item.title.equalsIgnoreCase(keyword)) {
                return item;
            }
        }
        return null;
    }
}

