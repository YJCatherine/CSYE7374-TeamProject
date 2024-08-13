import java.util.List;

public interface SearchStrategy {
    InventoryItem search(List<InventoryItem> items, String keyword);

}
